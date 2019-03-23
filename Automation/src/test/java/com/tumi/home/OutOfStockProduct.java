//sprint-3 
//TA-367  Verify Add to Cart button, if the product out of stock or not available
package com.tumi.home;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class OutOfStockProduct extends GenericMethods{
@Test(priority = 0,description = "Verify Add to Cart button, if the product out of stock or not available")
public void VerifyInStockProduct() {
	UIFunctions.addProductToCart("TumiTestData","Products");
	
	mouseHover(pdp.getAddToCart());
		if(pdp.getAddToCart().isEnabled()){
				logger.log(Status.INFO, "In-Stock");
			} else {
				Assert.fail("Out of stock");
			}
}
@Test(priority = 1) 
public void  verifyOutOfStockProduct() {
  UIFunctions.addProductToCart("TumiTestData","OutOfStock");
  if(!pdp.getAddToCart().isDisplayed()){
	String productName= getText(pdp.getProductName());
	logger.log(Status.INFO,productName+" is out of stock");
	}
  }   
  
}
