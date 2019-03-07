package com.tumi.webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.tumi.utilities.GenericMethods;

public class CreateAccountPage extends GenericMethods {

	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}
//same as US For Korea
	@FindBy(how = How.XPATH, using = "//input[@id='register.email']")
	private WebElement registeremail;

	public WebElement getRegisterEmail() {

		return explicitWait(registeremail);
	}
	
	@FindBy(how = How.XPATH, using = "//label[@id='register.email-error']")
	private WebElement registeremailError;

	public WebElement getRegisterEmailError() {

		return explicitWait(registeremailError);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='register.password']")
	private WebElement registerpassword;

	public WebElement getRegisterPassword() {

		return registerpassword;
	}
	
	@FindBy(how = How.XPATH, using = "//label[@id='register.password-error']")
	private WebElement registerpassError;

	public WebElement getRegisterPassError() {

		return registerpassError;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='register.checkPassword']")
	private WebElement registercheckPassword;

	public WebElement getRegisterCheckPassword() {

		return registercheckPassword;
	}
	
	@FindBy(how = How.XPATH, using = "//label[@id='register.checkPassword-error']")
	private WebElement registercheckPassError;

	public WebElement getRegisterCheckPassError() {

		return registercheckPassError;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='register.fname']")
	private WebElement registerFname;

	public WebElement getRegisterFName() {

		return registerFname;
	}
	
	@FindBy(how = How.XPATH, using = "//label[@id='register.fname-error']")
	private WebElement registerFnameError;

	public WebElement getRegisterFNameError() {

		return registerFnameError;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='register.lname']")
	private WebElement registerLname;

	public WebElement getRegisterLName() {

		return registerLname;
	}
	//Till last name loctaor are same for korea
	@FindBy(how = How.XPATH, using = "//label[@id='register.lname-error']")
	private WebElement registerLnameError;

	public WebElement getRegisterLNameError() {

		return registerLnameError;
	}

	@FindBy(how = How.XPATH, using = "//select[@id='register.country']")
	private WebElement registerCountry;

	public WebElement getRegisterCountry() {

		return registerCountry;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='register.subscribe']")
	private WebElement registerSubscribe;

	public WebElement getRegisterSubscribe() {

		return registerSubscribe;
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Create an account']")
	private WebElement registerCreate;

	public WebElement getRegisterCreate() {

		return registerCreate;
	}
	@FindBy(how = How.XPATH, using = "(//input[@type='submit'])[2]")
	private WebElement KrsubmitAccount;

	
	@FindBy(how = How.XPATH, using = "//input[@value='Create Account']")
	private WebElement submitAccount;

	public WebElement getSubmitAccount() {
		if (selectedCountry.contains("US")||
				selectedCountry.contains("Canada")) {
	
			
				return submitAccount;
				
			} else {

				return KrsubmitAccount;
			}
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-register-confirmation']/header/p")
	private WebElement registerConfirm;

	public WebElement getRegisterConfirm() {

		return registerConfirm;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='register.subscribe']/following::div[1]/div")
	private WebElement registerduplicate;

	public WebElement getRegisterError() {

		return registerduplicate;
	}
	
	
	//Korea
	@FindBy(how=How.XPATH,using="//div[@id='tm-panel-login']/div[2]/a")
private WebElement krAcccreateButton;
	public WebElement getkrAcccreateButton() {
		return krAcccreateButton;
	}
	//selecting country
	
	@FindBy(how=How.XPATH,using="//i[@id='register.countrySelectBoxItArrow']")
	private WebElement krSelectcountryArrow;
	public WebElement getkrAddSelectcountryArrow() {
		return krSelectcountryArrow;
	}
	@FindBy(how=How.XPATH,using="//span[@id='register.countrySelectBoxIt']")
	private WebElement krSelectcountry;
	public WebElement getkrAddSelectcountry() {
		return krSelectcountry;
	}
	@FindBy(how=How.XPATH,using="//span[@id='register.accountDurationySelectBoxIt']")
	private WebElement krselectyear;
	public WebElement getkrSelectyear() {
		return  krselectyear;
	}
		@FindBy(how=How.XPATH,using="//i[@id='register.accountDurationySelectBoxItArrow']")
		private WebElement krselectyearArrow;
		public WebElement getkrSelectyearArrow() {
			return  krselectyearArrow;
		
	}
	@FindBy(how=How.XPATH,using="//div[@id='tm-panel-register']/div[2]/a")
	private WebElement krLogin;
	public WebElement getkrLogin() {
		return krLogin;

	}
	@FindBy(how=How.XPATH,using="//input[@id='register.subscribe']")
	private WebElement krfirstcheckbox;
	public WebElement getkrfisrtCheckbox() {
		return krfirstcheckbox;
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='registerLegalCheck']")
	private WebElement krCheckboxprivacy;
	public WebElement getKrCheckboxprivacy() {
		return krCheckboxprivacy;
	}
}



