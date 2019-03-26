package com.tumi.testcases;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.UIFunctions;

public class VerifyCartPage extends GenericMethods {
	Map<String, String> personalization = ReadTestData.getJsonData("TumiTestData", "MonoGramDetails");
	Map<String, String> testdata = ReadTestData.getJsonData("TumiTestData", "Products");
	
	
	@Test(priority = 0, description = "TA-394, Verify Count of Products, TA-397, Verify Monogram")
	public void verifyProductCount() {
		SoftAssert cartAssertions = new SoftAssert();
		goToCartPageWithMoreQuantity();
		Integer cartSize = mainCart.getProductsList().size();

		String cartItems = getText(mainCart.getCartCount()).replaceAll("([a-z])", "").replaceAll("([A-Z])", "");
		Integer cartCount = Integer.parseInt(cartItems.replace("(", "").replace(")", "").replace(" ", ""));
		if (cartSize == cartCount) {
			logger.log(Status.INFO, "Verification Count of products added in cart is successfull");
		} else {
			cartAssertions.fail("Cart count is not matched with shopping cart value");
		}
	}
		

	@Test(priority = 1, description = "TA-393, Verify Product link", dependsOnMethods = "verifyProductCount")
	public void verifyProductLink() {
		goToCartPage();
		String skuid = getText(mainCart.getSkuID());
		click(mainCart.getProductLink(), "Product Link");
		String url = driver.getCurrentUrl();
		if (url.contains(skuid)) {
			logger.log(Status.INFO, "Click on Product Link is navigated to PDP page");
		} else {
			Assert.fail("Click on Product Link is not navigated to PDP page");
		}

	}
	@Test(priority = 2, description = "TA-393, Verify Monogram")
	public void verifyMonogram() {
		PDPpage.verifyMonogram();
		SoftAssert cartAssertions = new SoftAssert();
	
		click(mainCart.getAddclassicMono(),"Add Classic Monogram");
		if (mono.getStep1().isDisplayed()) {
			// domClick(mono.getAddPatch(),"Patch");
			if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
				if (mono.getAddPatch().isDisplayed()) {
					domClick(mono.getAddTag(), "Tag");
				} else {
					click(mono.getOptionsNext(), "Next");
				}
			}else {
				click(mono.getOptionsNext(), "Next");
			}
		} 
		webclick(mainCart.getAddHeart(),"Heart Symbol");
		webclick(mainCart.getSmiley(),"Smiley Symbol");
		webclick(mainCart.getStar(),"Star Symbol");
		
		input(mono.getFirstMonoInput(), personalization.get("FirstMonoInput"), "First Mono Input");
		input(mono.getSecondMonoInput(), personalization.get("SecondMonoInput"), "Second Mono Input");
		input(mono.getThirdMonoInput(), personalization.get("ThirdMonoInput"), "Third Mono Input");

