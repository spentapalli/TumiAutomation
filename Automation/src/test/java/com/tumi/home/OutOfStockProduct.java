//sprint-3 
//TA-367  Verify Add to Cart button, if the product out of stock or not available
package com.tumi.home;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class OutOfStockProduct extends GenericMethods {
	
	@Test(priority = 0, description = "Verify Add to Cart button, if the product out of stock or not available")
	public void VerifyInStockProduct() {
		UIFunctions.addProduct("TumiTestData", "Products","NoramlSKUID");
	}

	//@Test(priority = 1)
	public void verifyOutOfStockProduct() {
		UIFunctions.addProductToCart("TumiTestData", "OutOfStock");
		if (!pdp.getAddToCart().isDisplayed()) {
			String productName = getText(pdp.getProductName());
			logger.log(Status.INFO, productName + " is out of stock");
		}
	}

}
