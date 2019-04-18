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

/**
 * @author Suresh,Shwetha, Bindu
 *
 */
public class HomePage extends GenericMethods {

	public HomePage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);

	}

//same for korea
	@FindBy(how = How.XPATH, using = "//input[@id='search']")
	private WebElement searchProduct;

	public WebElement getSearchProduct() {
		delay(2000);
		return searchProduct;
	}

//same for korea
	@FindBy(how = How.XPATH, using = "//main[@id='navEnd']/div[2]/div[1]/div/div")
	private WebElement NoProducts;

	public WebElement getNoProducts() {
		delay(2000);
		return NoProducts;
	}

//kjhhfgszbuhtddxfg
	@FindBy(how = How.XPATH, using = "//ul[@id='matching_products']/li")
	private List<WebElement> matchingProducts;

	public List<WebElement> getMatchingProducts() {

		return matchingProducts;
	}

	// for Canada
	@FindBy(how = How.XPATH, using = "//div[@id='firstTimeEmailSignupPopup']/a/span")
	private WebElement signupPopup;

	public WebElement getCASignupPopup() {

		return signupPopup;
	}

	// for US
	@FindBy(how = How.XPATH, using = "//div[@id='firstTimeEmailSignupPopup']/a/span")
	private WebElement signupPopupUS;

	public WebElement getUSSignupPopupUS() {

		return signupPopupUS;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='firstTimeEmailSignupPopup']/div/span")
	private WebElement signupPopupUsProd;

	public WebElement getSignupPopupUsProd() {

		return signupPopupUsProd;

	}

	// korea
	@FindBy(how = How.XPATH, using = "//div[@id='firstTimeEmailSignupPopup']/div/span")
	private WebElement koreaSignUpPop;

	public WebElement getKoreaSignupPopup() {
		return koreaSignUpPop;
	}

	@FindBy(how = How.XPATH, using = "//a[@id='bx-close-inside-807411']")
	private WebElement offersPopupUsProd;

	public WebElement getOffersPopupUsProd() {

		return offersPopupUsProd;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='cmsSlot1']/div/div/div//div/div/ul/li[2]/a")
	private WebElement selectUS;

	public WebElement getSelectUS() {
		return explicitWait(selectUS);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='/country/selected?country=CA']")
	private WebElement selectCanada;

	public WebElement getSelectCanada() {
		return selectCanada;
	}

	@FindBy(how = How.XPATH, using = "//a[@href='/country/selected?country=KR']")
	private WebElement selectKorea;

	public WebElement getSelectKorea() {
		return selectKorea;
	}

