package com.tumi.login;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;

/**
 * @author Shwetha Capo
 *
 */
public class GoogleLogin extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "SocialNetworkDetails");

	/*
	 * TA-19 Verify valid Login with Google Account by giving valid credentials.
	 */
	@Test(description=" TA- 19 Verify valid Login with Google Account by giving valid credentials")
	public void verifyValidGoogleLogin() {

		// TumiLibs.closeSignUpForUS();
		click(home.getHeaderSignIn(), "Sign In");
		click(google.getGoogleLogin(), "Google login");
		String parentHandle = driver.getWindowHandle();
		Set<String> childs = driver.getWindowHandles();
		Iterator<String> ite = childs.iterator();
		while (ite.hasNext()) {
			String child = ite.next();
			if (!parentHandle.equals(child)) {

				driver.switchTo().window(child);
				delay(2000);
				input(google.getEmail(),testData.get("GoogleEmailID"), "gmail id");
				webclick(google.getFirstNext(), "Next");
				input(google.getPassword(), testData.get("GooglePassword"), "Password");
				webclick(google.getPasswordNext(), "password next");
				delay(2000);
				try {
					if(google.getVerifyYou().isDisplayed()) {
						click(google.getConfirmRecoveryemail(),"Confirm recovery email");
						input(google.getRecoveryEmail(),testData.get("GoogleRecoveryEmailID"), "gmail id");
						click(google.getRecoveryNext(),"Next");
					}
				} catch (Exception e) {
					
				}
			}
		}
		driver.switchTo().window(parentHandle);
		try {
			if (myacc.getSignout().isDisplayed()) {
				verifyAssertContains(getText(myacc.getWelcomeMessage()), getProperty("login.success.message"),
						"Failed to Login with Google");
				click(myacc.getSignout(), "Signout");
			}else {
				Assert.fail("Unable to login google");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
