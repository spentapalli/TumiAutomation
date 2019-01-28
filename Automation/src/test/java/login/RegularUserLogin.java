//TestCase : Regular login->Add item to cart->Checkoutpage->Wait for 10+ OR 30minute,confirm that user should be taken to /cart#expired and the login/register panel should open automatically

package login;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class RegularUserLogin extends GenericMethods {

	public Map<String, String> testData = ReadTestData.retrieveData("Login", "TumiLogin");

	@Test
	public void verifyLogin() throws InterruptedException {

		UIFunctions.closeSignUpForUS();

		login("Login", "RegularUserLogin");
		click(home.getCloseMyAccount(), "Close my account window");
		input(home.getSearch(), testData.get("PrdouctName"), "Product search");
		WebElement dropdown = driver.findElement(By.id("matching_products"));
		List<WebElement> allSearchResults = dropdown.findElements(By.tagName("li"));
		if (allSearchResults.isEmpty()) {
			final String emptyViewText = driver
					.findElement(By.xpath("//div[contains(text(),'Sorry, no search results for')]")).getText();
			if (!emptyViewText.contains("no results")) {
				throw new RuntimeException(emptyViewText);
			}
		} else {
			allSearchResults.get(0).click();
		}
		click(pdp.getAddToCart(), "Add To Cart");
		// delay(2000);

		click(minicart.getProceedCheckOut(), "Proceed to Checkout");

		click(mainCart.getProceedToCheckout(), "Cart");

		click(signinShip.getDurhamAddress1(), "Shipping address");
		click(shipping.getContinueShippingMethod(), "Continue shipping Method");

		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");

		click(signinBill.getAddNewPay(), "Add new Payment");
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");
		input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
		selectByVisibleText(guestBillPage.getExpiryMonth(), "05", "Expiry Month");
		selectByVisibleText(guestBillPage.getExpiryYear(), "2020", "Expiry Year");
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
		click(guestBillPage.getReviewOrder(), "Review your order");
		delay(2000);

		click(review.getPlaceOrder(), "place order");
		delay(5000);
		captureOrderConfScreen("OrderConfirmation");
		delay(20000);

	}

}
