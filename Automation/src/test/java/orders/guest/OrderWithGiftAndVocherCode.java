package orders.guest;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author Suresh
 * 
 */

public class OrderWithGiftAndVocherCode extends GenericMethods {
	/*
	 * TA-110 Verify Order with merchandise Ready to ship + Gift Boxing + Gift
	 * Message + Voucher/Promos for Guest User
	 */

	@Test(description = "TA-110 Verify Order with merchandise Ready to ship + Gift Boxing + Gift\r\n"
			+ "Message + Voucher/Promos for Guest User")
	public void verifyOrderwithGistandVocherCode() throws Exception {

		TumiLibs.addProductToCart("PlaceOrder", "OrderWithGiftServices");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		TumiLibs.addGiftMessage("PlaceOrder", "OrderWithGiftServices");
		TumiLibs.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		TumiLibs.addPromotionalCode("PlaceOrder", "PreOrderWithVoucher");
		TumiLibs.completeOrder("PlaceOrder", "OrderWithGiftServices");
	}

}
