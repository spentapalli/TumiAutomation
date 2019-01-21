package com.tumi.bindu;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.TumiLibs;

public class LoginFailed  extends GenericMethods{
		public Map<String, String> testData = ReadTestData.retrieveData("Login", "Tumilogin");
		
		@Test
		public void Verifylogin() {

			
			TumiLibs.closeSignUpForUsProd();
			click(home.getSelectCountryUS(), "Select US country");
			click(home.getSelectUS(), "click US");
			delay(3000);
			if (google.getNoThanks().isDisplayed()) {
				click(google.getNoThanks(), "offers popup");
			}
			
			login("Login", "TumiLogin");
			click(home.getCloseMyAccount(), "Close my account window");

			
			
		}
	


}

