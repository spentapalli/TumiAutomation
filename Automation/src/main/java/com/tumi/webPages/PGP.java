package com.tumi.webPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class PGP extends GenericMethods {

	public PGP(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Luggage')])[1]")
	private WebElement luggage;

	public WebElement getluggage() {

		return explicitWait(luggage);
	}// div[@id='product-filters']/div[2]

	@FindBy(how = How.XPATH, using = "(//ul[contains(@class,'nav-sub-list')]/li/ul/li/ul/li/ul/li/a)[1]")
	private WebElement carryOnLuggage;

	public WebElement getCarryOnLuggage() {

		return carryOnLuggage;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='grid-container']/div[1]/div[2]/div[3]/div[2]/a/span/div[1]")
	private WebElement SelectProduct;

	public WebElement getSelectProduct() {

		return SelectProduct;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='grid-container']/div[1]/div[2]/div[1]/div[3]/a")
	private WebElement QuickShop;

	public WebElement getQuickShop() {

		return QuickShop;
	}

	@FindBy(how = How.XPATH, using = "(//button[@type='submit'])[2]")
	private WebElement QuickShopAddtoCart;

	public WebElement getQuickShopAddtoCart() {

		return QuickShopAddtoCart;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='Color_group-ctrl']/ul/li/form/label")
	private List<WebElement> colorsList;

	public List<WebElement> getColorsList() {

		return colorsList;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div[2]")
	private WebElement productType;

	public WebElement getProductType() {
		return productType;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='facet-Carry-On Luggage']")
	private WebElement carryOnBagPT;

	public WebElement getCarryOnBagPT() {
		return explicitWait(carryOnBagPT);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='facet-Carry-On Luggage']/following::span[2]")
	private WebElement carryOnCountBagPT;

	public WebElement getCarryOnCountBagPT() {
		return carryOnCountBagPT;
	}

	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'totalCount')])[2]")
	private WebElement resultCount;

	public WebElement getResultCount() {
		return resultCount;
	}

}
