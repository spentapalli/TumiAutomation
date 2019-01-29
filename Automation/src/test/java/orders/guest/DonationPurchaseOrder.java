//TA_11 Verify Order with Donation purchase
	
package orders.guest;

	import org.testng.annotations.Test;

	import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;


	public class DonationPurchaseOrder extends GenericMethods{
		@Test
		public void orderWithAsGuest() {
			UIFunctions.addProductToCart("PlaceOrder", "DonationPurchaseOrder");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			UIFunctions.completeOrder("PlaceOrder", "DonationPurchaseOrder");
		}

	}


