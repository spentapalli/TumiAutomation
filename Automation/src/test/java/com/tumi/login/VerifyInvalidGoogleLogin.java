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

		TumiLibs.closeSignUpForUS();
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
		
			softAssertEquals(getText(google.getPasswordError()), getProperty("google.passwordError"));
			softAssertEquals(getText(google.getPasswordBlank()), getProperty("google.passwordBlank"));
			softAssertEquals(getText(google.getEmailBlankError()), getProperty("google.emailBlankError"));
			softAssertEquals(getText(google.getEmailError()), getProperty("google.emailError"));
			softAssertEquals(getText(google.getEmailNotFound()), getProperty("google.emailnotFound"));

		
	}

}
