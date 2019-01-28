package com.tumi.testcases;


import java.util.Map;

import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;


/**
 * @author Shwetha Capo
 *
 */
public class TumiLogin extends GenericMethods {

	public Map<String, String> testData = ReadTestData.retrieveData("Login", "TumiLogin");

	@Test
	public void verifyLogin() throws InterruptedException {
		
		
		UIFunctions.closeSignUpForUsProd();
		//click(home.getSelectCountryUS(), "Select US country");
		click(home.getSelectCountry(), "US country");
		click(home.getSelectCountry(), "Korea");
		delay(3000);
		
		login("Login", "TumiLogin");
		click(home.getCloseMyAccount(), "Close my account window");	
	}
}
