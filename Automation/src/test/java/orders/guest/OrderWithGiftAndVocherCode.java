package orders.guest;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

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

		UIFunctions.addProductToCart("PlaceOrder", "OrderWithGiftServices");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("PlaceOrder", "OrderWithGiftServices");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		UIFunctions.addPromotionalCode("PlaceOrder", "PreOrderWithVoucher");
		UIFunctions.completeOrder("PlaceOrder", "OrderWithGiftServices");
	}

}
