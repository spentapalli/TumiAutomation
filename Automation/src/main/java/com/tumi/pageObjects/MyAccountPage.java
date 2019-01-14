package com.tumi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;

/**
 * @author Shwetha Capo
 *
 */
public class MyAccountPage {
	
	public MyAccountPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="(//a[@title='View Your Profile'])[2]")
	private WebElement viewProfile;
	
	public WebElement getViewProfile() {
		
		return viewProfile;
	}
	@FindBy(how=How.XPATH,using="(//a[@title='Purchased Items'])[2]")
	private WebElement purchasedItems;
	
	public WebElement getPurchasedItems() {
		
		return purchasedItems;
	}
	
	@FindBy(how=How.XPATH,using="(//a[@title='View Your Order Status'])[2]")
	private WebElement viewYourOrderStatus;
	
	public WebElement getViewYourOrderStatus() {
		
		return viewYourOrderStatus;
	}
	
	@FindBy(how=How.XPATH,using="(//a[@title='Register Your TUMI'])[2]")
	private WebElement registerYourTumi;
	
	public WebElement getRegisterYourTumi() {
		
		return registerYourTumi;
	}
	
	@FindBy(how=How.XPATH,using="(//a[@title='Repair Services'])[2]")
	private WebElement repairServices;
	
	public WebElement getRepairServices() {
		
		return repairServices;
	}//div[@id='tm-panel-login-confirmation']/header/span
	
	@FindBy(how=How.XPATH,using="//div[@id='tm-panel-login-confirmation']/header/span")
	private WebElement welcomeMessage;
	
	public WebElement getWelcomeMessage() {
		
		return welcomeMessage;
	}
	
	@FindBy(how=How.XPATH, using="//h4[contains(text(),'New here?')]")
	private WebElement newHereMessage;
	
	public WebElement getNewHereMessage() {
		return newHereMessage;
	}

	public WebElement getCreateAcc() {
		return createAcc;
	}

	@FindBy(how=How.XPATH, using="//a[@href='#create-account']")
	private WebElement createAcc;

	@FindBy(how=How.XPATH, using="(//h3[contains(text(),'My Account')])[2]")
	private WebElement signUpMyAccMsg;
	
	public WebElement getSignUpMyAccMsg() {
		return signUpMyAccMsg;
	}
	@FindBy(how=How.XPATH, using="(//a[contains(text(),'Sign Out')])[3]")
	private WebElement signout;
	
	public WebElement getSignout() {
		return signout;
	}
}
