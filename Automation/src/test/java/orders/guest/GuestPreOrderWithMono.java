package placeOrder;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

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
		TumiLibs.addProductToCart("PlaceOrder", "PreOrderWithMonogram");
		TumiLibs.addMonogram("PlaceOrder", "PreOrderWithMonogram");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		TumiLibs.completeOrder("PlaceOrder", "PreOrderWithMonogram");
	}

}
