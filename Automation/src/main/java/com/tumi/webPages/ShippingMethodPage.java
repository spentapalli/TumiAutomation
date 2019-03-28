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
public class ShippingMethodPage extends GenericMethods {

	public ShippingMethodPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='standard-international-shipping-net']")
	private WebElement caStandardShippingMethod; // use this for canada

	@FindBy(how = How.XPATH, using = "//input[@id='standard-ground-net']") // this is for US
	private WebElement usStandardShippingMethod;

	@FindBy(how = How.XPATH, using = "//input[@name='deliveryMethodSelected']") // this is for Korea
	private WebElement krStandardShippingMethod;

	public WebElement getStandardShippingMethod() {

		if (selectedCountry.contains("Canada")) {

			return explicitWait(caStandardShippingMethod);

		} else if (selectedCountry.contains("US")) {

			return explicitWait(usStandardShippingMethod);
		} else {
			return explicitWait(krStandardShippingMethod);
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

	public WebElement getPriorityShippingMethod() {

		return explicitWait(priorityShippingMethod);
	}

	@FindBy(how = How.XPATH, using = "(//script[@id='checkoutMessages']/following::button)[3]") // for Korea proceed to
																								// payment
	private WebElement krProceedToPayment;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Proceed to Payment')]")
	private WebElement proceedToPayment;

	public WebElement getProceedToPayment() {
		delay(2000);
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return explicitWait(proceedToPayment);
		} else {

			return explicitWait(krProceedToPayment);
		}
	}

	@FindBy(how = How.XPATH, using = "(//button[@type='button'])[1]")
	private WebElement krEditAddress;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Edit')]")
	private WebElement editAddress;

	public WebElement getEditAddress() {
		delay(2000);
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return explicitWait(editAddress);
		} else {

			return explicitWait(krEditAddress);
		}

	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'address-info')]")
	private WebElement krAddInfo;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'address-info')]")
	private WebElement addInfo;

	public WebElement getAddInfo() {
		delay(2000);
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return addInfo;
		} else {

			return krAddInfo;
		}

	}

	@FindBy(how = How.XPATH, using = "(//script[@id='checkoutMessages']/following::button)[3]") /////////////////
	private WebElement krEstimatedShipping;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'pad3 onlyBottomPad')])[2]/div[2]")
	private WebElement estimatedShipping;

	public WebElement getEstimatedShipping() {
		delay(2000);
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return estimatedShipping;
		} else {

			return krEstimatedShipping;
		}

	}

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'pad3 onlyBottomPad')])[2]/div[2]")
	private WebElement shippingFree;

	public WebElement getEstimatedShipFree() {
		return shippingFree;
	}

	@FindBy(how = How.XPATH, using = "(//div[@class='line1'])[3]")
	private WebElement StandardGround;

	public WebElement getStandardGround() {

		return StandardGround;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='standard-ground-net']/../label/div[3]")
	private WebElement StandardShippingCharge;

	public WebElement getFirstShippingmethod() {

		return StandardShippingCharge;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='second-day-net']/../label/div[3]")
	private WebElement SecondShippingCharge;

	public WebElement getSecondShippingCharge() {

		return SecondShippingCharge;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='standard-international-shipping-net']/../label/div[3]")
	private WebElement caStandardShippingCharge;

	public WebElement getCAStandardShippingCharge() {

		return caStandardShippingCharge;
	}
	@FindBy(how = How.XPATH, using = "//input[@id='standard-shipping']/../label/div[3]")
	private WebElement krStandardShippingCharge;

	public WebElement getKrStandardShippingCharge() {

		return krStandardShippingCharge;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='overnight-net']/../label/div[3]")
	private WebElement Prioritycharge;

	public WebElement getPrioritycharge() {

		return Prioritycharge;
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'small total-price')]")
	private WebElement beforeTotal;

	public WebElement getBeforeTotal() {

		return beforeTotal;
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'small value tm_RED')]")
	private WebElement promoCharge;

	public WebElement getPromoCharge() {

		return promoCharge;
	}
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'pad3 onlyBottomPad')]/div[2]")
	private WebElement caSubTotal;

	public WebElement getCaSubTotal() {

		return caSubTotal;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='standard-international-shipping-net']/../label/div[1]")
	private WebElement CaStandardGround;
	public WebElement getCaShippingmethod() {
	return CaStandardGround;
	}
	@FindBy(how = How.XPATH, using = "//input[@id='standard-international-shipping-net']/../label/div[3]")
	private WebElement CastandardShippingFree;
	public WebElement getCaShippingFree() {
	return CastandardShippingFree;
}
	
	
	}

