package com.tumi.utilities;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.webPages.HomePage;

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
			click(home.getSignupPopup(), "Close SignUp Window");
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
		if (guestBillPage.getReviewOrder().isEnabled()) {
			Assert.fail("Able to Proceed Order with invalid details");
		}
	}

	public static int shoppingCartCount() {
		String cartItems = getText(pdp.getShoppingCart()).replace("(", "").replace(")", "").replaceAll("\\s", "");
		int cartCount = (int) cartItems.charAt(cartItems.length() - 1);
		return cartCount;
	}

}
