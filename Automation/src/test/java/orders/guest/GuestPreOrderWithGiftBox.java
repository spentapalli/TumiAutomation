package placeOrder;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 * 
 */

public class GuestPreOrderWithGiftBox extends GenericMethods {
	
	/* TA-107
	 * Verify Order with merchandise Pre Order + Gift Boxing for Guest user
	 */
	@Test
	public void preOrderWithGiftBoxAsGuest() throws Exception {
		TumiLibs.addProductToCart("PlaceOrder", "PreOrderWithGiftServices");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		TumiLibs.addGiftBox();
		click(gift.getContinueGiftService(), "continue");
		TumiLibs.completeOrder("PlaceOrder", "PreOrderWithGiftServices");

	}

}