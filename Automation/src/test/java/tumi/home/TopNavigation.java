package tumi.home;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mongodb.diagnostics.logging.Logger;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class TopNavigation extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData","VerifyPGPFilters");
	public static HttpURLConnection huc = null;
	public static String respCode;
	public static String currenturl = "";

	/*
	 * TA-76 Verify Top Navigation.
	 */

	//@Test(priority = 0, description = " Sprint 3- TA-342/ TA-76 Verify Location")
	public void verifyLocation() {
		if(selectedCountry.contains("US")) {
			delay(2000);
			verifyCA();
			verifyKR();
		}else if(selectedCountry.contains("Canada")) {
			delay(2000);
			verifyUS();
			verifyKR();
		}else {
			delay(2000);
			verifyUS();
			verifyCA();
		}

	}
	public void verifyUS() {
		click(home.getSelectCountry(), "select country");

		click(home.getSelectCountryUSforTop(), " selected US");

		String url = driver.getCurrentUrl();

		if (!url.contains(testData.get("USurl"))) {
			Assert.fail("Verification of Us country selection failed");
		} else {
			logger.log(Status.INFO, "Country Selection of US is successfull");
		}
		
	}
	public void verifyCA() {
		click(home.getSelectCountry(), "select country");
		click(home.getSelectCountryCAforTop(), "selected Canada");

		String caUrl = driver.getCurrentUrl();
		UIFunctions.closeSignUp();
		if (!caUrl.contains(testData.get("CAurl"))) {
			Assert.fail("Verification of Canada country selection failed");
		} else {
			logger.log(Status.INFO, "Country Selection of Canada is successfull");
		}
		
	}
	public void verifyKR() {
		click(home.getSelectCountry(), "select country");
		click(home.getSelectCountryKRforTop(), "selected Korea");

		String krUrl = driver.getCurrentUrl();
		UIFunctions.closeSignUp();
		if (!krUrl.contains(testData.get("KRurl"))) {
			Assert.fail("Verification of Korea country selection failed");
		} else {
			logger.log(Status.INFO, "Country Selection of Korea is successfull");
		}
		
	}

//	@Test(priority = 1, description = " Sprint 3- TA-343/ TA-76 Verify Language Selector")
	public void verifyLanguageSelector() {

		click(home.getSelectLanguage(), "Language");
		click(home.getSelectSpanishLanguage(), "Spanish");
		if (!getText(home.getSelectLanguageContainer()).contains("Español")) {
			Assert.fail("Select Sapnish language failed");
		} else {
			logger.log(Status.INFO, "Selection of Sapnish language is successfull");
		}
		click(home.getSelectLanguageContainer(), "Language");
		click(home.getSelectFrenchLanguage(), "French");
		if (!getText(home.getSelectLanguageContainer()).contains("Français")) {
			Assert.fail("Selecting french language is failed");
		} else {
			logger.log(Status.INFO, "Selection of French language is successfull");
		}

	}

	//@Test(priority = 2, description = " Sprint 3- TA-344/ TA-76 Verify Find A Store")
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

	//@Test(priority = 3, description = " Sprint 3- TA-345/ TA-76 Verify Customer Service")
	public void verifyCustomerService() {

		click(home.getHeaderCustomerService(), "Customer Service");
		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {

			currenturl = it.next().getAttribute("href");
			if (currenturl == null || currenturl.isEmpty()) {
				logger.log(Status.INFO, "URL is either not configured for anchor tag or it is empty");
				continue;
			}

			try {
				huc = (HttpURLConnection) (new URL(currenturl).openConnection());

				huc.setRequestMethod("HEAD");

				fixUntrustCertificate();

				huc.connect();

				respCode = huc.getResponseMessage();

				if (respCode.equals("OK")) {
					logger.log(Status.INFO, currenturl + "Server Response Code: " + respCode);
				} else {
					logger.log(Status.FAIL, currenturl + "Server Response Code: " + respCode);
				}
			} catch (Exception e) {
			}
		}
	}

	public static void fixUntrustCertificate() throws KeyManagementException, NoSuchAlgorithmException {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

	}

	//@Test(priority = 4, description = " Sprint 3- TA-346/ TA-76 Verify SignIn")
	  public void verifySignIn() {
		click(home.getHeaderSignIn(), "SignIn");
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			if (!getText(myacc.getMyAccMsg()).contains("My Account")) {
				Assert.fail("My Account window not opened");
			}
		} else {
			if (!getText(myacc.getMyAccMsg()).contains("내 계정")) {
				Assert.fail("My Account window not opened");
			}
		}
		// here add verification with Email text box display
		if (home.getUserName().isDisplayed()) {
			logger.log(Status.INFO, "Login window opened successfully");
		}
		click(home.getCloseMyAccountBefore(), "Close My Account");

	}

	// @Test(priority = 5, description = " Sprint 3- TA-347/ TA-76 Verify Search")	// pending
	 public void verifySearch() {
		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");

		UIFunctions.searchProducts(1, testData.get("ProductName"));

	}

}
