package com.tumi.demotestcases;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.TumiLibs;


public class TumiOrder extends GenericMethods {
	public Map<String, String> testData = ReadTestData.retrieveData("Login", "TumiOrder");
	
	@Test
	public void TumiOrder() throws InterruptedException {
		
		TumiLibs.closeSignUpForUS();
		final String pdpURL = GlobalConstants.url+"p/"+testData.get("SKUID");
		driver.get(pdpURL);
		click(pdp.getAddToCart(), "Add To Cart");
		
		// click on proceed to checkout in Mini cart
		click(cart.getProceedCheckOut(), "Proceed to Checkout");
		
		
		// click on proceed to checkout in cart page
		click(mainCart.getProceedToCheckout(), "Cart");
		
		// singlePageCheckout
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email");
		click(singlePage.getContinueAsGuest(), "Continue As Guest");
		delay(2000);

		// Shipping page
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address line1");
		delay(2000);
		
		for (WebElement ele : shipping.getListAddressLine1()) {
			if (getText(ele).equals("1001 6Th Ave Ph 1, New York NY 10018")) {
				click(ele, "AddressList");
				break;
			}
		}
		
		
		/*input(shipping.getAddressLine2(), testData.get("AddressLine2"), "Address Line2");
		input(shipping.getTown(), testData.get("TownCity"), "Town or city");
		input(shipping.getRegionIso(), testData.get("Region"), "RegionISO");
		input(shipping.getPostcode(), testData.get("PostCode"), "Post code");*/
		
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
