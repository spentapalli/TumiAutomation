package login;

import java.util.Map;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;


/**
 * @author Shwetha Capo
 *
 */
public class VerifyInvalidInstaLogin extends GenericMethods{
	
public Map<String, String> testData = ReadTestData.retrieveData("Login", "VerifyInvalidInstaLogin");
	
	@Test
	public void verifyInstaLogin() throws InterruptedException{
		UIFunctions.closeSignUpForUsProd();
		click(home.getSelectCountryUS(), "Select US country");
		click(home.getSelectUS(), "click US");
		delay(4000);
		if (google.getNoThanks().isDisplayed()) {
			click(google.getNoThanks(), "offers popup");
		}else {
			
		}
		/*if(home.getOffersPopupUsProd().isDisplayed()) {
		click(home.getOffersPopupUsProd(),"offers popup");
	}*/
		click(home.getHeaderSignIn(), "SignIn");
		
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		click(insta.getInsta(),"Instagram");
		delay(4000);
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		//code to do something on new window
		
		input(insta.getInstaUsername(),testData.get("EmailID"),"Username");
		input(insta.getInstaPassword(),testData.get("Password"), "Password");
		click(insta.getInstaLogin(),"Login");
		delay(4000);
		//driver.switchTo().window(parentHandle);
		/*String expectedMessage = "Sorry, your password was incorrect. Please double-check your password";
		String message = insta.getPasswordErr().getText();
		Assert.assertTrue(message.contains(expectedMessage), "Your error message");
		System.out.println(message);*/
		verifyAssertEquals(getText(insta.getPasswordErr()), getProperty("insta.passwordError"));
		
	    
		
	}

}
