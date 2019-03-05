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
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Women')]")
	private WebElement womenCategory;

	public WebElement getWomenCategory() {

		return explicitWait(womenCategory);
	}//a[contains(text(),'Women')]/following::a[2]


	@FindBy(how = How.XPATH, using = "(//ul[contains(@class,'nav-sub-list')]/li/ul/li/ul/li/ul/li/a)[1]")
	private WebElement carryOnLuggage;

	public WebElement getCarryOnLuggage() {

		return carryOnLuggage;
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Women')]/following::a[2]")
	private WebElement carryOnLuggageInWomen;

	public WebElement getCarryOnLuggageInWomen() {

		return carryOnLuggageInWomen;
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
		return explicitWait(productType);
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


	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Testing Category Title')]")
	private WebElement CategoryTitle;

	public WebElement getCategoryTitle() {
		return CategoryTitle;
	}
	

	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div/a")
	private WebElement clear;

	public WebElement getClear() {
		return clear;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div/a")
	private List<WebElement> clearList;

	public List<WebElement> getClearList() {
		return clearList;
	}


	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div/h4")
	private List<WebElement> filtersList;

	public List<WebElement> getFiltersList() {
		return filtersList;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='product_type-ctrl']/ul/li/form/input[3]")
	private List<WebElement> productTypeList;

	public List<WebElement> getProductTypeList() {
		return productTypeList;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='prices-ctrl']/ul/li/form/input[3]")
	private List<WebElement> pricesList;

	public List<WebElement> getPricesList() {
		return pricesList;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='facet-200:350']/following::span[2]")
	private WebElement firstRangeCount;

	public WebElement getFirstRangeCount() {
		return firstRangeCount;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-350:500']/following::span[2]")
	private WebElement priceRangeCount;

	public WebElement getPriceRangeCount() {
		return priceRangeCount;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='gender-ctrl']/ul/li/form/input[3]")
	private List<WebElement> genderList;

	public List<WebElement> getGenderList() {
		return genderList;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-Female']/following::span[2]")
	private WebElement femaleCount;

	public WebElement getFemaleCount() {
		return femaleCount;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='Collection-ctrl']/ul/li/form/input[3]")
	private List<WebElement> collectionList;

	public List<WebElement> getCollectionList() {
		return collectionList;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-Alpha 2']/following::span[2]")
	private WebElement alpha2Count;

	public WebElement getAlphaCount() {
		return alpha2Count;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='Material-ctrl']/ul/li/form/input[3]")
	private List<WebElement> materialList;

	public List<WebElement> getMaterialList() {
		return materialList;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-Leather']/following::span[2]")
	private WebElement leatherCount;

	public WebElement getLeatherCount() {
		return leatherCount;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='laptop_size-ctrl']/ul/li/form/input[3]")
	private List<WebElement> laptopSizeList;

	public List<WebElement> getLaptopSizeList() {
		return laptopSizeList;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-Fits up to 14\"']/following::span[2]")
	private WebElement fitsUpto14laptopCount;

	public WebElement getFitsUpto14laptopCount() {
		return fitsUpto14laptopCount;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='Wheels-ctrl']/ul/li/form/input[3]")
	private List<WebElement> wheelsList;

	public List<WebElement> getWheelsList() {
		return wheelsList;	
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-4.0']/following::span[2]")
	private WebElement fourWheelsCount;

	public WebElement getFourWheelsCount() {
		return fourWheelsCount;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='FSM_ExclusiveFeatures-ctrl']/ul/li/form/input[3]")
	private List<WebElement> exclusiceFeatureList;

	public List<WebElement> getExclusiceFeatureList() {
		return exclusiceFeatureList;	
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-Monogramable']/following::span[2]")
	private WebElement monoCount;

	public WebElement getMonoCount() {
		return monoCount;
	}


}
