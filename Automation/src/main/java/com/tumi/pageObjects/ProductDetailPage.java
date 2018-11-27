package com.tumi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class ProductDetailPage {
	
	 public ProductDetailPage(WebDriver driver) {
		 Reports.driver = driver;
			PageFactory.initElements(driver,this);
	}

	@FindBy(how = How.ID, using = "addToCartBtn")
	private WebElement addToCart;

	public WebElement getAddToCart() {

		return addToCart;
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
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Add Now')]")
	private WebElement addMonogram;
	
	public WebElement getAddMonogram() {
		
		return addMonogram;
		
	}
	
	
}