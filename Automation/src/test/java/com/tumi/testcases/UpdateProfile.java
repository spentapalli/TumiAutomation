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
public class UpdateProfile extends GenericMethods{

	public Map<String, String> testData = ReadTestData.retrieveData("Login", "UpdateProfile");
	
	@Test
	public void testUpdateProfile(){
		
		TumiLibs.closeSignUpForUsProd();
		click(home.getSelectCountry(), "US country");
		click(home.getSelectCountry(), "Korea");
		delay(3000);
		
		 //click on login window
		login("Login", "UpdateProfile");
	    
		//click on view my profile from MyAccount page
		click(myacc.getViewProfile(), "View Profile");
		
		//update profile name
		input(profile.getName(), testData.get("name"), "First name");
		input(profile.getPhone(),testData.get("Phone"), "Phone Number");
		click(profile.getNotifications(),"notifications");
		//click on save
		click(profile.getSave(), "Save Update");		
	}
}
