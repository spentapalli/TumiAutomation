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
public class OrderWithGuestUser extends GenericMethods {

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
	@Test(priority=0,description = "Verify Order with 2 'Ready to Ship' Items, One regular in stock SKU + One  Backorder SKU for Guest User")
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
	@Test(priority=0,description = "Verify Order with 2 'Ready to Ship' Items, One PreOrder  SKU + One  Backorder SKU for Guest User")
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
		@Test(priority=0,description = "Verify Order with 2 'Ready to Ship' Items, One In-stock in stock SKU + One DonationPurchase SKU for Guest User")
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
				@Test(priority=0,description = "Verify Order with 2 'Ready to Ship' Items, One In-stock in stock SKU + One GlobalLocator SKU for Guest User")
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
	@Test(priority=0,description = "Verify Order with 2 'Ready to Ship' Items, One regular in stock SKU + One in stock SKU with Personalization-Guest user")
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
		@Test(priority=10,description = "Verify Order with 'Pre Order' SKU + Donation purchase-Guest user")
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
		@Test(priority=8,description = "Verify Order with 'Pre Order' SKU + Global locator-Guest user")
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
	@Test(description = "Verify Order with 2 'Pre Order' Items, One Pre Order SKU + One Pre Order SKU with Personalization-Guest user")
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

	//TA23
	@Test(priority=3,description = "Verify Order with 2 'Back Order' Items, One Back Order SKU + One Back Order SKU with Gift boxing-Guest user")
	public void verifyGuestOrderWithTwoBackOrder() {

	UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
	click(pdp.getAddToCart(), "Add To Cart");
	click(minicart.getContinueShopping(), "Continue Shopping");
	UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
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
	
	


