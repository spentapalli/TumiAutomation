package login;

import java.util.*;

import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 *
 */
public class GoogleLogin extends GenericMethods {
	Map<String, String> testData = ReadTestData.retrieveData("Login", "GoogleLogin");

	/*
	 * TA-77 Verify valid Login with Google Account by giving valid credentials.
	 */
	@Test
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
				click(google.getFirstNext(), "Next");
				input(google.getPassword(), testData.get("Password"), "Password");
				click(google.getPasswordNext(), "password next");
				/*
				 * Write the code here for confirm your recover email and finally use
				 * 
				 * driver.switchTo().window(child).close();
				 */
			}
		}
		driver.switchTo().window(parentHandle);
		try {
			if (myacc.getSignout().isDisplayed()) {
				verifyAssertContains(getText(myacc.getWelcomeMessage()), getProperty("login.success.message"),
						"Faile to Login with Google");
				click(myacc.getSignout(), "Signout");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
