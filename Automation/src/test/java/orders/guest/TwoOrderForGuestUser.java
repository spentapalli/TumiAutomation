//sprint-2
//TA-Verify Order with 2 'In-stock Order' Items, One In-stock Order SKU + One In-stock Order SKU with GiftMessage -Guest user
package orders.guest;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class TwoOrderForGuestUser extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
		@Test(description = "Verify Order with 2 'In-stock Order' Items, One In-stock Order SKU + One In-stock Order SKU with GiftMessage -Guest user")
		public void verifyTwoOrderForGuestUse() {

			UIFunctions.addProductToCart("TumiTestData", "OrderWithTwoProducts");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getContinueShopping(), "Continue Shopping");
			UIFunctions.addProductToCart("TumiTestData", "OrderWithTwoProducts");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(gift.getMakeThisGift(), "Make this Gift");
		     click(gift.getContinueGiftService(), "continue");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
			UIFunctions.completeOrder();
		}

}
