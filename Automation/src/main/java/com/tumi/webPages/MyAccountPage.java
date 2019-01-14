package com.tumi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;

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
	}
	
	@FindBy(how=How.XPATH,using="(//a[@title='Close'])[4]")
	private WebElement myAccountClose;
	
	public WebElement getMyAccountClose() {
		
		return myAccountClose;
	}
	

}
