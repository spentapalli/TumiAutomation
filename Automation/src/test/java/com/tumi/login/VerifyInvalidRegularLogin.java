

package com.tumi.login;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;


/**
 * @author Shwetha Capo
 *
 */
public class VerifyInvalidRegularLogin extends GenericMethods {
	
	public Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "SocialNetworkDetails");
	
	/*TA-58 : 
	Verify Tumi Login Fail, with wrong credentials
	*/

	@Test(priority = 1, description = "TA-58 : Verify Tumi Login Fail, with wrong credentials")
	public void verifyInvalidUserMessage() {

		try {

			click(home.getHeaderSignIn(), "Sign In");
			input(home.getUserName(), testData.get("EmailID"), "Email Address");
			input(home.getPassWord(), testData.get("Password"), "Password");
			click(home.getLogOn(), "Login");
			if (!myacc.getSignout().isDisplayed()) {
				logger.log(Status.INFO, "User not able to logged in with invalid credentials ");
			}
			
		} catch (Exception e) {
			Assert.fail("user able to logged in with invalid credentials");
		}
		
	//	Assert.fail(getProperty("home.invalidCredentials"));
		

	}

}
