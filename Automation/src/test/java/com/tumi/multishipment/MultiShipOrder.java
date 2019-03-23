package com.tumi.multishipment;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class MultiShipOrder extends GenericMethods {

	public Map<String, String> testData = ReadTestData.retrieveData("PlaceOrder", "MultiShipOrder");
 //success
	@Test
	public void testMultiShipOrder() throws InterruptedException {

		UIFunctions.closeSignUp();
		
		for (int i = 1; i < 3; i++) {

			UIFunctions.searchProducts(i, testData.get("PrdouctName"));
			delay(3000);
			click(pdp.getAddToCart(), "Add to Cart");
			click(minicart.getContinueShopping(), "Continue shopping");

		}
		click(minicart.getMiniCartSymbol(), "Cart Image");
		click(minicart.getProceedCheckOut(), "proceed to checkout");
		click(mainCart.getProceedCart(), "Cart");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email");
		click(singlePage.getContinueAsGuest(), "Continue As Guest");
		delay(2000);

		click(multiShip.getMultiShipClick(), "MultiShipment");
		delay(2000);
		click(multiShip.getAddShippment0(), "add shipment 1"); //here getting error
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
		webclick(shipMethod.getPriorityShippingMethod(), "Priority Shipping Method");
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
			click(guestBillPage.getReviewOrder(), "Review your order");
			click(review.getPlaceOrder(), "Place Order");

		
	}

}
