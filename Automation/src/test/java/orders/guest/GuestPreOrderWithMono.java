package orders.guest;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class GuestPreOrderWithMono extends GenericMethods {

	/*
	 * TA-111 
	 * Verify Order with merchandise Pre Order + Personalization for 
	 * Guest User.
	 */
	@Test
	public void preOrderWithMonogramAsGuest() {
		UIFunctions.addProductToCart("PlaceOrder", "PreOrderWithMonogram");
		UIFunctions.addMonogram("PlaceOrder", "PreOrderWithMonogram");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		UIFunctions.completeOrder("PlaceOrder", "PreOrderWithMonogram");
	}

}
