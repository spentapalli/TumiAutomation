package com.tumi.webPages;

import java.util.List;

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
public class SignInShippingPage extends GenericMethods {
	public SignInShippingPage(WebDriver driver) {
		Reports.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//input[@id='8913687150615']
	@FindBy(how=How.XPATH,using="//div[@class='signInCheckout span8 pad15 border_CC removeFocusIndicator']/div[3]")
	private List<WebElement> defaultAddress;
	
	public List<WebElement> getListAddressLine1() {

		return defaultAddress;
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='8913687150615']")
	private WebElement tellAddress;
	
	@FindBy(how=How.XPATH,using="//input[@id='8913614569495']")
	private WebElement sixThAveAddress;
	
	
	@FindBy(how=How.XPATH,using="//input[@id='8907344642071']")
	private WebElement corkScrewAddress;
	
	@FindBy(how=How.XPATH,using="//input[@id='8907253579799']")
	private WebElement DurhamAddress1;
	
	@FindBy(how=How.XPATH,using="//input[@id='8904263958551']")
	private WebElement EnLafayetteAddress;
	
	@FindBy(how=How.XPATH,using="//input[@id='8899805806615']")
	private WebElement durham2Address;

	public WebElement getTellAddress() {
		return tellAddress;
	}

	public WebElement getSixThAveAddress() {
		return sixThAveAddress;
	}

	public WebElement getCorkScrewAddress() {
		return corkScrewAddress;
	}

	public WebElement getDurhamAddress1() {
		return DurhamAddress1;
	}

	public WebElement getEnLafayetteAddress() {
		return EnLafayetteAddress;
	}

	public WebElement getDurham2Address() {
		return durham2Address;
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='addNewAddress']")
	private WebElement addNewAddress;
	
	public WebElement getAddNewAddress() {
		return addNewAddress;
	}
}
