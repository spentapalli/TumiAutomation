package orders.registered;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class RegisterOrderWithVoucher extends GenericMethods{
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");


	@Test(description = " TA - 189 Verify Order with merchandise Ready to ship + Voucher -Registered User")
	public void orderWithVoucherAsRegistered() throws Exception {
		login("TumiTestData", "TumiLogin");
		UIFunctions.addProductToCart("TumiTestData", "RegisteredOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		domClick(signinShip.getAddNewAddress(), "Add new Address");
		UIFunctions.addGuestDetails();
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "GuestOrders");
		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		domClick(signinBill.getAddNewPay(), "Add new Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}

}
