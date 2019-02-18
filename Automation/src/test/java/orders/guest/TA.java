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
public class TA extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
	
	//TA113
	@Test(priority=0,description = "Verify Order with 2 'Ready to Ship' Items, One regular in stock SKU + One in stock SKU with Personalization-Guest user")
	public void verifyGuestOrderWithTwoReadyToShipProducts() {

		UIFunctions.addProductToCart("TumiTestData", "RegisteredOrders");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		UIFunctions.addMonogram("TumiTestData", "RegisteredOrders");
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
	//TA20
	@Test(priority=1,description = "Verify Order with 2 'Back Order' Items, One Back Order SKU + One Back Order SKU with Personalization-Guest user")
	public void verifyGuestOrderWithTwoBackOrderProducts() {

		UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		UIFunctions.addMonogram("TumiTestData", "BackOrderProduct");
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
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		UIFunctions.addMonogram("TumiTestData", "PreOrderProduct");
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
	
	//TA31
	@Test(priority=2,description = "Verify Order with 2 'Pre Order' Items, One Pre Order SKU + One Pre Order SKU with Gift boxing-Guest user")
	public void verifyGuestOrderWithTwoPreOrder() {

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
	//TA17
	@Test(priority=4,description = "Verify Order with 3 'Back Order' Items, One Back Order SKU + One Back Order SKU with Personalization + One Back Order SKU with Gift boxing-Guest user")
	public void verifyGuestOrderWithThreeBackOrderProducts() {

		UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
		input(mainCart.getEditProductQuantity(), "2", "Edit Product Quantity");
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
	//TA22
	@Test(priority=5,description = "Verify Order with 3 'Pre Order' Items, One Pre Order SKU + One Pre Order SKU with Personalization + One Pre Order SKU with Gift boxing-Guest user")
	public void verifyGuestOrderWithThreePreOrderProducts() {

		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		input(mainCart.getEditProductQuantity(), "2", "Edit Product Quantity");
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
	//TA32
	@Test(priority=6,description = "Verify Order with 3 'Ready to Ship' Items, One regular in stock SKU + One in stock SKU with Personalization + One in stock SKU with Gift boxing-Guest user")
	public void verifyGuestOrderWithThreeReadyToShipProducts() {

		UIFunctions.addProductToCart("TumiTestData", "RegisteredOrders");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		
		UIFunctions.addProductToCart("TumiTestData", "RegisteredOrders");
		input(mainCart.getEditProductQuantity(), "2", "Edit Product Quantity");
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
	//TA24
	@Test(priority=7,description = "Verify Order with 'Back Order' SKU + Global locator-Guest user")
	public void verifyGuestOrderWithBackOrderAndGloabalLocator() {

	UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
	click(pdp.getAddToCart(), "Add To Cart");
	click(minicart.getContinueShopping(), "Continue Shopping");
	
	
	}
	//TA25
	@Test(priority=8,description = "Verify Order with 'Pre Order' SKU + Global locator-Guest user")
	public void verifyGuestOrderWithPreOrderAndGloabalLocator() {

	UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
	click(pdp.getAddToCart(), "Add To Cart");
	click(minicart.getContinueShopping(), "Continue Shopping");
	
	
	}
	//TA21
	@Test(priority=9,description = "Verify Order with 'Back Order' SKU + Donation purchase-Guest user")
	public void verifyGuestOrderWithBackOrderAndDonation() {

	UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
	click(pdp.getAddToCart(), "Add To Cart");
	click(minicart.getContinueShopping(), "Continue Shopping");
	
	
	}
	//TA28
	@Test(priority=10,description = "Verify Order with 'Pre Order' SKU + Donation purchase-Guest user")
	public void verifyGuestOrderWithPreOrderAndDonation() {

	UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
	click(pdp.getAddToCart(), "Add To Cart");
	click(minicart.getContinueShopping(), "Continue Shopping");
	
	
	}
}
