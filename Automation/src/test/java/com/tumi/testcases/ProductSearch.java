package com.tumi.testcases;

import java.util.List;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 *
 */
public class ProductSearch extends GenericMethods {
	public Map<String, String> testData = ReadTestData.retrieveData("Login", "PrdouctSearch");

	@Test
	public void search() throws InterruptedException {

		TumiLibs.closeSignUpForUsProd();
		click(home.getSelectCountry(), "US country");
		click(home.getSelectCountry(), "Korea");
		delay(3000);
		proSearch(0);
	}

	// TumiLibs.closeSignUpForUS();
	/*
	 * final String pdpURL = GlobalConstants.url+"/p"+ testData.get("SKUID");
	 * driver.get(pdpURL);
	 */

	public void proSearch(int i) {

		input(home.getSearchProduct(), testData.get("PrdouctName"), "Product Search");

		//WebElement dropdown = driver.findElement(By.id("matching_products"));
		// dropdown.click(); // assuming you have to click the "dropdown" to open it
		//List<WebElement> allSearchResults = dropdown.findElements(By.tagName("li"));
		if (home.getMatchingProducts().isEmpty()) {
			final String emptyViewText = driver
					.findElement(By.xpath("//div[contains(text(),'Sorry, no search results for')]")).getText();
			if (!emptyViewText.contains("no results")) {
				throw new RuntimeException(emptyViewText);
			}
		} else {
			home.getMatchingProducts().get(i).click();

			/*
			 * if(String.valueOf(i)==null) //int i= Integer.valueOf(testData.get("Index"));
			 * { allSearchResults.get(0).click(); }else { allSearchResults.get(i).click(); }
			 */
		}
	}

}
