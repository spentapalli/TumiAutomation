//TestCase : Confirm for Blank of any one of the Email & password field should display alert message for Google login -  N

package com.tumi.login;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;


/**
 * @author Shwetha Capo
 *
 */
public class VerifyInvalidGoogleLogin extends GenericMethods {
	public Map<String, String> testData = ReadTestData.retrieveData("Login", "InValidCredentials");

	@Test
	public void verifyInvalidGoogleLogin() throws InterruptedException {

		/*TumiLibs.closeSignUpForUsProd();
		click(home.getSelectCountryUS(), "Select US country");
		click(home.getSelectUS(), "click US");
		delay(4000);

		if (google.getNoThanks().isDisplayed()) {
			click(google.getNoThanks(), "offers popup");
		}*/

		click(home.getHeaderSignIn(), "SignIn");

		/*
		 * System.out.println("the parent window handler id is"+pwindow);
		 * System.out.println("before switch to other window, the title is"+driver.
		 * getTitle());
		 */
		String parentHandle = driver.getWindowHandle();
		click(google.getGoogleLogin(), "Google login");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		input(google.getEmail(), testData.get("EmailID"), "gmail id");
		click(google.getFirstNext(), "Next");
		delay(2000);
		input(google.getPassword(), testData.get("Password"), "Password");
		click(google.getPasswordNext(), "password next");
		
		if(myacc.getSignout().isDisplayed()) {
			Assert.fail("verifying Invalid google login failed");
		}
		//verifyAssertEquals(getText(home.getInvalidCredentialsError()),
				getProperty("home.invalidCredentials");

	}

}
