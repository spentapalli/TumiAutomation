//Sprint-5
//TA-410 Verify 
package com.tumi.pageVerification;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class RegisteredOrderWithPreorder extends GenericMethods{
Map<String, String> testData= ReadTestData.getJsonData("TumiTestData","GuestDetails");
	
	
	@Test(priority=0,description = " TA - 410 Verify Order with PreOrder Registered User")
	public void VerifyRegisteredOrderPreorder() throws Exception {
	login("TumiTestData", "RegisteredOrders");
	UIFunctions.addProductToCart("TumiTestData","PreOrderProduct");
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

@Test(priority=1,description = " TA - 411 Verify Order with BackOrder Registered User")
public void VerifyRegisteredOrderBackorder() throws Exception {
login("TumiTestData", "RegisteredOrders");
UIFunctions.addProductToCart("TumiTestData","BackOrderProduct");
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
@Test(priority=2,description = " TA - 412 Verify Order with DonationOrder Registered User")
public void VerifyRegisteredOrderDonationorder() throws Exception {
login("TumiTestData", "RegisteredOrders");
UIFunctions.addProductToCart("TumiTestData","DonationPurchase");
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