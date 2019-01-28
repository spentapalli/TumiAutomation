package placeOrder;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 *
 */
public class GuestPreOrder extends GenericMethods {
	/*
	 * TA-112
	 *  Verify Order with merchandise Pre Order for Guest User
	 */

	@Test
	public void preOrderAsGuest() throws InterruptedException {

		TumiLibs.addProductToCart("PlaceOrder", "PreOrder");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		TumiLibs.completeOrder("PlaceOrder", "PreOrder");
	}

}
