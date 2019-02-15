package orders.guest;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha
 *
 */
public class Sprint2 extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
	
	/*TA- 178
	 *  Verify Order with merchandise Ready to ship with Gift message for Guest User
	 */
	
	//@Test(priority = 0, description = " TA- 178 Verify Order with merchandise Ready to ship with Gift message for Guest User")
	public void orderWithGiftMsgAsGuest()  {

		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "GuestOrders");
		click(gift.getContinueGiftService(), "Continue");
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
	
	//@Test(priority = 1, description = " TA- 179 Verify Order with merchandise Pre order Ready to ship with Gift message for Guest User")
	public void preOrderWithGiftMsgAsGuest(){

		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "GuestOrders");
		click(gift.getContinueGiftService(), "Continue");
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
	
	//@Test(priority = 2, description = " TA- 180 Verify Order with merchandise Back order Ready to ship with Gift message for Guest User")
	public void backOrderWithGiftMsgAsGuest(){

		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "GuestOrders");
		click(gift.getContinueGiftService(), "Continue");
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
	
	//@Test(priority = 3, description = " TA- 185 Verify Order with merchandise Ready to ship + Personalization - Registered User")
	public void orderWithMonogramAsRegistered()  {

		login("TumiTestData", "RegisteredOrders");
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		UIFunctions.addMonogram("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		domClick(signinShip.getAddNewAddress(),"Add new Address");
		UIFunctions.addGuestDetails();
		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		domClick(signinBill.getAddNewPay(),"Add new Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}
	
	//@Test(priority = 4, description = " TA- 186 Verify Order with merchandise Ready to ship + Gift Boxing - Registered User")
	public void orderWithGiftboxAsRegistered()  {

		login("TumiTestData", "RegisteredOrders");
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		domClick(signinShip.getAddNewAddress(),"Add new Address");
		UIFunctions.addGuestDetails();
		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		domClick(signinBill.getAddNewPay(),"Add new Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}
	
	
	
	
	//@Test(priority = 6, description = " TA- 188 Verify Order with merchandise Ready to ship + Gift Message + Gift Box - Registered User")
	public void orderWithGiftMsgNBoxAsRegistered()  {

		login("TumiTestData", "RegisteredOrders");
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "BackOrderProduct");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		domClick(signinShip.getAddNewAddress(),"Add new Address");
		UIFunctions.addGuestDetails();
		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		domClick(signinBill.getAddNewPay(),"Add new Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}
	
	//@Test(priority = 7, description = " TA- 190 Verify Order with merchandise Ready to ship + Gift Message + Gift Box + Voucher - Registered User")
	public void orderWithGiftMsgNBoxVoucherAsRegistered()  {

		login("TumiTestData", "RegisteredOrders");
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "BackOrderProduct");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		domClick(signinShip.getAddNewAddress(),"Add new Address");
		UIFunctions.addGuestDetails();
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "GuestOrders");
		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		domClick(signinBill.getAddNewPay(),"Add new Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}
	@Test(priority = 8, description = "TA- 8 Verify order fail with wrong card details for Guest user")
	public void orderWithWrongCardDetails() throws InterruptedException {
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "FailedOrder");
		try {
			if (review.getCheckoutMessages().isDisplayed()) {
				delay(2000);
				if(getText(review.getCheckoutMessages()).contains(getProperty("checkout.Messages"))){
					Assert.fail("Order is incompleted with invalid card details");
				}
			}
		} catch (Exception e) {
			Assert.fail("Order is completed with invalid card details");
		}
		UIFunctions.completeOrder();
	}
	

}
