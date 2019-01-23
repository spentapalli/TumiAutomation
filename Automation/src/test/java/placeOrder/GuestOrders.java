package placeOrder;

import org.testng.annotations.Test;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 * @author skurry
 *
 */
public class GuestOrders extends GenericMethods {
	/*
	 * TA-100 Verify Order with merchandise Ready to ship for Guest User
	 */

	@Test
	public void tumiOrderAsGuest() throws InterruptedException {

		TumiLibs.addProductToCart("PlaceOrder", "TumiOrder");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		TumiLibs.completeOrder("PlaceOrder", "TumiOrder");
	}

}
