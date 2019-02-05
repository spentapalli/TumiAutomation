package orders.registered;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class RegisteredOrderWithMultishipment extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
	
	/* TA-286
	 * Verify Order with 2 'Ready to Ship' Items with different SKU/sPurchase with Multishipment-Registered User
	 * 
	 */
	@Test(description = " Verify Order with 2 'Ready to Ship' Items with different SKU/sPurchase with Multishipment-Registered User")
	public void verifyRegisteredOrderWithMutlishipment()throws InterruptedException{
		login("TumiTestData", "RegisteredOrders");
		click(myacc.getMyAccountClose(), "My Account Close");
		UIFunctions.addMultipleProducts("TumiTestData", "GuestOrders");
		click(minicart.getMiniCartSymbol(), "Cart Image");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		UIFunctions.addMultishipForRegistered();
		domClick(signinBill.getAddNewPay(),"Add new Payment");
		UIFunctions.addMultishipAddressWithCardDeatils("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();

		
	}

}

