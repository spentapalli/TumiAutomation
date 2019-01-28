package placeOrder;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

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

		TumiLibs.addProductToCart("PlaceOrder", "PreOrderWithVoucher");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		TumiLibs.addVoucherID("PlaceOrder", "PreOrderWithVoucher");
		TumiLibs.completeOrder("PlaceOrder", "PreOrderWithVoucher");
	}

}