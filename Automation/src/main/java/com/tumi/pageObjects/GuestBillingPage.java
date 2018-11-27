package com.tumi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class GuestBillingPage {
	
	public GuestBillingPage(WebDriver driver) {
		Reports.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//input[@placeholder='Your Name (as appears on card)']")
	private WebElement nameOnCard;
	
	public WebElement getNameOnCard() {
		
		return nameOnCard;
	}
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Card Number']")
	private WebElement cardNumber;
	
	public WebElement getCardNumber() {
		
		return cardNumber;
	}

	@FindBy(how=How.XPATH,using="//span[@name='expiryMonth']")
	private WebElement expiryMonth;
	
	public WebElement getExpiryMonth() {
		
		return expiryMonth;
	}
	
	
	
	@FindBy(how=How.XPATH,using="//span[@name='expiryYear']")
	private WebElement expiryYear;
	
	public WebElement getExpiryYear() {
		
		return expiryYear;
	}
	
	@FindBy(how=How.ID,using="card_cvv")
	private WebElement cvvNumber;
	
	public WebElement getCvvNumber() {
		
		return cvvNumber;
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='email'][@placeholder='Email Address *']")
	private WebElement email;
	
	public WebElement getemail() {
		
		return email;
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='phone'][@placeholder='Daytime Phone(mobile preferred) *']")
	private WebElement phoneNumber;
	
	public WebElement getPhoneNumber() {
		
		return phoneNumber;
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='shippingAddressForBilling']")
	private WebElement useShippingAddressAsBilling;
	
	public WebElement getShippingAddressAsBilling() {
		
		return useShippingAddressAsBilling;
	}
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Review Your Order')]")
	private WebElement reviewOrder;
	
	public WebElement getReviewOrder() {
		
		return reviewOrder;
	}
	
	@FindBy(how=How.XPATH,using="//span[@name='countryIso']")
	private WebElement countrySelector;
	
	public WebElement getCountrySelector() {
		
		return countrySelector;
	}
	
	@FindBy(how=How.NAME,using="firstName")
	private WebElement firstName;
	
	public WebElement getFirstName() {
		
		return firstName;
	}
	
	@FindBy(how=How.NAME,using="lastName")
	private WebElement lastName;
	
	public WebElement getLastName() {
		
		return lastName;
	}
	
	@FindBy(how=How.NAME,using="line1")
	private WebElement addressLine1;
	
	public WebElement getAddressLine1() {
		
		return addressLine1;
	}
	
	@FindBy(how=How.NAME,using="line2")
	private WebElement addressLine2;
	
	public WebElement getAddressLine2() {
		
		return addressLine2;
	}
	
	@FindBy(how=How.NAME,using="townCity")
	private WebElement townOrCity;
	
	public WebElement getTownOrCity() {
		
		return townOrCity;
	}
	
	@FindBy(how=How.NAME,using="regionIso")
	private WebElement selectState;
	
	public WebElement getselectState() {
		
		return selectState;
	}
	
	@FindBy(how=How.NAME,using="postcode")
	private WebElement zipcode;
	
	public WebElement getZipcode() {
		
		return zipcode;
	}
	







}
