package login;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
		Set<String> childs = driver.getWindowHandles();
		Iterator<String> ite = childs.iterator();
		while (ite.hasNext()) {
			String child = ite.next();
			if (!parentHandle.equals(child)) {

				driver.switchTo().window(child);
				input(google.getEmail(), testData.get("EmailID"), "gmail id");
				click(google.getFirstNext(), "Next");
				delay(2000);
				input(google.getPassword(), testData.get("Password"), "Password");
				click(google.getPasswordNext(), "password next");
			}
		}
		
		softAssertEquals(getText(google.getPasswordError()), getProperty("google.passwordError"));
		softAssertEquals(getText(google.getPasswordBlank()), getProperty("google.passwordBlank"));
		softAssertEquals(getText(google.getEmailBlankError()), getProperty("google.emailBlankError"));
		softAssertEquals(getText(google.getEmailError()), getProperty("google.emailError"));
		softAssertEquals(getText(google.getEmailNotFound()), getProperty("google.emailnotFound"));
		driver.switchTo().window(parentHandle);
		try {
			if(myacc.getSignout().isDisplayed()) {
				Assert.fail("signout is displayed with invalid user");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
