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
public class GuestBillingPage extends GenericMethods {
	
	public GuestBillingPage(WebDriver driver) {
		Reports.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//input[@name='nameOnCard']")
	private WebElement nameOnCard;
	
	public WebElement getNameOnCard() {
		
		return explicitWait(nameOnCard);
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='cardNumber']")
	private WebElement cardNumber;
	
	public WebElement getCardNumber() {
		
		return cardNumber;
	}

	@FindBy(how=How.XPATH,using="//select[@name='expiryMonth']")
	private WebElement expiryMonth;
	
	public WebElement getExpiryMonth() {
		
		return expiryMonth;
	}
	
	
	
	@FindBy(how=How.XPATH,using="//select[@name='expiryYear']")
	private WebElement expiryYear;
	
	public WebElement getExpiryYear() {
		
		return expiryYear;
	}
	
	@FindBy(how=How.ID,using="card_cvv")
	private WebElement cvvNumber;
	
	public WebElement getCvvNumber() {
		
		return cvvNumber;
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='email'][@placeholder='Email Address *']")
	private WebElement email;
	
	public WebElement getemail() {
		
		return email;
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='phone'][@placeholder='Daytime Phone(mobile preferred) *']")
	private WebElement phoneNumber;
	
	public WebElement getPhoneNumber() {
		
		return explicitWait(phoneNumber);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='shippingAddressForBilling']")
	private WebElement useShippingAddressAsBilling;
	
	public WebElement getShippingAddressAsBilling() {
		
		return useShippingAddressAsBilling;
	}
	
	//@FindBy(how=How.XPATH,using="//div[@id='newPaymentButton']/button")
	//for multiship
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Review Your Order')]")
	
	private WebElement reviewOrder;
	
	public WebElement getReviewOrder() {
		
		return explicitWait(reviewOrder);
	}
	
	@FindBy(how=How.XPATH,using="//span[@name='countryIso']")
	private WebElement countrySelector;
	
	public WebElement getCountrySelector() {
		
		return countrySelector;
	}
	
	@FindBy(how=How.NAME,using="firstName")
	private WebElement firstName;
	
	public WebElement getFirstName() {
		
		return firstName;
	}
	
	@FindBy(how=How.NAME,using="lastName")
	private WebElement lastName;
	
	public WebElement getLastName() {
		
		return lastName;
	}
	
	@FindBy(how=How.NAME,using="line1")
	private WebElement addressLine1;
	
	public WebElement getAddressLine1() {
		
		return addressLine1;
	}
	
	@FindBy(how=How.NAME,using="line2")
	private WebElement addressLine2;
	
	public WebElement getAddressLine2() {
		
		return addressLine2;
	}
	
	@FindBy(how=How.NAME,using="townCity")
	private WebElement townOrCity;
	
	public WebElement getTownOrCity() {
		
		return townOrCity;
	}
	
	@FindBy(how=How.NAME,using="regionIso")
	private WebElement selectState;
	
	public WebElement getselectState() {
		
		return selectState;
	}
	
	@FindBy(how=How.NAME,using="postcode")
	private WebElement zipcode;
	
	public WebElement getZipcode() {
		
		return zipcode;
	}
	


	@FindBy(how = How.XPATH, using = "//div[@id='accordion__title-9']")
	private WebElement GiftcardButton;

	public WebElement getGiftcardButton() {
		return explicitWait(GiftcardButton);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='giftCardNumber']")
	private WebElement addGiftcard;

	public WebElement getGiftcard() {
		return addGiftcard;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='giftCardPin']")
	private WebElement addGiftpin;

	public WebElement getGiftpin() {
		return addGiftpin;

	}
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Check Balance')]")
	private WebElement checkBal;

	public WebElement getCheckBal() {
		return explicitWait(checkBal);

	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='accordion__body-9']/div/div")
	private WebElement availBalMsg;

	public WebElement getAvailBalMsg() {
		return availBalMsg;

	}

	@FindBy(how = How.XPATH, using = "(//button[@type='submit'])[1]")
	private WebElement addGiftcardApply;

	public WebElement getaddGiftcardApply() {
		return explicitWait(addGiftcardApply);

	}
	
	@FindBy(how=How.XPATH,using="//div[contains(@class,'checkoutAccordion')]/div")
	private List<WebElement> accordionBillList;
	
	public List<WebElement> getAccordionBillList(){
		
		return accordionBillList;
	}
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Remove')]")
	private WebElement removeGift;

	public WebElement getRemoveGift() {
		return removeGift;

	}
	@FindBy(how = How.XPATH, using = "//div[@id='accordion__body-9']/div/div")
	private WebElement lowBalMsg;

	public WebElement getLowBalMsg() {
		return lowBalMsg;

	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='accordion__body-9']/div/div")
	private WebElement invalidGift;

	public WebElement getInvalidGift() {
		return invalidGift;

	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='payPal']/../label")
	private WebElement payPal;

	public WebElement getPayPal() {
		return payPal;

	}
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Items Saved in Cart')]")
	private WebElement itemsInCart;

	public WebElement getItemsInCart() {
		return itemsInCart;

	}


}
