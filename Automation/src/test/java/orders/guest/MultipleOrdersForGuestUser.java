//Sprint-2
package orders.guest;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Suresh
 *
 */
public class MultipleOrdersForGuestUser extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
	
	//TA-14
	@Test(priority=0,description = "Verify Order with 2 'Ready to Ship' Items, One regular in stock SKU + One  Pre order SKU for Guest User")
	public void verifyGuestOrderWithTwoReadyToShipProductsandPreOrder() {

		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		 UIFunctions.addProductToCart("TumiTestData","PreOrderProduct");
		 click(pdp.getAddToCart(), "Add To Cart");
	    click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
		UIFunctions.completeOrder();
		
	}
	//TA-13
	@Test(priority=1,description = "Verify Order with 2 'Ready to Ship' Items, One regular in stock SKU + One  Backorder SKU for Guest User")
	public void verifyGuestOrderWithTwoReadyToShipProductsandBackOrder() {

		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		 UIFunctions.addProductToCart("TumiTestData","BackOrderProduct");
		 click(pdp.getAddToCart(), "Add To Cart");
	    click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
		UIFunctions.completeOrder();
	}
	//TA-4
	@Test(priority=2,description = "Verify Order with 2 'Ready to Ship' Items, One PreOrder  SKU + One  Backorder SKU for Guest User")
	public void verifyGuestOrderWithTwoPreOrderProductsandBackOrder() {

		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		 UIFunctions.addProductToCart("TumiTestData","BackOrderProduct");
		 click(pdp.getAddToCart(), "Add To Cart");
	    click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
		UIFunctions.completeOrder();
	}
	//TA-2
		@Test(priority=3,description = "Verify Order with 2 'Ready to Ship' Items, One In-stock in stock SKU + One DonationPurchase SKU for Guest User")
		public void verifyGuestOrderWithTwoReadyToShipandDonationProductOrder() {

			UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getContinueShopping(), "Continue Shopping");
			 UIFunctions.addProductToCart("TumiTestData","DonationPurchase");
			 click(pdp.getAddToCart(), "Add To Cart");
		    click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
			UIFunctions.completeOrder();
		}
		//TA-6
				@Test(priority=4,description = "Verify Order with 2 'Ready to Ship' Items, One In-stock in stock SKU + One GlobalLocator SKU for Guest User")
				public void verifyGuestOrderWithTwoReadyToShipandGlobalLocatorOrder() {

					UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
					click(pdp.getAddToCart(), "Add To Cart");
					click(minicart.getContinueShopping(), "Continue Shopping");
					 UIFunctions.addProductToCart("TumiTestData","GlobalLocatorProduct");
					 click(pdp.getAddToCart(), "Add To Cart");
				    click(minicart.getProceedCheckOut(), "Proceed to Checkout");
					click(mainCart.getProceedCart(), "Proceed to Checkout");
					input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
					click(singlePage.getContinueAsGuest(), "Contiue as Guest");
					UIFunctions.addGuestDetails();
					click(shipping.getContinueShippingMethod(), "Contiue Shipping");
					click(shipMethod.getProceedToPayment(), "Proceed to Payment");
					UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
					UIFunctions.completeOrder();
				}
	//TA113
	@Test(priority=5,description = "Verify Order with 2 'Ready to Ship' Items, One regular in stock SKU + One in stock SKU with Personalization-Guest user")
	public void verifyGuestOrderWithTwoReadyToShipProducts() {

		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		UIFunctions.addMonogram("TumiTestData", "BackOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		 UIFunctions.addProductToCart("TumiTestData","GuestOrders");
		 click(pdp.getAddToCart(), "Add To Cart");
	    click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
		UIFunctions.completeOrder();
	}
	//TA28
		@Test(priority=6,description = "Verify Order with 'Pre Order' SKU + Donation purchase-Guest user")
		public void verifyGuestOrderWithPreOrderAndDonation() {

			UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getContinueShopping(), "Continue Shopping");
			 UIFunctions.addProductToCart("TumiTestData","DonationPurchase");
			 click(pdp.getAddToCart(), "Add To Cart");
		    click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
			UIFunctions.completeOrder();
		}
		//TA25
		@Test(priority=7,description = "Verify Order with 'Pre Order' SKU + Global locator-Guest user")
		public void verifyGuestOrderWithPreOrderAndGloabalLocator() {

		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		 UIFunctions.addProductToCart("TumiTestData","GlobalLocatorProduct");
		 click(pdp.getAddToCart(), "Add To Cart");
	    click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
		UIFunctions.completeOrder();
		
		
		}
	
	//TA30
	@Test(priority=8,description = "Verify Order with 2 'Pre Order' Items, One Pre Order SKU + One Pre Order SKU with Personalization-Guest user")
	public void verifyGuestOrderWithTwoPersonalizePreOrder() {

		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		UIFunctions.addMonogram("TumiTestData", "BackOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		 UIFunctions.addProductToCart("TumiTestData","PreOrderProduct");
		 click(pdp.getAddToCart(), "Add To Cart");
	    click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
		UIFunctions.completeOrder();
	}

}
	
	

	

	
	
	
	
	


