//TestCase : Confirm Gmail login is successful on clicking "Google" and entering valid Email & password


package com.tumi.login;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

 
 /**
 * @author Shwetha Capo
 *
 */
public class GoogleLogin extends GenericMethods {
	private static final Logger LOG = Logger.getLogger(GoogleLogin.class);
	public Map<String, String> testData = ReadTestData.retrieveData("Login", "GoogleLogin");

	@Test
	public void verifyGoogleLogin() throws InterruptedException {

		TumiLibs.closeSignUpForUsProd();
		click(home.getSelectCountryUS(), "Select US country");
		click(home.getSelectUS(), "click US");
		delay(4000);

		if (google.getNoThanks().isDisplayed()) {
			click(google.getNoThanks(), "offers popup");
		}

		click(home.getHeaderSignIn(), "SignIn");
		click(google.getGoogleLogin(), "Google login");

		String pwindow = driver.getWindowHandle();
		/*
		 * System.out.println("the parent window handler id is"+pwindow);
		 * System.out.println("before switch to other window, the title is"+driver.
		 * getTitle());
		 */
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println(allwindows.size());
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String cwindow = itr.next();
			System.out.println(cwindow);
			if (!pwindow.equals(cwindow)) {
				driver.switchTo().window(cwindow);
				driver.switchTo().window(cwindow).getTitle();
				System.out.println(driver.getTitle());
				delay(2000);
				input(google.getEmail(), testData.get("EmailID"), "gmail id");
				click(google.getFirstNext(), "Next");
				delay(2000);
				input(google.getPassword(), testData.get("Password"), "Password");
				click(google.getPasswordNext(), "password next");
				delay(3000);

			}
		}
		driver.switchTo().window(pwindow);
		verifyAssertEquals(getText(myacc.getWelcomeMessage()), repository("login.success.message"));
	    
	    System.out.println("login.success.message");
		driver.close();

		/*
		 * if(myacc.getWelcomeMessage().getText().contains("Welcome back")) {
		 * System.out.println("login suucessfull");
		 * 
		 * }
		 */

	}

}
