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
	public Map<String, String> testData = ReadTestData.retrieveData("PlaceOrder", "PrdouctSearch");

	@Test
	public void search() throws InterruptedException {
		TumiLibs.closeSignUpForUS();
		TumiLibs.searchProducts(1, testData.get("PrdouctName"));
	}

	/*public void proSearch(int i) {

		input(home.getSearchProduct(), testData.get("PrdouctName"), "Product Search");
		if (home.getMatchingProducts().isEmpty()) {
			final String emptyViewText = driver
					.findElement(By.xpath("//div[contains(text(),'Sorry, no search results for')]")).getText();
			if (!emptyViewText.contains("no results")) {
				throw new RuntimeException(emptyViewText);
			}
		} else {
			home.getMatchingProducts().get(i).click();
		}
	}*/

}
