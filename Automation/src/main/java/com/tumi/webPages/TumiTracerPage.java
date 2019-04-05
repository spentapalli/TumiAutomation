package com.tumi.webPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class TumiTracerPage extends GenericMethods {

	public TumiTracerPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Register Your Tumi']")
	private WebElement registerUrTumi;

	@FindBy(how = How.XPATH, using = "//div[@class='visible-desktop']/following::a[5]")
	private WebElement krregisterUrTumi;

	public WebElement getRegisterUrTumi() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return registerUrTumi;
		} else {
			return krregisterUrTumi;
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@id='tracerNumber']")
	private WebElement inputTracerNo;

	public WebElement getInputTracerNo() {

		return inputTracerNo;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'regsiter-input')]/input") // input[i]
	private List<WebElement> inputTracerNoList;

	public List<WebElement> getInputTracerNoList() {

		return inputTracerNoList;
	}

	@FindBy(how = How.XPATH, using = "//ul[@id='numOfTracerFieldSelectBoxItOptions']/li")
	private List<WebElement> noOfProductsToRegisterList;

	public List<WebElement> getNoOfProductsToRegisterList() {

		return noOfProductsToRegisterList;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'btn btn-v-1 applyBtn')]")
	private WebElement applyTracerNo;

	public WebElement getApplyTracerNo() {

		return explicitWait(applyTracerNo);
	}

	@FindBy(how = How.XPATH, using = "//i[@id='address.countrySelectBoxItArrow']")
	private WebElement countryDropdown;

	public WebElement getCountryDropdown() {

		return countryDropdown;
	}

	@FindBy(how = How.XPATH, using = "//ul[@id='address.countrySelectBoxItOptions']/li/a/span")
	private List<WebElement> countryList;

	public List<WebElement> getCountryList() {

		return countryList;
	}

	@FindBy(how = How.XPATH, using = "(//i[@id='address.titleSelectBoxItArrow'])[1]")
	private WebElement titleDropdown;

	@FindBy(how = How.XPATH, using = "(//i[@id='address.titleSelectBoxItArrow'])[2]")
	private WebElement CAtitleDropdown;

	@FindBy(how = How.XPATH, using = "(//i[@id='address.titleSelectBoxItArrow'])[4]")
	private WebElement KRtitleDropdown;

	public WebElement getTitleDropdown() {
		if (selectedCountry.contains("US")) {
			return titleDropdown;
		} else if (selectedCountry.contains("Canada")) {
			return CAtitleDropdown;
		} else {
			return KRtitleDropdown;
		}
	}

	@FindBy(how = How.XPATH, using = "(//ul[@id='address.titleSelectBoxItOptions'])[1]//li/a")
	private List<WebElement> titleList;

	@FindBy(how = How.XPATH, using = "(//ul[@id='address.titleSelectBoxItOptions'])[2]//li/a")
	private List<WebElement> CAtitleList;

	@FindBy(how = How.XPATH, using = "(//ul[@id='address.titleSelectBoxItOptions'])[4]//li/a")
	private List<WebElement> KRtitleList;

	public List<WebElement> getTitleList() {
		if (selectedCountry.contains("US")) {
			return titleList;
		} else if (selectedCountry.contains("Canada")) {
			return CAtitleList;
		} else {
			return KRtitleList;
		}
	}

	@FindBy(how = How.XPATH, using = "(//input[@id='address.firstName'])[1]")
	private WebElement firstName;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.firstName'])[2]")
	private WebElement CAfirstName;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.firstName'])[4]")
	private WebElement KRfirstName;

	public WebElement getFirstName() {
		if (selectedCountry.contains("US")) {
			return firstName;
		} else if (selectedCountry.contains("Canada")) {
			return CAfirstName;
		} else {
			return KRfirstName;
		}
	}

	@FindBy(how = How.XPATH, using = "(//input[@id='address.surname'])[1]")
	private WebElement lastName;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.surname'])[2]")
	private WebElement CAlastName;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.surname'])[4]")
	private WebElement KRlastName;

	public WebElement getLastName() {
		if (selectedCountry.contains("US")) {
			return lastName;
		} else if (selectedCountry.contains("Canada")) {
			return CAlastName;
		} else {
			return KRlastName;
		}
	}

	@FindBy(how = How.XPATH, using = "(//input[@id='address.email'])[1]")
	private WebElement email;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.email'])[2]")
	private WebElement CAemail;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.email'])[4]")
	private WebElement KRemail;

	public WebElement getEmail() {
		if (selectedCountry.contains("US")) {
			return email;
		} else if (selectedCountry.contains("Canada")) {
			return CAemail;
		} else {
			return KRemail;
		}
	}

	@FindBy(how = How.XPATH, using = "(//input[@id='address.phoneNumber'])[1]")
	private WebElement phone;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.phoneNumber'])[2]")
	private WebElement CAphone;

	@FindBy(how = How.XPATH, using = "(//input[@id='tracer.reg.form.phoneNumber'])[2]")
	private WebElement KRphone;

	public WebElement getPhone() {
		if (selectedCountry.contains("US")) {
			return phone;
		} else if (selectedCountry.contains("Canada")) {
			return CAphone;
		} else {
			return KRphone;
		}
	}

	@FindBy(how = How.XPATH, using = "(//input[@id='address.line1'])[1]")
	private WebElement addressLine1;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.line1'])[2]")
	private WebElement CAaddressLine1;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.line1'])[4]")
	private WebElement KRaddressLine1;

	public WebElement getAddressLine1() {
		if (selectedCountry.contains("US")) {
			return addressLine1;
		} else if (selectedCountry.contains("Canada")) {
			return CAaddressLine1;
		} else {
			return KRaddressLine1;
		}
	}

	@FindBy(how = How.XPATH, using = "(//input[@id='address.townCity'])[1]")
	private WebElement townOrcity;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.townCity'])[2]")
	private WebElement CAtownOrcity;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.townCity'])[4]")
	private WebElement KRtownOrcity;

	public WebElement getTownOrcity() {
		if (selectedCountry.contains("US")) {
			return townOrcity;
		} else if (selectedCountry.contains("Canada")) {
			return CAtownOrcity;
		} else {
			return KRtownOrcity;
		}
	}

	@FindBy(how = How.XPATH, using = "(//i[@id='address.regionSelectBoxItArrow'])[1]")
	private WebElement stateDropdown;

	@FindBy(how = How.XPATH, using = "(//i[@id='address.regionSelectBoxItArrow'])[2]")
	private WebElement CAstateDropdown;

	@FindBy(how = How.XPATH, using = "(//i[@id='address.regionSelectBoxItArrow'])[4]")
	private WebElement KRstateDropdown;

	public WebElement getStateDropdown() {
		if (selectedCountry.contains("US")) {
			return stateDropdown;
		} else if (selectedCountry.contains("Canada")) {
			return CAstateDropdown;
		} else {
			return KRstateDropdown;
		}
	}

	@FindBy(how = How.XPATH, using = "(//ul[@id='address.regionSelectBoxItOptions'])[1]/li/a")
	private List<WebElement> stateList;

	@FindBy(how = How.XPATH, using = "(//ul[@id='address.regionSelectBoxItOptions'])[2]/li/a")
	private List<WebElement> CAstateList;

	@FindBy(how = How.XPATH, using = "(//ul[@id='address.regionSelectBoxItOptions'])[4]/li/a")
	private List<WebElement> KRstateList;

	public List<WebElement> getStateList() {
		if (selectedCountry.contains("US")) {
			return stateList;
		} else if (selectedCountry.contains("Canada")) {
			return CAstateList;
		} else {
			return KRstateList;
		}
	}

	@FindBy(how = How.XPATH, using = "(//input[@id='address.postcode'])[1]")
	private WebElement zipcode;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.postcode'])[2]")
	private WebElement CAzipcode;

	@FindBy(how = How.XPATH, using = "(//input[@id='address.postcode'])[4]")
	private WebElement KRzipcode;

	public WebElement getZipcode() {
		if (selectedCountry.contains("US")) {
			return zipcode;
		} else if (selectedCountry.contains("Canada")) {
			return CAzipcode;
		} else {
			return KRzipcode;
		}
	}

	@FindBy(how = How.XPATH, using = "(//button[@id='submitButton'])[1]")
	private WebElement completeRegistration;

	@FindBy(how = How.XPATH, using = "(//button[@id='submitButton'])[2]")
	private WebElement CAcompleteRegistration;

	@FindBy(how = How.XPATH, using = "(//button[@id='submitButton'])[4]")
	private WebElement KRcompleteRegistration;

	public WebElement getCompleteRegistration() {
		if (selectedCountry.contains("US")) {
			return explicitWait(completeRegistration);
		} else if (selectedCountry.contains("Canada")) {
			return explicitWait(CAcompleteRegistration);
		} else {
			return explicitWait(KRcompleteRegistration);
		}
	}

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'tumi-reg-thanks-message')]/div)[1]")
	private WebElement thanksMsg;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'tumi-reg-thanks-message')]/div)[2]")
	private WebElement CAthanksMsg;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'tumi-reg-thanks-message')]/div)[4]")
	private WebElement KRthanksMsg;

	public WebElement getThanksMsg() {
		if (selectedCountry.contains("US")) {
			return thanksMsg;
		} else if (selectedCountry.contains("Canada")) {
			return CAthanksMsg;
		} else {
			return KRthanksMsg;
		}
	}

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'tumi-reg-thanks-message')]/div)[3]")
	private WebElement registerdMailID;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'tumi-reg-thanks-message')]/div)[3]")
	private WebElement CAregisterdMailID;

	public WebElement getRegisterdMailID() {
		if (selectedCountry.contains("US")) {
			return registerdMailID;
		} else {
			return CAregisterdMailID;
		}
	}

	@FindBy(how = How.XPATH, using = "(//span[@id='firstName.errors'])[1]")
	private WebElement fristnameErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='firstName.errors'])[2]")
	private WebElement CAfristnameErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='firstName.errors'])[4]")
	private WebElement KRfristnameErr;

	public WebElement getFristnameErr() {
		if (selectedCountry.contains("US")) {
			return fristnameErr;
		} else if (selectedCountry.contains("Canada")) {
			return CAfristnameErr;
		} else {
			return KRfristnameErr;
		}
	}

	@FindBy(how = How.XPATH, using = "(//span[@id='lastName.errors'])[1]")
	private WebElement lastnameErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='lastName.errors'])[2]")
	private WebElement CAlastnameErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='lastName.errors'])[4]")
	private WebElement KRlastnameErr;

	public WebElement getLastnameErr() {
		if (selectedCountry.contains("US")) {
			return lastnameErr;
		} else if (selectedCountry.contains("Canada")) {
			return CAlastnameErr;
		} else {

		}
		return KRlastnameErr;
	}

	@FindBy(how = How.XPATH, using = "(//span[@id='email.errors'])[1]")
	private WebElement emailErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='email.errors'])[2]")
	private WebElement CAemailErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='email.errors'])[4]")
	private WebElement KRemailErr;

	public WebElement getEmailErr() {
		if (selectedCountry.contains("US")) {
			return emailErr;
		} else if (selectedCountry.contains("Canada")) {
			return CAemailErr;
		} else {
			return KRemailErr;
		}
	}

	@FindBy(how = How.XPATH, using = "(//span[@id='phoneNumber.errors'])[1]")
	private WebElement phoneErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='phoneNumber.errors'])[2]")
	private WebElement CAphoneErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='phoneNumber.errors'])[4]")
	private WebElement KRphoneErr;

	public WebElement getPhoneErr() {
		if (selectedCountry.contains("US")) {
			return phoneErr;
		} else if (selectedCountry.contains("Canada")) {
			return CAphoneErr;
		} else {
			return KRphoneErr;
		}
	}

	@FindBy(how = How.XPATH, using = "(//span[@id='line1.errors'])[1]")
	private WebElement addlineErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='line1.errors'])[2]")
	private WebElement CAaddlineErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='line1.errors'])[4]")
	private WebElement KRaddlineErr;

	public WebElement getAddlineErr() {
		if (selectedCountry.contains("US")) {
			return addlineErr;
		} else if (selectedCountry.contains("Canada")) {
			return CAaddlineErr;
		} else {
			return KRaddlineErr;
		}
	}

	@FindBy(how = How.XPATH, using = "(//span[@id='regionIso.errors'])[1]")
	private WebElement stateErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='regionIso.errors'])[2]")
	private WebElement CAstateErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='regionIso.errors'])[4]")
	private WebElement KAstateErr;

	public WebElement getStateErr() {
		if (selectedCountry.contains("US")) {
			return stateErr;
		} else if (selectedCountry.contains("Canada")) {
			return CAstateErr;
		} else {
			return KAstateErr;
		}
	}

	@FindBy(how = How.XPATH, using = "(//span[@id='townCity.errors'])[1]")
	private WebElement townorcityErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='townCity.errors'])[2]")
	private WebElement CAtownorcityErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='townCity.errors'])[4]")
	private WebElement KRtownorcityErr;

	public WebElement getTownorcityErr() {
		if (selectedCountry.contains("US")) {
			return townorcityErr;
		} else if (selectedCountry.contains("Canada")) {
			return CAtownorcityErr;
		} else {
			return KRtownorcityErr;
		}
	}

	@FindBy(how = How.XPATH, using = "(//span[@id='postcode.errors'])[1]")
	private WebElement zipcodeErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='postcode.errors'])[2]")
	private WebElement CAzipcodeErr;

	@FindBy(how = How.XPATH, using = "(//span[@id='postcode.errors'])[4]")
	private WebElement KRzipcodeErr;

	public WebElement getZipcodeErr() {
		if (selectedCountry.contains("US")) {
			return zipcodeErr;
		} else if (selectedCountry.contains("Canada")) {
			return CAzipcodeErr;
		} else {
			return KRzipcodeErr;
		}
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'information_message negative msg msg-error')]")
	private WebElement globalErrMsg;

	public WebElement getGlobalErrMsg() {

		return globalErrMsg;
	}

}
