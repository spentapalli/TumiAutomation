package orders.guest;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 * 
 */

public class GuestPreOrderWithGiftBoxMsg extends GenericMethods{
	/*TA-3
	 *Verify Order with merchandise Pre Order + Gift Boxing + Gift Message-Guest user
	 *
	 */
	
	@Test
	public void orderWithGiftBoxnMsgAsGuest() throws Exception {
		UIFunctions.addProductToCart("PlaceOrder", "PreOrderWithGiftServices");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("PlaceOrder", "PreOrderWithGiftServices");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		UIFunctions.completeOrder("PlaceOrder", "PreOrderWithGiftServices");

	}

}
