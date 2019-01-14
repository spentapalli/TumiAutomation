package com.tumi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

<<<<<<< HEAD:Automation/src/main/java/com/tumi/pageObjects/OrderReviewPage.java
/**
 * @author Shwetha Capo
 *
 */
=======
>>>>>>> aeedd54764433033c3ff3e941386c80d8b463e36:Automation/src/main/java/com/tumi/webPages/OrderReviewPage.java
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
	
	@FindBy(how=How.XPATH,using="(//button[@type='submit'])[1]")
	private WebElement placeOrder;
	
	public WebElement getPlaceOrder() {
		
		return explicitWait(placeOrder);
	}
	@FindBy(how=How.XPATH,using="//section[@id='confirmation-info-ctnr']/div/div/b")
	private WebElement orderNumber;

	public WebElement getOrderNumber() {
		return orderNumber;
	}
	
	
}
