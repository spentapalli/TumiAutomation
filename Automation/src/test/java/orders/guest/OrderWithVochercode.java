package orders.guest;

import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Suuresh
 *
 */
public class OrderWithVochercode extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");

	/*
	 * TA-15 Verify Order with merchandise Ready to ship + Voucher Code for Guest
	 * User
	 */
	@Test(dataProvider = "Location", 
			description = "Verify Order with merchandise Ready to ship + Voucher Code for Guest User")
	public void verifyOrderWithVocherCode(String name) throws InterruptedException {

		UIFunctions.selectCountry(name);
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		//UIFunctions.addPromotionalCodeAtCart("TumiTestData", "GuestOrders");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.addPromotionalCodeAtCart("TumiTestData", "GuestOrders");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}

}
