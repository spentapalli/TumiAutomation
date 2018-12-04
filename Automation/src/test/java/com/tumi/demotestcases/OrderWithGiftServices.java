package com.tumi.demotestcases;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.TumiLibs;

public class OrderWithGiftServices extends GenericMethods{
	
	public Map<String, String>  testData = ReadTestData.retrieveData("Login", "OrderWithGiftServices");

	@Test
	public void testOrderWithGiftServices() throws InterruptedException {
		
		//Close signUp window
		TumiLibs.closeSignUpForUS();
		final String pdpURL = GlobalConstants.url+"p/"+testData.get("SKUID");
		driver.get(pdpURL);
								
		click(pdp.getAddToCart(), "Add To Cart");
		
	
		click(cart.getProceedCheckOut(),"Proceed to Checkout");
		
		click(gift.getMakeThisGift(),"Make this Gift");
		click(gift.getCheckMessage(), " check Message");
		input(gift.getRecipientName(), testData.get("RecipientName"), "Recipients name");
		input(gift.getSenderName(), testData.get("SenderName"), "Sender name");
		input(gift.getAddMessage(),testData.get("Message"), "Message");
		click(gift.getCheckPremiumGift(), "Premium GiftBox");
		click(gift.getContinueGiftService(), "continue"); 
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(),testData.get("EmailID"), "Email ID");
		click(singlePage.getPromotionsAndNews(), "Check Promotions");
		click(singlePage.getContinueAsGuest(), "Continue as Guest");
		delay(2000);
		input(shipping.getFirstName(),testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"),"Last Name" );
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address Line1");
		delay(2000);
		
		for(WebElement ele : shipping.getListAddressLine1()) {
			if(getText(ele).equals("2 Beaver Creek Rd, Abbottstown PA 17301")) {
				click(ele, "AddressList");
				break;
			}
		}
		
		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
		click(shipping.getContinueShippingMethod(), "Continue");
		click(shipMethod.getpriorityShippingMethod(), "Over Night");
		click(shipMethod.getProceedToPayment(), "Continue Payment");
		
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");
		input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
		selectByVisibleText(guestBillPage.getExpiryMonth(), "03","Expiry Month" );
		selectByVisibleText(guestBillPage.getExpiryYear(), "2019", "Expiry Year");
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv number");
		input(guestBillPage.getemail(), testData.get("EmailID"), "Email ID");
		input(guestBillPage.getPhoneNumber(), testData.get("Phone"), "Phone number");
		
		click(guestBillPage.getReviewOrder(), "Review your Order");
		delay(2000);
		
		click(review.getPlaceOrder(), "Place Order");
		delay(10000);
		captureOrderConfScreen("OrderConfirmation");
	
		
		
		
		
		
	}
}
