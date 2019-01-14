package multishipment;

import java.util.List;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.testcases.ProductSearch;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 *
 */
public class MultiShipOrder extends GenericMethods {

	public Map<String, String> testData = ReadTestData.retrieveData("PlaceOrder", "MultiShipOrder");

	@Test
	public void testMultiShipOrder() throws InterruptedException {

		TumiLibs.closeSignUpForUS();
		/*click(home.getSelectCountryUS(), "Select US country");
		click(home.getSelectUS(), "click US");
		delay(3000);
		click(home.getOffersPopupUsProd(),"offers popup");
*/
		ProductSearch productSearch = new ProductSearch();
		/*
		 * proSearch((Integer) null);;
		 * 
		 * click(pdp.getAddToCart(), "Add to Cart");
		 * click(cart.getContinueShopping(),"Continue shopping")
		 */;

		for (int i = 1; i < 3; i++) {

			// String i="1";
			productSearch.proSearch(i);
			delay(3000);

			click(pdp.getAddToCart(), "Add to Cart");
			click(cart.getContinueShopping(), "Continue shopping");

		}
		click(cart.getMiniCartSymbol(), "Cart Image");
		click(cart.getProceedCheckOut(), "proceed to checkout");
		click(mainCart.getProceedToCheckout(), "Cart");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email");
		click(singlePage.getContinueAsGuest(), "Continue As Guest");
		delay(2000);

		click(multiShip.getMultiShipClick(), "MultiShipment");
		click(multiShip.getAddShippment0(), "add shipment 1");
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
		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
		click(multiShip.getNext(), "Continue next shipping");
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(multiShip.getNextShipment(), "Continue next shipment");
		delay(3000);

		click(multiShip.getAddShippment0(), "add shipment 2");
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLineForShip2"), "Address line1");
		delay(2000);

		for (WebElement ele : shipping.getListAddressLine1()) {
			if (getText(ele).equals("1 Beaver Creek Rd, Abbottstown PA 17301")) {
				click(ele, "AddressList");
				break;
			}
		}
		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
		click(multiShip.getNext(), "Continue next shipping");
		webclick(shipMethod.getpriorityShippingMethod(), "Priority Shipping Method");
		click(shipMethod.getProceedToPayment(),"Proceed to Payment");

		// billing page
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");

		// valid card details
		input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
		selectByVisibleText(guestBillPage.getExpiryMonth(), "05", "Expiry Month");
		selectByVisibleText(guestBillPage.getExpiryYear(), "2020", "Expiry Year");
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address line1");
		input(shipping.getTown(), testData.get("TownCity"), "Town");
		Select dropdown = new Select(driver.findElement(By.name("regionIso")));
		dropdown.selectByVisibleText("New Jersey");
		click(shipping.getRegionIso(),"Region");
		/*for (WebElement ele1 : shipping.getListRegionIso()) {
			if (getText(ele1).equals("New Jersey")) {
				click(ele1, "state list");
				break;
			}
		}*/
			input(shipping.getPostcode(), testData.get("PostCode"), "postal code");
			delay(2000);

			click(guestBillPage.getReviewOrder(), "Review your order");
			delay(2000);
			click(review.getPlaceOrder(), "Place Order");

		
	}

}
