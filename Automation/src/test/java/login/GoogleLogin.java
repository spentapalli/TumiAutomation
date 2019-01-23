//TestCase : Confirm Gmail login is successful on clicking "Google" and entering valid Email & password

package login;

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

	/*
	 * Suuresh - Observations Reading Test Data SheetName and TestCaseName are not
	 * available in excel
	 * 
	 * At Priority = 0 - Call userGoogleAccount i.e. called that method in 35 line
	 * Update google page locators
	 * 
	 * Verification of google offers should be surrender with try catch
	 * 
	 */

	// private static final Logger LOG = Logger.getLogger(GoogleLogin.class);
	public Map<String, String> testData = ReadTestData.retrieveData("Login", "GoogleLogin");
	public Map<String, String> testData1 = ReadTestData.retrieveData("Login", "InValidCredentials");

	@Test(priority = 0)
	public void verifyGoogleLogin() {
		TumiLibs.closeSignUpForUS();
		TumiLibs.signInWithGoogle("Login", "GoogleLogin");
		// click(home.getHeaderSignIn(), "SignIn");
		// click(google.getGoogleLogin(), "Google login");
		String parentHandle = driver.getWindowHandle();
		// click(google.getGoogleLogin(), "Google login");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		TumiLibs.signInWithGoogle("Login", "GoogleLogin");

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

		// click(google.getGoogleLogin(), "Google login");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		TumiLibs.signInWithGoogle("Login", "InValidCredentials");
		if (myacc.getSignout().isDisplayed()) {
			Assert.fail("verifying Invalid google login failed");
		}
		softAssertEquals(getText(home.getInvalidCredentialsError()), getProperty("home.invalidCredentials"));
		softAssertEquals(getText(google.getEmailBlankError()), getProperty("home.emailBlankError"));
		softAssertEquals(getText(google.getEmailError()), getProperty("home.emailError"));
		softAssertEquals(getText(google.getPasswordBlank()), getProperty("home.passwordBlank"));
		softAssertEquals(getText(google.getPasswordError()), getProperty("home.passwordError"));

	}
}
