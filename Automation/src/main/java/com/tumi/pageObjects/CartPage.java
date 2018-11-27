package com.tumi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;

public class CartPage {
	
	public CartPage(WebDriver driver) {
		Reports.driver= driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Edit')][1]")
	private WebElement editProductQuantity;
	
	public WebElement getEditProductQuantity() {
		
		return editProductQuantity;
	}
	
	/*@FindBy(how=How.XPATH,using="//a[@class='cta removeFocusIndicator']")
	private WebElement removeProduct;
	
	public WebElement getRemoveProduct() {
		
		return removeProduct;
	}*/
	
	@FindBy(how=How.XPATH,using="//div[@id='cart-items-container']/div/div/div/div/div/div/a")
	private WebElement makeGiftBox;
	
	public WebElement getMakeGiftBox() {
		
		return makeGiftBox;
	}
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Proceed to Checkout')]")
	private WebElement proceedToCheckout;
	
	public WebElement getProceedToCheckout() {
		
		return proceedToCheckout;
		
	}
	
	@FindBy(how=How.XPATH,using= "//img[@alt='Checkout with PayPal']")
    private WebElement payPalProceed;
	
	public WebElement getPayPalProceed() {
		
		return payPalProceed;
		
	}
	
	
	
	

}
