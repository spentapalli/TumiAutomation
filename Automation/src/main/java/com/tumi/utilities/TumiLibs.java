package com.tumi.utilities;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.webPages.HomePage;
import com.tumi.webPages.OrderReviewPage;

public class TumiLibs extends GenericMethods {

	public static void closeSignUp() {
		try {
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			try {
				home.getSignupPopup().click();
			} catch (Exception e) {
				logger.log(Status.INFO, "SignUp Window is Already Closed");
			}
		} catch (Exception e) {
			logger.log(Status.INFO, "SignUp Window is Not Displayed");
		}
	}

	public static void closeSignUpForUS() {
		try {
			home.getSignupPopup().click();
		} catch (Exception e) {
			logger.log(Status.INFO, "Sign Up Pop Up is not displayed for US");
		}
		try {
			home.getCASignupPopup().click();
		} catch (Exception e) {
			logger.log(Status.INFO, "Sign Up Pop Up is not displayed for CANADA");
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

		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);

		input(home.getSearchProduct(), testData.get("SKUID"), "Search Product");
		keyEnter(home.getSearchProduct());
	}

	public static void addMonochrome(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);

		mouseHover(mono.getComplimentaryMono());
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

	public static void completeOrder(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);

		click(mainCart.getProceedToCheckout(), "Cart");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email");
		click(singlePage.getContinueAsGuest(), "Continue As Guest");
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address line1");
		delay(2000);
		for (WebElement ele : shipping.getListAddressLine1()) {
			if (getText(ele).equals("1001 6Th Ave Ph 1, New York NY 10018")) {
				click(ele, "AddressList");
				break;
			}
		}
		input(shipping.getPostcode(), testData.get("PostCode"), "Post code");
		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
		click(shipping.getContinueShippingMethod(), "Continue shipping Method");
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		TumiLibs.addCardDetails("PlaceOrder", "TumiOrderKR");
		click(review.getPlaceOrder(), "Place Order");
		delay(4000);
		captureOrderConfScreen("OrderConfirmation");
	}

	public static void addGiftMessage(String sheet, String testCase) {
		
		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);

		click(gift.getCheckMessage(), "Check Message");
		input(gift.getRecipientName(), testData.get("RecipientName"), "Recipients name");
		input(gift.getSenderName(), testData.get("SenderName"), "Sender name");
		input(gift.getAddMessage(), testData.get("Message"), "Message");
	}

	public static void addGiftBox() {
		click(gift.getCheckPremiumGift(), "Premium GiftBox");
	}

}
