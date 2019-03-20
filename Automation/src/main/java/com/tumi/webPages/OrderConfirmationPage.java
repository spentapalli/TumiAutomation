package com.tumi.webPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class OrderConfirmationPage extends GenericMethods {
	
	public OrderConfirmationPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='loader-image']")
	private WebElement withForConfirmation;
	
	public WebElement getWithForConfirmation() {
		
		return withForConfirmation;
	}
	
	@FindBy(how = How.XPATH, using = "//section[@id='confirmation-info-ctnr']/div/div[1]")
	private WebElement confirmOrder;
	
	public WebElement getConfirmOrder() {
		
		return confirmOrder;
	}
	
	@FindBy(how = How.XPATH, using = "//section[@id='confirmation-info-ctnr']/div/div[1]/b")
	private WebElement orderNumber;
	
	public WebElement getOrderNumber() {
		
		return explicitWait(orderNumber);
	}
	

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign Out')][1]")
	private WebElement signoutAtConfirm;
	
	public WebElement getSignoutAtConfirm() {
		
		return signoutAtConfirm;
	}
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Create an account')]")
	private WebElement CreateAccount;
	
	public WebElement getCreateAccount() {
		
		return CreateAccount;
	}
	//dygfysgfhsdfdsufsdu
	@FindBy(how = How.XPATH, using = "//header[contains(@class,'black-text')]/a")
	private WebElement ProductLink;
	
	public WebElement getProductLink() {
		
		return ProductLink;
	}
	@FindBy(how = How.XPATH, using = "	//section[@id='payment-section-ctnr']/section[2]/div[1]/div/header")
	private WebElement ProductPayment;
	
	public WebElement getProductPaymentDetails() {
		
		return ProductPayment;
	}
	@FindBy(how = How.XPATH, using = "//header[@class='black-text removeFocusIndicator']")
	private WebElement ShipppingAddress;
	
	public  WebElement getShipppingAddress() {
		
		return ShipppingAddress;
	}
	@FindBy(how = How.XPATH, using = "//header[@class='black-text inline-text']")
	private WebElement ShippingMethods;
	
	public WebElement getShippingMethods() {
		
		return ShippingMethods;
	}
	
	

}
