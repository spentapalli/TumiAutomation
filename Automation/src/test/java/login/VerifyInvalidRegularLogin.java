//TA-99 : Verify Tumi Login Fail, with wrong credentials

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

		TumiLibs.closeSignUpForUS();
		login("Login", "InValidCredentials");
		
		Assert.fail(getProperty("home.invalidCredentials"));
		

	}

}
