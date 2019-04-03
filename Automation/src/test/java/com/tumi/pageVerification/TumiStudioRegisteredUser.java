//Sprint-5
//TA-413 Verify Order with TumiStudio ship-Registered User
package com.tumi.pageVerification;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class TumiStudioRegisteredUser extends GenericMethods {
	Map<String, String> testData= ReadTestData.getJsonData("TumiTestData","GuestDetails");
	
	
	@Test(description = " TA - 413 Verify Order with TumiStudio ship-Registered User")
	public void VerifyTumiStudioRegisterdUser() throws Exception {
		
login("TumiTestData", "RegisteredOrders");
			UIFunctions.addProductToCart("TumiTestData","TumiStudio");
			UIFunctions.addTumiStudio();
			//UIFunctions.addTumiID();
			delay(2000);
			click(pdp.getAddToCart(), "Add to cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			domClick(signinShip.getAddNewAddress(),"Add new Address");
			UIFunctions.addGuestDetails();
			domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			domClick(signinBill.getAddNewPay(),"Add new Payment");
			UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
			UIFunctions.completeOrder();
		}
		

}


	
