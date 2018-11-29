package com.tumi.demotestcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;

public class OrderWithMonogram extends GenericMethods{
	
	public Map<String, String>  testData = ReadTestData.retrieveData("Login", "OrderWithMonogram");

	@Test
	public void testOrderWithMonogram() throws InterruptedException {
		
	}
}
