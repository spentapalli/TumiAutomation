package com.tumi.demotestcases;


import java.util.Map;

import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;


/**
 * @author Shwetha Capo
 *
 */
public class TumiLogin extends GenericMethods {

	public Map<String, String> testData = ReadTestData.retrieveData("Login", "TumiLogin");

	@Test
	public void verifyLogin() throws InterruptedException {
		
		
		TumiLibs.closeSignUpForUsProd();
		//click(home.getSelectCountryUS(), "Select US country");
		click(home.getSelectCountryUS(), "Select US country");
		click(home.getSelectUS(), "click US");
		delay(3000);
		
		login("Login", "TumiLogin");
		click(home.getCloseMyAccount(), "Close my account window");


		
		
	}
}
