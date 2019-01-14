package com.tumi.demotestcases;

import java.util.Map;


import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;

/**
 * @author Shwetha Capo
 *
 */
public class KoreaOrder extends GenericMethods{
	 
		public Map<String, String> testData = ReadTestData.retrieveData("Login", "TumiOrderKR");
		
		
		@Test
		public void testTumiOrder() throws InterruptedException {
			

			final String pdpURL = GlobalConstants.url+"/p/"+testData.get("SKUID");
			driver.get(pdpURL);
			click(pdp.getAddToCart(), "Add To Cart");
			delay(2000);
			// click on proceed to checkout in Mini cart
			click(cart.getKrProceedCheckOut(), "Proceed to Checkout");
			delay(2000);
			
			// click on proceed to checkout in cart page
			click(mainCart.getKrProceedToCheckout(), "Cart");
			
			// singlePageCheckout
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email");
			click(singlePage.getContinueAsGuest(), "Continue As Guest");
			delay(2000);

			// Shipping page
			input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
			input(shipping.getLastName(), testData.get("LastName"), "Last Name");
			input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address line1");
			delay(2000);
			
			//input(shipping.getAddressLine2(), testData.get("AddressLine2"), "Address Line2");
			input(shipping.getTown(), testData.get("TownCity"), "Town or city");
			//input(shipping.getRegionIso(), testData.get("Region"), "RegionISO");
			input(shipping.getPostcode(), testData.get("PostCode"), "Post code");
			
			input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
			click(shipping.getContinueShippingMethod(), "Continue shipping Method");

			// shipping method page
			webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");

			// billing page
			input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");

			//valid card details
			input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
			selectByVisibleText(guestBillPage.getExpiryMonth(), "05", "Expiry Month");
			selectByVisibleText(guestBillPage.getExpiryYear(), "2020", "Expiry Year");	
			input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
			click(guestBillPage.getReviewOrder(), "Review your order");
			delay(2000);
	  
			
			click(review.getPlaceOrder(), "place order");
			/*delay(4000);
			captureOrderConfScreen("OrderConfirmation");*/
			
			
			

		}


}
