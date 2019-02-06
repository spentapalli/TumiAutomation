package login;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class ProductSearch extends GenericMethods {
	public Map<String, String> testData = ReadTestData.retrieveData("PlaceOrder", "PrdouctSearch");

	@Test
	public void search() throws InterruptedException {
		UIFunctions.closeSignUp();
		UIFunctions.searchProducts(1, testData.get("PrdouctName"));
	}

	

}
