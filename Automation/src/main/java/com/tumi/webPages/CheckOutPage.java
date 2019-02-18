package com.tumi.webPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.utilities.GenericMethods;

public class CheckOutPage extends GenericMethods {
	
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//span[contains(@class,'delete-link')]")
	private List<WebElement> removeProducts;
	
	public List<WebElement> getRemoveProducts() {
		return removeProducts;
	}
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Remove')]")//a[contains(@class,'product-remove')]
	private List<WebElement> removeMinicartProducts;
	
	public List<WebElement> getRemoveMinicartProducts() {
		return removeMinicartProducts;
	}
	@FindBy(how=How.XPATH,using="//ul[@class='cart-products']/li")
	private List<WebElement> minicartProducts;
	
	public List<WebElement> getMinicartProducts() {
		return minicartProducts;
	}
	
	
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Shopping Cart')]")
	private WebElement shoppingCart;
	
	public WebElement getShoppingCart() {
		return shoppingCart;
	}
	
	
	
}
