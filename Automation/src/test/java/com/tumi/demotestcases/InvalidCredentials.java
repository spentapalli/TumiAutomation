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
public class InvalidCredentials extends GenericMethods {

	public Map<String, String> testData = ReadTestData.retrieveData("Login", "InValidCredentials");

	@Test
	public void verifyInvalidUserMessage() {

		TumiLibs.closeSignUpForUsProd();
		click(home.getSelectCountryUS(), "Select US country");
		click(home.getSelectUS(), "click US");
		delay(3000);
		login("Login", "InValidCredentials");
		verifyAssertEquals(getText(home.getInvalidCredentialsError()),
				repository("home.invalidCredentials"));

	}

}
