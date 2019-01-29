//TA-12 Verify Order with Merchandise Pre order with Gift Boxing +Gift Message +Voucher code with Guest User
	
package orders.guest;
		import java.util.Map;

		import org.openqa.selenium.WebElement;
		import org.testng.annotations.Test;

		import com.tumi.dataProvider.ReadTestData;
		import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;
	

		public class PreorderWithVouchercode extends GenericMethods {
			@Test
			public void orderWithAsGuest() {
				UIFunctions.addProductToCart("PlaceOrder", "PreorderWithVouchercode");
				click(pdp.getAddToCart(), "Add To Cart");
				click(minicart.getProceedCheckOut(), "Proceed to Checkout");
				UIFunctions.completeOrder("PlaceOrder", "PreorderWithVouchercode");
			}

		}


