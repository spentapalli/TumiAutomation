

package login;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;


/**
 * @author Shwetha Capo
 *
 */
public class VerifyInvalidRegularLogin extends GenericMethods {
	
	public Map<String, String> testData = ReadTestData.retrieveData("Login", "SocialNetworkDetails");
	
	/*TA-58 : 
	Verify Tumi Login Fail, with wrong credentials
	*/

	@Test(priority = 1, description = "TA-58 : Verify Tumi Login Fail, with wrong credentials")
	public void verifyInvalidUserMessage() {

		UIFunctions.closeSignUp();
		userLogin("TumiTestData","SocialNetworkDetails");
		
		Assert.fail(getProperty("home.invalidCredentials"));
		

	}

}
