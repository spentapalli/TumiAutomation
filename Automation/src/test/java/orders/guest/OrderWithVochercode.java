package orders.guest;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

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
	@Test(description = "Verify Order with merchandise Ready to ship + Voucher Code for Guest User")
	public void verifyOrderWithVocherCode() throws InterruptedException {

		TumiLibs.addProductToCart("PlaceOrder", "OrderWithGiftServices");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		TumiLibs.addPromotionalCode("PlaceOrder", "PreOrderWithVoucher");
		TumiLibs.completeOrder("PlaceOrder", "OrderWithGiftServices");
	}

}
