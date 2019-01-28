package orders.guest;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class GuestPreOrderWithVoucher extends GenericMethods {
	/*
	 * TA-106 
	 * Verify Order with merchandise Ready to ship for Guest User
	 */

	@Test
	public void preOrderAsGuestWithVoucher() throws InterruptedException {

		UIFunctions.addProductToCart("PlaceOrder", "PreOrderWithVoucher");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		UIFunctions.addVoucherID("PlaceOrder", "PreOrderWithVoucher");
		UIFunctions.completeOrder("PlaceOrder", "PreOrderWithVoucher");
	}

}