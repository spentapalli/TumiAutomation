//TA-99 Verify Order With Merchandise Back order with gift message +Gift Boxing   
	
package orders.guest;

import org.openqa.selenium.WebElement;
	import java.util.Map;
	
	import org.testng.annotations.Test;

	import com.tumi.dataProvider.ReadTestData;
	import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;


	public class BackorderWithGiftServices extends GenericMethods {
		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "BackOrderProduct");

		
		@Test
		public void orderWithAsGuest() {
			UIFunctions.addProductToCart("TumiTestData","BackOrderProduct");
			click(pdp.getAddToCart(),"Add to cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(gift.getMakeThisGift(), "Make this Gift");
			UIFunctions.addGiftMessage("TumiTestData", "BackOrderProduct");
			UIFunctions.addGiftBox();
			
			click(gift.getContinueGiftService(), "Continue");
			click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			//UIFunctions.waitForContinueToEnable();
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "BackOrderProduct");
			UIFunctions.completeOrder();
			
		}
	}
