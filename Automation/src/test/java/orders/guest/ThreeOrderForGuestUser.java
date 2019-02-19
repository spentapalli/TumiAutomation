//Sprint-2
//TA-22 Verify Order with 3 'Pre Order' Items, One Pre Order SKU + One Pre Order SKU with Personalization + One Pre Order SKU with Gift boxing-Guest user
//TA-32 Verify Order with 3 'Ready to Ship' Items, One regular in stock SKU + One in stock SKU with Personalization + One in stock SKU with Gift boxing-Guest user
//TA-23 Verify Order with 3 'Back Order' Items, One Back Order SKU + One Back Order SKU with Personalization + One Back Order SKU with Gift boxing-Guest user
package orders.guest;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class ThreeOrderForGuestUser extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
	Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "FailedOrder");
	
	  @Test(priority = 1,description = "Verify Order with 3 'BackOrder' Items, OneBack Order SKU + One Back Order SKU with Personalization + One Back Order SKU with Gift boxing-Guest user")
	  public void verifyThreeOrderWithGiftMsgAndPersonalizationForGuestUser() {
		  UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		  input(mainCart.getEditProductQuantity(), "2", "Edit Product Quantity");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getContinueShopping(), "Continue Shopping");
			UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
			UIFunctions.addMonogram("TumiTestData", "PreOrderProduct");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(gift.getMakeThisGift(), "Make this Gift");
			UIFunctions.addGiftBox();
			click(gift.getContinueGiftService(), "continue");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
			UIFunctions.completeOrder();
	  }

		//@Test(priority = 2,description = "Verify Order with 3 'Pre Order' Items, One PreOrder SKU + One Pre Order SKU with Personalization + One pre Order SKU with Gift boxing-Guest user")
		public void verifyThreePreorderWithGiftMsgAndPersonalizationForGuestUser() {
			
			UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
			input(mainCart.getEditProductQuantity(), "2", "Edit Product Quantity");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getContinueShopping(), "Continue Shopping");
			UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
			UIFunctions.addMonogram("TumiTestData", "PreOrderProduct");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(gift.getMakeThisGift(), "Make this Gift");
			UIFunctions.addGiftBox();
			click(gift.getContinueGiftService(), "continue");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
			UIFunctions.completeOrder();

		}
	
		//@Test(priority=3,description = "Verify Order with 3 'Ready to Ship' Items, One regular in stock SKU + One in stock SKU with Personalization + One in stock SKU with Gift boxing-Guest user")
		public void verifyGuestOrderWithThreeReadyToShipProducts() {

			UIFunctions.addProductToCart("TumiTestData", "RegisteredOrders");
			input(mainCart.getEditProductQuantity(), "2", "Edit Product Quantity");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getContinueShopping(), "Continue Shopping");
			UIFunctions.addProductToCart("TumiTestData", "RegisteredOrders");
	     	UIFunctions.addMonogram("TumiTestData", "RegisteredOrders");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(gift.getMakeThisGift(), "Make this Gift");
			UIFunctions.addGiftBox();
			click(gift.getContinueGiftService(), "continue");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
			UIFunctions.completeOrder();
		}
}


