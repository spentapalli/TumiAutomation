//TestCase : Confirm clicking on Sign In link without entering credentials throws error message for normal sign in - N

package login;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;


/**
 * @author Shwetha Capo
 *
 */
public class VerifyInvalidRegularLogin extends GenericMethods {
	
	public Map<String, String> testData = ReadTestData.retrieveData("Login", "InValidCredentials");

	@Test
	public void verifyInvalidUserMessage() {

		TumiLibs.closeSignUpForUsProd();
		click(home.getSelectCountryUS(), "Select US country");
		click(home.getSelectUS(), "click US");
		delay(3000);
		if (google.getNoThanks().isDisplayed()) {
			click(google.getNoThanks(), "offers popup");
		}else {
			
		}
		login("Login", "InValidCredentials");
		
		/*verifyAssertEquals(getText(home.getInvalidCredentialsError()),
				repository("home.invalidCredentials"));*/
		String expectedMessage = "Your username or password was incorrect";
		String message = home.getInvalidCredentialsError().getText();
		Assert.assertTrue(message.contains(expectedMessage), "Your error message");
		System.out.println(message);

	}

}
