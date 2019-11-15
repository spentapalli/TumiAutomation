package com.tumi.guestOrders;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class TenderChange extends GenericMethods{
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData","GuestDetails");
	
	@Test(priority = 4, description = "TA_15 Verify Place Order with Tender Change(GiftCard+Credit/Debit Card)-Guest user")
	public void TenderChangeOrderAsGuest() {

		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		}
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.GiftCard("TumiTestData", "VoucherCodeDetails");
		UIFunctions.completeOrder();
	}	

}
