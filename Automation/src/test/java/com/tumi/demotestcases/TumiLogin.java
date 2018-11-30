package com.tumi.demotestcases;


import java.util.Map;
import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

public class TumiLogin extends GenericMethods {

	public Map<String, String> testData = ReadTestData.retrieveData("Login", "TumiLogin");

	@Test
	public void verifyLogin() throws InterruptedException {
		
		TumiLibs.closeSignUpForUS();
		// click on login window
		/*click(login.getLoginWindow(), " click on Login");
		// enter username
		input(login.getLoginUsername(), testData.get("EmailID"), "User Name");
		// enter password
		input(login.getLoginPassword(), testData.get("Password"), "Password");
		// click on SignIn
		click(login.getLogOn(), "click on SignIn");	*/
		login("Login", "TumiLogin");
		click(home.getCloseMyAccount(), "Close my account window");


		
	}
}
