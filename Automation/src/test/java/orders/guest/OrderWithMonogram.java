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
public class OrderWithMonogram extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "PreOrderProduct");
	
	@Test(priority=0,description = " TA - 48 Verify Order with merchandise Ready to ship + Personalization for  Guest User.")
	public void orderWithMonogramAsGuest() {
		UIFunctions.addProductToCart("TumiTestData","GuestOrders");
		UIFunctions.addMonogram("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(),"Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
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

	/*
	 * TA-111 
	 * Verify Order with merchandise Pre Order + Personalization for Guest User
	 * .
	 */
	
	@Test(priority=1,description = " TA - 111 Verify Order with merchandise Pre Order + Personalization for  Guest User.")
	public void preOrderWithMonogramAsGuest() {
		UIFunctions.addProductToCart("TumiTestData","PreOrderProduct");
		UIFunctions.addMonogram("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(),"Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
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
	
	@Test(priority = 2, description = "TA-108 Verify Order with BackOrder +Personalization")
	public void backOrderWithMonogramAsGuest() {
		UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
		UIFunctions.addMonogram("TumiTestData", "BackOrderProduct");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
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

}
