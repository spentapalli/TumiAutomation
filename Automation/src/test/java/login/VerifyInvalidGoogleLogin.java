

package login;

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
	
	/* TA-
	 * Verify in-valid Login with Google Account by giving wrong credentials.
	 * */

	@Test
	public void verifyInvalidGoogleLogin() throws InterruptedException {

		TumiLibs.closeSignUpForUS();
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
			Assert.fail(getProperty("google.passwordError"));
		}

		softAssertEquals(getText(google.getPasswordError()), getProperty("google.passwordError"));
		softAssertEquals(getText(google.getPasswordBlank()), getProperty("google.passwordBlank"));
		softAssertEquals(getText(google.getEmailBlankError()), getProperty("google.emailBlankError"));
		softAssertEquals(getText(google.getEmailError()), getProperty("google.emailError"));
		softAssertEquals(getText(google.getEmailNotFound()), getProperty("google.emailnotFound"));

	}

}
