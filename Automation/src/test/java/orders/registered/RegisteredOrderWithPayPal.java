package orders.registered;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

import login.RegularLogin;

	/**
	 * @author Shwetha Capo
	 * 
	 */

	public class RegisteredOrderWithPayPal extends GenericMethods {
		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
		
		/* TA-285
		 * Verify Order with merchandise Ready to ship with PayPal checkout-Registered user
		 * 
		 */
		@Test(description = " TA-285 Verify Order with merchandise Ready to ship with PayPal checkout-Registered user")
		public void orderWithPayPalAsRegistered() throws Exception {
			login("TumiTestData", "TumiLogin");
			UIFunctions.addProductToCart("TumiTestData","GuestOrders");
			click(pdp.getAddToCart(),"Add to cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			UIFunctions.payPalCheckout("TumiTestData","PayPalDeatils", mainCart.getEstimatedTotalRegistered());
			UIFunctions.completeOrder();

		}

	}


