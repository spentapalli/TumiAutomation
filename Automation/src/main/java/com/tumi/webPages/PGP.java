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

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[4]/a") // for Korea
	private WebElement carrierNtravel;

	public WebElement getCarrierNtravel() {

		return explicitWait(carrierNtravel);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Women')]")
	private WebElement womenCategory;

	public WebElement getWomenCategory() {

		return explicitWait(womenCategory);
	}

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

	@FindBy(how = How.XPATH, using = "//div[@id='grid-container']/div[1]/div[2]/div[2]/div[2]/a/span/div[2]")
	private WebElement SelectProduct;

	public WebElement getSelectProduct() {

		return SelectProduct;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='grid-container']/div[1]/div[2]/div[3]/div[3]/a")
	private WebElement QuickShop;

	public WebElement getQuickShop() {

		return QuickShop;
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'quick-view-link')]")
	private WebElement quickShop;

	public WebElement getquickShop() {

		return quickShop;
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

	@FindBy(how = How.XPATH, using = "//input[@id='facet-카드 케이스']/following::span[2]")
	private WebElement cardCasesCountForKR;

	public WebElement getCardCasesCountForKR() {
		return cardCasesCountForKR;
	}

	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'totalCount')])[2]")
	private WebElement resultCount;
	
	@FindBy(how = How.XPATH, using = "(// span[contains(@class,'totalCount')])[2]/span")
	private WebElement krResultCount;

	public WebElement getResultCount() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
			return resultCount;
			}else {
				return krResultCount;
			}
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'productMainLink')]")
	private WebElement resultImageWithSku;

	public WebElement getResultImageWithSku() {
		return resultImageWithSku;
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
	
	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div/div/ul/li/form/input[3]")
	private List<WebElement> krProductTypeList;

	public List<WebElement> getProductTypeList() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
			return productTypeList;
			}else {
				return krProductTypeList;
			}
	}

	@FindBy(how = How.XPATH, using = "//div[@id='prices-ctrl']/ul/li/form/input[3]")
	private List<WebElement> pricesList;
	
	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div[4]/div/ul/li/form/input[3]")
	private List<WebElement> krPricesList;

	public List<WebElement> getPricesList() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
			return pricesList;
			}else {
				return krPricesList;
			}
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-200:350']/following::span[2]")
	private WebElement firstRangeCount;

	public WebElement getFirstRangeCount() {
		return firstRangeCount;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='facet-350:500']/following::span[2]")
	private WebElement priceRangeCount;
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-0:200000']/following::span[2]")
	private WebElement krPriceRangeCount;

	public WebElement getPriceRangeCount() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
			return priceRangeCount;
			}else {
				return krPriceRangeCount;
			}
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='gender-ctrl']/ul/li/form/input[3]")
	private List<WebElement> genderList;
	
	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div[3]/div/ul/li/form/input[3]")
	private List<WebElement> krGenderList;

	public List<WebElement> getGenderList() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
			return genderList;
			}else {
				return krGenderList;
			}

	}
	
	

	@FindBy(how = How.XPATH, using = "//input[@id='facet-Female']/following::span[2]")
	private WebElement femaleCount;
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-남성']/following::span[2]")
	private WebElement krFemaleCount;

	public WebElement getFemaleCount() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
			return femaleCount;
			}else {
				return krFemaleCount;
			}
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='Collection-ctrl']/ul/li/form/input[3]")
	private List<WebElement> collectionList;
	
	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div[5]/div/ul/li/form/input[3]")
	private List<WebElement> krCollectionList;

	public List<WebElement> getCollectionList() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
			return collectionList;
			}else {
				return krCollectionList;
			}
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-Alpha 2']/following::span[2]")
	private WebElement alpha2Count;

	public WebElement getAlphaCount() {
		return alpha2Count;
	}
	@FindBy(how = How.XPATH, using = "//input[@id='facet-Alpha Bravo']/following::span[2]") //need to add for 'one' count
	private WebElement krAlphaBravoCount;

	public WebElement getKrAlphaBravoCount() {
		return krAlphaBravoCount;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='Material-ctrl']/ul/li/form/input[3]")
	private List<WebElement> materialList;
	
	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div[6]/div/ul/li/form/input[3]")
	private List<WebElement> krMaterialList;

	public List<WebElement> getMaterialList() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
			return materialList;
			}else {
				return krMaterialList;
			}
	}
	

	@FindBy(how = How.XPATH, using = "//input[@id='facet-Leather']/following::span[2]")
	private WebElement leatherCount;
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-가죽']/following::span[2]")
	private WebElement krLeatherCount;

	public WebElement getLeatherCount() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
			return leatherCount;
			}else {
				return krLeatherCount;
			}
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div[7]/div/ul/li/form/input[3]")
	private List<WebElement> krSizeList;

	public List<WebElement> getKrSizeList() {
		
			return krSizeList;
			
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-L']/following::span[2]")
	private WebElement krLSizeCount;
	
	public WebElement getKrLSizeCount() {
				return krLSizeCount;
	}
	

	@FindBy(how = How.XPATH, using = "//div[@id='laptop_size-ctrl']/ul/li/form/input[3]")
	private List<WebElement> laptopSizeList;
	
	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div[8]/div/ul/li/form/input[3]")
	private List<WebElement> krLaptopSizeList;

	public List<WebElement> getLaptopSizeList() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
			return laptopSizeList;
			}else {
				return krLaptopSizeList;
			}
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-Fits up to 14\"']/following::span[2]")
	private WebElement fitsUpto14laptopCount;

	public WebElement getFitsUpto14laptopCount() {
		return fitsUpto14laptopCount;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-최대 15\" 수납 가능']/following::span[2]")
	private WebElement krFitsUpto15laptopCount;

	public WebElement getKrFitsUpto15laptopCount() {
		return krFitsUpto15laptopCount;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='Wheels-ctrl']/ul/li/form/input[3]")
	private List<WebElement> wheelsList;
	
	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div[9]/div/ul/li/form/input[3]")
	private List<WebElement> krWheelsList;

	public List<WebElement> getWheelsList() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
			return wheelsList;
			}else {
				return krWheelsList;
			}
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-4.0']/following::span[2]") //same for Korea
	private WebElement fourWheelsCount;

	public WebElement getFourWheelsCount() {
		return fourWheelsCount;
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='FSM_ExclusiveFeatures-ctrl']/ul/li/form/input[3]")
	private List<WebElement> exclusiceFeatureList;
	
	@FindBy(how = How.XPATH, using = "//div[@id='product-filters']/div[10]/div/ul/li/form/input[3]")
	private List<WebElement> krExclusiceFeatureList;

	public List<WebElement> getExclusiceFeatureList() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
		return exclusiceFeatureList;
		}else {
			return krExclusiceFeatureList;
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@id='facet-Monogramable']/following::span[2]")
	private WebElement monoCount;
	
	@FindBy(how = How.XPATH, using = "//input[@id='facet-모노그램']/following::span[2]")
	private WebElement krMonoCount;

	public WebElement getMonoCount() {
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
			return monoCount;
			}else {
				return krMonoCount;
			}
	}

	@FindBy(how = How.XPATH, using = "//div[@id='breadcrumb']/ul")
	private WebElement BreadCrumb;

	public WebElement getBreadCrumb() {
		return BreadCrumb;
	}

}
