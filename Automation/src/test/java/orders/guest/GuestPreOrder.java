package orders.guest;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

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

		UIFunctions.addProductToCart("PlaceOrder", "PreOrder");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		UIFunctions.completeOrder("PlaceOrder", "PreOrder");
	}

}
