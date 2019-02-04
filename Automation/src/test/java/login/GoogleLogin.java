package login;

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
	Map<String, String> testData = ReadTestData.retrieveData("Login", "GoogleLogin");

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
				input(google.getEmail(), testData.get("EmailID"), "gmail id");
				webclick(google.getFirstNext(), "Next");
				input(google.getPassword(), testData.get("Password"), "Password");
				webclick(google.getPasswordNext(), "password next");
				driver.close();
			}
		}
		driver.switchTo().window(parentHandle);
		try {
			if (myacc.getSignout().isDisplayed()) {
				verifyAssertContains(getText(myacc.getWelcomeMessage()), getProperty("login.success.message"),
						"Faile to Login with Google");
				click(myacc.getSignout(), "Signout");
			}else {
				Assert.fail("Google Login Unsuccessful");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
