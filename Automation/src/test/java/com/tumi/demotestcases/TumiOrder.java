package com.tumi.demotestcases;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;

public class TumiOrder extends GenericMethods {

	public Map<String, String> testData = ReadTestData.retrieveData("Login", "PlainOrder");

	@Test
	public void PlainOrder() throws InterruptedException {

		click(pdp.getAddToCart(), "Add To Cart");
		// click on proceed to checkout in Mini cart
		click(cart.getProceedCheckOut(), "Proceed to Checkout");
		Thread.sleep(5000);
		// click on proceed to checkout in cart page
		click(mainCart.getProceedToCheckout(), "Cart");
		// singlePageCheckout
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email");
		click(singlePage.getContinueAsGuest(), "Continue As Guest");
		Thread.sleep(3000);
		// Shipping page
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address line1");
		input(shipping.getAddressLine2(), testData.get("AddressLine2"), "Address Line2");
		input(shipping.getTown(), testData.get("TownCity"), "Town or city");
		input(shipping.getRegionIso(), testData.get("Region"), "RegionISO");
		input(shipping.getPostcode(), testData.get("PostCode"), "Post code");
		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
		click(shipping.getContinueShippingMethod(), "Continue shipping Method");

		// shipping method page
		click(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");

		// billing page
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");

		// invalid card number
		input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
		click(guestBillPage.getExpiryMonth(), "ExipryMonth");
		click(driver.findElement(By.linkText("04")), "Expiry date");

		// driver.findElement(By.linkText("04")).click();

		click(guestBillPage.getExpiryYear(), "ExipryYear");
		click(driver.findElement(By.linkText("2020")), "Expiry year");
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
		click(guestBillPage.getReviewOrder(), "Review Order");

		// orderReviewPage
		click(review.getPlaceOrder(), "place order");

		// orderConfirmationPage

	}

}
