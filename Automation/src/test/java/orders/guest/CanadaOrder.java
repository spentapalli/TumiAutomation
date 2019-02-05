package orders.guest;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class CanadaOrder extends GenericMethods {

	public Map<String, String> testData = ReadTestData.retrieveData("PlaceOrder", "TumiOrderCA");

	@Test
	@Parameters({"countryName"})
	public void testTumiOrder(String name){

		//TumiLibs.closeSignUpForUsProd();
		//click(home.getSelectCountry(), "US country");
		//click(home.getSelectCountry(), "Korea");
		//delay(4000);
		//UIFunctions.selectCountry();
		/*
		 * if (google.getNoThanks().isDisplayed()) { click(google.getNoThanks(),
		 * "offers popup"); }else { }
		 */

		// TumiLibs.closeSignUpForUS();
		final String pdpURL = GlobalConstants.url + "/p/" + testData.get("SKUID");
		driver.get(pdpURL);
		click(pdp.getAddToCart(), "Add To Cart");
		delay(2000);
		// click on proceed to checkout in Mini cart
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");

		// click on proceed to checkout in cart page
		click(mainCart.getProceedCart(), "Cart");

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
			if (getText(ele).equals(getProperty("address.gladwin"))) {
				click(ele, "AddressList");
				break;
			}
		}
		/*
		 * input(shipping.getAddressLine2(), testData.get("AddressLine2"),
		 * "Address Line2"); input(shipping.getTown(), testData.get("TownCity"),
		 * "Town or city"); input(shipping.getRegionIso(), testData.get("Region"),
		 * "RegionISO");
		 */
		input(shipping.getPostcode(), testData.get("PostCode"), "Post code");

		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
		click(shipping.getContinueShippingMethod(), "Continue shipping Method");
		delay(2000);

		// shipping method page
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		/*
		 * Add Card Details
		 * @param: SheetName and TestCaseName
		 */
		UIFunctions.addCardDetails("PlaceOrder", "TumiOrderCA");
		click(review.getPlaceOrder(), "place order");
	}

}
