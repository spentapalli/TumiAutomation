package orders.registered;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;


/**
 * @author Shwetha Capo
 *
 */
public class RegisterOrderWithMonogram extends GenericMethods {
	
	@Test(description = " Sprint 2- TA- 185 Verify Order with merchandise Ready to ship + Personalization - Registered User")
	public void orderWithMonogramAsRegistered() {

		login("TumiTestData", "TumiLogin");
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		UIFunctions.addMonogram("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
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
