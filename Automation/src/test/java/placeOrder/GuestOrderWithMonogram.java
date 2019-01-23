package placeOrder;

import org.testng.annotations.Test;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 *
 */
public class GuestOrderWithMonogram extends GenericMethods {

	/*
	 * TA-101 Verify Order with merchandise Ready to ship + Personalization for
	 * Guest User.
	 */
	@Test
	public void orderWithMonogramAsGuest() {
		TumiLibs.addProductToCart("PlaceOrder", "OrderWithMonogram");
		TumiLibs.addMonogram("PlaceOrder", "OrderWithMonogram");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getContinueGiftService(), "continue");
		TumiLibs.completeOrder("PlaceOrder", "OrderWithMonogram");
	}

}
