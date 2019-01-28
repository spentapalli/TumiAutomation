package orders.guest;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

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
		UIFunctions.addProductToCart("PlaceOrder", "PreOrderWithGiftServices");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "continue");
		UIFunctions.completeOrder("PlaceOrder", "PreOrderWithGiftServices");

	}

}