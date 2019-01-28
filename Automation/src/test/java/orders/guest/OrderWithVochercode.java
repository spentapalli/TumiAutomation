package orders.guest;

import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Suuresh
 *
 */
public class OrderWithVochercode extends GenericMethods {

	Map<String, String> testData = ReadTestData.retrieveData("PlaceOrder", "OrderWithVochercode");

	/*
	 * TA-15 Verify Order with merchandise Ready to ship + Voucher Code for Guest
	 * User
	 */
	@Test(dataProvider = "Location", 
			description = "Verify Order with merchandise Ready to ship + Voucher Code for Guest User")
	public void verifyOrderWithVocherCode(String name) throws InterruptedException {

		UIFunctions.selectCountry(name);
		UIFunctions.addProductToCart("PlaceOrder", "OrderWithGiftServices");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		UIFunctions.addPromotionalCode("PlaceOrder", "PreOrderWithVoucher");
		UIFunctions.completeOrder("PlaceOrder", "OrderWithGiftServices");
	}

}
