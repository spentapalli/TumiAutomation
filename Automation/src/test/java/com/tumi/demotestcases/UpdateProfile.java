package com.tumi.demotestcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

public class UpdateProfile extends GenericMethods{

	public Map<String, String> testData = ReadTestData.retrieveData("Login", "UpdateProfile");
	
	@Test
	public void updateProfile(){
		
		TumiLibs.closeSignUpForUS();
		 //click on login window
		login("Login", "UpdateProfile");
	    
		//click on view my profile from MyAccount page
		click(myacc.getViewProfile(), "View Profile");
		
		//update profile name
		input(profile.getName(), testData.get("name"), "First name");
		
		//click on save
		click(profile.getSave(), "Save Update");
		
	}
}
