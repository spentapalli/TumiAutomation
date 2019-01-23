package placeOrder;

import java.util.Map;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 *
 */
public class GuestOrderWithMonogram extends GenericMethods{
	
	/* TA-101
	 * Verify Order with merchandise Ready to ship + Personalization for Guest User.
	 */
	@Test
	public void orderWithMonogramAsGuest() throws Exception {
	TumiLibs.addProductToCart("PlaceOrder", "OrderWithMonogram");
	TumiLibs.addMonogram("PlaceOrder", "OrderWithMonogram");
	click(pdp.getAddToCart(), "Add To Cart");
	click(minicart.getProceedCheckOut(), "Proceed to Checkout");
	click(gift.getContinueGiftService(), "continue");
	TumiLibs.completeOrder("PlaceOrder", "OrderWithMonogram");
		
	}

}
