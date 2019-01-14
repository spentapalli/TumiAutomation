package com.tumi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;

public class SinglePageCheckout {
	
	public SinglePageCheckout(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign In for Express Checkout')]")
	private WebElement signInExpressCheckout;

	public WebElement getSignInExpressCheckout() {

		return signInExpressCheckout;
	}
	
	@FindBy(how = How.XPATH, using = "(//input[@name='email'])[1]")
	private WebElement emailAddress;

	public WebElement getEmailAddress() {

		return emailAddress;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue as a Guest')]")
	private WebElement continueAsGuest;

	public WebElement getContinueAsGuest() {

		return continueAsGuest;
	}
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Send me emails with promotions and news.')]")
	private WebElement promotionsAndNews;

	public WebElement getPromotionsAndNews() {

		return promotionsAndNews;
	}
	
	

}