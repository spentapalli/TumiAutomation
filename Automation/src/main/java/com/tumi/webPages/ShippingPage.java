package com.tumi.webPages;

import java.util.List;

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
public class ShippingPage extends GenericMethods{

	public ShippingPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(how=How.XPATH,using="(//input[@name='firstName'])[1]")
	private WebElement firstName;
	
	public WebElement getFirstName() {
		
		return explicitWait(firstName);
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='lastName']")
	private WebElement lastName;
	
	public WebElement getLastName() {
		
		return lastName;
	}
	

	@FindBy(how=How.XPATH,using="//input[@name='line1']")
	private WebElement addressLine1;
	
	public WebElement getAddressLine1() {
		
		return addressLine1;
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='line1']/following::div[2]/div")
	private List<WebElement> listaddressLine1;
	
	public List<WebElement> getListAddressLine1() {
		
		return listaddressLine1;
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Address Line2']")
	private WebElement addressLine2;
	
	public WebElement getAddressLine2() {
		
		return addressLine2;
	}
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Town / City *']")
	private WebElement town;
	
	public WebElement getTown() {
		
		return town;
	}
	
	//select[@name='regionIso']
	@FindBy(how=How.XPATH,using="//span[@name='regionIso']")
	private WebElement regionIso;
	
	public WebElement getRegionIso() {
		
		return regionIso;
	}
	
	@FindBy(how=How.XPATH,using="//span[@name='regionIso']/following::ul/li")
	private List<WebElement> listregionIso;
	
	public List<WebElement> getListRegionIso() {
		
		return listregionIso;
	}
	
	
	//@FindBy(how=How.NAME,using="//input[@placeholder='Zip Code *']")
	@FindBy(how=How.XPATH,using="//input[@name='postcode']")
	
	private WebElement postcode;
	
	public WebElement getPostcode() {
		
		return postcode;
	}
	

	@FindBy(how=How.XPATH,using="//input[@name='phone']")
	private WebElement phoneNumber;
	
	public WebElement getPhoneNumber() {
		
		return phoneNumber;
	}
	
	@FindBy(how=How.XPATH,using="//button[contains(text(), 'Continue to Shipping Method')]")
    private WebElement continueShippingMethod;
	
	public WebElement getContinueShippingMethod() {
		
		return explicitWait(continueShippingMethod);
	}
	
	
	
}
