package com.tumi.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;

public class ShippingPageSingleItem extends GenericMethods {
	Map<String, String> testdata = ReadTestData.getJsonData("TumiTestData", "GuestDetails");

	/*
	 * TA - 61, Verify Shipping Page-Single item-Guest/Register User.
	 */

	@Test(priority = 0, description = "TA-439, verify shipping to different location- only for Guest User")
	public void verifyShiptoDiffLoc() {
		SinglePageCheckout.goToSinglePage();
		input(singlePage.getEmailAddress(), testdata.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		delay(2000);
		domClick(shipping.getShiptoDiffLoc(), "Ship to different location");
		String url = driver.getCurrentUrl();
		if (url.contains("country/select") || shipping.getShiptoDiffLocMsg().isDisplayed()) {
			logger.log(Status.PASS,
					"When clicking on 'Ship to Different Location, successfully navigated to Country selection page");
			delay(2000);
			if (selectedCountry.contains("US")) {
				click(shipping.getSelectCanada(), "Canada");
				if (driver.getCurrentUrl().contains("ca") && driver.getCurrentUrl().contains("cart")) {
					logger.log(Status.PASS, "After selecting Canada, successfully page navigated to Canada Cart page");
				} else if (driver.getCurrentUrl().equals("https://ca.hybris-stage2.tumi.com")) {
					logger.log(Status.INFO, "Either Product is in out of stock or Not available in Canada");
				} else
					Assert.fail("After selecting Canada, page couldn't navigated to Canada Cart page");
			} else if (selectedCountry.contains("Canada")) {
				webclick(shipping.getSelectKorea(), "Korea");
				if (driver.getCurrentUrl().contains("kr") && driver.getCurrentUrl().contains("cart")) {
					logger.log(Status.PASS, "After selecting Korea, successfully page navigated to Korea Cart page");
				} else if (driver.getCurrentUrl().equals("https://kr.hybris-stage2.tumi.com")) {
					logger.log(Status.INFO, "Either Product is in out of stock or Not available in Korea");
				} else {
					Assert.fail("After selecting Korea, page couldn't navigated to Korea Cart page");
				}
			} else {
				click(shipping.getSelectUS(), "US");
				if (driver.getCurrentUrl().contains("www") && driver.getCurrentUrl().contains("cart")) {
					logger.log(Status.PASS, "After selecting US, successfully page navigated to US Cart page");
				} else if (driver.getCurrentUrl().equals("https://www.hybris-stage2.tumi.com")) {
					logger.log(Status.INFO, "Either Product is in out of stock or Not available in US");
				} else {
					Assert.fail("After selecting US, page couldn't navigated to US Cart page");
				}

			}
		} else {
			Assert.fail(
					"When clicking on 'Ship to Different Location, Page coudln't navigated to Country selection page");
		}
	}
	
	@Test(priority = 1, description = "TA-440, Verify Sign-In for Guest Users "+ "TA-441, verify Add new address on Shipping page for Registered USer.")
	public void verifySignIn() {
		SinglePageCheckout.goToSinglePage();
		input(singlePage.getEmailAddress(), testdata.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		BillingPage.loginAfterCart("TumiTestData", "RegisteredOrders");
		//userLogin("TumiTestData", "RegisteredOrders");
		domClick(shipping.getAddNewAddress(),"Add New Address");
		if(shipping.getShipAddressForm().isEnabled()) {
			logger.log(Status.PASS, "When click Add New Address, it is allowing to add another address");
		}else {
			logger.log(Status.INFO, "When click Add New Address, deails are not displayed to add another address");
		}
	}

}
