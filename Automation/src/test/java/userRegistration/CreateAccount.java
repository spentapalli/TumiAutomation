//sprint-3
//TA-66 verify tumi account create
package userRegistration;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.webPages.CreateAccountPage;

public class CreateAccount extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "CreateAccount");
	Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "ExistingAccount");
	
	private String email;
@Test(priority = 0)
	public void newUserRegistration() {
	if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
		 email= testData.get("EmailID")+randomNumber()+ "@gmail.com";
		
     userAccount(email);
		verifyAssertEquals(getText(register.getRegisterConfirm()), getProperty("registration.success"));
		click(login.getLogOut(), "Sign Out");
	}else {
		 email= testData.get("EmailID")+randomNumber()+ "@gmail.com";
		userAccount(email);
		 if(register.getkrErrorMessage().isDisplayed())
				logger.log(Status.INFO,"Successfully CreatedAccount ");
	}
}
	
	@Test(priority = 1, dependsOnMethods = "newUserRegistration")
	public void existingAccount() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
		userAccount(testData1.get("EmailID"));
		verifyAssertContains(getText(register.getRegisterError()), getProperty("registration.duplicate"), "D");
		click(login.getCloseWindow(), "Close Window");
		}else {
			userAccount(testData1.get("EmailID"));
			 if(register.getkrErrorMessage().isDisplayed())
					logger.log(Status.INFO,"User Details already Exist  ");
		}
	}
	 @Test(priority = 2 ,dependsOnMethods = "newUserRegistration")
	  public void userLogin() {
			if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
	SignIn(email);
			}else {
				SignIn(email);
				if(register.getkrErrorMessage().isDisplayed())
					logger.log(Status.INFO,"Can't login");
		 } 
	 }
	@Test(priority = 3)
	public void registrationValidations() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
		click(home.getHeaderSignIn(), "Sign In");
		click(register.getRegisterCreate(), "Create an Account");
		click(register.getSubmitAccount(), "Submit Account Details");

		softAssertEquals(getText(register.getRegisterError()), getProperty("registration.error"));

		softAssertEquals(getText(register.getRegisterEmailError()), getProperty("registration.email"));

		softAssertEquals(getText(register.getRegisterPassError()), getProperty("registration.password"));

		softAssertEquals(getText(register.getRegisterCheckPassError()), getProperty("registration.confirm.password"));

		softAssertEquals(getText(register.getRegisterFNameError()), getProperty("registration.firstName"));

  softAssertEquals(getText(register.getRegisterLNameError()), getProperty("registration.lastName"));
		}else {
  click(home.getHeaderSignIn(), "Sign In");
	click(register.getRegisterCreate(), "Create an Account");
	click(register.getSubmitAccount(), "Submit Account Details");	
 if(register.getkrErrorMessage().isDisplayed())
					logger.log(Status.INFO,"Blank Message");	
	}
	}


	public void userAccount(String Data) {

		click(home.getHeaderSignIn(), "Sign In");
		click(register.getRegisterCreate(), "Create an Account");
		input(register.getRegisterEmail(), Data, "Email ID");
		input(register.getRegisterPassword(), testData.get("Password"), "Password");
		input(register.getRegisterCheckPassword(), testData.get("ConfirmPassword"), "Confirm Password");
		input(register.getRegisterFName(), testData.get("FirstName"), "First Name");
		input(register.getRegisterLName(), testData.get("LastName"), "Last Name");
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			domClick(register.getRegisterSubscribe(), "Activate Promotions");
			click(register.getSubmitAccount(), "Submit Account Details");
		}else {
		
		click(register.getkrAddSelectcountryArrow(),"Select country");
		click(register.getKrSelectcountry(),"Option Selected");
		click(register.getkrSelectyearArrow(),"Select Year");
		click(register.getKrSelectYear(),"Option Selected");
		domClick(register.getRegisterSubscribe(), "Activate Promotions");
		domClick(register.getKrCheckboxprivacy(),"Legal checkbox");
		click(register.getSubmitAccount(), "Submit Account Details");
		
		
	}
	}
	
	public void SignIn(String data) {
	
	click(home.getHeaderSignIn(), "Sign In");
	input(home.getUserName(), data, "Email Address");
	input(home.getPassWord(), testData.get("Password"), "Password");
	if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
	click(home.getLogOn(), "Login");
	
	click(home.getCloseMyAccount(),"close Account");
	
		}else {
			click(home.getLogOn(), "Login");
			if(register.getkrErrorMessage().isDisplayed())
				logger.log(Status.INFO,"Successfully Login");		
		}
	
	}

	}



