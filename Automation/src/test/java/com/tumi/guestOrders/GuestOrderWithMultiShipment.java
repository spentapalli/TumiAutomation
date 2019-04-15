package com.tumi.guestOrders;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class GuestOrderWithMultiShipment extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");

	/*
	 * TA-290 Verify Order with 2 'Ready to Ship' Items with different SKU/sPurchase
	 * with Multishipment for Guest user
	 * 
	 */
	@Test(description = "TA - 290 Verify Order with 2 'Ready to Ship' Items with different SKU/sPurchase with Multishipment for Guest user")
	public void verifyGuestOrderWithMutlishipment() throws InterruptedException {
		
		UIFunctions.addMultipleProducts("TumiTestData", "GuestDetails");
		click(minicart.getMiniCartSymbol(), "Cart Image");
		click(minicart.getProceedCheckOut(),"Proceed To Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addMultiship();
		UIFunctions.addMultishipAddressWithCardDeatils("TumiTestData", "CreditCardDetailsMultishipmnet");
		UIFunctions.completeOrder();

	}

}
