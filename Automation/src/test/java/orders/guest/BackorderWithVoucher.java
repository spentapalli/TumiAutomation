

	//TA-103 Verify Order With Merchandise BackOrder + Voucher Card with Guest User
	package orders.guest;

		import java.util.Map;

		import org.openqa.selenium.WebElement;
		import org.testng.annotations.Test;

		import com.tumi.dataProvider.ReadTestData;
		import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;
	

		public class BackorderWithVoucher extends GenericMethods{ 

				
				Map<String, String>  testData = ReadTestData.retrieveData("PlaceOrder", "BackorderWithVoucher");
				
				@Test
			
				public void orderWithAsGuest() {
					UIFunctions.addProductToCart("PlaceOrder", "BackorderWithVoucher");
					click(pdp.getAddToCart(), "Add To Cart");
					click(minicart.getProceedCheckOut(), "Proceed to Checkout");
					click(mainCart.getApply(),"check promocode");
					UIFunctions.completeOrder("PlaceOrder", "BackorderWithVoucher");
				}

			}
			
			



