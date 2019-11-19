//TA-9 Verify the Order with merchandise Globallocator

package com.tumi.guestOrders;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class GlobalLocatororder extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");

	@Test
	public void orderWithAsGuest() throws InterruptedException {

		UIFunctions.addProductToCart("TumiTestData", "GlobalLocatorProduct");
		UIFunctions.closeSignUp();
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		if (applicationUrl.equals("prod") && (selectedCountry.contains("US")
				|| selectedCountry.contains("United States") || selectedCountry.contains("Canada"))) {

			driver.findElement(By.xpath("//button[contains(text(),'Proceed to Checkout')]")).click();

		} else {
			webclick(mainCart.getProceedCart(), "Proceed to Checkout");
		}

		if (!(selectedCountry.contains("US") || selectedCountry.contains("Canada"))) {
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			UIFunctions.waitForContinueToEnable();
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		}
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();

	}

}
