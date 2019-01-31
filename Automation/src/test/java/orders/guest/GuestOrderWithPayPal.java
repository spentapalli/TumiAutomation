package orders.guest;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 * 
 */

public class GuestOrderWithPayPal extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
	
	/* TA-284
	 * Verify Order with merchandise Ready to ship with PayPal checkout-Guest user
	 * 
	 */
	@Test(description = "Verify Order with merchandise Ready to ship with PayPal checkout-Guest user")
	public void orderWithGiftBoxAsGuest() throws Exception {
		UIFunctions.addProductToCart("TumiTestData","GuestOrders");
		click(pdp.getAddToCart(),"Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		UIFunctions.payPalCheckout("TumiTestData","PayPalDeatils");
		UIFunctions.completeOrder();

	}

}



