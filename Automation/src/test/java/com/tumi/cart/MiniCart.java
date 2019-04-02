package com.tumi.cart;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
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
	/* TA-409
	 * Verify PDP is allowing to select required no. of quantity to add to cart
	 */
	@Test(priority=2)
	public void editCartProducts() {
		
		login("TumiTestData", "TumiLogin");
		UIFunctions.addProductToCart("TumiTestData","Products");
		input(driver.findElement(By.id("select-qty")), "5", "Quantity");
		click(pdp.getAddToCart(), "Add to cart");
		String cart[] = getText(home.getCartProductCount()).split(" ");
		assertEquals(5, Integer.parseInt(cart[0]));
	}

}
