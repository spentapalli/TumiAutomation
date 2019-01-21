//TestCase : Confirm when click on "sign In", In My Account window is having"New Here?" and  "Create an account" is there. 
//             If click on SignUp will take to "My Account Registration page".

package login;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.TumiLibs;
import org.apache.log4j.Logger;

/**
 * @author Shwetha Capo
 *
 */
public class MyAccPage extends GenericMethods {
	/* The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(MyAccPage.class);
	Map<String, String> testData = ReadTestData.retrieveData("Login", "MyAccPage");
	
	@Test
	public void verifyMyAccPage() throws InterruptedException{
		
		  // TumiLibs.closeSignUpForUS();
			TumiLibs.closeSignUpForUsProd();
			click(home.getSelectCountryUS(), "Select US country");
			click(home.getSelectUS(), "click US");
			//delay(4000);
			if (google.getNoThanks().isEnabled()) {
				click(google.getNoThanks(), "offers popup");
			}
		
			click(home.getHeaderSignIn(), "SignIn");
			
			if(myacc.getNewHereMessage().isDisplayed()) {
				logger.log(Status.INFO, "new here message displayed");
				System.out.println("new here message displayed");
			}else {
				Assert.fail("new here mesage is not displayed");
			}
			
			if(myacc.getCreateAcc().isDisplayed()) {
				
				click(myacc.getCreateAcc(),"Create Account");
				if(myacc.getSignUpMyAccMsg().isDisplayed()) {
					logger.log(Status.INFO, "SignUp window is displayed");
					System.out.println("SignUp window is displayed");

				}else {
					logger.log(Status.INFO, "SignUp window is not displayed");
				}
				
			}else {
				logger.log(Status.INFO, "Create account is not enabled");

			}
	
		
		
	}

}
