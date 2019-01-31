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
	
@FindBy(how=How.XPATH,using="(//input[@name='paymentMethodRadio'])[5]")
private WebElement Regpaymentbutton;
public WebElement  getRegpaymentButton() {
	return Regpaymentbutton;
	
}
@FindBy(how=How.XPATH,using ="//input[@name='saveInAccount']")
private WebElement SaveDefaultpayment;
public WebElement getSsaveDefaultPayment() {
	return SaveDefaultpayment;
}
//------------------------
@FindBy(how=How.XPATH,using="//div[@id='paymentSection']/div/div[2]/div/div[1]/div[1]/div[2]/div/div/label")
private WebElement PaypalButton;
public WebElement getPaypalButton() {
	return PaypalButton;
}
@FindBy(how=How.XPATH,using="(//button[@type='submit'])[3]")
private WebElement RevieworderButton;
public WebElement getRevieworderButton() {
	return RevieworderButton;
	
}
@FindBy(how=How.XPATH,using="//div[@id='accordion__title-6']/h5/div")
private WebElement GiftcardButton;
public WebElement getGiftcardButton() {
	return GiftcardButton;
}
@FindBy(how=How.XPATH,using="//input[@name='giftCardNumber']")
private WebElement addGiftcard;
public WebElement getGiftcard() {
	return  addGiftcard;
}
@FindBy(how=How.XPATH,using="//input[@name='giftCardPin']")
private WebElement addGiftpin;
public WebElement getGiftpin() {
	return addGiftpin;
	
}
@FindBy(how=How.XPATH,using="(//button[@type='submit'])[1]")
private WebElement addGiftcardApply;
public WebElement getaddGiftcardApply() {
	return addGiftcardApply;
}
}

