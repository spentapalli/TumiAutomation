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
	
	@FindBy(how = How.XPATH, using = "(//ul[contains(@class,'nav-sub-list')]/li/ul/li/ul/li/ul/li/a)[1]")
	private WebElement carryOnLuggage;

	public WebElement getCarryOnLuggage() {

		return carryOnLuggage;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='Color_group-ctrl']/ul/li/form/label")
	private List<WebElement> colorsList;

	public List<WebElement> getColorsList() {

		return colorsList;
	}

	

}
