package com.tumi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class SignInBillingPage extends GenericMethods {
	public SignInBillingPage(WebDriver driver) {
		Reports.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//input[@id='addNewPayment']")
	private WebElement addNewPay;
	public WebElement getAddNewPay() {
		return explicitWait(addNewPay);
	}
	

}
