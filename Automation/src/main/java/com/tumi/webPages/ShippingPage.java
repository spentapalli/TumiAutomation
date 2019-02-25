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
public class ShippingPage extends GenericMethods {

	public ShippingPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//input[@name='firstName'])[1]") // same for korea
	private WebElement firstName;

	public WebElement getFirstName() {

		return explicitWait(firstName);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='lastName']") // same for korea
	private WebElement lastName;

	public WebElement getLastName() {

		return lastName;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='line1']") // same for korea
	private WebElement addressLine1;

	public WebElement getAddressLine1() {

		return explicitWait(addressLine1);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='address-picklist']/div")
	private WebElement selectedAddressLine1;

	public WebElement getSelectedAddressLine() {
		return explicitWait(selectedAddressLine1);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='line1']/following::div[2]/div")
	private List<WebElement> listaddressLine1;

	public List<WebElement> getListAddressLine1() {

		return listaddressLine1;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='line1']/following::div[2]/div")
	private WebElement addressList;

	public WebElement getAddressList() {

		return addressList;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='line2']")
	private WebElement krAddressLine2;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Address Line2']")
	private WebElement addressLine2;

	public WebElement getAddressLine2() {
		if (selectedCountry.contains("배송하기: 대한민국")) {
			return krAddressLine2;
		} else {
			return addressLine2;
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@name='townCity']")
	private WebElement krTown;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Town / City *']")
	private WebElement town;

	public WebElement getTown() {
		if (selectedCountry.contains("US")||
				selectedCountry.contains("Canada")) {
			return town;
		} else {
			return krTown;
		}
	}

	// select[@name='regionIso']
	@FindBy(how = How.XPATH, using = "//span[@name='regionIso']") // this is not avialable for korea
	private WebElement regionIso;

	public WebElement getRegionIso() {

		return regionIso;
	}

	@FindBy(how = How.XPATH, using = "//span[@name='regionIso']/following::ul/li")
	private List<WebElement> listregionIso;

	public List<WebElement> getListRegionIso() {

		return listregionIso;
	}

	// @FindBy(how=How.NAME,using="//input[@placeholder='Zip Code *']")
	@FindBy(how = How.XPATH, using = "//input[@name='postcode']") // same for Korea

	private WebElement postcode;

	public WebElement getPostcode() {

		return postcode;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='phone']")
	private WebElement phoneNumber;

	public WebElement getPhoneNumber() {

		return phoneNumber;
	}

	@FindBy(how = How.XPATH, using = "(//script[@id='checkoutMessages']/following::button)[3]")
	private WebElement krContinueShippingMethod;

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Continue to Shipping Method')]")
	private WebElement continueShippingMethod;

	public WebElement getContinueShippingMethod() {

		if (selectedCountry.contains("배송하기: 대한민국")) {
			return explicitWait(krContinueShippingMethod);
		} else {

			return explicitWait(continueShippingMethod);
		}

	}
	@FindBy(how = How.XPATH, using = "//div[@class='address-picklist']/div")
	private List<WebElement> addList;
	
	public List<WebElement> getAddList() {
		return addList;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='line1']/following::div[2]/div")
	private List<WebElement> addListCA;
	
	public List<WebElement> getAddListCA() {
		return addListCA;
	}

}
