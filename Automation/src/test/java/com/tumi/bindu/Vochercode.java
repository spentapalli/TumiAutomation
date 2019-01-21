package com.tumi.bindu;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;

public class Vochercode extends GenericMethods{
	public Map<String, String> testData = ReadTestData.retrieveData("PlaceOrder", "Vochercode");
	
	@Test
	public void testVochercode() {

	
	final String pdpURL = GlobalConstants.url+"/p/"+testData.get("SKUID");
	driver.get(pdpURL);
	click(pdp.getAddToCart(), "Add To Cart");
	delay(2000);
	// click on proceed to checkout in Mini cart
	click(minicart.getProceedCheckOut(), "Proceed to Checkout");
	
	
	// click on proceed to checkout in cart page
	click(mainCart.getProceedToCheckout(), "Cart");
	
	
}

}