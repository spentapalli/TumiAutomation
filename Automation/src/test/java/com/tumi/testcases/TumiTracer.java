package com.tumi.testcases;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;

public class TumiTracer extends GenericMethods {

	Map<String, String> testdata = ReadTestData.getJsonData("TumiTestData", "TumiTracer");
	Map<String, String> kr = ReadTestData.getJsonData("TumiTestData", "GuestDeatilsForKorea");

	@Test(priority = 0, description = "TA-71, Verify Tumi Tracer for Guest")
	public void verifyTumiTracerRegistration() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", tracer.getRegisterUrTumi());
		//js.executeScript("window.scrollBy(0,-250)", "");
		click(tracer.getRegisterUrTumi(), "Register your tumi");
		input(tracer.getInputTracerNo(), testdata.get("TracerID"), "20 digit Tracer number");
		click(tracer.getApplyTracerNo(), "Apply");
		click(tracer.getCountryDropdown(), "Country drop down");
		delay(2000);

		for (WebElement ele : tracer.getCountryList()) {
			String country = getText(ele);
			if (selectedCountry.contains("US")) {
				if (country.contains("United States")) {
					click(ele, country);
					break;
				}
			} else if (selectedCountry.contains("Canada")) {
				if (country.contains("Canada")) {
					click(ele, country);
					break;
				}
			} else {
				if (country.contains("Korea")) {
					click(ele, country);
					break;
				}
			}
		}
		click(tracer.getTitleDropdown(), "Title drop down");
		delay(2000);
		for (WebElement ele1 : tracer.getTitleList()) {
			String title = getText(ele1);
			if (title.contains("Mrs")) {
				click(ele1, title);
				break;
			}
		}
		input(tracer.getFirstName(), testdata.get("FirstName"), "First Name");
		input(tracer.getLastName(), testdata.get("LastName"), "Last Name");
		input(tracer.getEmail(), testdata.get("EmailID"), "Email");
		input(tracer.getPhone(), testdata.get("Phone"), "Phone");
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			input(tracer.getAddressLine1(), testdata.get("AddressLine1"), "Address Line 1");
		} else {
			input(tracer.getAddressLine1(), kr.get("AddressLine1"), "Address Line 1");
		}
		if (selectedCountry.contains("US")) {
			input(tracer.getTownOrcity(), testdata.get("TownCity"), "Town/City");
		} else if (selectedCountry.contains("Canada")) {
			input(tracer.getTownOrcity(), testdata.get("CATownCity"), "Town/City");
		} else {
			input(tracer.getTownOrcity(), kr.get("TownCity"), "Town/City");
		}

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			click(tracer.getStateDropdown(), "State drop down");
			delay(2000);
			for (WebElement ele2 : tracer.getStateList()) {
				String state = getText(ele2);
				if (selectedCountry.contains("US")) {
					if (state.contains("New York")) {
						click(ele2, state);
						break;
					}
				} else if (selectedCountry.contains("Canada")) {
					if (state.contains("British Columbia")) {
						click(ele2, state);
						break;
					}
				}
			}
		}
		if (selectedCountry.contains("US")) {
			input(tracer.getZipcode(), testdata.get("ZipCode"), "Zip Code");
		} else if (selectedCountry.contains("Canada")) {
			input(tracer.getZipcode(), testdata.get("CAZipcode"), "Zip Code");
		} else {
			input(tracer.getZipcode(), kr.get("PostCode"), "Zip Code");
		}
		click(tracer.getCompleteRegistration(), "Complete Registration");

		try {
			if (tracer.getThanksMsg().isDisplayed()
					&& getText(tracer.getRegisterdMailID()).contains(testdata.get("EmailID"))) {
				logger.log(Status.PASS, "Tumi tracer registration is successfull");
			} else {
				Assert.fail("Tumi tracer registration is failed");
			}

		} catch (Exception e) {
			if (tracer.getGlobalErrMsg().isDisplayed()) {
				Assert.fail("You have entered wrong inputs");
			}

		}

	}

	@Test(priority = 1, description = "TA-71, Verify Tumi Tracer validations")
	public void tracerRegistrationValidations() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", tracer.getRegisterUrTumi());
		click(tracer.getRegisterUrTumi(), "Register your tumi");
		input(tracer.getInputTracerNo(), testdata.get("TracerID"), "20 digit Tracer number");
		click(tracer.getApplyTracerNo(), "Apply");
		click(tracer.getCompleteRegistration(), "Complete Registration");

		softAssertEquals(getText(tracer.getFristnameErr()), getProperty("tracer.firstname"));
		softAssertEquals(getText(tracer.getLastnameErr()), getProperty("tracer.lastname"));
		softAssertEquals(getText(tracer.getEmailErr()), getProperty("tracer.email"));
		softAssertEquals(getText(tracer.getPhoneErr()), getProperty("tracer.phone"));
		softAssertEquals(getText(tracer.getAddlineErr()), getProperty("tracer.addressline1"));
		softAssertEquals(getText(tracer.getTownorcityErr()), getProperty("tracer.townorcity"));
		softAssertEquals(getText(tracer.getStateErr()), getProperty("tracer.state"));
		softAssertEquals(getText(tracer.getZipcodeErr()), getProperty("tracer.zipcode"));
	}

}
