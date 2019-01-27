/* TA-26: Confirm Regular login is successful on clicking Sign In and Entering Valid Email address & Password
   TA-58 : Verify Tumi Login Fail, with wrong credentials*/
package login;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class RegularLogin extends GenericMethods {

	
	@Test(priority = 0)
	public void verifyValidLogin() {

		UIFunctions.closeSignUpForUS();
		login("Login", "TumiLogin");
		if(myacc.getSignout().isEnabled()) {
			click(myacc.getSignout(),"Signout");
		}
	}

	@Test(priority = 1)
	public void verifyInvalidUserMessage() {

		UIFunctions.closeSignUpForUS();
		login("Login", "InValidCredentials");

		Assert.fail(getProperty("home.invalidCredentials"));

	}

}
