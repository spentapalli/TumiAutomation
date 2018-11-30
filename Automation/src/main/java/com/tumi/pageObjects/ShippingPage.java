package com.tumi.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;

public class ShippingPage {

	public ShippingPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver,this);
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
	
	@FindBy(how=How.XPATH,using="//input[@name='line1']/following::div[2]/div")
	private List<WebElement> listaddressLine1;
	
	public List<WebElement> getListAddressLine1() {
		
		return listaddressLine1;
	}
	
	
	@FindBy(how=How.NAME,using="line2")
	private WebElement addressLine2;
	
	public WebElement getAddressLine2() {
		
		return addressLine2;
	}
	
	@FindBy(how=How.NAME,using="townCity")
	private WebElement town;
	
	public WebElement getTown() {
		
		return town;
	}
	
	
	@FindBy(how=How.XPATH,using="//select[@name='regionIso']")
	private WebElement regionIso;
	
	public WebElement getRegionIso() {
		
		return regionIso;
	}
	
	@FindBy(how=How.XPATH,using="//span[@name='regionIso']/following::ul/li")
	private List<WebElement> listregionIso;
	
	public List<WebElement> getListRegionIso() {
		
		return listregionIso;
	}
	
	
	@FindBy(how=How.NAME,using="postcode")
	private WebElement postcode;
	
	public WebElement getPostcode() {
		
		return postcode;
	}
	

	@FindBy(how=How.XPATH,using="//input[@placeholder='Daytime Phone(mobile preferred) *']")
	private WebElement phoneNumber;
	
	public WebElement getPhoneNumber() {
		
		return phoneNumber;
	}
	
	@FindBy(how=How.XPATH,using="//button[contains(text(), 'Continue to Shipping Method')]")
    private WebElement continueShippingMethod;
	
	public WebElement getContinueShippingMethod() {
		
		return continueShippingMethod;
	}
	
	
	
}
