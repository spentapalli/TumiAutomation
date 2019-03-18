package com.tumi.webPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class ComparePage extends GenericMethods {

	public ComparePage(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ctnr-additional-prod-items')]/div/div/div")
	private List<WebElement> productSuggestionsList;

	public List<WebElement> getProductSuggestionsList() {

		return productSuggestionsList;
	}

	@FindBy(how = How.XPATH, using = "(//a[text()='Bags'])[1]")
	private WebElement bagsCategory;

	@FindBy(how = How.XPATH, using = "//nav[@id='navMainCntr']/ul/li[6]")
	private WebElement krBagsnBriefs;

	public WebElement getBagsCategory() {

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return bagsCategory;

		} else {

			return krBagsnBriefs;
		}

	}

	@FindBy(how = How.XPATH, using = "(//a[text()='Crossbodies'])[1]")
	private WebElement crossbodiesInBags;
	
	@FindBy(how = How.XPATH, using = "(//ul[contains(@class,'nav-sub-list-break-ctnr')])[3]/li[2]/a")
	private WebElement krCrossbodiesInBags;

	public WebElement getCrossbodiesInBags() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return crossbodiesInBags;

		} else {

			return krCrossbodiesInBags;
		}
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'jspPane removeFocusIndicator')]/div[1]/div/div[2]/div/following::a")
	private WebElement productInSuggestions;

	public WebElement getProductInSuggestions() {
		return productInSuggestions;
	}

}
