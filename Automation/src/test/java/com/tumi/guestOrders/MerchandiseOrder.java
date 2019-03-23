package com.tumi.guestOrders;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author skurry
 *
 */
public class MerchandiseOrder extends GenericMethods {
	
	/* TA-102
	 * Verify Order with merchandise Ready to ship + Gift Boxing for Guest User.
	 */
	@Test
	public void readyToShipOrderWithGuest() {
		UIFunctions.closeSignUp();
		UIFunctions.addProductToCart("PlaceOrder", "TumiOrder");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
	}

}
