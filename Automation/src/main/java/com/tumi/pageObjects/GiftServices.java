package com.tumi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class GiftServices extends GenericMethods {
	
	public GiftServices(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="(//a[contains(text(),'Make this a Gift')])[1]")
	private WebElement makeThisGift;
	
	public WebElement getMakeThisGift() {
		return makeThisGift;
	}

	@FindBy(how=How.XPATH, using="//input[@id='giftMessage']")
	private WebElement checkMessage;
	
	public WebElement getCheckMessage() {
		return checkMessage;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='to']")
	private WebElement recipientName;
	
	public WebElement getRecipientName() {
		return recipientName;
	}
	
	
	@FindBy(how=How.XPATH, using="//input[@id='from']")
	private WebElement senderName;
	
	public WebElement getSenderName() {
		return senderName;
	}
	
	@FindBy(how=How.XPATH, using="//textarea[@id='message']")
	private WebElement addMessage;
	
	public WebElement getAddMessage() {
		return addMessage;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='premiumGiftBox']")
	private WebElement checkPremiumGift;
	
	public WebElement getCheckPremiumGift() {
		return checkPremiumGift;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='giftBox']")
	private WebElement checkStandardGift;
	
	public WebElement getCheckStandardGift() {
		return checkStandardGift;
	}
	
	@FindBy(how=How.XPATH, using="//button[@id='giftCardApplyBtn']")
	private WebElement continueGiftService;
	
	public WebElement getContinueGiftService() {
		return continueGiftService;
	}

}


	

	

	

	

	

	