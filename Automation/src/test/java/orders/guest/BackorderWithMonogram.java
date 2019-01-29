//TA-108 Verify Order with BackOrder +Personalization
	package orders.guest;
	import java.util.Map;

	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;

	import com.tumi.dataProvider.ReadTestData;
	import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;
	

	public class BackorderWithMonogram extends GenericMethods {
		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "BackOrderProduct");

		@Test
		public void  orderWithMonogramAsGuest() {
			UIFunctions.addProductToCart("TumiTestData","BackOrderProduct");
			UIFunctions.addMonogram("TumiTestData", "BackOrderProduct");
			click(pdp.getAddToCart(),"Add to cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
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
