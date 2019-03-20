package com.tumi.webPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class CartPage extends GenericMethods {

	public CartPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(how = How.XPATH, using = "//input[@id='select-qty']")
	private WebElement editProductQuantity;

	public WebElement getEditProductQuantity() {
		
			return editProductQuantity;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Edit')][1]")
	private WebElement editMonogramQuantity;

	public WebElement getEditMonogramQuantity() {

		return editMonogramQuantity;
	}

	@FindBy(how = How.XPATH, using = ("//div[@id='cart-items-container']/div[2]/div[1]/div[1]/div[2]/div[6]/span[3]/a"))
	private WebElement krremoveProductsQuantity;

	@FindBy(how = How.XPATH, using = "//a[@class='cta removeFocusIndicator']")
	private WebElement removeProduct;

	public WebElement getRemoveProduct() {
		if (selectedCountry.contains("US")||
				selectedCountry.contains("Canada")) {
			return removeProduct;
			
		} else {

			return krremoveProductsQuantity;
		}
	}

	@FindBy(how = How.XPATH, using = ("//div[@id='cart-summary-container']/div[2]/div[2]/div[1]/button"))
	private WebElement krProceedtoCart;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Proceed to Checkout')]")
	private WebElement proceedToCheckout;

	public WebElement getProceedCart() {
		if (selectedCountry.contains("US")|| selectedCountry.contains("United States")
				|| selectedCountry.contains("Canada")) {
			UIFunctions.delay(2000);
			return explicitWait(proceedToCheckout);
		} else {
			UIFunctions.delay(2000);
			return explicitWait(krProceedtoCart);
		}

	}

	@FindBy(how = How.XPATH, using = "//img[@alt='Checkout with PayPal']")
	private WebElement payPalProceed;

	public WebElement getPayPalProceed() {

		return payPalProceed;

	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Remove')])[1]")
	private WebElement removeItemInCart;

	public WebElement getRemoveItemInCart() {

		return removeItemInCart;

	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'empty-cart')]/p")
	private WebElement shopingCartMessege;

	public WebElement getShopingCartMessege() {

		return shopingCartMessege;

	}

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Add a Monogram')]/following-sibling::div/a")
	private List<WebElement> addClassicMonogram;

	public WebElement getAddClassicMonogram() {

		return addClassicMonogram.get(1);

	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Metal ($15/letter)')])[1]")
	private WebElement addMetalMonogram;

	public WebElement getAddMetalMonogram() {

		return addMetalMonogram;

	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Next')])[2]")
	private WebElement clickNext;

	public WebElement getClickNext() {

		return clickNext;

	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Apply')])[1]")
	private WebElement clickApply;

	public WebElement getClickApply() {

		return clickApply;

	}

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'added-monogram')]/div/span/following::span)[1]")
	private WebElement monogramMessege;

	public WebElement getMonogramMessege() {

		return monogramMessege;

	}

	@FindBy(how = How.XPATH, using = ("//div[@id='cart-items-container']/div[2]/div[1]/div[1]/div[2]/div[9]/div[2]/a"))
	private WebElement krMakegiftbox;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Make this a Gift')]")
	private List<WebElement> makeGiftBox;

	public WebElement getMakeGiftBox() {
		if (selectedCountry.contains("US")||
				selectedCountry.contains("Canada")) {
			
			return makeGiftBox.get(1);
		} else {

			return explicitWait(krMakegiftbox);
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@id='giftMessage']")
	private WebElement includeGiftMessege;

	public WebElement getIncludeGiftMessege() {

		return includeGiftMessege;

	}

	@FindBy(how = How.XPATH, using = "//input[@id='to']")
	private WebElement recipientName;

	public WebElement getRecipientName() {

		return recipientName;

	}

	@FindBy(how = How.XPATH, using = "//input[@id='from']")
	private WebElement senderName;

	public WebElement getSenderName() {

		return senderName;

	}

	@FindBy(how = How.XPATH, using = "//textarea[@id='message']")
	private WebElement addMessege;

	public WebElement getAddMessege() {

		return addMessege;

	}

	// same for korea
	@FindBy(how = How.XPATH, using = "//input[@id='giftBox']")
	private WebElement standardGiftBoxing;

	public WebElement getStandardGiftBoxing() {

		return standardGiftBoxing;

	}

//same for korea
	@FindBy(how = How.XPATH, using = "//button[@id='giftCardApplyBtn']")
	private WebElement continueButton;

	public WebElement getContinueButton() {

		return continueButton;

	}

	@FindBy(how = How.XPATH, using = "//div[@id='cart-items-container']/div/div/div/div/div/div/div/strong[1]")
	private WebElement giftBoxAdded;

	public WebElement getGiftBoxAdded() {

		return giftBoxAdded;
	}

	@FindBy(how = How.XPATH, using = ("(//input[@name='voucherCode'])[2]"))
	private WebElement krVoucherID;

	@FindBy(how = How.XPATH, using = "//input[@name='voucherCode']")
	private WebElement addPromocode;

	public WebElement getPromocode() {
		if (selectedCountry.contains("US")||
				selectedCountry.contains("Canada")) {
			return explicitWait(addPromocode);
			
		} else {
			return explicitWait(krVoucherID);
			
		}
	}

	@FindBy(how = How.XPATH, using = ("(//button[@id='signupnewsletter'])[2]"))
	private WebElement krApplyVoucher;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Apply')]")
	private WebElement ApplyClick;

	public WebElement getApply() {
		if (selectedCountry.contains("US")||
				selectedCountry.contains("Canada")) {
			return explicitWait(ApplyClick);
			
		} else {
			return explicitWait(krApplyVoucher);
		}
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Apply')]/../../following-sibling::div")
	private WebElement VocherMsg;

	public WebElement getVocherMsg() {

		return explicitWait(VocherMsg);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='globalMessages']")
	private WebElement vocherCardFailed;

	public WebElement getVocherCardFailed() {

		return vocherCardFailed;
	}

	@FindBy(how = How.XPATH, using = "(//div[contains(text(),'Promotional Code Applied:')])[2]/../form")
	private WebElement codeRemove;

	public WebElement getCodeRemove() {

		return codeRemove;
	}

	@FindBy(how = How.XPATH, using = "(//div[contains(text(),'Promotional Code Applied:')])[2]")
	private WebElement codeApplied;

	public WebElement getCodeApplied() {

		return codeApplied;
	}
	
	@FindBy(how = How.XPATH, using = "(//button[@type='submit'])[2]/following::div")
	private WebElement promoSuccessMsg;

	public WebElement getPromoSuccessMsg() {

		return promoSuccessMsg;
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'pad20 onlyTopPad')]/div/div[3]")
	private WebElement discountSummery;

	public WebElement getDiscountSummery() {

		return discountSummery;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Subtotal')]/../following-sibling::div[1]")
	private WebElement subtotalCode;

	public WebElement getSubtotalCode() {

		return subtotalCode;
	}

	// Korea-Cart
	// updatecart

	@FindBy(how = How.XPATH, using = ("//button[@id='updateCartButton']"))
	private WebElement UpdateCart;

	public WebElement getUpdatecart() {
		return UpdateCart;
	}

	@FindBy(how = How.XPATH, using = ("//input[@name='quantity']"))
	private WebElement UpdatecartQuantity;

	public WebElement getUpdatecartQuantity() {
		return UpdatecartQuantity;

	}

	// ContinueShopping
	@FindBy(how = How.XPATH, using = ("//main[@id='navEnd']/div[3]/div[1]/h2/a"))
	private WebElement ContinueShopping;

	public WebElement getContinueshopping() {
		return ContinueShopping;
	}

	@FindBy(how = How.XPATH, using = (""))
	private WebElement subTotalValue;

	public WebElement getSubTotalValue() {
		return subTotalValue;
	}
	
	@FindBy(how = How.XPATH, using = ("//div[@id='cart-summary-container']/div[2]/div/div[2]/div[2]/div[2]"))
	private WebElement estimatedTotalRegistered;
	
	public WebElement getEstimatedTotalRegistered() {
		return estimatedTotalRegistered;
	}
	

	@FindBy(how = How.XPATH, using = ("//div[@id='cart-summary-container']//div[2]/div/div[2]/div[2]/div[2]"))
	private WebElement estimatedTotal;
	
	public WebElement getEstimatedTotal() {
		return estimatedTotal;
	}
	
}
