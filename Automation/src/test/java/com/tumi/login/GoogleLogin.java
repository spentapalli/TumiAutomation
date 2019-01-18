//TestCase : Confirm Gmail login is successful on clicking "Google" and entering valid Email & password

package com.tumi.login;
import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 *
 */
public class GoogleLogin extends GenericMethods {
	// private static final Logger LOG = Logger.getLogger(GoogleLogin.class);
	public Map<String, String> testData = ReadTestData.retrieveData("Login", "GoogleLogin");
	public Map<String, String> testData1 = ReadTestData.retrieveData("Login", "InValidCredentials");

	@Test(priority = 0)
	public void verifyGoogleLogin() {
		
		TumiLibs.closeSignUpForUS();
		//click(home.getHeaderSignIn(), "SignIn");
		//click(google.getGoogleLogin(), "Google login");
		String parentHandle = driver.getWindowHandle();
		//click(google.getGoogleLogin(), "Google login");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		userGoogleAccount(testData.get("EmailID"));
		
		driver.switchTo().window(parentHandle);
		verifyAssertContains(getText(myacc.getWelcomeMessage()), getProperty("login.success.message"), "D");
		/*
		 * if(myacc.getWelcomeMessage().getText().contains("Welcome back")) {
		 * System.out.println("login suucessfull");
		 * 
		 * }
		 */
	}


	@Test(priority = 1)
	public void GoogleLoginValidation() {

		String parentHandle = driver.getWindowHandle();
		//click(google.getGoogleLogin(), "Google login");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		userGoogleAccount(testData1.get("EmailID"));
		if (myacc.getSignout().isDisplayed()) {
			Assert.fail("verifying Invalid google login failed");
		}
		softAssertEquals(getText(home.getInvalidCredentialsError()), getProperty("home.invalidCredentials"));
		softAssertEquals(getText(google.getEmailBlankError()), getProperty("home.emailBlankError"));
		softAssertEquals(getText(google.getEmailError()), getProperty("home.emailError"));
		softAssertEquals(getText(google.getPasswordBlank()), getProperty("home.passwordBlank"));
		softAssertEquals(getText(google.getPasswordError()), getProperty("home.passwordError"));

	}

	public void userGoogleAccount(String data) {
		click(home.getSelectCountryUS(), "Select US country");
		click(home.getSelectUS(), "click US");
		delay(4000);

		if (google.getNoThanks().isDisplayed()) {
			click(google.getNoThanks(), "offers popup");
		}

		click(home.getHeaderSignIn(), "Sign In");
		click(google.getGoogleLogin(), "Google login");
		input(google.getEmail(), data, "gmail id");
		click(google.getFirstNext(), "Next");
		input(google.getPassword(), testData.get("Password"), "Password");
		click(google.getPasswordNext(), "password next");

	}

}
