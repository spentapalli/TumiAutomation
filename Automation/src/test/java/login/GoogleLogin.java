
 

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
	Map<String, String> testData = ReadTestData.retrieveData("Login", "GoogleLogin");
	
	/* TA-77
	 * Verify valid Login with Google Account by giving valid credentials.
	 * */
	
	@Test
	public void verifyValidGoogleLogin() {
		
		TumiLibs.closeSignUpForUS();
		click(home.getHeaderSignIn(), "Sign In");
		click(google.getGoogleLogin(), "Google login");
		String parentHandle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		input(google.getEmail(), testData.get("EmailID"), "gmail id");
		click(google.getFirstNext(), "Next");
		input(google.getPassword(), testData.get("Password"), "Password");
		click(google.getPasswordNext(), "password next");
		driver.switchTo().window(parentHandle);
		if(myacc.getSignout().isDisplayed()) {
			verifyAssertContains(getText(myacc.getWelcomeMessage()), getProperty("login.success.message"), "D");
			click(myacc.getSignout(),"Signout");
		}
		
	}

}
