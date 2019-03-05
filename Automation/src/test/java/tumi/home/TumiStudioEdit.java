package tumi.home;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

 
/**
 * @author Shwetha Capo
 *
 */
public class TumiStudioEdit extends GenericMethods {
	
Map<String, String> testData= ReadTestData.getJsonData("TumiTestData","GuestOrders");
	
	@Test(description ="TA-329 verify Tumi studio ")
	public void testTumiIdOrder() throws InterruptedException{
		
		UIFunctions.addProductToCart("TumiTestData","TumiStudio");
		UIFunctions.addTumiStudio();
		delay(2000);
		webclick(tumiId.getTumiIdEditDesign(),"Edit Design");
		delay(3000);
		
		domClick(tumiId.getFrontPocket(), "Front Pocket");
		delay(2000);

		for (WebElement ele : tumiId.getFrontPocketList()) {
			if (getText(ele).contains("Atlantic")) {

				webclick(ele, "Front Pocket color");
				logger.log(Status.INFO, "Front pocket color changing is successfull");
				break;
			}
		}
		
		domClick(tumiId.getSidePocket(), "Side Pocket");
		delay(2000);

		for (WebElement ele : tumiId.getSidePocketList()) {
			if (getText(ele).contains("Red")) {
				webclick(ele, "Side Pocket color");
				logger.log(Status.INFO, "Side pocket color changing is successfull");
				break;
			}
		}
		click(tumiId.getWebbing(), "Webbing");
		delay(2000);

		for (WebElement ele : tumiId.getWebbingList()) {
			if (getText(ele).contains("Shadow Grey")) {

				webclick(ele, "Webbing color");
				logger.log(Status.INFO, "Webbing color changing is successfull");
				break;
			}
		}
		click(tumiId.getSaveDesign(), "Save");
		logger.log(Status.INFO, "Edit of Tumi Studio design is successfull");

}
}
