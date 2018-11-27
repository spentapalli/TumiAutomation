package com.tumi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;

public class ShippingMethodPage {
	
	public ShippingMethodPage(WebDriver driver) {
		Reports.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.NAME,using="deliveryMethodSelected")
	private WebElement standardShippingMethod;
	
	public WebElement getStandardShippingMethod() {
		
		return standardShippingMethod;
	}

	@FindBy(how=How.XPATH,using="//button[contains(text(), 'Proceed to Payment')]")
	private WebElement proceedToPayment;
	
	public WebElement getProceedToPayment() {
		
		return proceedToPayment;
	}

}
