package com.tumi.demotestcases;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;

public class UpdateProfile extends GenericMethods{

	public Map<String, String> testData = ReadTestData.retrieveData("Login", "UpdateProfile");
	
	@Test
	public void updateProfile(){
		
		 //click on login window
		click(login.getLoginWindow(), " click on Login");
					
		//enter username
		input(login.getLoginUsername(), testData.get("EmailID"), "User Name");
				
		//enter password
		input(login.getLoginPassword(), testData.get("Password"), "Password");
				
		//click on SignIn
		click(login.getLogOn(), "click on SignIn");
	    
		//click on view my profile from MyAccount page
		click(myacc.getViewProfile(), "View Profile");
		
		//update profile name
		input(profile.getName(), testData.get("name"), "First name");
		
		//click on save
		click(profile.getSave(), "Save Update");
		
	}
}
