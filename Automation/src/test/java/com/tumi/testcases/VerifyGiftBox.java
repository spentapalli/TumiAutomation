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
		
		Double beforeTotal = Double.valueOf(getText(mainCart.getTotal()).replace("$", "").replace(",", ""));
		click(gift.getMakeThisGift(),"Make this a gift");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		Double premiumCost = Double.valueOf(getText(mainCart.getPremiumCharge()).replace("$", "").replace(",", ""));
		
		Double afterTotal = Double.valueOf(getText(mainCart.getTotal()).replace("$", "").replace(",", ""));
		
		if(premiumCost==(afterTotal-beforeTotal)) {
			logger.log(Status.PASS, "Verification of Premium charges is successfull");
		}else {
			premiumAsser.fail("Before Estimated total cost and after applying Premium charges,total cost are not matched,Please check");
		}
		click(gift.getGiftRemove(),"Remove");
		Double afterRemove = Double.valueOf(getText(mainCart.getTotal()).replace("$", "").replace(",", ""));
		if(beforeTotal==afterRemove) {
			logger.log(Status.PASS, "After remove Premium gift box, the price is updated successfully");
		}else {
			premiumAsser.fail("After remove Premium gift box, the price is not updated successfully, Please Check");
		}
		
		premiumAsser.assertAll();
		
	}
	
	
}


