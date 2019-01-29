//TA-9 Verify the Order with merchandise Globallocator
	
package orders.guest;

	import org.testng.annotations.Test;

	import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;
	

	public class GlobalLocatororder extends GenericMethods {
		@Test
		public void orderWithAsGuest() {
			UIFunctions.addProductToCart("PlaceOrder", "GlobalLocatororder");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			UIFunctions.completeOrder("PlaceOrder", "GlobalLocatororder");
		}

	}


