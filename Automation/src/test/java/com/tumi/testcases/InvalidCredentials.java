package com.tumi.testcases;

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

	public Map<String, String> testData = ReadTestData.retrieveData("PlaceOrder", "InValidCredentials");

	@Test
	public void verifyInvalidUserMessage() {

		TumiLibs.closeSignUpForUsProd();
		click(home.getSelectCountry(), "US country");
		click(home.getSelectCountry(), "Korea");
		delay(3000);
		login("Login", "InValidCredentials");
		verifyAssertEquals(getText(home.getInvalidCredentialsError()),
				getProperty("home.invalidCredentials"));

	}

}
