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
public class GuestOrderWithMultiShipment extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
	
	/* TA-290
	 * Verify Order with 2 'Ready to Ship' Items with different SKU/sPurchase with Multishipment for Guest user
	 * 
	 */
	@Test(description = "Verify Order with 2 'Ready to Ship' Items with different SKU/sPurchase with Multishipment for Guest user")
	public void verifyGuestOrderWithMutlishipment()throws InterruptedException{
		UIFunctions.addMultipleProducts("TumiTestData", "GuestOrders");
		click(minicart.getMiniCartSymbol(), "Cart Image");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		//UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addMultiship();
		UIFunctions.addMultishipAddressWithCardDeatils("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();

		
	}

}
