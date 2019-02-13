//TA-18 :Verify Login with Instagram Account-- functionality issue.
//TA    :Verify InLogin with Instagram Account-- functionality issue

package login;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class InstagramLogin extends GenericMethods {

	/* TA-18 :
	 * Verify Login with Instagram Account-- functionality issue
	 * 
	 */

	@Test(priority=0, description="TA-18 :Verify Login with Instagram Account")
	public void verifyInstaValidLogin(){
		instaLogin("TumiTestData", "InstagramLogin");
		/*String parentHandle = driver.getWindowHandle(); 
		driver.switchTo().window(parentHandle);*/
		delay(2000);
		if(myacc.getSignout().isEnabled()) {
			click(myacc.getSignout(),"Signout");
		}
	}
	
	public void instaLogin(String sheetName, String testCaseName) {
		Map<String, String> testData = ReadTestData.getJsonData(sheetName, testCaseName);
		
		click(home.getHeaderSignIn(), "SignIn");
		String parentHandle = driver.getWindowHandle(); 
		click(insta.getInsta(), "Instagram");
		delay(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); 
		}
		input(insta.getInstaUsername(), testData.get("EmailID"), "Username");
		input(insta.getInstaPassword(), testData.get("Password"), "Password");
		click(insta.getInstaLogin(), "Login");
		driver.switchTo().window(parentHandle);
	}

}
