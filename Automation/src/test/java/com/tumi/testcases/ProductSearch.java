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

	

}
