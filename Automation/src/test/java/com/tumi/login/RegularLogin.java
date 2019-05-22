
   
package com.tumi.login;

import org.testng.annotations.Test;
import com.tumi.utilities.GenericMethods;

/**
 * @author Shwetha Capo
 *
 */
public class RegularLogin extends GenericMethods {
	/* 
	 * TA-26: Confirm Regular login is successful on clicking Sign In and Entering Valid Email address & Password
	 * 
	 */

	
	@Test(priority = 0, description="TA-26: Verify Login with Tumi account")
	public void verifyValidLogin() {

		userLogin("TumiTestData", "RegisteredOrders");
		
	}

}

