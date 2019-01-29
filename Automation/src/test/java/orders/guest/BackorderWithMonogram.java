//TA-108 Verify Order with BackOrder +Personalization
	package orders.guest;
	import java.util.Map;

	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;

	import com.tumi.dataProvider.ReadTestData;
	import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;
	

	public class BackorderWithMonogram extends GenericMethods {

		@Test
		public void  orderWithMonogramAsGuest() {
		UIFunctions.addProductToCart("PlaceOrder", "BackorderWithMonogram");
		UIFunctions.addMonogram("PlaceOrder", "BackorderWithMonogram");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			
			UIFunctions.completeOrder("PlaceOrder","BackorderWithMonogram");
}
	}
