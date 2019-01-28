package orders.guest;

import org.testng.annotations.Test;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class GuestOrderWithMonogram extends GenericMethods {

	/*
	 * TA-48 
	 * Verify Order with merchandise Ready to ship + Personalization for
	 * Guest User.
	 */
	@Test
	public void orderWithMonogramAsGuest() {
		UIFunctions.addProductToCart("PlaceOrder", "OrderWithMonogram");
		UIFunctions.addMonogram("PlaceOrder", "OrderWithMonogram");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		UIFunctions.completeOrder("PlaceOrder", "OrderWithMonogram");
	}

}
