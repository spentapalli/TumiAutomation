package com.tumi.utilities;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.webPages.HomePage;

/**
 * @author Suuresh
 *
 */
public class UIFunctions extends GenericMethods {

	public static void closeSignUp() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		try {
			home.getSignupPopup().click();
		} catch (Exception e) {
		}
		try {
			home.getCASignupPopup().click();
		} catch (Exception e) {
		}

		try {
			home.getKoreaSignupPopup().click();
		} catch (Exception e) {
		}
	}

	public static void closeSignUpForUsProd() {
		try {
			click(home.getSignupPopup(), "Close SignUp Window");
		} catch (Exception e) {
		}
	}

	public static void acceptCookies() {
		try {
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			domClick(home.getAcceptCookies(), "Accept Cookies");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verifyVPN() {
		try {
			if (home.getVPNDis().isDisplayed()) {
				Assert.fail("VPN is Disconnected, Kindly User VPN to Access Application");
			}
		} catch (Exception e) {
		}
	}

	public static void addCardDetails(String sheet, String testCaseName) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCaseName);

		// billing page
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");

		// invalid card number
		input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
		selectByVisibleText(guestBillPage.getExpiryMonth(), "05", "Expiry Month");
		selectByVisibleText(guestBillPage.getExpiryYear(), "2020", "Expiry Year");
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
		input(guestBillPage.getemail(), testData.get("EmailID"), "Email ID");
		input(guestBillPage.getPhoneNumber(), testData.get("Phone"), "Phone number");
		domClick(guestBillPage.getReviewOrder(), "Review your order");
	}

	public static void addInvalidCardDetails(String sheet, String testCaseName) {

		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCaseName);

		// billing page
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");

		// invalid card number
		input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
		selectByVisibleText(guestBillPage.getExpiryMonth(), "05", "Expiry Month");
		selectByVisibleText(guestBillPage.getExpiryYear(), "2020", "Expiry Year");
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
		input(guestBillPage.getemail(), testData.get("EmailID"), "Email ID");
		input(guestBillPage.getPhoneNumber(), testData.get("Phone"), "Phone number");
		click(guestBillPage.getReviewOrder(), "Review your order");
		if (review.getPlaceOrder().isEnabled()) {
			Assert.fail("Able to Proceed Order with invalid details");
		}
	}

	public static int shoppingCartCount() {
		String cartItems = getText(pdp.getShoppingCart()).replace("(", "").replace(")", "").replaceAll("\\s", "");
		int cartCount = (int) cartItems.charAt(cartItems.length() - 1);
		return cartCount;
	}

	public static void addProductToCart(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		final String pdpURL = GlobalConstants.url + "/p/" + testData.get("SKUID");
		driver.get(pdpURL);
		WaitForJStoLoad();
		verifyAssertContains(driver.getCurrentUrl(), testData.get("SKUID"), "Wrong Product is displayed");
		try {
			if (pdp.getAddToCart().isDisplayed()) {
				verifyAssertEquals("Add To Cart", getText(pdp.getAddToCart()));
			}
		} catch (Exception e) {
			Assert.fail(testData.get("SKUID") + " Product is not available");
		}
		// click(pdp.getAddToCart(), "Add to Cart");

		// due to product search issue i am using above code to get the product.

		/*
		 * input(home.getSearchProduct(), testData.get("SKUID"), "Search Product");
		 * keyEnter(home.getSearchProduct());
		 * verifyAssertContains(driver.getCurrentUrl(), testData.get("SKUID"),
		 * "Wrong Product is displayed"); try { if (pdp.getAddToCart().isDisplayed()) {
		 * 
		 * verifyAssertEquals("Add To Cart", getText(pdp.getAddToCart())); } } catch
		 * (Exception e) { Assert.fail(testData.get("SKUID")
		 * +" Product is not available"); }
		 */

	}

	public static void addBackOrderProduct(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		final String pdpURL = GlobalConstants.url + "/p/" + testData.get("BackOrderSKUID");
		driver.get(pdpURL);

		// due to product search issue i am using above code to get the product.

		/*
		 * input(home.getSearchProduct(), testData.get("SKUID"), "Search Product");
		 * keyEnter(home.getSearchProduct());
		 * verifyAssertContains(driver.getCurrentUrl(), testData.get("SKUID"),
		 * "Wrong Product is displayed"); try { if (pdp.getAddToCart().isDisplayed()) {
		 * 
		 * verifyAssertEquals("Add To Cart", getText(pdp.getAddToCart())); } } catch
		 * (Exception e) { Assert.fail(testData.get("SKUID")
		 * +" Product is not available"); }
		 */

	}

	public static void addPrekOrder(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		final String pdpURL = GlobalConstants.url + "/p/" + testData.get("PreOrderSKUID");
		driver.get(pdpURL);

		// due to product search issue i am using above code to get the product.

		/*
		 * input(home.getSearchProduct(), testData.get("SKUID"), "Search Product");
		 * keyEnter(home.getSearchProduct());
		 * verifyAssertContains(driver.getCurrentUrl(), testData.get("SKUID"),
		 * "Wrong Product is displayed"); try { if (pdp.getAddToCart().isDisplayed()) {
		 * 
		 * verifyAssertEquals("Add To Cart", getText(pdp.getAddToCart())); } } catch
		 * (Exception e) { Assert.fail(testData.get("SKUID")
		 * +" Product is not available"); }
		 */

	}

	public static void addMonogram(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		// domClick(mono.getComplimentaryMono(),"Monogram");
		click(mono.getAddPersonalization(), "Add Personalization");
		input(mono.getFirstMonoInput(), testData.get("FirstMonoInput"), "First Mono Input");
		input(mono.getSecondMonoInput(), testData.get("SecondMonoInput"), "Second Mono Input");
		input(mono.getThirdMonoInput(), testData.get("ThirdMonoInput"), "Third Mono Input");

		click(mono.getNext(), "Next");
		click(mono.getTextStyleBold(), "Serif as Bold");
		click(mono.getCafeColor(), "Color");
		click(mono.getApply(), "Apply");
		delay(3000);
	}

	/*
	 * public static void completeOrder(String sheet, String testCase) {
	 * 
	 * Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);
	 * 
	 * click(mainCart.getProceedToCheckout(), "Cart");
	 * input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email");
	 * click(singlePage.getContinueAsGuest(), "Continue As Guest");
	 * input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
	 * input(shipping.getLastName(), testData.get("LastName"), "Last Name");
	 * input(shipping.getAddressLine1(), testData.get("AddressLine1"),
	 * "Address line1"); do { delay(2000); } while
	 * (!shipping.getAddressList().isDisplayed());
	 * 
	 * for (int i = 1; i < shipping.getAddList().size(); i++) {
	 * 
	 * WebElement add =
	 * driver.findElement(By.xpath("//div[@class='address-picklist']/div[" + i +
	 * "]")); if (add.getText().contains("PRINCE RUPERT")) { click(add,
	 * "Address Line1"); break; } }
	 * 
	 * added code for Canada
	 * 
	 * 
	 * 
	 * for (WebElement ele : shipping.getListAddressLine1()) { if
	 * (getText(ele).equals("10 SUMAS WAY, ABBOTSFORD, BC, V2S 8B7")) { click(ele,
	 * "AddressList"); break; } }
	 * 
	 * input(shipping.getPostcode(), testData.get("PostCode"), "Post code");
	 * input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
	 * click(shipping.getContinueShippingMethod(), "Continue shipping Method");
	 * webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
	 * String fee = getText(shipMethod.getShippingFree());
	 * click(shipMethod.getProceedToPayment(), "Proceed to Payment"); if
	 * (!fee.equals("FREE")) { UIFunctions.addCardDetails("PlaceOrder",
	 * "TumiOrder"); } click(review.getPlaceOrder(), "Place Order"); do {
	 * delay(2000); } while (confirmation.getWithForConfirmation().isDisplayed());
	 * 
	 * if (!confirmation.getConfirmOrder().isDisplayed()) {
	 * 
	 * Assert.fail("Faile to Place An Order"); } orderNumber =
	 * getText(confirmation.getOrderNumber()); logger.log(Status.INFO,
	 * "Thank you for Your Order, here is your Order Number " + orderNumber);
	 * captureOrderConfScreen("OrderConfirmation"); }
	 */

	public static void addGuestDetails() {

		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "OrderWithTwoProducts");
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address Line1");
		explicitWait(shipping.getSelectedAddressLine());
		for (int i = 1; i < shipping.getAddList().size(); i++) {
			WebElement add = driver.findElement(By.xpath("//div[@class='address-picklist']/div[" + i + "]"));
			if (add.getText().contains("Fairport NY 14450")) {
				click(add, "Address Line1");
				break;
			}
		}
		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
	}

	public static void completeOrder() {
		delay(2000);
		domClick(review.getPlaceOrder(), "Place Order");
		do {
			delay(2000);
		} while (confirmation.getWithForConfirmation().isDisplayed());

		if (!confirmation.getConfirmOrder().isDisplayed()) {

			Assert.fail("Faile to Place An Order");
		}
		orderNumber = getText(confirmation.getOrderNumber());
		logger.log(Status.INFO, "Thank you for Your Order, here is your Order Number " + orderNumber);
		captureOrderConfScreen("OrderConfirmation");
	}

	public static void addPromotionalCodeAtCart(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		input(mainCart.getPromocode(), testData.get("VoucherID"), "Vocher Id");
		click(mainCart.getApply(), "Check Promocode");
		/*
		 * try { if (mainCart.getVocherCardFailed().isDisplayed()) {
		 * 
		 * Assert.fail(getText(mainCart.getVocherCardFailed()));
		 * 
		 * } else if (!mainCart.getCodeApplied().isDisplayed()) {
		 * 
		 * Assert.fail("Promo Code Remove link is not displayed");
		 * 
		 * } else if (!mainCart.getCodeRemove().isDisplayed()) {
		 * 
		 * Assert.fail("Promo Code Applied Message is not displayed");
		 * 
		 * } else if (!mainCart.getSubtotalCode().isDisplayed()) {
		 * 
		 * Assert.fail("Promo Code Subtotal is not displayed");
		 * 
		 * } else if (mainCart.getVocherCardFailed().isDisplayed()) {
		 * 
		 * Assert.fail(getText(mainCart.getVocherCardFailed())); } } catch (Exception e)
		 * {
		 * 
		 * Assert.fail("Vocher Card related Fields are not displayed " +
		 * e.getMessage()); }
		 */

	}

	public static void addPromotionalCodeAtSinglePage(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		input(singlePage.getPromocode(), testData.get("VoucherID"), "Vocher Id");
		click(singlePage.getApply(), "Check Promocode");
		// delay(2000);

		/*
		 * try { if (mainCart.getVocherCardFailed().isDisplayed()) {
		 * 
		 * Assert.fail(getText(mainCart.getVocherCardFailed()));
		 * 
		 * } else if (!mainCart.getCodeApplied().isDisplayed()) {
		 * 
		 * Assert.fail("Promo Code Remove link is not displayed");
		 * 
		 * } else if (!mainCart.getCodeRemove().isDisplayed()) {
		 * 
		 * Assert.fail("Promo Code Applied Message is not displayed");
		 * 
		 * } else if (!mainCart.getSubtotalCode().isDisplayed()) {
		 * 
		 * Assert.fail("Promo Code Subtotal is not displayed");
		 * 
		 * } else if (mainCart.getVocherCardFailed().isDisplayed()) {
		 * 
		 * Assert.fail(getText(mainCart.getVocherCardFailed())); } } catch (Exception e)
		 * {
		 * 
		 * Assert.fail("Vocher Card related Fields are not displayed " +
		 * e.getMessage()); }
		 */

	}

	public static void addGiftMessage(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		domClick(gift.getCheckMessage(), "Check Message");
		input(gift.getRecipientName(), testData.get("RecipientName"), "Recipients name");
		input(gift.getSenderName(), testData.get("SenderName"), "Sender name");
		input(gift.getAddMessage(), testData.get("Message"), "Message");

	}

	public static void addGiftBox() {
		click(gift.getCheckPremiumGift(), "Premium GiftBox");
	}

	public static void addVoucherID(String sheet, String testCase) {
		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);
		input(mainCart.getPromocode(), testData.get("VocherID"), "Voucher Code");
		click(mainCart.getApply(), "Apply Promocode");
	}

	public static void signInWithGoogle(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);

		try {
			if (google.getNoThanks().isDisplayed()) {
				click(google.getNoThanks(), "offers popup");
			}
		} catch (Exception e) {
		}
		String parent = driver.getWindowHandle();
		webclick(home.getHeaderSignIn(), "Sign In");
		webclick(google.getGoogleLogin(), "Google login");
		Set<String> set = driver.getWindowHandles();
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			String child = ite.next();
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				input(google.getEmail(), testData.get("EmailID"), "Gmail Id");
				webclick(google.getFirstNext(), "Next");
				input(google.getPassword(), testData.get("Password"), "Password");
				webclick(google.getPasswordNext(), "password next");
			}
		}
	}

	public static void searchProducts(int i, String data) {
		input(home.getSearchProduct(), data, "Product Search");
		if (home.getMatchingProducts().isEmpty()) {
			final String emptyViewText = driver
					.findElement(By.xpath("//div[contains(text(),'Sorry, no search results for')]")).getText();
			if (!emptyViewText.contains("no results")) {
				throw new RuntimeException(emptyViewText);
			}
		} else {
			home.getMatchingProducts().get(i).click();
		}
	}

	public static void addMultipleProducts(String sheet, String testCase) {
		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);
		for (int i = 0; i < 2; i++) {
			UIFunctions.searchProducts(i, testData.get("PrdouctName"));
			delay(3000);
			// verifyAssertContains(driver.getCurrentUrl(), testData.get("SKUID"), "Wrong
			// Product is displayed");
			try {
				if (pdp.getAddToCart().isDisplayed()) {
					verifyAssertEquals("Add To Cart", getText(pdp.getAddToCart()));
				}
			} catch (Exception e) {
				Assert.fail(testData.get("SKUID") + " Product is not available");
			}
			click(pdp.getAddToCart(), "Add to Cart");
			click(minicart.getContinueShopping(), "Continue shopping");
		}
	}

	public static void countrySelection(String name) {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		click(home.getHomeCountry(), "Default Country");
		for (WebElement ele : home.getCountriesList()) {

			if (getText(ele).equalsIgnoreCase(name)) {
				click(ele, getText(ele));
				break;
			}
		}
		selectedCountry = home.getHomeCountry().getText();
		System.out.println("Execution Country is " + selectedCountry);
		UIFunctions.closeSignUp();
	}

	public static void selectCountry(String name) {

		switch (name.toUpperCase()) {
		case "US":
			// countrySelection("United States");
			break;
		case "CANADA":
			countrySelection("Canada");
			break;
		case "KOREA":
			countrySelection("Korea");
			break;
		default:
			countrySelection("United States");
			break;
		}

	}

	public static void payPalCheckout(String sheet, String testCase) {
		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);
		String value = getText(mainCart.getEstimatedTotalRegistered()); // use this for registered user
		// String value = getText(mainCart.getEstimatedTotal()); //use this for Guest
		// users
		System.out.println(value);
		Double dValue = Double.valueOf(value.replace("$", ""));
		if (dValue.intValue() >= 100) {
			click(paypal.getPayPalAnother(), "PayPal");
		} else {

			click(paypal.getPayPal(), "PayPal");
		}
		input(paypal.getPayPalEmail(), testData.get("EmailID"), "EmailID");
		click(paypal.getNext(), "Next");
		input(paypal.getPayPalPassword(), testData.get("Password"), "Password");
		click(paypal.getLogin(), "Login");
		domClick(paypal.getVisax111(), "Select Visa");
		click(paypal.getPaypalContinue(), "Continue");
		click(paypal.getPaypalCheckout(), "Checkout");
	}

	public static void waitForContinueToEnable() {
		
		do {
			delay(2000);	
		} while (singlePage.isContinueDisabled().isDisplayed());
	}
}
