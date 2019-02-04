package orders.guest;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Suresh , Shwetha Capo
 *
 */
public class GuestOrder extends GenericMethods {
	
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
	Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "FailedOrder");
	/*
	 * TA-100 Verify Order with merchandise Ready to ship for Guest User
	 */

	@Test(priority = 0, description = " TA- 100 Verify Order with merchandise Ready to ship for Guest User")
	public void tumiOrderAsGuest() throws InterruptedException {

		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}

	@Test(priority = 1, description = " TA-16 Verify Order with merchandise Back Order + "
			+ "Gift Boxing + Gift Message + Voucher/Promos for Guest User")
	public void backOrderAsGuest() throws Exception {

		UIFunctions.addProductToCart("TumiTestData", "BackOrderProduct");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "BackOrderProduct");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "BackOrderProduct");
		UIFunctions.completeOrder();
	}

	@Test(priority = 2, description = "TA- 112,Verify Order with merchandise Pre Order for Guest User")
	public void preOrderAsGuest() throws InterruptedException {

		UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
		UIFunctions.completeOrder();
	}

	@Test(priority = 3, description = "TA_11 Verify Order with Donation purchase")
	public void donationPurchaseOrderAsGuest() {

		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}

	@Test(priority = 4, description = "Verify whether the user is able to place an order with invalid credit card details")
	public void orderWithWrongCardDetails() throws InterruptedException {

		input(home.getSearchProduct(), testData1.get("SKUID"), "Search Product");
		keyEnter(home.getSearchProduct());
		try {
			if (getText(home.getNoProducts()).contains("SORRY")) {
				Assert.fail("Sorry, no search results");
			}
		} catch (Exception e) {

		}
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData1.get("EmailID"), "Email");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		input(shipping.getFirstName(), testData1.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData1.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData1.get("AddressLine1"), "Address line1");
		explicitWait(shipping.getSelectedAddressLine());
		for (int i = 1; i < shipping.getAddList().size(); i++) {
			WebElement add = driver.findElement(By.xpath("//div[@class='address-picklist']/div[" + i + "]"));
			if (add.getText().contains("Fairport NY 14450")) {
				click(add, "Address Line1");
				break;
			}
		}
		input(shipping.getPhoneNumber(), testData1.get("Phone"), "Phone Number");
		click(shipping.getContinueShippingMethod(), "Continue shipping Method");
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("PlaceOrder", "FailedOrder");
		click(review.getreviewOrder(), "Review Order");
		if (review.getCheckoutMessages().isDisplayed()) {
			verifyAssertContains(getText(review.getCheckoutMessages()), getProperty("checkout.Messages"),
					"Order Proceeded with Invalid Cart details");
		}

	}
	
	@Test(priority=5,description = "TA-284 Verify Order with merchandise Ready to ship with PayPal checkout-Guest user")
	public void orderWithPayPalAsGuest() throws Exception {
		UIFunctions.addProductToCart("TumiTestData","GuestOrders");//
		click(pdp.getAddToCart(),"Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		UIFunctions.payPalCheckout("TumiTestData","PayPalDeatils",mainCart.getEstimatedTotal());
		UIFunctions.completeOrder();
	}
	
	@Test(priority=6,description = "TA-1 Verify Order with 2 'Ready to Ship' Items with different SKU/sPurchase-Guest user")
	public void orderWithTwoDiffProducts() throws InterruptedException {

		UIFunctions.addMultipleProducts("TumiTestData", "GuestOrders");
		click(minicart.getMiniCartSymbol(), "Cart Image");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();
	}

}
