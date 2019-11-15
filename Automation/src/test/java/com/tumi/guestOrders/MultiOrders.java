package com.tumi.guestOrders;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class MultiOrders extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");

	@Test(priority = 0,description = "TA- 20 Verify Order with 2 'Back Order' Items, One Back Order SKU + One Back Order SKU with Personalization-Guest user")
	public void verifyGuestOrderWithTwoBackOrderProducts() {

		UIFunctions.addProduct("TumiTestData", "Products","BackOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		UIFunctions.addMonogram("TumiTestData", "MonoGramDetails");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		}
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
	}

	@Test(priority = 1, description = "TA - 21 Verify Order with 'Back Order' SKU + Donation purchase-Guest user")
	public void verifyGuestOrderWithBackOrderAndDonation() {

		UIFunctions.addProductToCart("TumiTestData", "DonationPurchase");
		UIFunctions.removeMonogram();
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		UIFunctions.addProduct("TumiTestData", "Products","BackOrderProduct");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		}
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();

	}

	@Test(priority = 2, description = " TA - 23 Verify Order with 2 'Back Order' Items, One Back Order SKU + One Back Order SKU with Gift boxing-Guest user")
	public void verifyGuestOrderWithTwoBackOrder() {

		UIFunctions.addProduct("TumiTestData", "Products","BackOrderProduct");
		UIFunctions.removeMonogram();
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		delay(5000);
		domClick(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		}
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
	}

	@Test(priority=3, description = " TA - 24 Verify Order with 'Back Order' SKU + Global locator-Guest user")
	public void verifyGuestOrderWithBackOrderAndGloabalLocator() {

		UIFunctions.addProductToCart("TumiTestData", "GlobalLocatorProduct");
		UIFunctions.removeMonogram();
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		UIFunctions.addProduct("TumiTestData", "Products","BackOrderProduct");
		UIFunctions.removeMonogram();
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		}
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();

	}

}
