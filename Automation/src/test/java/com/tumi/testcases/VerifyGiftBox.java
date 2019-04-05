package com.tumi.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class VerifyGiftBox extends GenericMethods{
	static Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "Products");
	
	@Test(description="TA-36 Verify Gift Box Charges applied to Order Summery")
	public void verifyPremiumGiftCharge() {
		SoftAssert premiumAsser = new SoftAssert();
		ProductDetails.addProductForPDPtest(testData.get("GiftBoxSKU"));
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart..");
		
		
		
		premiumAsser.assertAll();
		
	}
	
	

}


