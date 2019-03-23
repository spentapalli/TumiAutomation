
   
package com.tumi.login;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;

/**
 * @author Shwetha Capo
 *
 */
public class RegularLogin extends GenericMethods {
	/* 
	 * TA-26: Confirm Regular login is successful on clicking Sign In and Entering Valid Email address & Password
	 * TA-58 : Verify Tumi Login Fail, with wrong credentials
	 */

	
	@Test(priority = 0, description="TA-26: Verify Login with Tumi account")
	public void verifyValidLogin() {

		userLogin("TumiTestData", "RegisteredOrders");
		/*try {
			if (myacc.getSignout().isDisplayed()) {
				verifyAssertContains(getText(myacc.getWelcomeMessage()), getProperty("login.success.message"),
						"Successfully logged with Regular user valid credentials");
				click(myacc.getSignout(), "Signout");
			}else {
				Assert.fail("user signin is failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}

