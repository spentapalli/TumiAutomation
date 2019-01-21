package placeOrder;

import java.util.Map;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 *
 */
public class OrderWithMonogram extends GenericMethods{
	
	public Map<String, String>  testData = ReadTestData.retrieveData("PlaceOrder", "OrderWithMonogram");

	@Test
	public void testOrderWithMonogram() throws InterruptedException {
		
		TumiLibs.closeSignUpForUS();
		input(home.getSearchProduct(), testData.get("SKUID"), "FailedOrder");
		keyEnter(home.getSearchProduct());
		try {
			if (getText(home.getNoProducts()).contains("SORRY")) {
				Assert.fail("Sorry, no search results");
			}
		} catch (Exception e) {

		}
		/*final String pdpURL = GlobalConstants.url+"/p/"+testData.get("SKUID");
		driver.get(pdpURL);*/
		
		
		//Adding Personalization
		Actions action = new Actions(driver);
        action.moveToElement(mono.getComplimentaryMono()).perform();
		click(mono.getAddPersonalization(), "Add Personalization");
		input(mono.getFirstMonoInput(), testData.get("FirstMonoInput"), "First Mono Input");
		input(mono.getSecondMonoInput(), testData.get("SecondMonoInput"), "Second Mono Input");
		input(mono.getThirdMonoInput(), testData.get("ThirdMonoInput"), "Third Mono Input");
		
		click(mono.getNext(),"Next");
		click(mono.getTextStyleBold(),"Serif as Bold");
		click(mono.getCafeColor(), "Color");
		//delay(2000);
		//click(mono.getSecondNext(), "Second Next");
		
		click(mono.getApply(),"Apply");
		delay(3000);
				
		click(pdp.getAddToCart(), "Add To Cart");
		
	
		click(minicart.getProceedCheckOut(),"Proceed to Checkout");
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
