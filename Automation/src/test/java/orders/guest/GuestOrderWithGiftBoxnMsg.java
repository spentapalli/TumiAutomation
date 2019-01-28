package orders.guest;

import org.testng.annotations.Test;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 * 
 */

public class GuestOrderWithGiftBoxnMsg extends GenericMethods{
	/*TA-53 
	 * Verify Order with merchandise Ready to ship + Gift Boxing + Gift Message for Guest User
	 * */
	
	@Test
	public void orderWithGiftBoxnMsgAsGuest() throws Exception {
		UIFunctions.addProductToCart("PlaceOrder", "OrderWithGiftServices");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("PlaceOrder", "OrderWithGiftServices");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		UIFunctions.completeOrder("PlaceOrder", "OrderWithGiftServices");

	}

}
