package com.tumi.registerOrders;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;


/**
 * @author Shwetha Capo
 *
 */
public class RegisterOrderWithGiftServices extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
	
	@Test(priority = 0, description = " Sprint 2- TA- 186 Verify Order with merchandise Ready to ship + Gift Boxing - Registered User")
	public void orderWithGiftboxAsRegistered() {

		login("TumiTestData", "RegisteredOrders");
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		domClick(signinShip.getAddNewAddress(), "Add new Address");
		UIFunctions.addGuestDetails();
		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		domClick(signinBill.getAddNewPay(), "Add new Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
		click(confirmation.getSignoutAtConfirm(), "Signout");
	}

   @Test(priority = 1, description = " TA - 187 Verify Order with merchandise Ready to ship + Gift Message-Registered User")

	public void orderWithGiftMsgAsRegistered() {
		login("TumiTestData", "RegisteredOrders");
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "VoucherCodeDetails");
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		domClick(signinShip.getAddNewAddress(), "Add new Address");
		UIFunctions.addGuestDetails();
		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		domClick(signinBill.getAddNewPay(), "Add new Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
		click(confirmation.getSignoutAtConfirm(), "Signout");
	}

	@Test(priority = 2, description = " TA- 188 Verify Order with merchandise Ready to ship + Gift Message + Gift Box - Registered User")
	public void orderWithGiftMsgNBoxAsRegistered() {

		login("TumiTestData", "RegisteredOrders");
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "VoucherCodeDetails");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		domClick(signinShip.getAddNewAddress(), "Add new Address");
		UIFunctions.addGuestDetails();
		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		domClick(signinBill.getAddNewPay(), "Add new Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
		click(confirmation.getSignoutAtConfirm(), "Signout");
	}

	@Test(priority = 3, description = " TA- 190 Verify Order with merchandise Ready to ship + Gift Message + Gift Box + Voucher - Registered User")
	public void orderWithGiftMsgNBoxVoucherAsRegistered() {

		login("TumiTestData", "RegisteredOrders");
		UIFunctions.addProductToCart("TumiTestData","Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "VoucherCodeDetails");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		domClick(signinShip.getAddNewAddress(), "Add new Address");
		UIFunctions.addGuestDetails();
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "VoucherCodeDetails");
		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		domClick(signinBill.getAddNewPay(), "Add new Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
		click(confirmation.getSignoutAtConfirm(), "Signout");
	}

}
