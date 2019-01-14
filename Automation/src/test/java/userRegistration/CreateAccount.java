package userRegistration;

import java.util.Map;

import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;

public class CreateAccount extends GenericMethods {

	public Map<String, String> testData = ReadTestData.retrieveData("Registration", "NewRegistration");
	public Map<String, String> testData1 = ReadTestData.retrieveData("Registration", "ExistingAccount");

	@Test(priority = 0)
	public void newUserRegistration() {
		userAccount(testData.get("EmailID") + randomNumber() + "@gmai.com");
		verifyAssertEquals(getText(register.getRegisterConfirm()), getProperty("registration.success"));
		// Sign Out is Not working after user Registration
		click(login.getLogOut(), "Sign Out");
	}

	@Test(priority = 1, dependsOnMethods = "newUserRegistration")
	public void existingAccount() {

		userAccount(testData1.get("EmailID"));
		verifyAssertContains(getText(register.getRegisterError()), getProperty("registration.duplicate"), "D");
		click(login.getCloseWindow(), "Close Window");
	}

	@Test(priority = 2)
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
		domClick(register.getRegisterSubscribe(), "Activate Promotions");
		click(register.getSubmitAccount(), "Submit Account Details");
	}

}
