//TA-100: Verify Order with merchandise Ready to ship for Guest User
package placeOrder;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.TumiLibs;


/**
 * @author Shwetha  Capo
 *
 */
public class TumiOrder extends GenericMethods {
	public Map<String, String> testData = ReadTestData.retrieveData("PlaceOrder", "TumiOrder");
	public Map<String, String> testData1 = ReadTestData.retrieveData("PlaceOrder", "OrderWithMonogram");
	public Map<String, String> testData2 = ReadTestData.retrieveData("PlaceOrder", "OrderWithGiftServices");
	
	
	@Test(priority = 0)
	public void placeGuestTumiOrder() throws InterruptedException {
		orderInputsHome(testData.get("SKUID"));
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		checkoutInputs(testData.get("EmailID"));
	}
	
	@Test(priority = 1)
	public void placeGuestOrderWithMonogram() {
		orderInputsHome(testData1.get("SKUID"));
		inputsForMono();
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		giftMessage();
		click(gift.getContinueGiftService(), "continue");
		checkoutInputs(testData1.get("EmailID"));
		
	}
	@Test(priority = 2)
	public void placeGuestOrderWithGiftMsg() {
		orderInputsHome(testData2.get("SKUID"));
		inputsForMono();
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		giftMessage();
		click(gift.getContinueGiftService(), "continue");
		checkoutInputs(testData.get("EmailID"));
		
	}
	@Test(priority = 3)
	public void placeGuestOrderWithGiftBox() {
		orderInputsHome();
		inputsForMono();
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		giftBox();
		click(gift.getContinueGiftService(), "continue");
		checkoutInputs(testData.get("EmailID"));
		
	}
	
	public void orderInputsHome(String data) {
		TumiLibs.closeSignUpForUS();
		input(home.getSearchProduct(),data , "Search Product");
		keyEnter(home.getSearchProduct());
	}
	public void inputsForMono() {
		
		Actions action = new Actions(driver);
        action.moveToElement(mono.getComplimentaryMono()).perform();
		click(mono.getAddPersonalization(), "Add Personalization");
		input(mono.getFirstMonoInput(), testData.get("FirstMonoInput"), "First Mono Input");
		input(mono.getSecondMonoInput(), testData.get("SecondMonoInput"), "Second Mono Input");
		input(mono.getThirdMonoInput(), testData.get("ThirdMonoInput"), "Third Mono Input");
		
		click(mono.getNext(),"Next");
		click(mono.getTextStyleBold(),"Serif as Bold");
		click(mono.getCafeColor(), "Color");
		click(mono.getApply(),"Apply");
		delay(3000);
	}
	public void giftMessage() {
		
		click(gift.getCheckMessage(), " check Message");
		input(gift.getRecipientName(), testData.get("RecipientName"), "Recipients name");
		input(gift.getSenderName(), testData.get("SenderName"), "Sender name");
		input(gift.getAddMessage(), testData.get("Message"), "Message");
		
	}
	public void giftBox() {
		click(gift.getCheckPremiumGift(), "Premium GiftBox");
	}
	
	public void checkoutInputs(String data) {
		click(mainCart.getProceedToCheckout(), "Cart");
		input(singlePage.getEmailAddress(), data.get("Email"), "Email");
		click(singlePage.getContinueAsGuest(), "Continue As Guest");
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address line1");
		delay(2000);
		
		for (WebElement ele : shipping.getListAddressLine1()) {
			if (getText(ele).equals("1001 6Th Ave Ph 1, New York NY 10018")) {
				click(ele, "AddressList");
				break;
			}
		}
		
		input(shipping.getPostcode(), testData.get("PostCode"), "Post code");
		
		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
		click(shipping.getContinueShippingMethod(), "Continue shipping Method");
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		TumiLibs.addCardDetails("PlaceOrder", "TumiOrderKR");
		click(review.getPlaceOrder(), "Place Order");
		delay(4000);
		captureOrderConfScreen("OrderConfirmation");
	
	}
	

}