//jfhfgsfjsdfjsdgz
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Close')]")
	private WebElement acceptCookies;

	public WebElement getAcceptCookies() {

		return acceptCookies;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Location')]")
	private WebElement selectCountry;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'header-country')]")
	private WebElement krselectCountry;

	public WebElement getSelectCountry() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return selectCountry;
		} else {
			return krselectCountry;
		}
	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'United States')])[2]")
	private WebElement selectCountryUS;

	public WebElement getSelectCountryUS() {

		return explicitWait(selectCountryUS);
	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'United States')])[1]")
	private WebElement selectCountryUSforTop;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'north-america')]/ul/li[2]/a)[1]")
	private WebElement krselectCountryUSforTop;

	public WebElement getSelectCountryUSforTop() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return explicitWait(selectCountryUSforTop);
		} else {
			return explicitWait(krselectCountryUSforTop);
		}
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Canada')]")
	private WebElement selectCountryCAforTop;

	public WebElement getSelectCountryCAforTop() {

		return explicitWait(selectCountryCAforTop);
	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Canada')])[2]")
	private WebElement selectCountryCA;

	public WebElement getSelectCountryCA() {

		return explicitWait(selectCountryCA);
	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'ëŒ€í•œë¯¼êµ­')])[2]")
	private WebElement selectCountryKR;

	public WebElement getSelectCountryKR() {

		return explicitWait(selectCountryKR);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Korea')]")
	private WebElement selectCountryKRforTop;

	public WebElement getSelectCountryKRforTop() {

		return explicitWait(selectCountryKRforTop);
	}

	@FindBy(how = How.XPATH, using = "//i[@id='lang-selectorSelectBoxItArrow']")
	private WebElement selectLanguage;

	public WebElement getSelectLanguage() {

		return selectLanguage;

	}

	@FindBy(how = How.XPATH, using = "//ul[contains(@id,'lang-selectorSelect')]/li/a")
	private List<WebElement> langList;

	public List<WebElement> getLangList() {

		return langList;
	}

	@FindBy(how = How.XPATH, using = "//span[@id='lang-selectorSelectBoxItContainer']")
	private WebElement selectLanguageContainer;

	public WebElement getSelectLanguageContainer() {

		return selectLanguageContainer;

	}

	// ul[contains(@id,'lang-selectorSelect')]/li/a/span
	@FindBy(how = How.XPATH, using = "//ul[contains(@id,'lang-selectorSelect')]/li[2]/a")
	private WebElement selectSpanishLanguage;

	public WebElement getSelectSpanishLanguage() {

		return explicitWait(selectSpanishLanguage);

	}

	@FindBy(how = How.XPATH, using = "//ul[contains(@id,'lang-selectorSelect')]/li[3]/a")
	private WebElement selectFrenchLanguage;

	public WebElement getSelectFrenchLanguage() {

		return explicitWait(selectFrenchLanguage);

	}

	@FindBy(how = How.XPATH, using = "//header[@id='top-nav']/section/div[1]/div[1]/div[3]/a")
	private WebElement krheaderFindStore;

	@FindBy(how = How.XPATH, using = "(//a[text()='Find a Store'])[1]")
	private WebElement headerFindStore;

	public WebElement getHeaderFindStore() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return headerFindStore;
		} else {

			return explicitWait(krheaderFindStore);

		}
	}

	@FindBy(how = How.XPATH, using = "//section[@id='top-nav']/header/div[1]/div[2]/a")
	private WebElement krheaderCustomerService;

	@FindBy(how = How.XPATH, using = "(//a[text()='Customer Service'])[1]")
	private WebElement headerCustomerService;

	public WebElement getHeaderCustomerService() {

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return headerCustomerService;

		} else {

			return explicitWait(krheaderCustomerService);
		}
	}

	@FindBy(how = How.XPATH, using = "(//a[@href='#login'])[1]")
	private WebElement krHeaderSignIn;

	@FindBy(how = How.XPATH, using = "(//a[text()='Sign In'])[1]")
	private WebElement headerSignIn;

	public WebElement getHeaderSignIn() {

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {

			return explicitWait(headerSignIn);
		} else {

			return explicitWait(krHeaderSignIn);
		}
	}

//same for korea
	@FindBy(how = How.XPATH, using = "//li[@id='janrain-instagram']/a")
	private WebElement instaLogin;

	public WebElement VerifyInstaLogin() {
		return instaLogin;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='j_username']")
	private WebElement j_username;

	public WebElement getUserName() {

		return j_username;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='j_password']")
	private WebElement j_password;

	public WebElement getPassWord() {

		return j_password;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='login-option-regular']/input")
	private WebElement krSubmit;

	@FindBy(how = How.XPATH, using = "//input[@value='Sign in']")
	private WebElement submit;

	public WebElement getLogOn() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return explicitWait(submit);

		} else {
			return explicitWait(krSubmit);
		}

	}

	@FindBy(how = How.XPATH, using = "(//div[@class='dEOOab RxsGPe'])[1]")
	private WebElement emailBlankError;

	public WebElement getEmailBlankError() {

		return emailBlankError;
	}

	@FindBy(how = How.XPATH, using = "//label[@id='j_password-error']")
	private WebElement emailRegularError;

	public WebElement getEmailRegularError() {

		return emailRegularError;
	}

	@FindBy(how = How.XPATH, using = "//label[@id='j_username-error']")
	private WebElement emailBlank;

	public WebElement getEmailBlank() {

		return emailBlank;
	}

	@FindBy(how = How.XPATH, using = "//label[@id='j_password-error']")
	private WebElement passwordRegularError;

	public WebElement getPasswordRegularError() {

		return passwordRegularError;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='GQ8Pzc']")
	private WebElement passwordBlank;

	public WebElement getPasswordBlank() {

		return passwordBlank;
	}

	@FindBy(how = How.XPATH, using = "//form[@id='tm-login-form']/div[4]/div")
	private WebElement krinvalidCredentials;

	@FindBy(how = How.XPATH, using = "(//div[@class='error-message'])[1]")
	private WebElement invalidCredentials;

	public WebElement getInvalidCredentialsError() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return explicitWait(invalidCredentials);
		} else {

			return (krinvalidCredentials);
		}
	}

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/header/a")
	private WebElement closeMyAccount;

	public WebElement getCloseMyAccount() {
		return closeMyAccount;
	}// div[@id='tm-panel-login']/header/a

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login']/header/a")
	private WebElement closeMyAccountBefore;

	public WebElement getCloseMyAccountBefore() {
		return closeMyAccountBefore;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='firstTimeEmailSignupPopup']/a")
	private WebElement signUpPop;

	public WebElement getSignupPopup() {
		return signUpPop;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'No Thanks')]")
	private WebElement noThanks;

	public WebElement getNoThanks() {
		return noThanks;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='main-content']/div[2]/h1/span")
	private WebElement vpnIssue;

	public WebElement getVPNDis() {
		return vpnIssue;
	}

	// same for korea
	@FindBy(how = How.XPATH, using = "//span[@class='item-count']")
	private WebElement minicartcount;

	public WebElement getMinicartCount() {
		return explicitWait(minicartcount);
	}

