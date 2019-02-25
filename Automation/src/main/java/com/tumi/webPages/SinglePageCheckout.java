package com.tumi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

/**
 * @author Shwetha Capo , Suresh
 *
 */
public class SinglePageCheckout extends GenericMethods {

	public SinglePageCheckout(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[@class='tm-button tm-white-button singlePageCheckout-login tm-login-element removeFocusIndicator']")
	private WebElement krSignInExpressCheckout;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign In for Express Checkout')]")
	private WebElement signInExpressCheckout;

	public WebElement getSignInExpressCheckout() {
		if (selectedCountry.contains("US")||
				selectedCountry.contains("Canada")) {
			
			return signInExpressCheckout;
		} else {
			return krSignInExpressCheckout;
		}
	}

	@FindBy(how = How.XPATH, using = "(//input[@name='email'])[1]") // same for Korea
	private WebElement emailAddress;

	public WebElement getEmailAddress() {

		return explicitWait(emailAddress);
	}

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'disabled-red-button')]") // same for Korea
	private WebElement continuedisplayed;

	public WebElement isContinueDisabled() {

		return explicitWait(continuedisplayed);
	}

	@FindBy(how = How.XPATH, using = "(//button[@type='submit'])[1]")
	private WebElement krContinueAsGuest;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue as a Guest')]")
	private WebElement continueAsGuest;

	public WebElement getContinueAsGuest() {
		if (selectedCountry.contains("US")||
				selectedCountry.contains("Canada")) {
			
			return explicitWait(continueAsGuest);
		} else {
			return explicitWait(krContinueAsGuest);
		}
	}

	@FindBy(how = How.XPATH, using = "(//label[@class='cvform-lbl-checkbox'])[1]") // or
																					// (//input[@id='subscribeInfo']/following::label)[1]
	private WebElement krPromotionsAndNews;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Send me emails with promotions and news.')]")
	private WebElement promotionsAndNews;

	public WebElement getPromotionsAndNews() {
		if (selectedCountry.contains("US")||
				selectedCountry.contains("Canada")) {
			return promotionsAndNews;
		} else {
			return explicitWait(krPromotionsAndNews);
			
		}
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='voucherCode']")
	private WebElement addPromocode;
	
	public WebElement getPromocode() {
		return  explicitWait(addPromocode);
	}
	@FindBy(how=How.XPATH,using="(//button[@type='submit'])[2]")
	private WebElement ApplyClick;
	
	public WebElement getApply() {
		
		return explicitWait(ApplyClick);
	}

}