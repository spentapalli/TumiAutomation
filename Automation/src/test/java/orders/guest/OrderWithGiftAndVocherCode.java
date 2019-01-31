package orders.guest;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Suresh
 * 
 */

public class OrderWithGiftAndVocherCode extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
	/*
	 * TA-110 Verify Order with merchandise Ready to ship + Gift Boxing + Gift
	 * Message + Voucher/Promos for Guest User
	 */

	@Test(description = "TA-110 Verify Order with merchandise Ready to ship + Gift Boxing + Gift\r\n"
			+ "Message + Voucher/Promos for Guest User")
	public void verifyOrderwithGistandVocherCode() throws Exception {

		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "GuestOrders");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		//UIFunctions.addPromotionalCodeAtCart("TumiTestData", "GuestOrders");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "GuestOrders");
		//UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}

}
