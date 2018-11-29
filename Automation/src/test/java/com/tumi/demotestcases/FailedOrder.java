package com.tumi.demotestcases;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;

public class FailedOrder extends GenericMethods{
	public Map<String, String> testData = ReadTestData.retrieveData("Login", "FailedOrder");
	
	@Test
	public void testFailedOrder() throws InterruptedException{
		
		
		click(pdp.getAddToCart(), "Add To Cart");
		
		//click on proceed to checkout in Mini cart
		click(cart.getProceedCheckOut(), "Proceed to Checkout");
		//Thread.sleep(5000);
		
		//click on proceed to checkout in cart page
		click(mainCart.getProceedToCheckout(), "Cart");
	
		//singlePageCheckout
		input(singlePage.getEmailAddress(),testData.get("EmailID"),"Email");
		click(singlePage.getContinueAsGuest(), "Continue As Guest");
		//Thread.sleep(3000);
		
		//Shipping page
		
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(),testData.get("AddressLine1"), "Address line1");
		//-------------- added
		delay(2000);
		for (WebElement ele : shipping.getListAddressLine1()) {
			
			System.out.println(getText(ele));
			if (getText(ele).equals("13 E Lefevre Rd, Sterling IL 61081")) {
				click(ele, "AddressList");
				break;
			}
		}
		//input(shipping.getAddressLine2(),testData.get("AddressLine2"), "Address Line2");
		input(shipping.getTown(), testData.get("TownCity"), "Town or city");
		selectByVisibleText(shipping.getRegionIso(), testData.get("Region"), "Region");
		
		input(shipping.getPostcode(), testData.get("PostCode"), "Post code");
		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
		
		click(shipping.getContinueShippingMethod(),"Continue shipping Method");
				
		//shipping method page
		click(shipMethod.getStandardShippingMethod(),"Standard Shipping Method");
		//-------------------Missing Step
		click(driver.findElement(By.xpath("//button[contains(text(),'Proceed to Payment')]")), "Proceed");
		//billing page
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");
		
		
		//invalid card number
		input(guestBillPage.getCardNumber(),testData.get("CardNumber"), "Card Number");
		click(guestBillPage.getExpiryMonth(),"ExipryMonth");
		click(driver.findElement(By.linkText("04")),"Expiry date");
	    
		//driver.findElement(By.linkText("04")).click();
	    
	    click(guestBillPage.getExpiryYear(), "ExipryYear");
	    click(driver.findElement(By.linkText("2020")),"Expiry year");
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
		click(guestBillPage.getReviewOrder(), "Review Order");
		
		
		
		
		
	}

}
