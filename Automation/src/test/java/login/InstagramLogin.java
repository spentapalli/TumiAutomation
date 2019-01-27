//TA-78 :Verify Login with Instagram Account-- functionality issue.
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

	

	@Test(priority=0)
	public void verifyInstaValidLogin(){
		UIFunctions.closeSignUpForUS();
		instaLogin("Login", "InstagramLogin");
		/*String parentHandle = driver.getWindowHandle(); 
		driver.switchTo().window(parentHandle);*/
		delay(2000);
		if(myacc.getSignout().isEnabled()) {
			click(myacc.getSignout(),"Signout");
		}
	}

	@Test(priority=1)
	public void inValidInstaLogin(){
		//TumiLibs.closeSignUpForUS();
		instaLogin("Login", "VerifyInvalidInstaLogin");
		delay(4000);
		verifyAssertEquals(getText(insta.getPasswordErr()), getProperty("insta.passwordError"));
	}
	
	public void instaLogin(String sheetName, String testCaseName) {
		Map<String, String> testData = ReadTestData.retrieveData(sheetName, testCaseName);
		
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
