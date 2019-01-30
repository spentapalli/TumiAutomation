package com.tumi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

/**
 * @author Shwetha Capo
 *
 */
public class PayPalPage extends GenericMethods {
	
	public PayPalPage(WebDriver driver) {
		Reports.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//img[@alt='Checkout with PayPal']")
	private WebElement payPal;
	
	public WebElement getPayPal() {
		return explicitWait(payPal);
	}
	@FindBy(how=How.XPATH,using="(//div[@id='paypal-animation-content']/div/div)[1]")
	private WebElement payPalAnother;
	
	public WebElement getPayPalAnother() {
		return explicitWait(payPalAnother);
	}
	
	@FindBy(how=How.XPATH, using= "//a[contains(text(),'Log In')]")
	private WebElement payPalLogin;
	
	public WebElement getPayPalLogin() {
		return explicitWait(payPalLogin);
	}
	
	@FindBy(how=How.XPATH, using= "//input[@id='email']")
	private WebElement payPalEmail;
	
	public WebElement getPayPalEmail() {
		
		return payPalEmail;
	}
	 
	@FindBy(how=How.XPATH, using="//button[@id='btnNext']")
	private WebElement next;
	
	public WebElement getNext() {
		return explicitWait(next);
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='password']")
	private WebElement payPalPassword;
	
	public WebElement getPayPalPassword() {
		return explicitWait(payPalPassword);
	}
	
	@FindBy(how=How.XPATH, using="//button[@id='btnLogin']")
	private WebElement login;
	
	public WebElement getLogin() {
		return explicitWait(login);
	}
	
	//(//div[@id='paymentMethod']//label)[1]
	@FindBy(how=How.XPATH, using="//ul[@data-test-id='fundingInstruments']/li[1]")
	private WebElement creditUnion;
	
	public WebElement getCreditUnion() {
		return creditUnion;
	}
	
	//(//div[@id='paymentMethod']//label)[2]
	////ul[@data-test-id='fundingInstruments']/li[2]
	@FindBy(how=How.XPATH, using="//input[@id='d546777e383511d791ddc41b1942ce1b']/following::label")
	private WebElement visax111;
	
	public WebElement getVisax111() {
		return explicitWait(visax111);
	}
	
	@FindBy(how=How.XPATH, using="//ul[@data-test-id='fundingInstruments']/li[3]")
	private WebElement discover;
	
	public WebElement getdiscover() {
		return discover;
	}
	
	@FindBy(how=How.XPATH, using="//ul[@data-test-id='fundingInstruments']/li[4]")
	private WebElement visax5770;
	
	public WebElement getVisax5770() {
		return visax5770;
	}
	
	
	
	//input[@id='confirmButtonTop']
	@FindBy(how=How.XPATH, using="//div[@id='button']")
	private WebElement paypalContinue;

	public WebElement getPaypalContinue() {
		return paypalContinue;
	}
}
