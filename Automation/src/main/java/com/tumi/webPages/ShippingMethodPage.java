package com.tumi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class ShippingMethodPage extends GenericMethods {

	public ShippingMethodPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='standard-international-shipping-net']")
	private WebElement caStandardShippingMethod; //use this for canada
	
	@FindBy(how = How.XPATH, using = "//input[@id='standard-ground-net']") //this is for US
	private WebElement usStandardShippingMethod;
	
	@FindBy(how=How.XPATH,using="//input[@name='deliveryMethodSelected']") //this is for Korea
	private WebElement krStandardShippingMethod;

	public WebElement getStandardShippingMethod() {

		if (selectedCountry.contains("Canada")) {

			return explicitWait(caStandardShippingMethod);
			
		} else if (selectedCountry.contains("배송하기: 대한민국")) {
			
			return explicitWait(krStandardShippingMethod);
		}else {
			return explicitWait(usStandardShippingMethod);
		}

	}

	@FindBy(how = How.XPATH, using = "//input[@id='standard-ground-net']/../label/div[3]")
	private WebElement standardShippingFree;

	public WebElement getShippingFree() {

		return standardShippingFree;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='standard-international-shipping-net']")
	private WebElement caStandardShippingMethod1;

	public WebElement getCaStandardShippingMethod() {

		return explicitWait(caStandardShippingMethod);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='second-day-net']")
	private WebElement secondDayShippingMethod;

	public WebElement getSecondDayShippingMethod() {

		return explicitWait(secondDayShippingMethod);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='overnight-net']")
	private WebElement priorityShippingMethod;

	public WebElement getpriorityShippingMethod() {

		return explicitWait(priorityShippingMethod);
	}
	
	@FindBy(how = How.XPATH, using = "(//script[@id='checkoutMessages']/following::button)[3]") // for Korea proceed to payment
	private WebElement krProceedToPayment;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Proceed to Payment')]")
	private WebElement proceedToPayment;

	public WebElement getProceedToPayment() {
		if (selectedCountry.contains("배송하기: 대한민국")) {
			return explicitWait(krProceedToPayment);
		}else {
			
		return explicitWait(proceedToPayment);
	}

}
}
