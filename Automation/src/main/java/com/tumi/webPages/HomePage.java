package com.tumi.webPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

/**
 * @author Shwetha Capo
 *
 */
public class HomePage extends GenericMethods {
	
	public HomePage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='search']")
	private WebElement searchProduct;
	
	public WebElement getSearchProduct() {
		delay(2000);
		return searchProduct;
	}
	
	@FindBy(how=How.XPATH,using="//main[@id='navEnd']/div[2]/div[1]/div/div")
	private WebElement NoProducts;
	
	public WebElement getNoProducts() {
		delay(2000);
		return NoProducts;
	}
	
	
	@FindBy(how=How.XPATH,using="//ul[@id='matching_products']/li")
	private List<WebElement> matchingProducts;
	
	public List<WebElement> getMatchingProducts() {
		
		return matchingProducts;
	}
	
	//for Canada
	@FindBy(how=How.XPATH,using="//div[@id='firstTimeEmailSignupPopup']/a/span")
	private WebElement signupPopup;
	
	public WebElement getCASignupPopup() {
		
		return signupPopup;
	}
	
	//for US
	@FindBy(how=How.XPATH,using="//div[@id='firstTimeEmailSignupPopup']/a/span")
	private WebElement signupPopupUS;
	
	public WebElement getUSSignupPopupUS() {
		
		return signupPopupUS;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='firstTimeEmailSignupPopup']/div/span")
	private WebElement signupPopupUsProd;
	
	public WebElement getSignupPopupUsProd() {
		
		return signupPopupUsProd;
	}
	
	@FindBy(how=How.XPATH,using="//a[@id='bx-close-inside-807411']")
	private WebElement offersPopupUsProd;
	
	public WebElement getOffersPopupUsProd() {
		
		return offersPopupUsProd;
	}
	@FindBy(how=How.XPATH,using="//div[@id='cmsSlot1']/div/div/div//div/div/ul/li[2]/a")
	private WebElement selectUS;
	
	public WebElement getSelectUS() {
		return explicitWait(selectUS);
	}
	@FindBy(how=How.XPATH,using="//a[@href='/country/selected?country=CA']")
	private WebElement selectCanada;
	
	public WebElement getSelectCanada() {
		return selectCanada;
	}
	
	@FindBy(how=How.XPATH,using="//a[@href='/country/selected?country=KR']")
	private WebElement selectKorea;
	
	public WebElement getSelectKorea() {
		return selectKorea;
	}
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Close')]")
	private WebElement acceptCookies;
	
	public WebElement getAcceptCookies() {
		
		return acceptCookies;
	}
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Location: United States')]")
	private WebElement selectCountryUS;
	
	public WebElement getSelectCountryUS() {
		
		return selectCountryUS;
	}
	
	@FindBy(how=How.XPATH,using="//a[text()='Location: Canada']")
	private WebElement selectCountry;
	
	public WebElement getSelectCountry() {
		
		return selectCountry;
	}
	
	@FindBy(how=How.XPATH,using="//i[@id='lang-selectorSelectBoxItArrow']")
	private WebElement selectLanguage;
	
	public WebElement getSelectLanguage() {
		
		return selectLanguage;
		
	}
	
	@FindBy(how=How.XPATH,using="(//a[text()='Find a Store'])[1]")
	private WebElement headerFindStore;
	
	public WebElement getHeaderFindStore() {
	
		return headerFindStore;
		
	}
	
	@FindBy(how=How.XPATH,using="(//a[text()='Customer Service'])[1]")
	private WebElement headerCustomerService;
	
	public WebElement getHeaderCustomerService() {
		
		return headerCustomerService;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='search']")
	private WebElement search;
	
	public WebElement getSearch() {
		
		return search;
		
	}
	
	
	@FindBy(how=How.XPATH,using="(//a[text()='Sign In'])[1]")
	private WebElement headerSignIn;
	
	public WebElement getHeaderSignIn() {
		
		return headerSignIn;
	
	}
	
	
	@FindBy(how=How.XPATH,using="//li[@id='janrain-instagram']/a")
	private WebElement instaLogin;
	
	public WebElement VerifyInstaLogin() {
		return instaLogin;
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@id='j_username']")
	private WebElement j_username;
	
	public WebElement getUserName() {
		
		return j_username;
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='j_password']")
	private WebElement j_password;
	
	public WebElement getPassWord() {
		
		return j_password;
	} 
	
	@FindBy(how=How.XPATH,using="//input[@value='Sign in']")
	private WebElement submit;
	
	public WebElement getLogOn() {
		
		return submit;
	}
		
	@FindBy(how=How.XPATH,using="(//div[@class='error-message'])[1]")
	private WebElement invalidCredentials;
	
	public WebElement getInvalidCredentialsError() {
		
		return invalidCredentials;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='tm-panel-login-confirmation']/header/a")
	private WebElement closeMyAccount;

	public WebElement getCloseMyAccount() {
		return closeMyAccount;
	}

	@FindBy(how=How.XPATH,using="//div[@id='firstTimeEmailSignupPopup']/a")
	private WebElement signUpPop;
	
	public WebElement getSignupPopup() {
		return signUpPop ;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='main-content']/div[2]/h1/span")
	private WebElement vpnIssue;
	
	public WebElement getVPNDis() {
		return vpnIssue ;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='minicart_data']/span[2]")
	private WebElement minicartcount;
	
	public WebElement getMinicartCount() {
		return minicartcount ;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='minicart_data']")
	private WebElement minicart;
	
	public WebElement getMinicart() {
		return minicartcount ;
	}
	
	
	
}
