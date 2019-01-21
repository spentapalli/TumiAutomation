package placeOrder;

import java.util.Map;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;


public class OrderWithVochercode extends GenericMethods{ 

		
		Map<String, String>  testData = ReadTestData.retrieveData("PlaceOrder", "OrderWithVochercode");
		
		@Test
		private void testOrderWith() {
			// Close signUp window
			 TumiLibs.closeSignUpForUS();
			input(home.getSearchProduct(), testData.get("SKUID"), "FailedOrder");
			keyEnter(home.getSearchProduct());
			try {
				if (getText(home.getNoProducts()).contains("SORRY")) {
					Assert.fail("Sorry, no search results");
				}
			} catch (Exception e) {

			}
		
				
			click(pdp.getAddToCart(), "Add To Cart");
		
			click(minicart.getProceedCheckOut(),"Proceed to Checkout");
			click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
			input(mainCart.getPromocode(),testData.get("VocherId")," Vocher Id");
			click(mainCart.getApply(),"check promocode");
			input(singlePage.getEmailAddress(),testData.get("EmailID"), "Email ID");
			click(singlePage.getPromotionsAndNews(), "Check Promotions");

			click(singlePage.getContinueAsGuest(), "Continue as Guest");
		
			input(shipping.getFirstName(),testData.get("FirstName"), "First Name");
			input(shipping.getLastName(), testData.get("LastName"),"Last Name" );
			input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address Line1");
			
			for(WebElement ele : shipping.getListAddressLine1()) {
				if(getText(ele).equals("1 Beaver Creek Rd, Abbottstown PA 17301")) {
					click(ele, "AddressList");
					break;
				}
			}
			
			input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
			click(shipping.getContinueShippingMethod(), "Continue");
			click(shipMethod.getpriorityShippingMethod(), "Over Night");
			click(shipMethod.getProceedToPayment(), "Continue Payment");
			
			/*
			 * Add Card Details
			 * @param: SheetName and TestCaseName
			 */
			TumiLibs.addCardDetails("PlaceOrder", "OrderWithMonogram");
			click(review.getPlaceOrder(), "Place Order");
			/*delay(4000);
			captureOrderConfScreen("OrderConfirmation");*/
		
		}
	
	}


