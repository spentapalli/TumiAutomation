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

public class ProductDetailPage extends GenericMethods {

	public ProductDetailPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//button[@id='addToCartBtn']") //for korea it is same
	private WebElement addToCart;

	public WebElement getAddToCart() {
		
		if (browserName.equals("mobile")) {
			scrollDown(300);
		}
		
		return explicitWait(addToCart);
	}

	@FindBy(how = How.ID, using = "select-qty")  // for KR it is same
	private WebElement selectQuantity;

	public WebElement getSelectQuantity() {

		return selectQuantity;
	}
	
	 @FindBy(how = How.XPATH, using = "//a[@id='airlineCarryOnPopupLink']")
	 private WebElement krAirlineCarryonGuide;
	 
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'View the List')]")
	private WebElement airlineCarryonGuide;

	public WebElement getAirlineCarryonGuide() {
		 if (selectedCountry.contains("US")||
					selectedCountry.contains("Canada")) {
			return krAirlineCarryonGuide;
		}else {
		return airlineCarryonGuide;
	}
	}
	
	@FindBy(how = How.XPATH, using = "//a[@id='monogramming-popup-link']/div")
	private WebElement krAddMonogram;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Now')]")
	private WebElement addMonogram;

	public WebElement getAddMonogram() {
		 if (selectedCountry.contains("US")||
					selectedCountry.contains("Canada")) {
				return addMonogram;
		}else {
	
		return krAddMonogram;
		}
		 
	}

	@FindBy(how = How.XPATH, using = "//input[@id='select-qty']")
	private WebElement productQuantity;

	public WebElement getProductQuantity() {

		return productQuantity;

	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='cart-items-container']/h2")
	private WebElement krShoppingCart;
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Shopping Cart')]")
	private WebElement shoppingCart;

	public WebElement getShoppingCart() {
		 if (selectedCountry.contains("US")||
					selectedCountry.contains("Canada")) {
				return shoppingCart;
		}else {
	
		return krShoppingCart;
	}
	}

	@FindBy(how = How.XPATH, using = "//div[@role='row']") //same for Korea
	private List<WebElement> cartRows;

	public List<WebElement> getCartRows() {

		return cartRows;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='minicart_data']/span[2]") //same for Korea
	private WebElement cartCount;

	public WebElement getCartCount() {

		return cartCount;

	}

	@FindBy(how = How.XPATH, using = "//ul[@class='cart-products']/li") //same for korea
	private List<WebElement> minicartProducts;

	public List<WebElement> getTotalProductInMiniCart() {
		return minicartProducts;
	}
	
	@FindBy(how = How.XPATH, using = "//ul[@class='cart-products']/li/following::a[3]")
	private List<WebElement> krMinicartProductsremove;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='cart-products']/li/following::a") 
	private List<WebElement> minicartProductsremove;

	public List<WebElement> getMiniCartRemove() {
		 if (selectedCountry.contains("US")||
					selectedCountry.contains("Canada")) {
			 return minicartProductsremove;
		}else {
		
		return krMinicartProductsremove;
	}
	}
	
	@FindBy(how = How.XPATH, using = "//span[@class='link delete-link']/a")
	private List<WebElement> krCartProductsremove;

	@FindBy(how = How.XPATH, using = "(//a[text()='Remove'])[1]") 
	private List<WebElement> cartProductsremove;

	public WebElement getCartRemove() {
		 if (selectedCountry.contains("US")||
					selectedCountry.contains("Canada")) {
			 return minicartProductsremove.get(1);
		}else {
			return krMinicartProductsremove.get(1);
		
	}
	}
	
	@FindBy(how = How.XPATH, using = "(//span[@class='cta quick-view-link quick-view-modal'])[1]") 
	private WebElement krEditQuantity;
	 
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Edit')]")  
	private WebElement editQuantity;

	public WebElement getFEditQuantity() {
		if (selectedCountry.contains("US")||
				selectedCountry.contains("Canada")) {
			return krEditQuantity;
		}else {
		return editQuantity;
	}
	}

	@FindBy(how = How.XPATH, using = "//input[@id='quantity']") //same for Korea
	private WebElement enterQuantity;

	public WebElement getEnterQuantity() {
		return enterQuantity;
	}

	@FindBy(how = How.XPATH, using = "//button[@id='updateCartButton']") //same for Korea
	private WebElement updateCartButton;

	public WebElement getUpdateQuantity() {
		return updateCartButton;
	}
	@FindBy(how = How.XPATH, using = "//div[@id='pdp']/div[2]/div/div[3]/div") 
	private WebElement StockMessage;

	public WebElement getStockmessage() {
		return StockMessage;
	}
		@FindBy(how = How.XPATH, using = "//div[@id='prod-details']/h1") 
		private WebElement ProductName;

		public WebElement getProductName() {
			return ProductName;
		
	}
	
	
}
