package orders.registered;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class RegisterOrderWithGiftBox extends GenericMethods {
	
	@Test(description = " Sprint 2- TA- 186 Verify Order with merchandise Ready to ship + Gift Boxing - Registered User")
	
	public void orderWithGiftboxAsRegistered() {

		login("TumiTestData", "TumiLogin");
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		domClick(signinShip.getAddNewAddress(), "Add new Address");
		UIFunctions.addGuestDetails();
		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		domClick(signinBill.getAddNewPay(), "Add new Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
		click(confirmation.getSignoutAtConfirm(), "Signout");
	}
}
