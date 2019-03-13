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
	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Alpha Bravo Luggage Tag - Small')])[1]")
	private WebElement ProductLink;
	
	public WebElement getProductLink() {
		
		return ProductLink;
	}
	@FindBy(how = How.XPATH, using = "	//section[@id='payment-section-ctnr']")
	private List<WebElement> ProductPayment;
	
	public List<WebElement> getProductPaymentDetails() {
		
		return ProductPayment;
	}

	

}
