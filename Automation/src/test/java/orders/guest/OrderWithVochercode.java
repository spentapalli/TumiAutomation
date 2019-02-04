package orders.guest;

import java.util.Map;
import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha, Suuresh
 *
 */
public class OrderWithVochercode extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");

	/*
	 * TA-15 Verify Order with merchandise Ready to ship + Voucher Code for Guest
	 * User
	 * 
	 * dataProvider = "Location",
	 */
	@Test(priority = 0, description = " TA -15 Verify Order with merchandise Ready to ship + Voucher Code for Guest User")
	public void verifyOrderWithVocherCode() throws InterruptedException {
		String msg = null;
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		// UIFunctions.addPromotionalCodeAtCart("TumiTestData", "GuestOrders");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		UIFunctions.addPromotionalCodeAtCart("TumiTestData", "GuestOrders");
		if (mainCart.getVocherMsg().isDisplayed()) {
			msg = getText(mainCart.getVocherMsg());
		}
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		if (msg.equals("Voucher could not be applied.")) {

			UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		}

		UIFunctions.completeOrder();
	}

	@Test(priority = 1, description="TA-103 Verify Order With Merchandise BackOrder + Voucher Card with Guest User")
	public void backOrderWithVocherAsGuest() {
		UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		// UIFunctions.addPromotionalCodeAtCart("TumiTestData", "BackOrderProduct");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "BackOrderProduct");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "BackOrderProduct");
		UIFunctions.completeOrder();
	}

	@Test(priority = 2, description = " TA - 106 Verify Order with merchandise Pre Order + Voucher Code for Guest User")
	public void preOrderVocherAsGuest() throws InterruptedException {
		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		// UIFunctions.addPromotionalCodeAtCart("TumiTestData", "PreOrderProduct");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "BackOrderProduct");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "PreOrderProduct");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
		UIFunctions.completeOrder();
	}
	
	@Test(priority=3,description = "TA-110 Verify Order with merchandise Ready to ship + Gift Boxing + Gift\r\n"
			+ "Message + Voucher/Promos for Guest User")
	public void verifyOrderwithGiftandVocherCode() throws Exception {

		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "GuestOrders");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		//UIFunctions.addPromotionalCodeAtCart("TumiTestData", "GuestOrders");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "BackOrderProduct");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "GuestOrders");
		//UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}

}
