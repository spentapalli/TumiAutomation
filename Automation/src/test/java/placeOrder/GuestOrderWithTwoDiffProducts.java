package placeOrder;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.testcases.ProductSearch;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;


 /**
 * @author Shwetha Capo
 *
 */
public class GuestOrderWithTwoDiffProducts extends GenericMethods {
	
	/* TA-1
	 * Verify Order with 2 'Ready to Ship' Items with different SKU/sPurchase-Guest user
	 * 
	 */
	
	@Test
	public void verifyGuestOrderWithTwoDiffProducts()throws InterruptedException{
	TumiLibs.addMultipleProducts("PlaceOrder", "GuestOrderWithTwoDiffProducts");
	click(minicart.getMiniCartSymbol(), "Cart Image");
	click(minicart.getProceedCheckOut(), "Proceed to Checkout");
	TumiLibs.completeOrder("PlaceOrder", "GuestOrderWithTwoDiffProducts");
}
}
