package tumi.home;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class TopNavigation extends GenericMethods{
	
	/* TA-76 
	 * Verify Top Navigation.
	 */
	
	//@Test(priority = 0, description = " Sprint 3- TA-342/ TA-76 Verify Location")
	public void verifyLocation() {
		
		click(home.getSelectCountry(),"select country");
		
		if(selectedCountry.contains("US")) {
		click(home.getSelectCountryUS()," selected US");
		
		if(!getText(home.getSelectCountry()).contains("United States")) {
			Assert.fail("Verification of country selection failed");
		}
		
		} else if(selectedCountry.contains("Canada")){
			click(home.getSelectCountryCA(),"selected Canada");
			
			if(!getText(home.getSelectCountry()).contains("Canada")) {
				Assert.fail("Verification of country selection failed");
			}
			
		} else{
			
			click(home.getSelectCountryKR(),"selected Korea");

			if(!getText(home.getSelectCountry()).contains("대한민국")) {
				Assert.fail("Verification of country selection failed");
			}
			
		}
		
	}
	
	//@Test(priority = 1, description = " Sprint 3- TA-343/ TA-76 Verify Language Selector")
	public void verifyLanguageSelector() {
		
		click(home.getSelectLanguage(),"Language");
		click(home.getSelectSpanishLanguage(),"Spanish");
		if(!getText(home.getSelectLanguageContainer()).contains("Español")) {
			Assert.fail("Select Sapnish language failed");
		}
		click(home.getSelectLanguageContainer(),"Language");
		click(home.getSelectFrenchLanguage(),"French");
		if(!getText(home.getSelectLanguageContainer()).contains("Français")) {
			Assert.fail("Selecting french language is failed");
		}
		
	}
	
	//@Test(priority = 2, description = " Sprint 3- TA-344/ TA-76 Verify Find A Store")
	public void verifyFindAStore() {
		
		click(home.getHeaderFindStore(), "Store Finder");
		
		
	}
	
	//@Test(priority = 3, description = " Sprint 3- TA-345/ TA-76 Verify Customer Service")
	public void verifyCustomerService() {
		
		click(home.getHeaderCustomerService(),"Customer Service");
		
	}
	
	//@Test(priority = 4, description = " Sprint 3- TA-346/ TA-76 Verify SignIn")
	public void verifySignIn() {
		click(home.getHeaderSignIn(),"SignIn");
		if(!getText(myacc.getMyAccMsg()).contains("My Account")) {
			Assert.fail("My account window not opened");
		}
		click(home.getCloseMyAccount(),"Close My acc");
		
	}
	
	@Test(priority = 5, description = " Sprint 3- TA-347/ TA-76 Verify Search")
	public void verifySearch() {
		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
		
		UIFunctions.searchProducts(1, testData.get("ProductName"));
		
	}
	
	


}
