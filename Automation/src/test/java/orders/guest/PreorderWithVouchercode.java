//TA-12 Verify Order with Merchandise Pre order with Gift Boxing +Gift Message +Voucher code with Guest User
	
package orders.guest;
		import java.util.Map;

		import org.openqa.selenium.WebElement;
		import org.testng.annotations.Test;

		import com.tumi.dataProvider.ReadTestData;
		import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;
	

		public class PreorderWithVouchercode extends GenericMethods {
			Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "PreOrderProduct");
			@Test
			public void orderWithAsGuest() {
				
				UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
				click(pdp.getAddToCart(), "Add To Cart");
				click(minicart.getProceedCheckOut(), "Proceed to Checkout");
				//UIFunctions.addPromotionalCodeAtCart("TumiTestData", "PreOrderProduct");
				click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
				input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
				UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "PreOrderProduct");
				//UIFunctions.waitForContinueToEnable();
				click(singlePage.getContinueAsGuest(), "Contiue as Guest");
				UIFunctions.addGuestDetails();
				click(shipping.getContinueShippingMethod(), "Contiue Shipping");
				click(shipMethod.getProceedToPayment(), "Proceed to Payment");
				UIFunctions.addCardDetails("TumiTestData", "PreOrderProduct");
				UIFunctions.completeOrder();
			}

		}


