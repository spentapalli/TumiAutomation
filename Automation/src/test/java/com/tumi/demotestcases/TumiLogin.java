package com.tumi.demotestcases;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;

public class TumiLogin extends GenericMethods {
	
	public Map<String,String> testData = ReadTestData.retrieveData("Login", "TuiLogin");
	
	@Test
	public void verifyLogin() throws InterruptedException{
		
		    //click on login window
			click(login.getLoginWindow(), " click on Login");
						
			//enter username
			input(login.getLoginUsername(), testData.get("EmailID"), "User Name");
					
			//enter password
			input(login.getLoginPassword(), testData.get("Password"), "Password");
					
			//click on SignIn
			click(login.getSignInClick(), "click on SignIn");
		
	}
	
	

}
