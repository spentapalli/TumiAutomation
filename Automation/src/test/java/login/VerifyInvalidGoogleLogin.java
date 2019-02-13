package login;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class VerifyInvalidGoogleLogin extends GenericMethods {
	public Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "InValidGoogleCredentials");
	
	/* TA-162
	 * Verify in-valid Login with Google Account by giving wrong credentials.
	 * */

	@Test(description = "TA - 162 Verify in-valid Login with Google Account by giving wrong credentials.")
	public void verifyInvalidGoogleLogin() throws InterruptedException {

		UIFunctions.closeSignUp();
		click(home.getHeaderSignIn(), "SignIn");
		click(google.getGoogleLogin(), "Google login");
		String parentHandle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		input(google.getEmail(), testData.get("EmailID"), "gmail id");
		click(google.getFirstNext(), "Next");
		delay(2000);
		input(google.getPassword(), testData.get("Password"), "Password");
		click(google.getPasswordNext(), "password next");
		if(myacc.getSignout().isDisplayed()) {
			Assert.fail("signout is displayed with invalid user");
		}

		softAssertEquals(getText(google.getPasswordError()), getProperty("google.passwordError"));
		softAssertEquals(getText(google.getPasswordBlank()), getProperty("google.passwordBlank"));
		softAssertEquals(getText(google.getEmailBlankError()), getProperty("google.emailBlankError"));
		softAssertEquals(getText(google.getEmailError()), getProperty("google.emailError"));
		softAssertEquals(getText(google.getEmailNotFound()), getProperty("google.emailnotFound"));

	}

}
