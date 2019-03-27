package com.tumi.cart;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class MiniCart extends GenericMethods {

	@Test(priority = 0)
	public void verifyMiniCartCount() {

		login("TumiTestData", "TumiLogin");

		if (!getText(home.getMinicartCount()).contains("0")) {

			webclick(home.getMinicart(), "Minicart");
			String cart[] = getText(home.getCartProductCount()).split(" ");
			assertEquals(Integer.parseInt(cart[0]), home.getCartProducts().size());
		}
	}

	@Test(priority = 1)
	public void removeProductInCart() {

		login("TumiTestData", "TumiLogin");
		UIFunctions.addProductToCart("TumiTestData", "GlobalLocatorProduct");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getRemoveItemInCart(), "Remove item in cart");
		verifyAssertEquals(getText(mainCart.getShopingCartMessege()), getProperty("cart.emptyCart"));
	}

}
