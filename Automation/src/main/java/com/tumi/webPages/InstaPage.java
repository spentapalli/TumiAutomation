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
public class InstaPage extends GenericMethods {
	
	public InstaPage(WebDriver driver) {
		Reports.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using= "//li[@id='janrain-instagram']")
	private WebElement insta;
	
	public WebElement getInsta() {
		return explicitWait(insta);
	}
	
	@FindBy(how=How.XPATH, using="//input[@name='username']")
	private WebElement instaUsername;
	
	public WebElement getInstaUsername() {
		return explicitWait(instaUsername);
	}

	public WebElement getInstaPassword() {
		return instaPassword;
	}

	public WebElement getInstaLogin() {
		return instaLogin;
	}

	@FindBy(how=How.XPATH, using="//input[@name='password']")
	private WebElement instaPassword;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Log in')]")
	private WebElement instaLogin;
	
	@FindBy(how=How.XPATH, using="//div[@class='eiCW-']/p")
	private WebElement passwordErr;
	
	public WebElement getPasswordErr() {
		return passwordErr;
	}

	public WebElement getUsernameErr() {
		return usernameErr;
	}

	@FindBy(how=How.XPATH, using="//p[@id='slfErrorAlert']")
	private WebElement usernameErr;
	
	@FindBy(how=How.XPATH, using="//div[@class='eiCW-']/p")
	private WebElement instaErr;
	
	public WebElement getInstaErr() {
		return instaErr;
	}

}
