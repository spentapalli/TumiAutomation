package com.tumi.footerSection;

import static org.testng.Assert.assertTrue;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class FooterSection2 extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");

	@Test(priority = 0, description = "TA-304 Verify My Account")
	public void verifyMyAccount() {

		click(home.getMyAccount(), "My Account");

		if (getText(home.getMyAccountHeader()).equalsIgnoreCase("My Account")) {

			logger.log(Status.INFO, "My Account redirection is succesful");
		}
		click(home.getCreateAnAccount(), "Create an Account");

		assertTrue(home.getMyAccountEmailBox().isDisplayed(), "Registration form is not displayed");

		domClick(home.getMyAccountCloseButton(), "My Account Close Button");
		
		userLogin("TumiTestData", "RegisteredOrders");

		click(home.getMyAccount(), "My Account");

		click(home.getMyAccountMyProfile(), "My Account My Profile");
		
		assertTrue(home.getMyProfileSurname().isDisplayed(), "My Profile form is not displayed");

	}

	@Test(priority = 1, description = "TA-305 Verify Sign In")
	public void verifySignIn() {

		click(home.getSignIn(), "Sign In");

		if (getText(home.getSignInHeader()).equalsIgnoreCase("Sign in to your TUMI.com account")) {

			logger.log(Status.INFO, "Sign In redirection is succesful");
		}
		click(home.getCreateAnAccount(), "Create an Account");

		assertTrue(home.getSignButton().isEnabled(), "SignIn button is not enabled");

		domClick(home.getMyAccountCloseButton(), "My Account Close Button");

		userLogin("TumiTestData", "RegisteredOrders");

		click(home.getSignIn(), "Sign In");

		click(home.getMyAccountMyProfile(), "My Account My Profile");

		assertTrue(home.getMyProfileSurname().isDisplayed(), "My Profile form is not displayed");
	}

	@Test(priority = 2, description = "TA-306 Verify Track Orders")
	public void verifyTrackOrders() {

		click(home.getTrackOrders(), "Track Orders");
		
		click(home.getTrackingYourOrder(), "Tracking Your Order");
		
		if (getText(home.getTrackingYourOrderHeader()).equalsIgnoreCase("TRACKING YOUR ORDER")) {

			logger.log(Status.INFO, "Track Orders redirection is success");
		}

		userLogin("TumiTestData", "RegisteredOrders");

		click(home.getTrackOrders(), "Track Orders");
		
		click(home.getFullOrderDetails(), "Track Orders");
		
		assertTrue(home.getOrderDetailsHeader().isDisplayed(), "Order Details is not displayed");

	}

	@Test(priority = 3, description = "TA-307 Verify Register Your Tumi")
	public void verifyRegisterYourTumi() {

		click(home.getRegisterYourTumi(), "Register Your Tumi");

		if (getText(home.getRegisterYourTumiHeader()).equalsIgnoreCase("TUMI TRACER REGISTRATION")) {

			logger.log(Status.INFO, "Tumi Tracer redirection is success");

		}		
		assertTrue(home.getSignInTumiTracerPage().isDisplayed(), "Sign In is not displayed");
		
		if (getText(home.getTumiTracerRegistrationHeader()).equalsIgnoreCase("TUMI TRACER REGISTRATION")) {
			
			logger.log(Status.INFO, "Tumi Tracer Registration is Displayed");
			
		}
	}
}
