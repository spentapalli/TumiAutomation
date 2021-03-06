//Sprint-3
// TA-65 Verify Quick shop in PGP.
package com.tumi.home;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class Quickshop extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
	public static HttpURLConnection huc = null;
	public static int respCode;
	@Test
	public void VerifyQuickShop() {
		mouseHover(home.getOptions());
		click(home.getSubCateogry(), "Select option");
		click(pgp.getQuickShop(), "QuickShop");
		try {
			if (pgp.getQuickShopAddtoCart().isDisplayed()) {
				click(pgp.getQuickShopAddtoCart(), "QuickShop Add to Cart");
				click(minicart.getProceedCheckOut(), "Proceed to Checkout");
				click(mainCart.getProceedCart(), "Proceed to Checkout");
				input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
				UIFunctions.waitForContinueToEnable();
				click(singlePage.getContinueAsGuest(), "Contiue as Guest");
				UIFunctions.addGuestDetails();
				click(shipping.getContinueShippingMethod(), "Contiue Shipping");
				click(shipMethod.getProceedToPayment(), "Proceed to Payment");
				UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
				UIFunctions.completeOrder();
			} else if (pdp.getOutofStock().isDisplayed()) {
				Assert.fail("Product is Out of Stock, Unable to verify Add to Cart");
			}
		} catch (Exception e) {
			Assert.fail("Quick shop button is not functioning");
		}
	}

}