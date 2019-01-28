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
public class MiniCartPage extends GenericMethods{

	public MiniCartPage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH,using="//div[@id='minicart_data']") //same for Korea
	private WebElement miniCartSymbol;
	
	public WebElement getMiniCartSymbol() {
		
		return miniCartSymbol;
	}
	
	/*for Korea proceed to checkout
	 * @FindBy(how=How.XPATH,using="(//a[@href='/cart'])[2]") or 
	 * @FindBy(how=How.XPATH,using="//div[@id='tm-panel-mini-cart']/div/div[2]/a[1]")
	 *
	 */
	@FindBy(how=How.XPATH,using="//a[@title='Proceed to Checkout']")
	private WebElement proceedtoCheck;
	
	public WebElement getProceedCheckOut() {
		
		return  explicitWait(proceedtoCheck);
	}
	/*for Korea continue shopping
	 * @FindBy(how=How.XPATH,using="//div[@id='tm-panel-mini-cart']/div/div[2]/a[2]")
	 */
	
	@FindBy(how=How.XPATH,using="//a[@title='Continue Shopping']")
	private WebElement continueShopping;
	
	public WebElement getContinueShopping() {
		
		return continueShopping;
	}

}
