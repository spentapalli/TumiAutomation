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

public class BackOrderProdcut extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "BackOrderProduct");
	/*
	 * TA-16 Verify Order with merchandise Back Order + Gift Boxing + Gift Message
	 * + Voucher/Promos for Guest User
	 */

	@Test(description = "Verify Order with merchandise Back Order + "
			+ "Gift Boxing + Gift Message + Voucher/Promos for Guest User")
	public void verifyOrderwithBackOrderProduct() throws Exception {
		UIFunctions.addProductToCart("TumiTestData","BackOrderProduct");
		click(pdp.getAddToCart(),"Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "BackOrderProduct");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		//UIFunctions.addPromotionalCodeAtCart("TumiTestData", "BackOrderProduct");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "BackOrderProduct");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "BackOrderProduct");
		UIFunctions.completeOrder();
		
	}

}
