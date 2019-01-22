//TA-76: Confirm Regular login is successful on clicking Sign In and Entering Valid Email address & Password

package login;

	import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
	import com.tumi.dataProvider.ReadTestData;
	import com.tumi.utilities.GenericMethods;
	import com.tumi.utilities.TumiLibs;

	
	/**
	 * @author Shwetha Capo
	 *
	 */
	public class RegularLogin extends GenericMethods {

		public Map<String, String> testData = ReadTestData.retrieveData("Login", "TumiLogin");

		@Test
		public void verifyLogin() throws InterruptedException {
			
			TumiLibs.closeSignUpForUsProd();
			click(home.getSelectCountryUS(), "Select US country");
			click(home.getSelectUS(), "click US");
			delay(3000);
			if (google.getNoThanks().isDisplayed()) {
				click(google.getNoThanks(), "offers popup");
			}
			
			login("Login", "TumiLogin");
			click(home.getCloseMyAccount(), "Close my account window");

			
			
		}
	


}
