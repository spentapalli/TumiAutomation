package com.tumi.webPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class CartPage extends GenericMethods {
	
	public CartPage(WebDriver driver) {
		Reports.driver= driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Edit')][1]")
	private WebElement editProductQuantity;
	
	public WebElement getEditProductQuantity() {
		
		return editProductQuantity;
	}
	
	/*@FindBy(how=How.XPATH,using="//a[@class='cta removeFocusIndicator']")
	private WebElement removeProduct;
	
	public WebElement getRemoveProduct() {
		
		return removeProduct;
	}*/

	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Proceed to Checkout')]")
	private WebElement proceedToCheckout;
	
	public WebElement getProceedToCheckout() {
		
		return proceedToCheckout;
		
	}
	
	@FindBy(how=How.XPATH, using="")
	private WebElement krProceedtoCheckout;
	
	public WebElement getkrProceedtoCheckout() {
		return krProceedtoCheckout;
	}
	
	@FindBy(how=How.XPATH,using= "//img[@alt='Checkout with PayPal']")
    private WebElement payPalProceed;
	
	public WebElement getPayPalProceed() {
		
		return payPalProceed;
		
	}
	
	@FindBy(how=How.XPATH,using= "(//a[contains(text(), 'Remove')])[1]")
    private WebElement removeItemInCart;
	
	public WebElement getRemoveItemInCart() {
		
		return removeItemInCart;
		
	}
	
	@FindBy(how=How.XPATH,using= "//div[contains(@class, 'empty-cart')]/p")
    private WebElement shopingCartMessege;
	
	public WebElement getShopingCartMessege() {
		
		return shopingCartMessege;
		
	}
	@FindBy(how=How.XPATH,using= "//*[contains(text(),'Add a Monogram')]/following-sibling::div/a")
    private List<WebElement> addClassicMonogram;
	
	public WebElement getAddClassicMonogram() {
		
		return addClassicMonogram.get(1);
		
	}
	
	@FindBy(how=How.XPATH,using= "(//a[contains(text(),'Metal ($15/letter)')])[1]")
    private WebElement addMetalMonogram;
	
	public WebElement getAddMetalMonogram() {
		
		return addMetalMonogram;
		
	}

	@FindBy(how=How.XPATH,using= "(//a[contains(text(),'Next')])[2]")
    private WebElement clickNext;
	
	public WebElement getClickNext() {
		
		return clickNext;
		
	}
	
	@FindBy(how=How.XPATH,using= "(//a[contains(text(),'Apply')])[1]")
    private WebElement clickApply;
	
	public WebElement getClickApply() {
		
		return clickApply;
		
	}
	
	@FindBy(how=How.XPATH,using= "(//div[contains(@class,'added-monogram')]/div/span/following::span)[1]")
    private WebElement monogramMessege;
	
	public WebElement getMonogramMessege() {
		
		return monogramMessege;
		
	}
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Make this a Gift')]")
	private List<WebElement> makeGiftBox;
	
	public WebElement getMakeGiftBox() {
		
		return makeGiftBox.get(1);
	}
	
	@FindBy(how=How.XPATH,using= "//input[@id='giftMessage']")
    private WebElement includeGiftMessege;
	
	public WebElement getIncludeGiftMessege() {
		
		return includeGiftMessege;
		
	}
	
	@FindBy(how=How.XPATH,using= "//input[@id='to']")
    private WebElement recipientName;
	
	public WebElement getRecipientName() {
		
		return recipientName;
		
	}
	@FindBy(how=How.XPATH,using= "//input[@id='from']")
    private WebElement senderName;
	
	public WebElement getSenderName() {
		
		return senderName;
		
	}
	@FindBy(how=How.XPATH,using= "//textarea[@id='message']")
    private WebElement addMessege;
	
	public WebElement getAddMessege() {
		
		return addMessege;
		
	}
	@FindBy(how=How.XPATH,using= "//input[@id='giftBox']")
    private WebElement standardGiftBoxing;
	
	public WebElement getStandardGiftBoxing() {
		
		return standardGiftBoxing;
		
	}
	
	@FindBy(how=How.XPATH,using= "//button[@id='giftCardApplyBtn']")
    private WebElement continueButton;
	
	public WebElement getContinueButton() {
		
		return continueButton;
		
	}
	
	@FindBy(how=How.XPATH,using= "//div[@id='cart-items-container']/div/div/div/div/div/div/div/strong[1]")
    private WebElement giftBoxAdded;
	
	public WebElement getGiftBoxAdded() {
		
		return giftBoxAdded;
		}
	@FindBy(how=How.XPATH,using="(//input[@name='voucherCode'])[2]")
	private WebElement addPromocode;
	
	public WebElement getPromocode() {
		return  explicitWait(addPromocode);
	}
	@FindBy(how=How.XPATH,using="(//button[@id='signupnewsletter'])[2]")
	private WebElement ApplyClick;
	
	public WebElement getApply() {
		
		return explicitWait(ApplyClick);
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='globalMessages']")
	private WebElement vocherCardFailed;
	
	public WebElement getVocherCardFailed() {
		
		return vocherCardFailed;
	}
	
	
	
	@FindBy(how=How.XPATH,using="(//div[contains(text(),'Promotional Code Applied:')])[2]/../form")
	private WebElement codeRemove;
	
	public WebElement getCodeRemove() {
		
		return codeRemove;
	}
	
	@FindBy(how=How.XPATH,using="(//div[contains(text(),'Promotional Code Applied:')])[2]")
	private WebElement codeApplied;
	
	public WebElement getCodeApplied() {
		
		return codeApplied;
	}
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Subtotal')]/../following-sibling::div[1]")
	private WebElement subtotalCode;
	
	public WebElement getSubtotalCode() {
		
		return subtotalCode;
	}
	
	//Korea-Cart 
		//editcart--------------------------------
		@FindBy(how=How.XPATH,using=("//div[@id='cart-items-container']/div/div[1]/div[1]/div[2]/div[6]/span[1]/span"))
		private WebElement editProductsQuantity;
		public WebElement geteditQuantity() {
			return editProductsQuantity; 
		}
	//remove------------------------------------
		@FindBy(how=How.XPATH,using=("//div[@id='cart-items-container']/div[2]/div[1]/div[1]/div[2]/div[6]/span[3]/a"))
		private WebElement removeProductsQuantity;
		public WebElement getremoveQuantity() {
			return removeProductsQuantity;
		}
		//proceedtocheckout----------------------------
	@FindBy(how=How.XPATH,using=("//div[@id='cart-summary-container']/div[2]/div[2]/div[1]/button"))
	private WebElement proceedtoCart;
	public WebElement getProceedtoCart() {
		return  proceedtoCart;
	}
	//giftservices-----------------------------------
	@FindBy(how=How.XPATH,using=("//div[@id='cart-items-container']/div[2]/div[1]/div[1]/div[2]/div[9]/div[2]/a"))
	private WebElement Makegiftbox;
	public WebElement getGiftbox() {
		return Makegiftbox;
	}
	@FindBy(how=How.XPATH,using=("//input[@id='giftBox']"))
	private WebElement GiftBoxservices;
	public WebElement getGiftBoxservices() {
		return GiftBoxservices;
	}
	@FindBy(how=How.XPATH,using=("//button[@id='giftCardApplyBtn']"))
	private WebElement GiftBoxcontinueButton;
	public WebElement GiftboxgetContinueButton() {
		return  GiftBoxcontinueButton;
	}

	//Voucher
	@FindBy(how=How.XPATH,using=("(//input[@name='voucherCode'])[2]"))
	private WebElement VoucherID;
	public WebElement getpromocode() {
	return VoucherID;
	}
	@FindBy(how=How.XPATH,using=("(//button[@id='signupnewsletter'])[2]"))
	private WebElement ApplyVoucher;
	public WebElement getApplyvoucher() {
		return ApplyVoucher;
	}
	//monogram
	@FindBy(how=How.XPATH,using=("//a[@id='monogramming-popup-link']"))
	private WebElement addMonogram;
	public WebElement getMonogram() {
		return addMonogram;
	}
	@FindBy(how=How.XPATH,using=("(//a[@title='monogram step 2'])[1]"))
	private WebElement MonogramNextbutton;
	public WebElement getNextbutton() {
	return MonogramNextbutton;
	}
	@FindBy(how=How.XPATH,using=("(//a[@title='monogram step 3'])[1]"))
	private WebElement MonogramnextStep;
	public WebElement getMonogramnextStep() {
		return MonogramnextStep;
	}
	@FindBy(how=How.XPATH,using=("//div[@id='monogram-step3']/div[3]/a[2]"))
	private WebElement MonogramApply;
	public WebElement getMOnogramApply() {
		return MonogramApply;
	}
}
