package orders.guest;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 * @author skurry
 *
 */
public class GuestOrder extends GenericMethods {
	/*
	 * TA-100 Verify Order with merchandise Ready to ship for Guest User
	 */

	@Test
	public void tumiOrderAsGuest() throws InterruptedException {

		UIFunctions.addProductToCart("PlaceOrder", "TumiOrder");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		UIFunctions.completeOrder("PlaceOrder", "TumiOrder");
	}

}
