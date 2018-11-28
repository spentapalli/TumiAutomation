package com.tumi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="(//a[contains(text(),'Sign In')])[1]")
	//us
	//@FindBy(how=How.XPATH,using="//div[@id='signInDiv']")
	private WebElement loginWindow;
	
	public WebElement getLoginWindow() {
		
		return loginWindow;
	}
	@FindBy(how=How.ID,using="j_username")
	private WebElement loginUsername;
	
	public WebElement getLoginUsername() {
		
		 return loginUsername;
	}
	
	@FindBy(how=How.ID,using="j_password")
	private WebElement loginPassword;
	
	public WebElement getLoginPassword() {
		
		return loginPassword;
	}
	
	@FindBy(how=How.ID,using="j_remember")
	private WebElement rememberMe;
	
	public WebElement getRememberMe() {
		
		return rememberMe;
	}
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Forgot password?')]")
	private WebElement forgetPassword;
	
	public WebElement getForgetPAssword() {
		
		return rememberMe;
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='login-option-regular']/input")
	private WebElement signInClick;
	
	public WebElement getSignInClick() {
		
		return signInClick;
	}
	

}
