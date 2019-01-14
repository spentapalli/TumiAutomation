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
public class MultiShippingPage extends GenericMethods{
	
	public MultiShippingPage(WebDriver driver) {
		Reports.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using=("//input[@id='multiShipment']"))
	private WebElement multiShipClick;
	
	public WebElement getMultiShipClick() {
		return multiShipClick;
	}
	//input[@id='AddToShipment0']
	@FindBy(how=How.XPATH,using=("//input[@id='AddToShipment0']"))
	private WebElement addShippment0;
	
	public WebElement getAddShippment0() {
		return addShippment0;
	}
	@FindBy(how=How.XPATH,using=("//input[@id='AddToShipment1']"))
	private WebElement addShippment1;
	
	public WebElement getAddShippment1() {
		return addShippment1;
	}
	@FindBy(how=How.XPATH,using=("//button[contains(text(),'Next')]"))
	private WebElement next;
	
	public WebElement getNext() {
		return next;
	}
	@FindBy(how=How.XPATH,using=("//button[contains(text(),'Next Shipment')]"))
	private WebElement nextShipment;
	
	public WebElement getNextShipment() {
		return nextShipment;
	}
	
	

}
