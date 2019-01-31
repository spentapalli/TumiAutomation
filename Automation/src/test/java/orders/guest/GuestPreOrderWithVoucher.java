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
public class GuestPreOrderWithVoucher extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "PreOrderProduct");
	
	/*
	 * TA-106 
	 * Verify Order with merchandise Pre Order + Voucher Code for Guest User	
	 */

	@Test(description = " Verify Order with merchandise Pre Order + Voucher Code for Guest User")
	public void preOrderAsGuestWithVoucher() throws InterruptedException {
		UIFunctions.addProductToCart("TumiTestData","PreOrderProduct");
		click(pdp.getAddToCart(),"Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		//UIFunctions.addPromotionalCodeAtCart("TumiTestData", "PreOrderProduct");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "PreOrderProduct");
		//UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
		UIFunctions.completeOrder();
	}

}