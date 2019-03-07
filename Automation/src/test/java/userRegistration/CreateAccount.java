package userRegistration;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.webPages.CreateAccountPage;

public class CreateAccount extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "CreateAccount");
	Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "ExistingAccount");
	

@Test(priority = 0)
	public void newUserRegistration() {
		userAccount(testData.get("EmailID") + randomNumber() + "@gmail.com");
		verifyAssertEquals(getText(register.getRegisterConfirm()), getProperty("registration.success"));
		click(login.getLogOut(), "Sign Out");
	}
 
	
	@Test(priority = 1, dependsOnMethods = "newUserRegistration")
	public void existingAccount() {

		userAccount(testData1.get("EmailID"));
		verifyAssertContains(getText(register.getRegisterError()), getProperty("registration.duplicate"), "D");
		click(login.getCloseWindow(), "Close Window");
	}
	 @Test(priority = 2)
	  public void userLogin() {
		  SignIn(testData1.get("EmailID"));
		  //input(home.getUserName(), testData1.get("EmailID"), "Email Address");
		 // input(home.getPassWord(), testData1.get("Password"), "Password");
			//click(home.getLogOn(), "Login");
	}

	@Test(priority = 3)
	public void registrationValidations() {

		click(home.getHeaderSignIn(), "Sign In");
		click(register.getRegisterCreate(), "Create an Account");
		click(register.getSubmitAccount(), "Submit Account Details");

		softAssertEquals(getText(register.getRegisterError()), getProperty("registration.error"));

		softAssertEquals(getText(register.getRegisterEmailError()), getProperty("registration.email"));

		softAssertEquals(getText(register.getRegisterPassError()), getProperty("registration.password"));

		softAssertEquals(getText(register.getRegisterCheckPassError()), getProperty("registration.confirm.password"));

		softAssertEquals(getText(register.getRegisterFNameError()), getProperty("registration.firstName"));

		softAssertEquals(getText(register.getRegisterLNameError()), getProperty("registration.lastName"));
	}

	public void userAccount(String data) {

		click(home.getHeaderSignIn(), "Sign In");
		click(register.getRegisterCreate(), "Create an Account");
		input(register.getRegisterEmail(), data, "Email ID");
		input(register.getRegisterPassword(), testData.get("Password"), "Password");
		input(register.getRegisterCheckPassword(), testData.get("ConfirmPassword"), "Confirm Password");
		input(register.getRegisterFName(), testData.get("FirstName"), "First Name");
		input(register.getRegisterLName(), testData.get("LastName"), "Last Name");
		if (selectedCountry.equals("Korea")) {
			click(register.getkrAddSelectcountryArrow(), "Country Selection");
			selectByVisibleText(register.getkrAddSelectcountry(), testData.get("SelectCountry"), "SelectCountry");
			
		}else {
		domClick(register.getRegisterSubscribe(), "Activate Promotions");
		click(register.getSubmitAccount(), "Submit Account Details");
	}
	}
	public void SignIn(String data) {
	click(home.getHeaderSignIn(), "Sign In");
	input(home.getUserName(), testData1.get("EmailID"), "Email Address");
	input(home.getPassWord(), testData1.get("Password"), "Password");
	click(home.getLogOn(), "Login");
	click(home.getCloseMyAccount(),"close Account");
		
	}

	}



