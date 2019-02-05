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
public class LoginPage extends GenericMethods {

	public LoginPage(WebDriver driver) {

		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(how = How.XPATH, using = "//font[@class='removeFocusIndicator']/font")
	private WebElement krLoginWindow;
	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Sign In')])[1]")
	// us
	// @FindBy(how=How.XPATH,using="//div[@id='signInDiv']")
	private WebElement loginWindow;

	public WebElement getLoginWindow() {
		if (selectedCountry.contains("배송하기: 대한민국")) {
			return explicitWait(krLoginWindow);
			} else {
			return loginWindow;
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@id='j_username']")
	private WebElement loginUsername;

	public WebElement getLoginUsername() {

		return loginUsername;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='j_password']")
	private WebElement loginPassword;

	public WebElement getLoginPassword() {

		return loginPassword;
	}

	@FindBy(how = How.ID, using = "j_remember")
	private WebElement rememberMe;

	public WebElement getRememberMe() {

		return rememberMe;
	}

	@FindBy(how = How.XPATH, using = "//span[@class='link-underline']/font")
	private WebElement krForgetPassword;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Forgot password?')]")
	private WebElement forgetPassword;

	public WebElement getForgetPAssword() {
		if (selectedCountry.contains("배송하기: 대한민국")) {
			return krForgetPassword;
		} else {
			return rememberMe;
		}
	}

	@FindBy(how = How.XPATH, using = "(//input[@class='tm-button login-button'])[1]")
	private WebElement krSignInClick;

	@FindBy(how = How.XPATH, using = "//input[@value='Sign in']")
	private WebElement signInClick;

	public WebElement getLogOn() {
		if (selectedCountry.contains("배송하기: 대한민국")) {
			return krSignInClick;
		} else {
			return signInClick;
		}
	}

	@FindBy(how = How.XPATH, using = "//li[@class='removeFocusIndicator']/a")
	private WebElement krLogOut;

	@FindBy(how = How.XPATH, using = "//a[@title='Sign Out']")
	private WebElement logOut;

	public WebElement getLogOut() {
		if (selectedCountry.contains("배송하기: 대한민국")) {
			return explicitWait(krLogOut);
		} else {
			return logOut;
		}
	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Hi, Tumi')])[2]")
	private WebElement UserHi;

	public WebElement getUserHi() {

		return UserHi;
	}

	@FindBy(how = How.XPATH, using = "(//header[@class='tm-header']/a/span)[4]")
	private WebElement krCloseWindow;

	@FindBy(how = How.XPATH, using = "(//header[@class=\"tm-header\"])[2]/a")
	private WebElement closeWindow;

	public WebElement getCloseWindow() {
		if (selectedCountry.contains("배송하기: 대한민국")) {
			return krCloseWindow;
		} else {
			return closeWindow;
		}
	}
	




}


