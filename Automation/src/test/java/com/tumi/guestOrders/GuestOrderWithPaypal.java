package com.tumi.guestOrders;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha 
 *
 */

public class GuestOrderWithPaypal extends GenericMethods{
	
	@Test(description = "TA-284 Verify Order with merchandise Ready to ship with PayPal checkout-Guest user")
	public void orderWithPayPalAsGuest() throws Exception {
		UIFunctions.addProductToCart("TumiTestData","Products");
		click(pdp.getAddToCart(),"Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		UIFunctions.payPalCheckout("TumiTestData","PayPalDeatils",mainCart.getEstimatedTotal());
		UIFunctions.completeOrder();
	}

}
