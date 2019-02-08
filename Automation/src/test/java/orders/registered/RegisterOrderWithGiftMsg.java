//sprint-2
//TA- 187 Verify Order with merchandise Ready to ship + Gift Message-Registered User
package orders.registered;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;


public class RegisterOrderWithGiftMsg extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");


	@Test(description = " TA - 187 Verify Order with merchandise Ready to ship + Gift Message-Registered User")
	public void orderWithGiftMsgAsRegistered() throws Exception {
		login("TumiTestData", "RegisteredOrders");
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "PreOrderProduct");
		click(gift.getContinueGiftService(), "continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		domClick(signinShip.getAddNewAddress(), "Add new Address");
		UIFunctions.addGuestDetails();
		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		domClick(signinBill.getAddNewPay(), "Add new Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}

}
