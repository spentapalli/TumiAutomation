//sprint-2
//TA-181 Verify Order with 2 'In-stock Order' Items, One In-stock Order SKU + One In-stock Order SKU with GiftMessage -Guest user
//TA-182 Verify Order with 2'PreOrder Items,One Preorder SKU + One PreOrder SKU with GiftMessage-Guest User
//TA-183  Verify Order with 2'PreOrder Items,One Backorder SKU + One Backorder SKU with GiftMessage-Guest User
package orders.guest;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class TwoOrderForGuestUser extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
	Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "FailedOrder");
	
	
	
	  @Test(priority = 1,description = "Verify Order with 2 'In-stock Order' Items, One In-stock Order SKU + One In-stock Order SKU with GiftMessage -Guest user")
	  public void verifyTwoOrderWithGiftMsgForGuestUser() {
	  UIFunctions.addProductToCart("TumiTestData","OrderWithTwoProducts");
	 click(pdp.getAddToCart(), "Add To Cart");
	  click(minicart.getContinueShopping(), "Continue Shopping");
	  UIFunctions.addProductToCart("TumiTestData","GuestOrders");
	  click(pdp.getAddToCart(), "Add To Cart");
	 click(minicart.getProceedCheckOut(), "Proceed to Checkout");
	  click(gift.getMakeThisGift(), "Make this Gift");
	  UIFunctions.addGiftMessage("TumiTestData", "GuestOrders");
	  click(gift.getContinueGiftService(), "continue");
	  click(mainCart.getProceedCart(), "Proceed to Checkout");
	  input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
	  click(singlePage.getContinueAsGuest(), "Contiue as Guest");
	  UIFunctions.addGuestDetails();
	  click(shipping.getContinueShippingMethod(),"Contiue Shipping");
	  click(shipMethod.getProceedToPayment(), "Proceed to Payment");
	  UIFunctions.addCardDetails("TumiTestData",  "GuestOrders"); 
	  UIFunctions.completeOrder();
	  }
	 

		@Test(priority = 2,description = "Verify Order with 2 'Pre Order' Items, One Pre Order SKU + One PreOrder SKU with GiftMessage -Guest user")
		public void verifyTwoPreorderWithGiftMsgForGuestUser() {
			
		UIFunctions.addProductToCart("TumiTestData","PreOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		UIFunctions.addProductToCart("TumiTestData","PreOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "PreOrderProduct");
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
		
		@Test(priority = 3,description = "Verify Order with 2 'BackOrder' Items, One BackOrder SKU + One BackOrder SKU with GiftMessage -Guest user")
		public void verifyTwoBackOrdeWithGiftMsgrForGuestUser() {
              UIFunctions.addProductToCart("TumiTestData","BackOrderProduct");
              click(pdp.getAddToCart(), "Add To Cart");
              click(minicart.getContinueShopping(), "Continue Shopping");
              UIFunctions.addProductToCart("TumiTestData","BackOrderProduct");
              click(pdp.getAddToCart(), "Add To Cart");
              click(minicart.getProceedCheckOut(), "Proceed to Checkout");
              click(gift.getMakeThisGift(), "Make this Gift");
              UIFunctions.addGiftMessage("TumiTestData", "PreOrderProduct");
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
		//TA-114
		@Test(priority = 4,description = "Verify Order with 2 'Ready to Ship' Items, One regular in stock SKU + One in stock SKU with Gift boxing-Guest user")
		public void verifyTwoInstockWithGiftMsg() {
              UIFunctions.addProductToCart("TumiTestData","GuestOrders");
              click(pdp.getAddToCart(), "Add To Cart");
              click(minicart.getContinueShopping(), "Continue Shopping");
              UIFunctions.addProductToCart("TumiTestData","OrderWithTwoProducts");
              click(pdp.getAddToCart(), "Add To Cart");
              click(minicart.getProceedCheckOut(), "Proceed to Checkout");
              click(gift.getMakeThisGift(), "Make this Gift");
      		UIFunctions.addGiftBox();
      		click(gift.getContinueGiftService(), "Continue");
             click(mainCart.getProceedCart(), "Proceed to Checkout");
             input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
            click(singlePage.getContinueAsGuest(), "Contiue as Guest");
          UIFunctions.addGuestDetails();
          click(shipping.getContinueShippingMethod(), "Contiue Shipping");
           click(shipMethod.getProceedToPayment(), "Proceed to Payment");
          UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
                 UIFunctions.completeOrder();
}
		
		//TA31
		@Test(priority=5,description = "Verify Order with 2 'Pre Order' Items, One Pre Order SKU + One Pre Order SKU with Gift boxing-Guest user")
		public void verifyWithTwoPreOrderWithGiftBox() {

		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
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