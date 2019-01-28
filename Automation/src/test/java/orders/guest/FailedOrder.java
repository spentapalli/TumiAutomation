package orders.guest;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class FailedOrder extends GenericMethods {
	public Map<String, String> testData = ReadTestData.retrieveData("PlaceOrder", "FailedOrder");
/*
 * Verify whether the user is able to place an order with invalid credit card details
 */
	@Test
	public void testFailedOrder() throws InterruptedException {
		
		//TumiLibs.closeSignUpForUS();
		input(home.getSearchProduct(), testData.get("SKUID"), "Search Product");
		keyEnter(home.getSearchProduct());
		try {
			if (getText(home.getNoProducts()).contains("SORRY")) {
				Assert.fail("Sorry, no search results");
			}
		} catch (Exception e) {
			
		}
		/*final String pdpURL = GlobalConstants.url+"/p/"+testData.get("SKUID");
		driver.get(pdpURL);
*/
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedToCheckout(), "Cart");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email");
		click(singlePage.getContinueAsGuest(), "Continue As Guest");
		delay(2000);
		// Shipping page
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address line1");
		delay(2000);
		for (WebElement ele : shipping.getListAddressLine1()) {
			if (getText(ele).equals("13 E Lefevre Rd, Sterling IL 61081")) {
				click(ele, "AddressList");
				break;
			}
		}
		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
		click(shipping.getContinueShippingMethod(), "Continue shipping Method");

		// shipping method pages
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		
		/*
		 * Add Card Details
		 * @param: SheetName and TestCaseName
		 */
		UIFunctions.addCardDetails("PlaceOrder", "FailedOrder");
		click(review.getPlaceOrder(), "place order");
	}

}
