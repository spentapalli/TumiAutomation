package placeOrder;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

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
		TumiLibs.addProductToCart("PlaceOrder", "PreOrderWithGiftServices");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		TumiLibs.addGiftMessage("PlaceOrder", "PreOrderWithGiftServices");
		TumiLibs.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		TumiLibs.completeOrder("PlaceOrder", "PreOrderWithGiftServices");

	}

}
