//TestCase : Confirm "Instagram" login is succesful on clicking Instagram and entering Email OR Phone & password

package login;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 *
 */
public class InstagramLogin extends GenericMethods {

	public Map<String, String> testData = ReadTestData.retrieveData("Login", "InstagramLogin");

	@Test
	public void verifyInstaLogin() throws InterruptedException {
		
		TumiLibs.closeSignUpForUS();
		click(home.getHeaderSignIn(), "SignIn");

		String parentHandle = driver.getWindowHandle(); // get the current window handle
		click(insta.getInsta(), "Instagram");
		delay(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's
													// your newly opened window)
		}
		// code to do something on new window

		input(insta.getInstaUsername(), testData.get("EmailID"), "Username");
		input(insta.getInstaPassword(), testData.get("Password"), "Password");
		click(insta.getInstaLogin(), "Login");
		delay(2000);
		driver.switchTo().window(parentHandle);

	}
}
