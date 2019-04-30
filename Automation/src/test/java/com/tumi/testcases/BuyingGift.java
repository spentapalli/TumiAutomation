package com.tumi.testcases;

import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class BuyingGift extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");

	@Test(priority = 0, description = "TA-282 Verify SmartGift/ Buying a Gift")
	public void verifySmartGiftOrBuyingGift() {

		UIFunctions.addProduct("TumiTestData", "Products", "SmartGiftSKUID");
		
		smartGiftRedirection();

		assertTrue(home.getExperienceYourGift().isDisplayed(), "Experience Your Gift is not Displayed");

		webclick(home.getExperienceYourGift(), "Experience Your Gift");

		assertTrue(home.getYourGiftPreview().isDisplayed(), "Your Gift Preview is not Displayed");

		mouseHover(home.getCustomizeGift());
		mouseHover(home.getAcceptThisGift());
		mouseHover(home.getExchangeGift());

		webclick(home.getGoBackButton(), "Go Back");
		delay(5000);
		driver.switchTo().activeElement();
		
		try {
			if(home.getPopUp().isDisplayed()) {
				
				webclick(home.getClosePopUp(), "PopUp Close Button");
			
			}
		} catch (Exception e) {
			Assert.fail("Go Back Button is not working");
		}
		
		UIFunctions.closeSignUp();
		UIFunctions.selectCountry();
		
		UIFunctions.addProduct("TumiTestData", "Products", "SmartGiftSKUID");

		smartGiftRedirection();

		webclick(home.getLetsGoButton(), "Let's Go");

		assertTrue(home.getPrepareYourGiftHeader().isDisplayed(), "Prepare Your Gift redirection unsuccess");

		input(home.getFirstName(), testData.get("FirstName"), "First Name");
		input(home.getLastName(), testData.get("LastName"), "First Name");
		input(home.getEmail(), testData.get("EmailID"), "Email");
		input(home.getPhoneNo(), testData.get("Phone"), "Phone");
		input(home.getTheirFirstName(), testData.get("FirstName"), "Their First Name");
		input(home.getTheirLasttName(), testData.get("LastName"), "Their First Name");

		webclick(home.getNextButton(), "Next");

		assertTrue(home.getReviewYourInfotHeader().isDisplayed(), "Review Your Information redirection unsuccess");

		webclick(home.getGoBackButton(), "Go Back");

		assertTrue(home.getPrepareYourGiftHeader().isDisplayed(), "Prepare Your Gift redirection unsuccess");

		webclick(home.getNextButton(), "Next");

		webclick(home.getConfirmButton(), "Confirm");
		
		webclick(home.getPreviewYourGiftButton(), "Preview Your Gift");
		
		driver.switchTo().activeElement();

		webclick(home.getClickToReveal(), "Click to reveal");

	}

	public static void smartGiftRedirection() {

		click(home.getBuyingGift(), "Buying A Gift?");
		explicitWait(home.getExperienceYourGift());
		String tabName = driver.getTitle();

		if (tabName.equalsIgnoreCase("SmartGift - How it works")) {

			logger.log(Status.INFO, "SmartGift redirection is success");
			
		} else {

			Assert.fail("User is redirected to " + tabName);
		}
	}
}
