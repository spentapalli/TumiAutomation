package com.tumi.webPages;

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
		if (selectedCountry.contains("배송하기: 대한민국")) {
			return explicitWait(krviewProfile);
			} else {
			return viewProfile;
	}
	}
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[2]/a")
	private WebElement krpurchasedItems;
	
	@FindBy(how = How.XPATH, using = "(//a[@title='Purchased Items'])[2]")
	private WebElement purchasedItems;
	

	public WebElement getPurchasedItems() {
		if (selectedCountry.contains("배송하기: 대한민국")) {
			return explicitWait(krpurchasedItems);
			} else {
		return purchasedItems;
	}
	}
	@FindBy(how=How.XPATH,using="//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[3]/a") 
	private WebElement krviewYourOrderStatus;
	
	@FindBy(how = How.XPATH, using = "(//a[@title='View Your Order Status'])[2]")
	private WebElement viewYourOrderStatus;

  public WebElement getViewYourOrderStatus() {
		if (selectedCountry.contains("배송하기: 대한민국")) {
			return explicitWait(krviewYourOrderStatus);
			} else {
		return viewYourOrderStatus;
	}
  }

	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[1]/li[4]/a")
	private WebElement krregisterYourTumi;
	
	@FindBy(how = How.XPATH, using = "(//a[@title='Register Your TUMI'])[2]")
	private WebElement registerYourTumi;
	
   public WebElement getRegisterYourTumi() {
	if (selectedCountry.contains("배송하기: 대한민국")) {
		return explicitWait(krregisterYourTumi);
		} else {

		return registerYourTumi;
	}
   }

	@FindBy(how = How.XPATH, using = "(//a[@title='Repair Services'])[2]")
	private WebElement repairServices;

	public WebElement getRepairServices() {
		return repairServices;
	}
	

	
	//same for korea
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
		if (selectedCountry.contains("배송하기: 대한민국")) {
			return explicitWait(krmyAccountClose);
			} else {
		return myAccountClose;
	}
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
		if (selectedCountry.contains("배송하기: 대한민국")) {
			return explicitWait(krSignout);
			} else {
		return explicitWait(signout);
	}
	}

	// Korea
	// Myacc button
	@FindBy(how = How.XPATH, using = "//div[@id='tm-panel-login-confirmation']/div/div/ul[2]/li[1]/a")
	private WebElement MyaccButton;

	public WebElement getMyaccButton() {
		if(selectedCountry.contains("Korea")) {
			return signUpMyAccMsg;
		}else {

	return MyaccButton;
}
	}
	}
	


 