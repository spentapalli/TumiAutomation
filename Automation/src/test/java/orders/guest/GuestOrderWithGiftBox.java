package orders.guest;

import org.testng.annotations.Test;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 * 
 */

public class GuestOrderWithGiftBox extends GenericMethods {
	
	/* TA-47 
	 * Verify Order with merchandise Ready to ship + Gift Boxing for Guest User.
	 */
	@Test
	public void orderWithGiftBoxAsGuest() throws Exception {
		UIFunctions.addProductToCart("PlaceOrder", "OrderWithGiftServices");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "continue");
		UIFunctions.completeOrder("PlaceOrder", "TumiOrder");

	}

}
