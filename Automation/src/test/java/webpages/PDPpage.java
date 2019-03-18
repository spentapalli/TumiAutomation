package webpages;

import java.util.Map;

import org.openqa.selenium.WebElement;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class PDPpage extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
	
	public void verifyPDP() {
		
		
		
	}
	public void verifyBreadScrumbs(){
		UIFunctions.addProductToCart("TumiTestData", "GuestDetails");
		
		for(WebElement ele: pdp.getBreadCrumbsList()) {
			if(getText(ele).contains("Home")) {
				click(ele,"");
			}
		}
		
	}

}
