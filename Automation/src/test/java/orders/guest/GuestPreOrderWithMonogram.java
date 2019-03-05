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

public class GuestPreOrderWithMonogram extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
	/*
	 * TA-111 Verify Order with merchandise Pre Order + Personalization for Guest
	 * User .
	 */

	@Test(priority = 1, description = " TA - 111 Verify Order with merchandise Pre Order + Personalization for  Guest User.")
	public void preOrderWithMonogramAsGuest() {
		UIFunctions.addProductToCart("TumiTestData", "Products");
		UIFunctions.addMonogram("TumiTestData", "MonoGramDetails");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
	}

}
