package placeOrder;

import org.testng.annotations.Test;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 * 
 */

public class GuestOrderWithGiftBox extends GenericMethods {
	
	/* TA-102 
	 * Verify Order with merchandise Ready to ship + Gift Boxing for Guest User.
	 */
	@Test
	public void orderWithGiftBoxAsGuest() throws Exception {
		TumiLibs.addProductToCart("PlaceOrder", "OrderWithGiftServices");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		TumiLibs.addGiftBox();
		click(gift.getContinueGiftService(), "continue");
		TumiLibs.completeOrder("PlaceOrder", "TumiOrder");

	}

}