//same for korea
	@FindBy(how = How.XPATH, using = "//div[@id='minicart_data']/span")
	private WebElement minicart;

	public WebElement getMinicart() {
		return explicitWait(minicart);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='minicart_data']")
	private WebElement minicartButton;

	public WebElement getMinicartButton() {
		return explicitWait(minicartButton);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-mini-cart']/div/header/h3")
	private WebElement minicartProductsCount;

	public WebElement getCartProductCount() {
		return explicitWait(minicartProductsCount);
	}

	@FindBy(how = How.XPATH, using = "//ul[@class='cart-products']/li")
	private List<WebElement> minicartProducts;

	public List<WebElement> getCartProducts() {
		return minicartProducts;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'header-country')]/a")
	private WebElement homeCountry;

	public WebElement getHomeCountry() {
		return explicitWait(homeCountry);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='select-country']/div/ul/li/a")
	private List<WebElement> countriesList;

	public List<WebElement> getCountriesList() {
		return countriesList;
	}

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'CHOOSE YOUR LOCATION')]")
	private WebElement selectLocation;

	@FindBy(how = How.XPATH, using = "//form[@id='storeFinderForm']//div/label")
	private WebElement krSelectLocation;

	public WebElement getSelectLocation() {

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return selectLocation;
		} else {
			return krSelectLocation;
		}
	}

	// Mobile
	@FindBy(how = How.XPATH, using = "//select[@name='country']")
	private WebElement mobileCountry;

	public WebElement getMobileCountry() {

		return mobileCountry;
	}

	// home page TUMI logo
	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[2]")
	private WebElement LuggageOption;

	public WebElement getLuggageOption() {

		return LuggageOption;
	}

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[3]")
	private WebElement BackPackOption;

	public WebElement getBackPackOption() {

		return BackPackOption;
	}

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[3]/ul/li[1]/ul/li[1]/ul/li/ul/li[3]/a")
	private WebElement BackPackTestBridgewater;

	public WebElement getBackPackTestBridgewater() {

		return BackPackTestBridgewater;
	}

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[4]/a")
	private WebElement BagOptions;

	public WebElement getOptions() {

		return BagOptions;
	}

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[4]/ul/li[1]/ul/li[1]/ul/li/ul/li[2]/a")
	private WebElement BagwheeledBriefCase;

	public WebElement getSubCateogry() {

		return BagwheeledBriefCase;
	}

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[5]")
	private WebElement AccessoriesOptions;

	public WebElement getAccessoriesOptions() {

		return AccessoriesOptions;
	}

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[5]/ul/li[1]/ul/li[1]/ul/li[1]/ul/li[6]/a")
	private WebElement AccessoriesKeyFobs;

	public WebElement getAccessoriesKeyFobs() {

		return AccessoriesKeyFobs;
	}

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[6]")
	private WebElement CollectionsOptions;

	public WebElement getCollectionsOptions() {

		return CollectionsOptions;
	}

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[7]")
	private WebElement GiftIdeasOptions;

	public WebElement getGiftIdeasOptions() {

		return GiftIdeasOptions;
	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Sale')])[1]")
	private WebElement SalesOptions;

	public WebElement getSalesOptions() {

		return SalesOptions;
	}

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[9]/ul/li[1]/ul/li[1]/ul/li/ul/li[1]/a")
	private WebElement SalesVoyageurCollection;

	public WebElement getSalesVoyageurCollection() {

		return SalesVoyageurCollection;
	}

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']")
	private List<WebElement> CategoriesSelection;

	public List<WebElement> getCategoriesSelection() {

		return CategoriesSelection;
	}

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[2]/ul/li[1]/ul/li[1]/ul/li[1]/ul")
	private List<WebElement> SubCategoriesSelection;

	public List<WebElement> SubgetCategoriesSelection() {

		return SubCategoriesSelection;

	}
	
	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li/a")
	private List<WebElement> CategoriesList;

	public List<WebElement> getCategoriesList() {

		return CategoriesList;

	}

	
	// FOLLOW US
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'social')]/a")
	private List<WebElement> followUs;

	public List<WebElement> getFollowUs() {

		return followUs;
	}

	// CUSTOMER SERIVE
	@FindBy(how = How.XPATH, using = "//footer[@role='contentinfo']/div/div/div/div[1]/ul/li/a")
	private WebElement customerService;

	public WebElement getCustomerService() {

		return customerService;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Customer Service')]")
	private WebElement customerServiceHeader;

	public WebElement getCustomerServiceHeader() {

		return customerServiceHeader;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='cmsSlot1']/div/div/div/div/div/div/div/div/div/a")
	private List<WebElement> customerServiceContents;

	public List<WebElement> getCustomerServiceContents() {

		return customerServiceContents;
	}

	// CONTACT US
	@FindBy(how = How.XPATH, using = "//footer[@role='contentinfo']/div/div/div/div[2]/ul/li/a")
	private WebElement contactUs;

	public WebElement getContactUs() {

		return contactUs;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='breadcrumb']/following::div[1]/h1")
	private WebElement contactUsHeader;

	public WebElement getContactUsHeader() {

		return contactUsHeader;
	}

	// TOLLFREE NUMBER
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'1-800-299-8864')]")
	private WebElement contact18002998864;

	public WebElement get18002998864() {

		return contact18002998864;
	}

	// SHIPPING
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Shipping')]")
	private WebElement shipping;

	public WebElement getShipping() {

		return shipping;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='cmsSlot1']/div/div/div/div/h1")
	private WebElement shippingHeader;

	public WebElement getShippingHeader() {

		return shippingHeader;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='tumi_shipping']/div/table/tbody/tr/td/a")
	private List<WebElement> shippingMenuTable;

	public List<WebElement> getShippingMenuTable() {

		return shippingMenuTable;
	}

	// RETURNS
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Returns')]")
	private WebElement returns;

	public WebElement getReturns() {

		return returns;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='breadcrumb']/following::div[1]/h1")
	private WebElement returnsHeader;

	public WebElement getReturnsHeader() {

		return returnsHeader;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='breadcrumb']/following::div[2]/h2")
	private List<WebElement> returnsContent;

	public List<WebElement> getReturnsContent() {

		return returnsContent;
	}

	// PAYMENT METHODS
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Payment Methods')]")
	private WebElement paymentMethods;

	public WebElement getPaymentMethods() {

		return paymentMethods;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='ccPaymentMethod']/div/div/div[1]/div/h1")
	private WebElement paymentMethodsHeader;

	public WebElement getPaymentMethodsHeader() {

		return paymentMethodsHeader;
	}

	@FindBy(how = How.XPATH, using = "//h2[text()='PayPal']/../p[4]/a")
	private WebElement signupforPayPalnow;

	public WebElement getSignupforPayPalnow() {

		return signupforPayPalnow;
	}

	@FindBy(how = How.XPATH, using = "//h2[text()='PayPal']/../p[3]/a")
	private WebElement helpCentre;

	public WebElement getHelpCentre() {

		return helpCentre;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Apple Pay Support.')]")
	private WebElement applePaySupport;

	public WebElement getApplePaySupport() {

		return applePaySupport;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'//a[contains(text(),'Set up Apple Pay')]")
	private WebElement setUpApplePay;

	public WebElement getSetUpApplePay() {

		return setUpApplePay;
	}

	// SERVICES & REPAIR
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Service & Repairs')]")
	private WebElement serviceRepair;

	public WebElement getServicerepair() {

		return serviceRepair;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='FaqPage']/div/div/following::div[1]/div/ul/li/a")
	private List<WebElement> serviceRepairKeywords;

	public List<WebElement> getServiceRepairKeywords() {

		return serviceRepairKeywords;
	}

	// FAQs
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'FAQs')]")
	private WebElement faqs;

	public WebElement getFAQs() {

		return faqs;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='FaqPage']/div/div/following::div[1]/div/ul/li/a")
	private List<WebElement> faqsKeywords;

	public List<WebElement> getFAQsKeywords() {

		return faqsKeywords;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='accordion-26']/../a/span[3]")
	private WebElement shippingContent;

	public WebElement getShippingContent() {

		return shippingContent;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='accordion-7']/../a/span[3]")
	private WebElement orderStatusContent;

	public WebElement getOrderContent() {

		return orderStatusContent;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='accordion-1']/../a/span[3]")
	private WebElement repairsContent;

	public WebElement getRepairsContent() {

		return repairsContent;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='accordion-5']/../a/span[3]")
	private WebElement traceRegistrationContent;

	public WebElement getTraceRegistrationContent() {

		return traceRegistrationContent;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='accordion-20']/../a/span[3]")
	private WebElement returnExcahngeContent;

	public WebElement getReturnExcahngeContent() {

		return returnExcahngeContent;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='accordion-12']/../a/span[3]")
	private WebElement productEnquiryContent;

	public WebElement getProductEnquiryContent() {

		return productEnquiryContent;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='accordion-1']/../a/span[3]")
	private WebElement viewAllContent;

	public WebElement getViewAllContent() {

		return viewAllContent;
	}

	// WARRANTY
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Warranty')]")
	private WebElement warranty;

	public WebElement getWarranty() {

		return warranty;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='breadcrumb']/following::h1[1]")
	private WebElement productInfoWarrantyHeader;

	public WebElement getProductInfoWarrantyHeader() {

		return productInfoWarrantyHeader;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='breadcrumb']/following::div[1]/div/ul/li/a")
	private List<WebElement> changeLanguage;

	public List<WebElement> getChangeLanguage() {

		return changeLanguage;
	}

	@FindBy(how = How.XPATH, using = "(//div[@id='cmsSlot1']/div/div/div/div/div)[1]")
	private WebElement englishContent;

	public WebElement getEnglishContent() {

		return englishContent;
	}

	@FindBy(how = How.XPATH, using = "(//div[@id='cmsSlot1']/div/div/div/div/div)[2]")
	private WebElement GermanContent;

	public WebElement getDeutscheContent() {

		return GermanContent;
	}

	@FindBy(how = How.XPATH, using = "(//div[@id='cmsSlot1']/div/div/div/div/div)[3]")
	private WebElement FrenchContent;

	public WebElement getFran�aisContent() {

		return FrenchContent;
	}

	@FindBy(how = How.XPATH, using = "(//div[@id='cmsSlot1']/div/div/div/div/div)[4]")
	private WebElement spanishContent;

	public WebElement getEspanolContent() {

		return spanishContent;
	}

	@FindBy(how = How.XPATH, using = "(//div[@id='cmsSlot1']/div/div/div/div/div)[5]")
	private WebElement italianContent;

	public WebElement getItalianoContent() {

		return italianContent;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='breadcrumb']/following::div[1]/div/ul/li[6]/a")
	private WebElement japaneseContent;

	public WebElement getJapanese() {

		return japaneseContent;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='breadcrumb']/following::div[1]/div/ul/li[7]/a")
	private WebElement chinaContent;

	public WebElement getChina() {

		return chinaContent;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='breadcrumb']/following::div[1]/div/ul/li[8]/a")
	private WebElement koreanContent;

	public WebElement getKorean() {

		return koreanContent;
	}

	// REPLACEMENT PARTS
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Replacement Parts')]")
	private WebElement replacementParts;

	public WebElement getReplacementParts() {

		return replacementParts;
	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Quick Shop')])[4]")
	private WebElement replacementItem;

	public WebElement getReplacementItem() {

		return replacementItem;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Add to cart')]")
	private WebElement quickShopAddToCart;

	public WebElement getQuickShopAddToCart() {

		return quickShopAddToCart;
	}

	@FindBy(how = How.XPATH, using = "(//input[@name='email'])[1]")
	private WebElement guestEmail;

	public WebElement getGuestEmail() {

		return guestEmail;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue as a Guest')]")
	private WebElement continueAsGuest;

	public WebElement getContinueAsGuest() {

		return continueAsGuest;
	}

	// GIFT CARD SERVICES
	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Gift Card/Services')])[2]")
	private WebElement giftCardSerivices;

	public WebElement getGiftCardSerivices() {

		return giftCardSerivices;
	}

	@FindBy(how = How.XPATH, using = "//ul[@id='giftCardAmountOptions']/li")
	private List<WebElement> giftCardValues;

	public List<WebElement> getGiftCardValues() {

		return giftCardValues;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Add to cart')]")
	private WebElement giftCardValuesAddToCart;

	public WebElement getGiftCardValuesAddToCart() {

		return giftCardValuesAddToCart;
	}

	// MY ACCOUNT
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'My Account')])[4]")
	private WebElement myAccount;

	public WebElement getMyAccount() {

		return myAccount;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login']/header/h1")
	private WebElement myAccountHeader;

	public WebElement getMyAccountHeader() {

		return myAccountHeader;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login']/header/a/span")
	private WebElement myAccountCloseButton;

	public WebElement getMyAccountCloseButton() {

		return explicitWait(myAccountCloseButton);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='register.email']")
	private WebElement myAccountEmailBox;

	public WebElement getMyAccountEmailBox() {

		return myAccountEmailBox;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Create an Account')]")
	private WebElement createAnAccount;

	public WebElement getCreateAnAccount() {

		return createAnAccount;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'My Profile')]")
	private WebElement myAccountMyProfile;

	public WebElement getMyAccountMyProfile() {

		return myAccountMyProfile;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='profile.lastName']")
	private WebElement myProfileSurname;

	public WebElement getMyProfileSurname() {

		return myProfileSurname;
	}

	// SIGN IN
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Sign In')])[3]")
	private WebElement signIn;

	public WebElement getSignIn() {

		return signIn;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login']/header/span")
	private WebElement signInHeader;

	public WebElement getSignInHeader() {

		return signInHeader;
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Sign in']")
	private WebElement signInButton;

	public WebElement getSignButton() {

		return signInButton;
	}

	// TUMI DIFFERENCE
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'TUMI Difference')]")
	private WebElement tumiDifference;

	public WebElement getTumiDifference() {

		return tumiDifference;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='diffBlock']//div/h1")
	private WebElement tumiDifferenceHeader;

	public WebElement getTumiDifferenceHeader() {

		return tumiDifferenceHeader;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='aboutBlock']/div/following::ul[1]/li")
	private List<WebElement> aboutTumi;

	public List<WebElement> getAboutTumi() {

		return aboutTumi;
	}

	// CORPORATE RESPONSIBILITY
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Corporate Responsibility')]")
	private WebElement corporateResponsibility;

	public WebElement getCorporateResponsibility() {

		return corporateResponsibility;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='hero-wrapper']/following::div[2]/div/div/div/div/h2")
	private WebElement corporateResponsibilityHeader;

	public WebElement getCorporateResponsibilityHeader() {

		return corporateResponsibilityHeader;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Explore Careers')]")
	private WebElement exploreCareers;

	public WebElement getExploreCareers() {

		return exploreCareers;
	}

	// CALIFORNIA TRANSPARECY
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'California Transparency in Supply Chain Act')]")
	private WebElement californiaTransparencyInSupplyChainAct;

	public WebElement getSupplyChainAct() {

		return californiaTransparencyInSupplyChainAct;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='cmsSlot1']/div/div/div[1]/div[2]/h2")
	private WebElement supplyChainHeader;

	public WebElement getSupplyChainHeader() {

		return supplyChainHeader;
	}

	// CAREERS
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Careers')]")
	private WebElement careers;

	public WebElement getCareers() {

		return careers;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='careers-hero']/following::div/h2")
	private WebElement careersHeader;

	public WebElement getCareersHeader() {

		return careersHeader;
	}

	// CORPORATE CONTACTS
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Corporate Contacts')]")
	private WebElement corporateContacts;

	public WebElement getCorporateContacts() {

		return corporateContacts;
	}

	@FindBy(how = How.XPATH, using = "//h3[@id='region']")
	private List<WebElement> corporateOfficeAddress;

	public List<WebElement> getCorporateOfficeAddress() {

		return corporateOfficeAddress;
	}

	// CORPORATE GIFTS & INCENTIVES
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Corporate Gifts & Incentives')]")
	private WebElement corporateGiftsIncentives;

	public WebElement getCorporateGiftsIncentives() {

		return corporateGiftsIncentives;
	}

	// TRACK ORDERS
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Track Orders')]")
	private WebElement trackOrders;

	public WebElement getTrackOrders() {

		return trackOrders;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Tracking Your Order')]")
	private WebElement trackingYourOrder;

	public WebElement getTrackingYourOrder() {

		return trackingYourOrder;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='ia-list-middle']/following::section/h3")
	private WebElement trackingYourOrderHeader;

	public WebElement getTrackingYourOrderHeader() {

		return trackingYourOrderHeader;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Order History')]")
	private WebElement orderHistory;

	public WebElement getOrderHistory() {

		return orderHistory;
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Full Order Details')]")
	private WebElement fullOrderDetails;

	public WebElement getFullOrderDetails() {

		return fullOrderDetails;
	}

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Order Details')]")
	private WebElement orderDetailsHeader;

	public WebElement getOrderDetailsHeader() {

		return orderDetailsHeader;
	}

	// REGISTER YOUR TUMI
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Register Your Tumi')]")
	private WebElement registerYourTumi;

	public WebElement getRegisterYourTumi() {

		return registerYourTumi;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Tumi tracer registration')]")
	private WebElement registerYourTumiHeader;

	public WebElement getRegisterYourTumiHeader() {

		return registerYourTumiHeader;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Sign In')]")
	private WebElement signInTumiTracerPage;

	public WebElement getSignInTumiTracerPage() {

		return signInTumiTracerPage;
	}

	@FindBy(how = How.XPATH, using = "//form[@id='tumiTracerForm']/div/h3/following::div[1]/div/div[1]")
	private WebElement tumiTracerRegistrationHeader;

	public WebElement getTumiTracerRegistrationHeader() {

		return tumiTracerRegistrationHeader;
	}

	// TUMI LOGO
	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'CHAT')]//following::footer/div[2]/div/div/span/a")
	private WebElement tumiLogo;

	public WebElement getTumiLogo() {

		return tumiLogo;
	}

	// SIGN UP FOR NEWSLETTER
	@FindBy(how = How.XPATH, using = "//input[@id='newsletteremaildFooter']")
	private WebElement signUpForNewsLetterWithEmail;

	public WebElement getSignUpForNewsLetterWithEmail() {

		return signUpForNewsLetterWithEmail;
	}

	@FindBy(how = How.XPATH, using = "//span[@id='responseAlreadySignedUpFooter']")
	private WebElement messegeThrown;

	public WebElement getMessegeThrownl() {

		return messegeThrown;
	}

	// CURRENT USER
	@FindBy(how = How.XPATH, using = "//div[@id='loggedInDiv']/a")
	private WebElement currentUserKR;
	
	@FindBy(how = How.XPATH, using = "(//a[contains(text(), 'Hi,')])[2]")
	private WebElement currentUser;

	public WebElement getCurrentUser() {

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {

			return currentUser;
		} else {
			return explicitWait(currentUserKR);
		}
	}

	//BUYING A GIFT
	@FindBy(how = How.XPATH, using = "//a[@title='Slings']")
	private WebElement slings;

	public WebElement getSlings() {

		return slings;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='grid-container']/div/div[2]/div/div[2]/div/a/div")
	private List<WebElement>  slingProducts;

	public List<WebElement>  getSlingProducts() {

		return slingProducts;
	}

	@FindBy(how = How.XPATH, using = "//a[@id='smartGiftBtn']/span[2]")
	private WebElement buyingGift;

	public WebElement getBuyingGift() {

		return buyingGift;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='preview-wrapper']/div/h1")
	private WebElement experienceYourGift;

	public WebElement getExperienceYourGift() {

		return experienceYourGift;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='scratch-gift-content']/section/div/div[2]/div/div/div[1]")
	private WebElement yourGiftPreview;

	public WebElement getYourGiftPreview() {

		return yourGiftPreview;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='scratch-gift-content']/section/div/div[1]/div")
	private WebElement customizeGift;

	public WebElement getCustomizeGift() {

		return customizeGift;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='scratch-gift-content']/section/button[1]")
	private WebElement acceptThisGift;

	public WebElement getAcceptThisGift() {

		return acceptThisGift;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='preview-wrapper']/div/p")
	private WebElement clickToReveal;

	public WebElement getClickToReveal() {

		return clickToReveal;
	}
	@FindBy(how = How.XPATH, using = "//div[@id='scratch-gift-content']/section/button[2]")
	private WebElement exchangeGift;

	public WebElement getExchangeGift() {

		return exchangeGift;
	}
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Go Back')]")
	private WebElement goBack;

	public WebElement getGoBackButton() {

		return goBack;
	}
	
	@FindBy(how = How.XPATH, using = "//w-div[@id='gpgjfuy']/div[2]/div[1]")
	private WebElement goBackPopUp;

	public WebElement getGoBackPopUp() {

		return goBackPopUp;
	}
	
	@FindBy(how = How.XPATH, using = "//w-div[@id='gpgjfuy']/span")
	private WebElement closePopUp;

	public WebElement getClosePopUp() {

		return closePopUp;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='app']/div/div[2]/div/div/div/button")
	private WebElement letsGo;

	public WebElement getLetsGoButton() {

		return letsGo;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='app']/div/div[2]/div/div[2]/div[2]/div/h1")
	private WebElement prepareYourGiftHeader;

	public WebElement getPrepareYourGiftHeader() {

		return prepareYourGiftHeader;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id= 'senderFirstName']")
	private WebElement firstName;

	public WebElement getFirstName() {

		return firstName;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id= 'senderLastName']")
	private WebElement lastName;

	public WebElement getLastName() {

		return lastName;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id= 'senderEmail']")
	private WebElement email;

	public WebElement getEmail() {

		return email;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id= 'senderPhone']")
	private WebElement phone;

	public WebElement getPhoneNo() {

		return phone;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id= 'recipientFirstName']")
	private WebElement theirFirstName;

	public WebElement getTheirFirstName() {

		return theirFirstName;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id= 'recipientLastName']")
	private WebElement theirLastName;

	public WebElement getTheirLasttName() {

		return theirLastName;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Next')]")
	private WebElement next;

	public WebElement getNextButton() {

		return next;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='app']/div/div[2]/div/div[2]/div[2]/div/h1")
	private WebElement reviewYourInformation;

	public WebElement getReviewYourInfotHeader() {

		return reviewYourInformation;
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Confirm')]")
	private WebElement confirm;

	public WebElement getConfirmButton() {

		return confirm;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='app']/div/div[2]/div/div[2]/div/div/h1")
	private WebElement shareYourGiftWithSV;

	public WebElement getShareYourGifHeader() {

		return shareYourGiftWithSV;
	}
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Preview Your Gift')]")
	private WebElement previewYourGift;

	public WebElement getPreviewYourGiftButton() {

		return previewYourGift;
	}
	
}
