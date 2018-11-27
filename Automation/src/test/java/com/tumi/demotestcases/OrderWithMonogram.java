package com.tumi.demotestcases;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.pageObjects.MiniCartPage;
import com.tumi.pageObjects.ShippingPage;
import com.tumi.utilities.GenericMethods;

public class OrderWithMonogram extends GenericMethods{
	
	public Map<String, String>  testData = ReadTestData.retrieveData("Login", "OrderWithMonogram");

	@Test
	public void testOrderWithMonogram() throws InterruptedException {
		
		MiniCartPage cart=PageFactory.initElements(driver, MiniCartPage.class);
		ShippingPage shipping=PageFactory.initElements(driver, ShippingPage.class);
		
	}
}
