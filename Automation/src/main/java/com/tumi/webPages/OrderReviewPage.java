package com.tumi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class OrderReviewPage extends GenericMethods {
	
	public OrderReviewPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how=How.XPATH,using="(//button[@type='button'])[1]")
	private WebElement editShippingAddress;
	
	public WebElement getEditShippingAddressut() {
		
		return editShippingAddress;
	}
	
	@FindBy(how=How.XPATH,using="(//button[@type='button'])[2]")
	private WebElement editShippingMethod;
	
	public WebElement getEditShippingMethod() {
		
		return editShippingMethod;
	}
	
	@FindBy(how=How.XPATH,using="(//button[@type='button'])[3]")
	private WebElement editPayment;
	
	public WebElement getEditPayment() {
		
		return editPayment;
	}
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Place Order')]")
	private WebElement placeOrder;
	
	public WebElement getPlaceOrder() {
		
		return explicitWait(placeOrder);
	}
	@FindBy(how=How.XPATH,using="//section[@id='confirmation-info-ctnr']/div/div/b")
	private WebElement orderNumber;

	public WebElement getOrderNumber() {
		return orderNumber;
	}
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Review Your Order')]")
	private WebElement reviewOrder;

	public WebElement getreviewOrder() {
		return reviewOrder;
	}
	
	
	
	@FindBy(how=How.XPATH,using="//script[@id='checkoutMessages']/following::span[1]")
	private WebElement checkoutMessages;

	public WebElement getCheckoutMessages() {
		return checkoutMessages;
	}
	
}
