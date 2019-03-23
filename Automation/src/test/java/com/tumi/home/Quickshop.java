//Sprint-3
// TA-65 Verify Quick shop in PGP.
package com.tumi.home;

import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class Quickshop extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
		@Test
		public void VerifyQuickShop(){
			mouseHover(home.getOptions());
			click(home.getSubCateogry(),"Select option");
		        click(pgp.getQuickShop(),"QuickShop");
			   
			   	if(!pgp.getQuickShopAddtoCart().isDisplayed()){
			   			logger.log(Status.INFO,"product is out of stock");
			   	}else {
			   		click(pgp.getQuickShopAddtoCart(),"QuickShop Add to Cart");
				click(minicart.getProceedCheckOut(), "Proceed to Checkout");
				click(mainCart.getProceedCart(), "Proceed to Checkout");
				input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
				UIFunctions.waitForContinueToEnable();
				click(singlePage.getContinueAsGuest(), "Contiue as Guest");
				UIFunctions.addGuestDetails();
				click(shipping.getContinueShippingMethod(), "Contiue Shipping");
				click(shipMethod.getProceedToPayment(), "Proceed to Payment");
				UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
				UIFunctions.completeOrder();
			}
}
		
		
}