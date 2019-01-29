//TA-99 Verify the merchandise Back Order + Gift Box
	
package orders.guest;


	

	import org.testng.annotations.Test;

	import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;
	

	public class BackOrderWithGiftBox extends GenericMethods{
		@Test
		public void orderWithAsGuest() {
		UIFunctions.addProductToCart("PlaceOrder", "BackOrderWithGiftBox");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(gift.getMakeThisGift(), "Make this Gift");
			UIFunctions.addGiftBox();
			click(gift.getContinueGiftService(), "Continue");
			UIFunctions.completeOrder("PlaceOrder", "BackOrderWithGiftBox");
		}
	}


