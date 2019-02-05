package com.tumi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

/**
 * @author Shwetha Capo
 *
 */
public class MyAccountPage extends GenericMethods {

	public MyAccountPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//a[@title='View Your Profile'])[2]")
	private WebElement viewProfile;
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[1]/a")
	private WebElement krviewProfile;

	public WebElement getViewProfile() {

		return viewProfile;
	}

	@FindBy(how = How.XPATH, using = "(//a[@title='Purchased Items'])[2]")
	private WebElement purchasedItems;
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[2]/a")
	private WebElement krpurchasedItems;

	public WebElement getPurchasedItems() {

		return purchasedItems;
	}

	@FindBy(how = How.XPATH, using = "(//a[@title='View Your Order Status'])[2]")
	private WebElement viewYourOrderStatus;
	@FindBy(how=How.XPATH,using="//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[3]/a") 
	private WebElement krviewYourOrderStatus;

	
	public WebElement getViewYourOrderStatus() {

		return viewYourOrderStatus;
	}

	@FindBy(how = How.XPATH, using = "(//a[@title='Register Your TUMI'])[2]")
	private WebElement registerYourTumi;
	
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[4]/a")
	private WebElement krregisterYourTumi;


	public WebElement getRegisterYourTumi() {

		return registerYourTumi;
	}

	@FindBy(how = How.XPATH, using = "(//a[@title='Repair Services'])[2]")
	private WebElement repairServices;

	public WebElement getRepairServices() {

		return repairServices;
	}

	// div[@id='tm-panel-login-confirmation']/header/span
	// Same for korea
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/header/span")
	private WebElement welcomeMessage;

	public WebElement getWelcomeMessage() {

		return welcomeMessage;
	}

	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'New here?')]")
	private WebElement newHereMessage;

	public WebElement getNewHereMessage() {
		return newHereMessage;
	}

	@FindBy(how = How.XPATH, using = "(//a[@title='Close'])[4]")
	private WebElement myAccountClose;

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/header/a/span")
	private WebElement krmyAccountClose;

	public WebElement getMyAccountClose() {

		return myAccountClose;
	}

	
	

	@FindBy(how = How.XPATH, using = "//a[@href='#create-account']")
	private WebElement createAcc;

	@FindBy(how = How.XPATH, using = "(//h3[contains(text(),'My Account')])[2]")
	private WebElement signUpMyAccMsg;

	public WebElement getCreateAcc() {
		return createAcc;

	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Sign Out')])[3]")
	private WebElement signout;
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[2]/li[2]/a")
	private WebElement krSignout;

	public WebElement getSignout() {
		return explicitWait(signout);
	}

	// Korea
	// Myacc button
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[2]/li[1]/a")
	private WebElement MyaccButton;

	public WebElement getMyaccButton() {
		if(selectedCountry.contains("Korea")) {
			return signUpMyAccMsg;
		}else {

	return MyaccButton;
}
	}
}
/*
 * //signout public WebElement getSignUpMyAccMsg() {
		return signUpMyAccMsg;
 * 
 * public WebElement getkrSignout() { if(selectedCountry.contains("Korea")) {
 * return krSignout; }else {
 * 
 * return signout; } } //viewmyprofile
 * 
 * 
 * 
 * public WebElement getkrViewProfile() { if(selectedCountry.contains("Korea"))
 * { return krSignout; }else { return viewProfile; } }
 * ////div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[2]/a
 * 
 * 
 * public WebElement getkrPurchasedItems() {
 * if(selectedCountry.contains("Korea")) { return krpurchasedItems; }else {
 * return purchasedItems; }
 * 
 * }
 * 
 * @FindBy(how=How.XPATH,using=
 * "//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[3]/a") private
 * WebElement krviewYourOrderStatus;
 * 
 * public WebElement getkrViewYourOrderStatus() {
 * if(selectedCountry.contains("Korea")) { return krviewYourOrderStatus; }else {
 * 
 * return viewYourOrderStatus; } }
 * 
 * 
 * 
 * 
 * public WebElement getkrRegisterYourTumi() {
 * if(selectedCountry.contains("Korea")) { return krviewYourOrderStatus; }else {
 * 
 * return registerYourTumi; } }
 * 
 * 
 * 
 * public WebElement getkrMyAccountClose() {
 * if(selectedCountry.contains("Korea")) { return krmyAccountClose; }else {
 * return myAccountClose; } }
 * 
 * }
 * 
 * 
 * 
 */