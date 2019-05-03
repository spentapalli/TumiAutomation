package com.tumi.guestOrders;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha
 *
 */
public class GuestOrdersWithGiftMsg extends GenericMethods {
	
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");

	/*
	 * TA- 178 Verify Order with merchandise Ready to ship with Gift message for
	 * Guest User
	 */

	@Test(priority = 0, description = "Sprint 2- TA- 178 Verify Order with merchandise Ready to ship with Gift message for Guest User")
	public void orderWithGiftMsgAsGuest() {

		UIFunctions.addProductToCart("TumiTestData", "Products");
		UIFunctions.verifyAddToCart();
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "VoucherCodeDetails");
		click(gift.getContinueGiftService(), "Continue");
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

	@Test(priority = 1, description = "Sprint 2- TA- 179 Verify Order with merchandise Pre order Ready to ship with Gift message for Guest User")
	public void preOrderWithGiftMsgAsGuest() {

		UIFunctions.addProduct("TumiTestData", "Products","PreOrderProduct");
		UIFunctions.verifyAddToCart();
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "VoucherCodeDetails");
		click(gift.getContinueGiftService(), "Continue");
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

	@Test(priority = 2, description = "Sprint 2- TA- 180 Verify Order with merchandise Back order Ready to ship with Gift message for Guest User")
	public void backOrderWithGiftMsgAsGuest() {

		UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
		UIFunctions.verifyAddToCart();
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "VoucherCodeDetails");
		click(gift.getContinueGiftService(), "Continue");
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
