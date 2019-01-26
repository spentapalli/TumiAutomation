package orders.guest;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;

/**
 * @author Suresh
 * 
 */

public class BackOrderProdcut extends GenericMethods {
	/*
	 * TA-16 Verify Order with merchandise Back Order + Gift Boxing + Gift Message
	 * + Voucher/Promos for Guest User
	 */

	@Test(description = "Verify Order with merchandise Back Order + "
			+ "Gift Boxing + Gift Message + Voucher/Promos for Guest User")
	public void verifyOrderwithBackOrderProduct() throws Exception {

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
