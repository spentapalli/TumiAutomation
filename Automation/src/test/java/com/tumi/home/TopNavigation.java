package com.tumi.home;

import java.net.HttpURLConnection;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class TopNavigation extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "VerifyPGPFilters");
	public static HttpURLConnection huc = null;
	public static String respCode;
	public static String currenturl = "";

	/*
	 * TA-76 Verify Top Navigation.
	 */

	/*@Test(priority = 0, description = " Sprint 3- TA-342/ TA-76 Verify Location")
	public void verifyLocation() {
		if (selectedCountry.contains("US")) {
			delay(2000);
			verifyCA();
			verifyKR();
		} else if (selectedCountry.contains("Canada")) {
			delay(2000);
			verifyUS();
			verifyKR();
		} else {
			delay(2000);
			verifyUS();
			verifyCA();
		}

	}

	public void verifyUS() {

		click(home.getSelectCountry(), "Country");
		click(home.getSelectCountryUSforTop(), "US");
		String url = driver.getCurrentUrl();
		if (!url.contains("www")) {
			Assert.fail("When select US, Page couldn't navigated to US country");
		} else {
			logger.log(Status.INFO, "Country Selection of US is successfull");
		}

	}

	public void verifyCA() {

		click(home.getSelectCountry(), "Country");
		click(home.getSelectCountryCAforTop(), "Canada");
		String caUrl = driver.getCurrentUrl();
		UIFunctions.closeSignUp();
		if (!caUrl.contains("ca")) {
			Assert.fail("When select Canada, Page couldn't navigated to Canada country");
		} else {
			logger.log(Status.INFO, "Country Selection of Canada is successfull");
		}
	}

	public void verifyKR() {

		click(home.getSelectCountry(), "Country");
		click(home.getSelectCountryKRforTop(), "Korea");
		String krUrl = driver.getCurrentUrl();
		UIFunctions.closeSignUp();
		if (!krUrl.contains("kr")) {
			Assert.fail("When select Korea, Page couldn't navigated to Korea country");
		} else {
			logger.log(Status.INFO, "Country Selection of Korea is successfull");
		}

	}

	@Test(priority = 1, description = " Sprint 3- TA-343/ TA-76 Verify Language Selector")
	public void verifyLanguageSelector() {

		click(home.getSelectLanguage(), "Language");
		click(home.getSelectSpanishLanguage(), "Spanish");
		try {
			if (!getText(home.getSelectLanguageContainer()).contains("English")||!home.getHeaderFindStore().isDisplayed()) {
				logger.log(Status.INFO, "Selection of Sapnish language is successfull");
			}
		} catch (Exception e) {
			Assert.fail("Page couldn't displayed in Sapnish language");
		}
		click(home.getSelectLanguageContainer(), "Language");
		click(home.getSelectFrenchLanguage(), "French");
		try {
			if (!getText(home.getSelectLanguageContainer()).contains("English")||!home.getHeaderFindStore().isDisplayed()) {
				logger.log(Status.INFO, "Selection of French language is successfull");
			}
		} catch (Exception e) {
			Assert.fail("Page couldn't displayed in French language");
		}
		
	}

	@Test(priority = 2, description = " Sprint 3- TA-344/ TA-76 Verify Find A	 Store")
	public void verifyFindAStore() {

		click(home.getHeaderFindStore(), "Store Finder");
		String url = driver.getCurrentUrl();

		if (url.contains("store-finder")) {
			logger.log(Status.INFO, "Valid store Finder url navigation is successfull");
		} else {
			Assert.fail("Valid Store finder url navigation is unsuccessfull");
		}
		if (!home.getSelectLocation().isDisplayed()) {
			Assert.fail("Valid Store finder url navigation is unsuccessfull");
		}

	}

	@Test(priority = 5, description = " Sprint 3- TA-345/ TA-76 Verify	 CustomerService")
	public void verifyCustomerService() {

		click(home.getHeaderCustomerService(), "Customer Service");
		HomePageVerification.verifyHomePageResponse();
	}*/

	@Test(priority = 4, description = " Sprint 3- TA-346/ TA-76 Verify SignIn")
	public void verifySignIn() {
		click(home.getHeaderSignIn(), "SignIn");
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			if (!getText(myacc.getMyAccMsg()).contains("My Account")) {
				Assert.fail("My Account window not opened");
			}
		} else {
			if (!myacc.getKrEnterEmail().isDisplayed()) {
				Assert.fail("My Account window not opened");
			}
		}
		if (home.getUserName().isDisplayed()) {
			logger.log(Status.INFO, "Login window opened successfully");
		}
		click(home.getCloseMyAccountBefore(), "Close My Account");

	}

	//@Test(priority = 5, description = " Sprint 3- TA-347/ TA-76 Verify Search")
	// // pending
	public void verifySearch() {
		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");

		// by using product/ collection name
		UIFunctions.searchProducts(1, testData.get("ProductName"));

		// using SKUID
		input(home.getSearchProduct(), testData.get("SKUID"), "Search Product");
		keyEnter(home.getSearchProduct());
		verifyAssertContains(driver.getCurrentUrl(), testData.get("SKUID"), "Wrong Product is displayed");
		String result = getText(pgp.getResultCount());
		int resultCount = Integer.parseInt(result.replaceAll("\\D", ""));
		if (resultCount == 1) {
			click(pgp.getResultImageWithSku(), "Result SKUID");
			logger.log(Status.INFO, "Exact Result Match with Searching SKUID is successfull");
		}
		try {
			if (pdp.getAddToCart().isDisplayed()) {

				verifyAssertEquals("Add To Cart", getText(pdp.getAddToCart()));
				logger.log(Status.INFO, "Product is available");
			}
		} catch (Exception e) {
			Assert.fail(testData.get("SKUID") + " Product is not available");
		}

	}

}
