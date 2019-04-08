package com.tumi.registerOrders;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 * 
 */

public class RegisteredOrder extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");

	/*
	 * TA-184 Verify Order with merchandise Ready to ship-Registered User
	 * 
	 */
	@Test(description = " TA - 184 Verify Order with merchandise Ready to ship-Registered User")
	public void tumiOrderAsRegistered() throws Exception {

		login("TumiTestData", "RegisteredOrders");

		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		waitForSinglePage();
		domClick(signinShip.getAddNewAddress(), "Add new Address");
		UIFunctions.addGuestDetails();
		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		domClick(signinBill.getAddNewPay(), "Add new Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
	}

	
}
