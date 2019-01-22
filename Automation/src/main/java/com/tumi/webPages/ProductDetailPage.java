package com.tumi.webPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class ProductDetailPage extends GenericMethods{

	public ProductDetailPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "addToCartBtn")
	private WebElement addToCart;

	public WebElement getAddToCart() {

		return explicitWait(addToCart);
	}

	@FindBy(how = How.ID, using = "select-qty")
	private WebElement selectQuantity;

	public WebElement getSelectQuantity() {

		return selectQuantity;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'View the List')]")
	private WebElement airlineCarryonGuide;

	public WebElement getAirlineCarryonGuide() {

		return airlineCarryonGuide;

	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Now')]")
	private WebElement addMonogram;

	public WebElement getAddMonogram() {

		return addMonogram;

	}

	@FindBy(how = How.XPATH, using = "//input[@id='select-qty']")
	private WebElement productQuantity;

	public WebElement getProductQuantity() {

		return productQuantity;

	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Shopping Cart')]")
	private WebElement shoppingCart;

	public WebElement getShoppingCart() {

		return shoppingCart;
	}

	@FindBy(how = How.XPATH, using = "//div[@role='row']")
	private List<WebElement> cartRows;

	public List<WebElement> getCartRows() {

		return cartRows;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='minicart_data']/span[2]")
	private WebElement cartCount;

	public WebElement getCartCount() {

		return cartCount;

	}

	@FindBy(how = How.XPATH, using = "//ul[@class='cart-products']/li")
	private List<WebElement> minicartProducts;

	public List<WebElement> getTotalProductInMiniCart() {
		return minicartProducts;
	}

	@FindBy(how = How.XPATH, using = "//ul[@class='cart-products']/li/following::a")
	private List<WebElement> minicartProductsremove;

	public List<WebElement> getMiniCartRemove() {
		return minicartProductsremove;
	}

	@FindBy(how = How.XPATH, using = "(//a[text()='Remove'])[1]")
	private List<WebElement> cartProductsremove;

	public WebElement getCartRemove() {

		return minicartProductsremove.get(1);
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Edit')]")
	private WebElement editQuantity;

	public WebElement getFEditQuantity() {
		return editQuantity;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='quantity']")
	private WebElement enterQuantity;

	public WebElement getEnterQuantity() {
		return enterQuantity;
	}

	@FindBy(how = How.XPATH, using = "//button[@id='updateCartButton']")
	private WebElement updateCartButton;

	public WebElement getUpdateQuantity() {
		return updateCartButton;
	}

}