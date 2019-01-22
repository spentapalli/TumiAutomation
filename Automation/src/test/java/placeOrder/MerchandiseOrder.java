package placeOrder;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author skurry
 *
 */
public class MerchandiseOrder extends GenericMethods {
	
	/* TA-102
	 * Verify Order with merchandise Ready to ship + Gift Boxing for Guest User.
	 */
	@Test
	public void readyToShipOrderWithGuest() {
		TumiLibs.closeSignUpForUS();
		TumiLibs.addProductToCart("PlaceOrder", "TumiOrder");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
	}

}
