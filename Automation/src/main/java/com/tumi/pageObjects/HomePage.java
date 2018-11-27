package com.tumi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class HomePage extends GenericMethods {
	
	public HomePage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//for Canada
	@FindBy(how=How.XPATH,using="//div[@id='firstTimeEmailSignupPopup']/div/span")
	private WebElement signupPopup;
	
	public WebElement getSignupPopup() {
		
		return signupPopup;
	}
	
	//for US
	@FindBy(how=How.XPATH,using="//div[@id='firstTimeEmailSignupPopup']/a/span")
	private WebElement signupPopupUS;
	
	public WebElement getSignupPopupUS() {
		
		return signupPopupUS;
	}
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Close')]")
	private WebElement acceptCookies;
	
	public WebElement getAcceptCookies() {
		
		return acceptCookies;
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
	
	@FindBy(how=How.XPATH,using="(//a[text()='Sign In'])[1]")
	private WebElement headerSignIn;
	
	public WebElement getHeaderSignIn() {
		
		return headerSignIn;
	
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
}
