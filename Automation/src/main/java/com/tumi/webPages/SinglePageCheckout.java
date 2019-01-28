package com.tumi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;

/**
 * @author Shwetha Capo
 *
 */
public class SinglePageCheckout {

	public SinglePageCheckout(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * for Korea Expresscheckout
	 * 
	 * @FindBy(how = How.XPATH, using =
	 * "//button[@class='tm-button tm-white-button singlePageCheckout-login tm-login-element removeFocusIndicator']"
	 * )
	 */

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign In for Express Checkout')]")
	private WebElement signInExpressCheckout;

	public WebElement getSignInExpressCheckout() {

		return signInExpressCheckout;
	}

	@FindBy(how = How.XPATH, using = "(//input[@name='email'])[1]") // same for Korea
	private WebElement emailAddress;

	public WebElement getEmailAddress() {

		return emailAddress;
	}

	/*
	 * for Korea continue as guest
	 * 
	 * @FindBy(how = How.XPATH, using = "(//button[@type='submit'])[1]")
	 */

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue as a Guest')]")
	private WebElement continueAsGuest;

	public WebElement getContinueAsGuest() {

		return continueAsGuest;
	}

	/*
	 * for Korea promotions and news
	 * 
	 * @FindBy(how = How.XPATH, using ="(//label[@class='cvform-lbl-checkbox'])[1]") or (//input[@id='subscribeInfo']/following::label)[1]
	 */
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Send me emails with promotions and news.')]")
	private WebElement promotionsAndNews;

	public WebElement getPromotionsAndNews() {

		return promotionsAndNews;
	}

}