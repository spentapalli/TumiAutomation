package com.tumi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;

public class MiniCartPage {

	public MiniCartPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(how=How.XPATH,using="//a[@title='Proceed to Checkout']")
	private WebElement proceedtoCheck;
	
	public WebElement getProceedCheckOut() {
		
		return proceedtoCheck;
	}
	
	@FindBy(how=How.XPATH,using="//a[@title='Continue Shopping']")
	private WebElement continueShopping;
	
	public WebElement getContinueShopping() {
		
		return continueShopping;
	}

}
