package orders.guest;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;



/**
 * @author Shwetha Capo
 *
 */
public class GuestOrderFail extends GenericMethods {
	
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
	
	@Test(priority = 8, description = "TA- 8 Verify order fail with wrong card details for Guest user")
	public void orderWithWrongCardDetails() throws InterruptedException {
		UIFunctions.addProductToCart("TumiTestData", "GuestOrders");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "FailedOrder");
		try {
			if (review.getCheckoutMessages().isDisplayed()) {
				delay(2000);
				if (!getText(review.getCheckoutMessages()).contains(getProperty("checkout.Messages"))) {
					Assert.fail("Order is completed with invalid card details");
				}else {
					logger.log(Status.INFO, "Order failed due to wrong card deatils");
					}
			}
		} catch (Exception e) {
			Assert.fail("Order is completed with invalid card details");
		}
	}


}