		click(mono.getNext(), "Next");
		click(mono.getTextStyleBold(), "Serif as Bold");
		click(mono.getCafeColor(), "Color");
		click(mono.getApply(), "Apply");
		delay(2000);
		try {
			if(mainCart.getAddedMonoMsg().isDisplayed()) {
				logger.log(Status.INFO, "Monogram added Successfully");
				click(mono.getRemove(), "Remove");
				delay(2000);
				if (mainCart.getAddclassicMono().isEnabled()) {
					logger.log(Status.INFO, "Verification of Remove Monogram is successfull");
				} else {
					cartAssertions.fail("Verification of Remove Monogram is faield");
				}
			} 
		} catch (Exception e) {
			if(getText(mono.getMonoErrorMsg()).equals(getProperty("mono.error"))||getText(mono.getMonoErrorMsgAtCart()).equals(getProperty("mono.carterror")))  {
				cartAssertions.fail("Please enter atleast one character to add Monogram");
			}else {
				cartAssertions.fail("Monogram couldn't added, Please Check");
			}
		}
		cartAssertions.assertAll();
	}

	

	@Test(priority = 3, description = "TA-395, Verify Edit link to update cart and TA-396, Verify Remove Link")
	public void cartVerifications() {
		
		goToCartPageWithMoreQuantity();

		// verify Edit link
		click(mainCart.getEditQuantity(), "Edit");

		// remove Product
		Integer beforeCartSize = mainCart.getProductsList().size();
		click(mainCart.getRemoveProduct(), "Remove");
		Integer afterCartSize = mainCart.getProductsList().size();
		if (afterCartSize < beforeCartSize) {
			logger.log(Status.INFO, "Product removed successfully");
		} else {
			Assert.fail("Product is not removed");
		}

	}
	
	@Test(priority = 4, description = "TA-395, Verify Edit link to update cart and TA-396, Verify Remove Link")
	public void verifyContinueShopping() {
		goToCartPage();
		PDPpage.addProductForPDPtest(testdata.get("BreadCrumbsTest"));
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		String skuid = getText(driver.findElement(By.xpath("(//div[contains(@class,'ledger-prod-attr attr-style')]/span)[2]")));
		
		click(mainCart.getContinueshopping(),"Continue Shopping");
		String url = driver.getCurrentUrl();
		if(url.contains(skuid)&& pdp.getAddToCart().isDisplayed()) {
			logger.log(Status.INFO, "Clicking on continue shopping is navigating to PDP page");
			click(pdp.getAddToCart(),"Add to cart");
			if(minicart.getProceedCheckOut().isDisplayed()) {
				logger.log(Status.INFO, "Able to add products by clicking on continue shopping button");
			}else if(pdp.getOutOfStock().isDisplayed()) {
				logger.log(Status.PASS, "Product is out of stock to add product to cart" );
			}else {
				Assert.fail("Not able to add products by clicking on continue shopping button via pdp page");
			}
		}else {
			Assert.fail("Verification of Continue shopping failed");
		}
		
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test(priority = 5, description = "TA-395, Verify Edit link to update cart and TA-396, Verify Remove Link")
	public void verifyPromocode() {
		goToCartPage();
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "VoucherCodeDetails");
		if (singlePage.getPromocodeRemove().isDisplayed()) {
			logger.log(Status.INFO, "Promocode applied successfully");
		} else if (getText(mainCart.getPromoSuccessMsg()).equals(getProperty("voucher.successmsg"))) {
			logger.log(Status.INFO, "Promocode applied successfully");
		} else if ((mainCart.getPromoSuccessMsg()).equals(getProperty("voucher.alreadyapplied"))) {
			logger.log(Status.INFO, "Voucher already been applied successfully");
		} else {
			Assert.fail("Promocode couldn't be applied");
		}

		if (mainCart.getDiscountSummery().isDisplayed()) {
			logger.log(Status.INFO, "Promocode Discount has been added to Order Summery");
		} else {
			Assert.fail("Promocode has not added to Order Summery");
		}
	}
	
	@Test(priority = 6, description = "TA-395, Verify Edit link to update cart and TA-396, Verify Remove Link")
	public void verifySignInCartPage() {
		goToCartPage();
		userLogin("TumiTestData", "RegisteredOrders");
	}

	public void goToCartPage() {
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
	}

	public void goToCartPageWithMoreQuantity() {
		UIFunctions.addProductToCart("TumiTestData", "Products");
		input(mainCart.getEditProductQuantity(), "4", "Edit Product Quantity");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
	}
	public static void addProductForCartTest(String data) {

		if (selectedCountry.contains("US")) {

			final String pdpURL = GlobalConstants.S2 + "/p/" + data;
			driver.get(pdpURL);
		} else if (selectedCountry.contains("Canada")) {

			final String pdpURL = GlobalConstants.urlca + "/p/" + data;
			driver.get(pdpURL);

		} else {

			final String pdpURL = GlobalConstants.urlkr + "/p/" + data;
			driver.get(pdpURL);
		}
		UIFunctions.verifyVPN();
	}


}
