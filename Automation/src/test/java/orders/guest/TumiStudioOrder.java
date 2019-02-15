package orders.guest;

import java.util.Map;


import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha  Capo
 *
 */
public class TumiStudioOrder extends GenericMethods{
	/*
	 * TA-10 verify order with Tumi studio - Guest user
	 * */
	
	Map<String, String> testData= ReadTestData.getJsonData("TumiTestData","GuestOrders");
	
	@Test(description ="TA-10 verify order with Tumi studio - Guest user")
	public void testTumiIdOrder() throws InterruptedException{
		
		UIFunctions.addProductToCart("TumiTestData","TumiIDPRoduct");
		UIFunctions.addTumiStudio();
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}

	
}
