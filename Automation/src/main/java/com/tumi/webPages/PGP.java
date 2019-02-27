package com.tumi.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

public class PGP extends GenericMethods{
	
	public PGP(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}



}
