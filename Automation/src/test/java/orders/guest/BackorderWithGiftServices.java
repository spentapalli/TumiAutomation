//TA-99 Verify Order With Merchandise Back order with gift message +Gift Boxing   
	
package orders.guest;

import org.openqa.selenium.WebElement;
	import java.util.Map;
	
	import org.testng.annotations.Test;

	import com.tumi.dataProvider.ReadTestData;
	import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;


	public class BackorderWithGiftServices extends GenericMethods {
		
		@Test
		public void orderWithAsGuest() {
			UIFunctions.addProductToCart("PlaceOrder", "BackorderWithGiftServices");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(gift.getMakeThisGift(), "Make this Gift");
			UIFunctions.addGiftMessage("PlaceOrder", "BackorderWithGiftServices");
			UIFunctions.addGiftBox();
			
			click(gift.getContinueGiftService(), "Continue");
			UIFunctions.completeOrder("PlaceOrder", "BackorderWithGiftServices");
		}
	}

