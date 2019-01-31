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

public class GuestPreOrderWithGiftBoxMsgVoucher extends GenericMethods{
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "PreOrderProduct");
	/*TA-12
	 *Verify Order with merchandise Pre Order + Gift Boxing + Gift Message + Voucher/Promos-Guest User
	 *
	 */
	
	@Test(description = "Verify Order with merchandise Pre Order + Gift Boxing + Gift Message + Voucher/Promos-Guest User")
	public void orderWithGiftBoxnMsgAsGuest() throws Exception {
		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "PreOrderProduct");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
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

