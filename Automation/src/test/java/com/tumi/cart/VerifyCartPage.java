package com.tumi.cart;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.testcases.BillingPage;
import com.tumi.testcases.ProductDetails;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.UIFunctions;



/**
 * @author Shwetha  Capo
 *
 */
public class VerifyCartPage extends GenericMethods {
	
	/*
	 * TA-73 : Verify Cart Page.
	 */
	
	Map<String, String> personalization = ReadTestData.getJsonData("TumiTestData", "MonoGramDetails");
	Map<String, String> testdata = ReadTestData.getJsonData("TumiTestData", "Products");
	
	
//	@Test(priority = 0, description = "TA-394, Verify Count of Products")
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
		

	//@Test(priority = 1, description = "TA-393, Verify Product link")
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
	//@Test(priority = 2, description = "TA-397, Verify Monogram")
	public void verifyMonogram() {
		goToCartPage();
		SoftAssert cartAssertions = new SoftAssert();
	
		click(mainCart.getAddclassicMono(),"Add Classic Monogram");
		UIFunctions.addMonogram(mainCart.getEditMono(), mainCart.getRemove());
		
		cartAssertions.assertAll();
		
	}

	

	//@Test(priority = 3, description =  " TA-396, Verify Remove Link")
	public void verifyRemoveLink() {
		
		goToCartPageWithMoreQuantity();

		Integer beforeCartSize = mainCart.getProductsList().size();
		click(mainCart.getRemoveProduct(), "Remove");
		Integer afterCartSize = mainCart.getProductsList().size();
		if (afterCartSize < beforeCartSize) {
			logger.log(Status.INFO, "Product removed successfully");
		} else {
			Assert.fail("Product is not removed");
		}

	}
	@Test(priority = 4, description = "TA-395, Verify Edit link to update cart" )
	public void verifyEditLink() {
		goToCartPage();
		delay(2000);
		click(mainCart.getEditQuantity(), "Edit");
		
		input(mainCart.getInputQuantity(),"2","Quantity");
		click(mainCart.getUpdateCart(),"Update Cart");
		delay(2000);
		Integer cartSize = mainCart.getProductsList().size();
		if(cartSize==2) {
			logger.log(Status.PASS, "Product quantity updated successfully");
		}else {
			Assert.fail("Product quantity couldn't updated correctly");
		}
		
	}
	
	
	//@Test(priority = 5, description = "TA- 399, Verify Continue shopping.")
	public void verifyContinueShopping() {
		ProductDetails.addProductForPDPtest(testdata.get("BreadCrumbsTest"));
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		String skuid = getText(driver.findElement(By.xpath("//div[contains(@class,'ledger-prod-attr attr-style')]/span")));
		
		click(mainCart.getContinueshopping(),"Continue Shopping");
		String url = driver.getCurrentUrl();
		try {
			if(url.contains(skuid)&& pdp.getAddToCart().isDisplayed()) {
				logger.log(Status.INFO, "Clicking on continue shopping is navigating to PDP page");
				click(pdp.getAddToCart(),"Add to cart");
				try {
					if(minicart.getProceedCheckOut().isDisplayed()) {
						logger.log(Status.INFO, "Able to add products by clicking on continue shopping button");
					}else if(pdp.getOutOfStock().isDisplayed()) {
						logger.log(Status.PASS, "Product is out of stock to add product to cart" );
					}
				} catch (Exception e) {
						Assert.fail("Not able to add products by clicking on continue shopping button via pdp page");
				}
			}
		} catch (Exception e) {
				Assert.fail("Verification of Continue shopping failed");
		}
		
		
	}
	
//	@Test(priority = 6, description = "TA-401, Verify Sign In")
	public void verifySignInCartPage() {
		goToCartPage();
		userLogin("TumiTestData", "RegisteredOrders");
	}
	//@Test(priority = 7, description = "TA- 402, Verify PayPal link")
	public void verifyPayPalLink() {
		goToCartPage();
		String value = getText(mainCart.getEstimatedTotal());
		System.out.println(value);
		Double dValue = Double.valueOf(value.replace("$", ""));
		if (dValue.intValue() >= 100) {
			click(paypal.getPayPalAnother(), "PayPal");
		} else {
			click(paypal.getPayPal(), "PayPal");
		}
		try {
			if(paypal.getPayPalEmail().isDisplayed()) {
				logger.log(Status.PASS, "Click on PayPal, Successfully navigated to PayPal login page");
			}
		} catch (Exception e) {
			Assert.fail("Click on PayPal, Page couldn't navigated to PayPal login page");
		}
		
	}
	
	//@Test(priority = 8, description = "TA-403, Verify accordions/labels")
	public void verifyAccordions() {
		BillingPage.verifyAccordions();
		
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
