//TA-100: Verify Order with merchandise Ready to ship for Guest User
package placeOrder;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 * @author skurry
 *
 */
public class GuestOrders extends GenericMethods {


	@Test(priority = 0)
	public void tumiOrderAsGuest() throws InterruptedException {

		TumiLibs.addProductToCart("PlaceOrder", "TumiOrder");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		TumiLibs.completeOrder("PlaceOrder", "TumiOrder");
	}

	@Test(priority = 1)
	public void orderWithMonogramAsGuest() {

		TumiLibs.addProductToCart("PlaceOrder", "OrderWithMonogram");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		TumiLibs.addGiftMessage("PlaceOrder", "TumiOrder");
		click(gift.getContinueGiftService(), "continue");
		TumiLibs.completeOrder("PlaceOrder", "OrderWithMonogram");

	}

	@Test(priority = 2)
	public void orderWithGiftMsgAsGuest() {

		TumiLibs.addProductToCart("PlaceOrder", "OrderWithGiftServices");
		TumiLibs.addMonochrome("PlaceOrder", "TumiOrder");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		TumiLibs.addGiftMessage("PlaceOrder", "TumiOrder");
		click(gift.getContinueGiftService(), "continue");
		TumiLibs.completeOrder("PlaceOrder", "TumiOrder");

	}

	@Test(priority = 3)
	public void orderWithGiftBoxAsGuest() {

		TumiLibs.addProductToCart("PlaceOrder", "TumiOrder");
		TumiLibs.addMonochrome("PlaceOrder", "TumiOrder");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		TumiLibs.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		TumiLibs.completeOrder("PlaceOrder", "TumiOrder");

	}

}
