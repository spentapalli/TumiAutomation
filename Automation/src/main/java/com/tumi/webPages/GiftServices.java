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
public class GiftServices extends GenericMethods {
	
	public GiftServices(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = ("//div[@id='cart-items-container']/div[2]/div[1]/div[1]/div[2]/div[9]/div[2]/a"))
	private WebElement krMakegiftbox;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Make this a Gift')]")
	private WebElement makeGiftBox;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Gift Card/Services')]")
	private WebElement makeGiftCard;

	public WebElement getMakeThisGift() {
		if (browserName.equals("mobile")) {
			return makeGiftCard;
		}else {
			if (selectedCountry.contains("US")||
					selectedCountry.contains("Canada")) {
				return makeGiftBox;
			} else {
				return explicitWait(krMakegiftbox);
			
			}
		
		}
	}

	

	@FindBy(how=How.XPATH, using="//input[@id='giftMessage']")
	private WebElement checkMessage;
	
	public WebElement getCheckMessage() {
		return checkMessage;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='to']")
	private WebElement recipientName;
	
	public WebElement getRecipientName() {
		return explicitWait(recipientName);
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
	
	//@FindBy(how=How.XPATH, using="//input[@id='premiumGiftBox']")
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),' Premium Gift Boxing ')]")
	private WebElement checkPremiumGift;
	public WebElement getCheckPremiumGift() {
	
		return explicitWait(checkPremiumGift);
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='giftBox']")
	private WebElement checkStandardGift;
	
	public WebElement getCheckStandardGift() {
		return checkStandardGift;
	}
	
	@FindBy(how=How.XPATH, using="//button[@id='giftCardApplyBtn']")
	private WebElement continueGiftService;
	
	public WebElement getContinueGiftService() {
		return explicitWait(continueGiftService);
	}
	@FindBy(how=How.XPATH, using="(//div[contains(@class,'extra-actions')])[2]/a")
	private WebElement giftEdit;
	
	public WebElement getGiftEdit() {
		return explicitWait(giftEdit);
	}
	@FindBy(how=How.XPATH, using="//div[contains(@class,'giftBoxAdded')]/div/form/input[3]")
	private WebElement giftRemove;
	
	public WebElement getGiftRemove() {
		return explicitWait(giftRemove);
	}
	@FindBy(how=How.XPATH, using="//div[contains(@class,'giftBoxAdded')]/strong[2]")
	private WebElement giftMsgAdded;
	
	public WebElement getGiftMsgAdded() {
		return giftMsgAdded;
	}
	@FindBy(how=How.XPATH, using="//div[contains(@class,'giftBoxAdded')]/strong[1]")
	private WebElement giftBoxAdded;
	
	public WebElement getGiftBoxAdded() {
		return giftBoxAdded;
	}

}


	

	

	

	

	

	