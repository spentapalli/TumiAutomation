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
public class VerifyInvalidInstaLogin extends GenericMethods{
	
public Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "InValidInstagramCredentials");
	
	
		/* TA-177 :
		 * Verify Login fail, with wrong Instagram Account credentials
		 * 
		 */
		@Test(priority=1,description=" TA-177 :Verify Login fail, with wrong Instagram Account credentials " )
		public void inValidInstaLogin(){
			Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "InValidGoogleCredentials");
			
			click(home.getHeaderSignIn(), "SignIn");
			click(insta.getInsta(), "Instagram");
			delay(2000);
			String parentHandle = driver.getWindowHandle();
			Set<String> childs = driver.getWindowHandles();
			Iterator<String> ite = childs.iterator();
			while (ite.hasNext()) {
				String child = ite.next();
				if (!parentHandle.equals(child)) {

					driver.switchTo().window(child);
					input(insta.getInstaUsername(), testData.get("EmailID"), "Username");
					input(insta.getInstaPassword(), testData.get("Password"), "Password");
					click(insta.getInstaLogin(), "Login");
					delay(2000);
					/*softAssertEquals(getText(insta.getInstaErr()), getProperty("insta.error"));
					softAssertEquals(getText(insta.getPasswordErr()), getProperty("insta.passwordError"));
					softAssertEquals(getText(insta.getUsernameErr()), getProperty("insta.usernameError"));*/
					
				}
			}
			
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
