package com.tumi.webPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
//import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GenericMethods;

/**
 * @author Shwetha Capo
 *
 */
public class MyAccountPage extends GenericMethods {

	public MyAccountPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[1]/a")
	private WebElement krviewProfile;

	@FindBy(how = How.XPATH, using = "(//a[@title='View Your Profile'])[2]")
	private WebElement viewProfile;

	public WebElement getViewProfile() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return viewProfile;

		} else {
			return explicitWait(krviewProfile);
		}
	}

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[2]/a")
	private WebElement krpurchasedItems;

	@FindBy(how = How.XPATH, using = "(//a[@title='Purchased Items'])[2]")
	private WebElement purchasedItems;

	public WebElement getPurchasedItems() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {

			return purchasedItems;
		} else {
			return explicitWait(krpurchasedItems);
		}
	}

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[3]/a")
	private WebElement krviewYourOrderStatus;

	@FindBy(how = How.XPATH, using = "(//a[@title='View Your Order Status'])[2]")
	private WebElement viewYourOrderStatus;

	public WebElement getViewYourOrderStatus() {
		
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {

			return viewYourOrderStatus;
		} else {
			return explicitWait(krviewYourOrderStatus);

		}
	}

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[4]/a")
	private WebElement krregisterYourTumi;

	@FindBy(how = How.XPATH, using = "(//a[@title='Register Your TUMI'])[2]")
	private WebElement registerYourTumi;

	public WebElement getRegisterYourTumi() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return registerYourTumi;
		} else {

			return explicitWait(krregisterYourTumi);
		}
	}

	@FindBy(how = How.XPATH, using = "(//a[@title='Repair Services'])[2]")
	private WebElement repairServices;

	public WebElement getRepairServices() {
		return repairServices;
	}

	// @FindBy(how = How.XPATH, using = "(//h3[contains(text(),'My Account')])[1]")
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login']/header/h3")
	private WebElement myAccMsg;

	public WebElement getMyAccMsg() {
		return myAccMsg;
	}

	@FindBy(how = How.XPATH, using = "(// form[@id='tm-login-form']/div/div/label)[1]")
	private WebElement krEnterEmail;

	public WebElement getKrEnterEmail() {
		return krEnterEmail;
	}

	// same for korea
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/header/span")
	private WebElement welcomeMessage;

	public WebElement getWelcomeMessage() {

		return welcomeMessage;
	}

	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'New here?')]")
	private WebElement newHereMessage;

	public WebElement getNewHereMessage() {
		return newHereMessage;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/header/a/span")
	private WebElement krmyAccountClose;

	@FindBy(how = How.XPATH, using = "(//a[@title='Close'])[4]")
	private WebElement myAccountClose;

	public WebElement getMyAccountClose() {

		/*
		 * if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
		 * return explicitWait(myAccountClose); } else {
		 */
		return explicitWait(krmyAccountClose);
		// }
	}

	@FindBy(how = How.XPATH, using = "//a[@href='#create-account']")
	private WebElement createAcc;

	public WebElement getCreateAcc() {
		return createAcc;

	}

	@FindBy(how = How.XPATH, using = "(//h3[contains(text(),'My Account')])[2]")
	private WebElement signUpMyAccMsg;

	public WebElement getSignUpMyAccMsg() {
		return signUpMyAccMsg;

	}

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[2]/li[2]/a")
	private WebElement krSignout;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Sign Out')])[3]")
	private WebElement signout;

	public WebElement getSignout() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return explicitWait(signout);
		} else {
			return explicitWait(krSignout);
		}
	}

	// Korea
	// Myacc button
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[2]/li[1]/a")
	private WebElement MyaccButton;

	public WebElement getMyaccButton() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return MyaccButton;
		} else {

			return signUpMyAccMsg;
		}
	}
	
	@FindBy(how = How.XPATH, using = "(//a[@title='View Your Profile'])[2]")
	private WebElement myProfile;

	public WebElement getMyProfile() {
		return explicitWait(myProfile);

	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Payment/Gift Card']")
	private WebElement payment;

	public WebElement getMyPayments() {
		return payment;

	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Payment Card')]/following::section/div[3]/form/button")
	private List<WebElement> cards;

	public List<WebElement> getAvailableCards() {
		return cards;

	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Payment Card')]/following::section[1]/div[3]/form[1]/button")
	private WebElement removeCards;

	public WebElement getRemoveCards() {
		return removeCards;

	}
	
	//div[contains(text(),'Payment Card')]/following::section[1]/div[3]/form[1]/button
	
	//VIEW YOUR PROFILE
	
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[1]/a")
	private WebElement viewYourProfileKR;
	
	@FindBy(how = How.XPATH, using = "(//a[@title='View Your Profile'])[2]")
	private WebElement viewYourProfile;

	public WebElement getViewYourProfile() {

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {

			return viewYourProfile;
		} else {
			return explicitWait(orderHistoryHeaderKR);

		}
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='profile.firstName']")
	private WebElement	profileFirstName;

	public WebElement getProfileFirstName() {
		return profileFirstName;

	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='profile.lastName']")
	private WebElement	profileSurName;

	public WebElement getProfileSurName() {
		return profileSurName;

	}
	
	//PURCHASED ITEMS
	@FindBy(how = How.XPATH, using = "//h1[@class='section-headline-lite']")
	private WebElement	myPurchases;

	public WebElement getMyPurchases() {
		return myPurchases;

	}
	
	//VIEW ORDER STATUS
	
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[3]/a")
	private WebElement viewOrderStatusKR;
	
	@FindBy(how = How.XPATH, using = "(//a[@title='View Your Order Status'])[2]")
	private WebElement viewOrderStatus;

	public WebElement getViewOrderStatus() {

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {

			return viewOrderStatus;
		} else {
			return explicitWait(viewOrderStatusKR);

		}
	}

	@FindBy(how = How.XPATH, using = "//div[@id='globalMessages']/following::div/div/div[2]/h2")
	private WebElement orderHistoryHeaderKR;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Order History')]")
	private WebElement orderHistoryHeader;

	public WebElement getOrderHistoryHeader() {

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {

			return orderHistoryHeader;
		} else {
			return explicitWait(orderHistoryHeaderKR);
		}
	}
	
	//REGISTER YOUR TUMI
	@FindBy(how = How.XPATH, using = "//input[@id='tracerNumber']")
	private WebElement tumiTracerNumber;

	public WebElement getTumiTracerNumber() {
		return tumiTracerNumber;

	}

	//REPAIR SERVICES FOR US
	@FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Repair Services')]")
	private WebElement repairServicesHeader;

	public WebElement getRepairServicesHeader() {
		return repairServicesHeader;

	}
}
