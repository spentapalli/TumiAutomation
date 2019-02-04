package orders.guest;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class OrderWithGiftBox extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "BackOrderProduct");

	@Test(priority = 1)
	public void backOrderWithGiftBox() {
		UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "BackOrderProduct");
		UIFunctions.completeOrder();

	}

	@Test(priority = 2, description = "TA-16 Verify Order with merchandise Back Order + Gift Boxing + Gift Message "
			+ "+ Voucher/Promos for Guest User")
	public void backOrderAsGuest() {
		UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "BackOrderProduct");
		UIFunctions.addGiftBox();

		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "BackOrderProduct");
		UIFunctions.completeOrder();
	}

	@Test(priority = 3, description = "Verify Order with merchandise Ready to ship " + "+ Gift Boxing for Guest User")
	public void orderWithGiftBoxAsGuest() throws Exception {
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "continue");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}

	@Test(priority = 4, description = "Verify Order with merchandise Ready to ship + Gift Boxing "
			+ "+ Gift Message for Guest User")
	public void orderWithGiftBoxnMsgAsGuest() throws Exception {
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "GuestOrders");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}

	@Test(priority = 5, description = "Verify Order with merchandise Pre Order + Gift Boxing for Guest user")
	public void preOrderWithGiftBoxAsGuest() throws Exception {

		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
		UIFunctions.completeOrder();
	}

	@Test(priority = 6, description = "Verify Order with merchandise Pre Order + Gift Boxing + Gift Message-Guest user")
	public void preOrderWithGiftBoxnMsgAsGuest() throws Exception {
		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "PreOrderProduct");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
		UIFunctions.completeOrder();
	}

	@Test(priority = 7, description = "Verify Order with merchandise Pre Order + Gift Boxing "
			+ "+ Gift Message + Voucher/Promos-Guest User")
	public void preOrderWithGiftBoxnMsgVocher() {
		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "PreOrderProduct");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		// UIFunctions.addPromotionalCodeAtCart("TumiTestData", "PreOrderProduct");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
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
}
