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
public class RegisterOrderWithVoucher extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");

	@Test(description = " TA - 189 Verify Order with merchandise Ready to ship + Voucher -Registered User")
	public void orderWithVoucherAsRegistered() throws Exception {

		login("TumiTestData", "TumiLogin");
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		if (mainCart.getEditAddress().isDisplayed()) {
			domClick(signinShip.getAddNewAddress(), "Add new Address");
			UIFunctions.addGuestDetails();
			UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "VoucherCodeDetails");
			domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		}
		UIFunctions.completeOrder();
	}

}
