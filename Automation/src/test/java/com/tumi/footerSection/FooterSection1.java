package com.tumi.footerSection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class FooterSection1 extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");

	@Test(priority = 0, description = "TA-320 Verify Follow Us( Facebook,Twitter, Pinterest, Instagaram and Youtube)")
	public void verifyFollowUs() {

		String parentWindow = driver.getWindowHandle();
		for (int i = 1; i < home.getFollowUs().size(); i++) {

			driver.findElement(By.xpath("//div[contains(@class, 'social')]/a[" + i + "]")).click();

			UIFunctions.delay(5000);

			Set<String> childWindow = driver.getWindowHandles();

			Iterator<String> ite = childWindow.iterator();

			while (ite.hasNext()) {

				String str = ite.next();

				if (!parentWindow.equalsIgnoreCase(str)) {

					driver.switchTo().window(str);

					String tabName = driver.getTitle();

					if (tabName.equalsIgnoreCase("TUMI - Home | Facebook")) {

						logger.log(Status.INFO, "Facebook redirection is success");

					} else if (tabName.equalsIgnoreCase("TUMI (@tumitravel) | Twitter")) {

						logger.log(Status.INFO, "Twitter redirection is success");

					} else if (tabName.equalsIgnoreCase("TUMI (tumitravel) on Pinterest")) {

						logger.log(Status.INFO, "Pinterest redirection is success");

					} else if (tabName.equalsIgnoreCase("TUMI (@tumitravel) • Instagram photos and videos")) {

						logger.log(Status.INFO, "Instagram redirection is success");

					} else if (tabName.equalsIgnoreCase("TumiTravel - YouTube")) {

						logger.log(Status.INFO, "YouTube redirection is success");

					} else if (tabName.equalsIgnoreCase("Untitled")) {

						continue;

					} else {

						Assert.fail("User is redirected to " + tabName);
					}
					driver.close();
				}

			}
			driver.switchTo().window(parentWindow);
		}
	}

	@Test(priority = 1, description = "TA-291 Verify Customer Service")
	public void verifyCustomerService() {

		click(home.getCustomerService(), "CUSTOMER SERVICE");

		try {
			if (getText(home.getCustomerServiceHeader()).equalsIgnoreCase("CUSTOMER SERVICE")) {

				logger.log(Status.INFO, "Customer Serivce redirection is success");
			}
		} catch (Exception e) {
			
			Assert.fail("Customer Service Header is not available in "+driver.getCurrentUrl());
		}
	}

	@Test(priority = 2, description = "TA-292 Verify Shipping")
	public void verifyShipping() {

		click(home.getShipping(), "Shipping");

		for (int i = 1; i < home.getShippingMenuTable().size(); i++) {

			String menuName = driver
					.findElement(By.xpath("//div[@class='tumi_shipping']/div/table/tbody/tr/td[" + i + "]/a"))
					.getText();

			if (menuName.equalsIgnoreCase("Shipping Methods & Costs")) {

				logger.log(Status.INFO, "Shipping Methods & Costs menu is available");

			} else if (menuName.equalsIgnoreCase("Item Availability")) {

				logger.log(Status.INFO, "Item Availability menu is available");

			} else if (menuName.equalsIgnoreCase("Tracking Your Order")) {

				logger.log(Status.INFO, "Tracking Your Order menu is available");

			} else if (menuName.equalsIgnoreCase("")) {

				continue;

			} else {
				Assert.fail("Shipping is not available");
			}
		}
	}

	@Test(priority = 3, description = "TA-293 Verify Returns")
	public void verifyReturns() {

		click(home.getReturns(), "Returns");

		for (int i = 1; i < home.getReturnsContent().size(); i++) {

			String contentName = driver.findElement(By.xpath("//div[@id='breadcrumb']/following::div[2]/h2[" + i + "]"))
					.getText();

			if (contentName.equalsIgnoreCase("FREE RETURNS")) {

				logger.log(Status.INFO, "Free Returns content is available");

			} else if (contentName.equalsIgnoreCase("RETURN SHIPPING IS FREE")) {

				logger.log(Status.INFO, "Return Shipping content is available");

			} else if (contentName.equalsIgnoreCase("NO EXCHANGES")) {

				logger.log(Status.INFO, "No exchanges content is available");

			} else if (contentName.equalsIgnoreCase("CREDIT")) {

				logger.log(Status.INFO, "Credit content is available");

			} else if (contentName.equalsIgnoreCase("RETURNING AN ITEM - EVERYDAY FREE RETURNS WORLDWIDE")) {

				logger.log(Status.INFO, "Returning an Item content is available");

			} else if (contentName.equalsIgnoreCase("RETURN POLICY - U.S. FULL PRICE STORES")) {

				logger.log(Status.INFO, "Return Policy content is available");

			} else if (contentName.equalsIgnoreCase("RETURN POLICY - U.S. OUTLET STORES")) {

				logger.log(Status.INFO, "Return Policy Outlet content is available");

			} else if (contentName.equalsIgnoreCase("INTERNATIONAL RETURN POLICY")) {

				logger.log(Status.INFO, "International Return Policy content is available");

			} else if (contentName.equalsIgnoreCase("")) {

				continue;

			} else {
				Assert.fail("Reutrn not available");
			}
		}
	}

	@Test(priority = 4, description = "TA-302 Verify Contact Us")
	public void verifyContactUs() {

		click(home.getContactUs(), "Contact us");

		try {
			if (getText(home.getContactUsHeader()).equalsIgnoreCase("CONTACT US")) {

				logger.log(Status.INFO, "Contact Us redirection is success");
			}
		} catch (Exception e) {
			
			Assert.fail("Contact us is not available in "+driver.getCurrentUrl());
		}
	}

	@Test(priority = 5, description = "TA-303 Verify 1-800-299-8864")
	public void verify18002998864() {

		if (getText(home.get18002998864()).equalsIgnoreCase("1-800-299-8864")) {

			logger.log(Status.INFO, "1-800-299-8864 display is success");

		} else {

			Assert.fail("1-800-299-8864 is not available");
		}
	}

	// This also applies to: description = TA-295 Verify Service & Repairs)
	@Test(priority = 6, description = "TA-299 Verify FAQ's")
	public void verifyFAQs() {

		click(home.getFAQs(), "FAQs");

		for (int i = 1; i < home.getFAQsKeywords().size(); i++) {

			String keywordName = driver
					.findElement(By.xpath("//div[@id='FaqPage']/div/div/following::div[1]/div/ul/li[" + i + "]/a"))
					.getText();

			if (keywordName.equalsIgnoreCase("Shipping")) {

				driver.findElement(By.xpath("//div[@id='FaqPage']/div/div/following::div[1]/div/ul/li[" + i + "]/a"))
						.click();

				if (!getText(home.getShippingContent())
						.equalsIgnoreCase("When should I expect to my products to be shipped?")) {

					logger.log(Status.INFO, "Shipping content is available");

				}

			} else if (keywordName.equalsIgnoreCase("Order/Order Status")) {

				driver.findElement(By.xpath("//div[@id='FaqPage']/div/div/following::div[1]/div/ul/li[" + i + "]/a"))
						.click();

				if (!getText(home.getOrderContent())
						.equalsIgnoreCase("Can I use two credit cards to pay for my purchase?")) {

					logger.log(Status.INFO, "Order/Order Status content is available");

				}
			} else if (keywordName.equalsIgnoreCase("Repairs")) {

				driver.findElement(By.xpath("//div[@id='FaqPage']/div/div/following::div[1]/div/ul/li[" + i + "]/a"))
						.click();

				if (!getText(home.getRepairsContent())
						.equalsIgnoreCase("How do I go about sending my bag in for repair?")) {

					logger.log(Status.INFO, "Repairs content is available");

				}

			} else if (keywordName.equalsIgnoreCase("Tracer Registration")) {

				driver.findElement(By.xpath("//div[@id='FaqPage']/div/div/following::div[1]/div/ul/li[" + i + "]/a"))
						.click();

				if (!getText(home.getTraceRegistrationContent())
						.equalsIgnoreCase("Why can't I see my registered TUMI products in my TUMI.com profile?")) {

					logger.log(Status.INFO, "Tracer Registration content is available");

				}

			} else if (keywordName.equalsIgnoreCase("Returns/Exchanges")) {

				driver.findElement(By.xpath("//div[@id='FaqPage']/div/div/following::div[1]/div/ul/li[" + i + "]/a"))
						.click();

				if (!getText(home.getReturnExcahngeContent()).equalsIgnoreCase("What is your return policy?")) {

					logger.log(Status.INFO, "Returns/Exchanges content is available");

				}
			} else if (keywordName.equalsIgnoreCase("Product Inquiry")) {

				driver.findElement(By.xpath("//div[@id='FaqPage']/div/div/following::div[1]/div/ul/li[" + i + "]/a"))
						.click();

				if (!getText(home.getProductEnquiryContent())
						.equalsIgnoreCase("How do I submit feedback for my Tumi products and/or experience?")) {

					logger.log(Status.INFO, "Product Inquiry content is available");

				}
			} else if (keywordName.equalsIgnoreCase("View All")) {

				driver.findElement(By.xpath("//div[@id='FaqPage']/div/div/following::div[1]/div/ul/li[" + i + "]/a"))
						.click();

				if (!getText(home.getViewAllContent())
						.equalsIgnoreCase("How do I go about sending my bag in for repair?")) {

					logger.log(Status.INFO, "View All content is available");

				}
			} else {

				Assert.fail("FAQs redirection unsuccessful");
			}
		}
	}

	// This method has been used in TA-294 Verify Payment Methods
	public void switchToNewTab() {

		ArrayList<String> childs = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window(childs.get(1));
	}

	// This method has been used in TA-294 Verify Payment Methods
	public void closeNewTab() {

		ArrayList<String> childs = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window(childs.get(1));
		driver.close();
	}

	// This method has been used in TA-294 Verify Payment Methods
	public void switchToNewParent() {
		ArrayList<String> childs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(childs.get(0));
	}

	@Test(priority = 7, description = "TA-294 Verify Payment Methods")
	public void verifyPaymentMethods() {

		click(home.getPaymentMethods(), "Payment Methods");

		click(home.getSignupforPayPalnow(), "Signup for PayPal now");

		switchToNewTab();

		String signUpTab = driver.getTitle().trim();

		if (!signUpTab.equalsIgnoreCase("Sign Up for PayPal: Create a Business or Personal Account Now With PayPal")) {

			logger.log(Status.FAIL, "Sign Up for PayPal redirection is unsuccess");
			System.out.println("asca");
		}

		closeNewTab();

		switchToNewParent();

		click(home.getHelpCentre(), "Help Centre");

		switchToNewTab();

		String helpCentreTab = driver.getTitle().trim();

		if (helpCentreTab.equalsIgnoreCase("PayPal Help Center Home")) {

			logger.log(Status.INFO, "PayPal Help Center Home redirection is success");

		}
		closeNewTab();
		switchToNewParent();

		click(home.getApplePaySupport(), "Apple Pay Support");

		switchToNewTab();

		String applePaySupportTab = driver.getTitle().trim();

		if (applePaySupportTab.equalsIgnoreCase("Apple Pay - Official Apple Support")) {

			logger.log(Status.INFO, "Apple Pay Support redirection is success");

			UIFunctions.delay(5000);
		}
		closeNewTab();
		switchToNewParent();

		click(home.getHelpCentre(), "Help Centre");

		switchToNewTab();

		String setUpApplePayTab = driver.getTitle().trim();

		if (setUpApplePayTab.equalsIgnoreCase("Set up Apple Pay - Apple Support")) {

			logger.log(Status.INFO, "Set up Apple Pay redirection is success");

			UIFunctions.delay(5000);
		}
		closeNewTab();
		switchToNewParent();
	}

	@Test(priority = 8, description = "TA-298 Verify Warranty")
	public void verifyWarranty() {

		click(home.getWarranty(), "Warranty");

		try {
			if (getText(home.getProductInfoWarrantyHeader()).equalsIgnoreCase("Product Information and Warranty")) {

				logger.log(Status.INFO, "Warranty redirection is success");
			}
		} catch (Exception e) {
			
			Assert.fail("Warrenty is not available in "+driver.getCurrentUrl());
		}
		for (int i = 1; i < home.getChangeLanguage().size(); i++) {

			String language = driver
					.findElement(By.xpath("//div[@id='breadcrumb']/following::div[1]/div/ul/li[" + i + "]/a"))
					.getText();

			if (language.equalsIgnoreCase("English")) {

				driver.findElement(By.xpath("//div[@id='breadcrumb']/following::div[1]/div/ul/li[" + i + "]/a"))
						.click();

				if (!getText(home.getEnglishContent()).contains("First Year of Ownership: Worry Free")) {

					logger.log(Status.INFO, "English content is available");
				}

			} else if (language.equalsIgnoreCase("Deutsche")) {

				driver.findElement(By.xpath("//div[@id='breadcrumb']/following::div[1]/div/ul/li[" + i + "]/a"))
						.isDisplayed();

				logger.log(Status.INFO, "German content is available");

			} else if (language.equalsIgnoreCase("français")) {

				driver.findElement(By.xpath("//div[@id='breadcrumb']/following::div[1]/div/ul/li[" + i + "]/a"))
						.isDisplayed();

				logger.log(Status.INFO, "French content is available");

			} else if (language.equalsIgnoreCase("Español")) {

				driver.findElement(By.xpath("//div[@id='breadcrumb']/following::div[1]/div/ul/li[" + i + "]/a"))
						.isDisplayed();

				logger.log(Status.INFO, "Spanish content is available");

			} else if (language.equalsIgnoreCase("italiano")) {

				driver.findElement(By.xpath("//div[@id='breadcrumb']/following::div[1]/div/ul/li[" + i + "]/a"))
						.isDisplayed();

				logger.log(Status.INFO, "italian content is available");
			}
		}

		home.getJapanese().isDisplayed();
		logger.log(Status.INFO, "Japanese content is available");

		home.getChina().isDisplayed();
		logger.log(Status.INFO, "China content is available");

		home.getKorean().isDisplayed();
		logger.log(Status.INFO, "Korea content is available");
	}

	@Test(priority = 9, description = "TA-308 Verify Tumi Difference")
	public void verifyTumiDifference() {

		click(home.getTumiDifference(), "Tumi Difference");

		try {
			if (!getText(home.getTumiDifferenceHeader()).trim().equalsIgnoreCase("THE TUMI DIFFERENCE")) {

				Assert.fail("Tumi Difference redirection unsuccessful");
			}
		} catch (Exception e) {
			
			Assert.fail("Tumi Difference is not available "+driver.getCurrentUrl());
		}
		for (int i = 1; i < home.getAboutTumi().size(); i++) {

			String link = driver.findElement(By.xpath("//div[@id='aboutBlock']/div/following::ul[1]/li[" + i + "]"))
					.getText();

			if (link.equalsIgnoreCase("TUMI DIFFERENCE")) {

				driver.findElement(By.xpath("//div[@id='aboutBlock']/div/following::ul[1]/li[" + i + "]")).click();

			} else if (link.equalsIgnoreCase("CORPORATE RESPONSIBILITY")) {

				driver.findElement(By.xpath("//div[@id='aboutBlock']/div/following::ul[1]/li[" + i + "]")).click();

				if (getText(home.getCorporateResponsibilityHeader())
						.equalsIgnoreCase("COMMUNITY ENGAGEMENT & CORPORATE GIVING")) {

					logger.log(Status.INFO, "Corporate responsibility link is available");
				}

			} else if (link.equalsIgnoreCase("CA TRANSPARENCY IN SUPPLY CHAIN ACT")) {

				driver.findElement(By.xpath("//div[@id='aboutBlock']/div/following::ul[1]/li[" + i + "]")).click();

				if (getText(home.getSupplyChainHeader())
						.equalsIgnoreCase("FORCED LABOR AND HUMAN TRAFFICKING POLICY")) {

					logger.log(Status.INFO, "Supply Chain Act link is available");
				}

			} else if (link.equalsIgnoreCase("CAREERS")) {

				driver.findElement(By.xpath("//div[@id='aboutBlock']/div/following::ul[1]/li[" + i + "]")).click();

				if (getText(home.getCareersHeader()).equalsIgnoreCase("ENVISION YOUR FUTURE WITH A CAREER AT TUMI")) {

					logger.log(Status.INFO, "Careers responsibility link is available");
				}
			} else {

				Assert.fail("Tumi Differnce redirection unsuccess");
			}
		}
	}

	@Test(priority = 10, description = "TA-310 Verify Corporate Responsibility")
	public void verifyCorporateResponsibility() {

		click(home.getCorporateResponsibility(), "Corporate Responsibility");

		try {
			if (getText(home.getCorporateResponsibilityHeader())
					.equalsIgnoreCase("COMMUNITY ENGAGEMENT & CORPORATE GIVING")) {

				click(home.getExploreCareers(), "Explore Careers");

				if (!getText(home.getCareersHeader()).equalsIgnoreCase("ENVISION YOUR FUTURE WITH A CAREER AT TUMI")) {

					Assert.fail("Corporate Responsibility redirection unsuccessful");
				}
			}
		} catch (Exception e) {
			Assert.fail("Corporate Responsibility is not available "+driver.getCurrentUrl());
		}
	}

	@Test(priority = 11, description = "TA-311 Verify California Transparency in Supply Chain Act")
	public void verifyCaliforniaTransparencyInSupplyChainAct() {

		click(home.getSupplyChainAct(), "California Transparency In Supply ChainAct");

		try {
			if (!getText(home.getSupplyChainHeader()).equalsIgnoreCase("FORCED LABOR AND HUMAN TRAFFICKING POLICY")) {

				Assert.fail("California TransparencyIn Supply Chain Act redirection unsuccessful");
			}
		} catch (Exception e) {
			Assert.fail("California TransparencyIn Supply Chain Act is not available "+driver.getCurrentUrl());
		}

	}

	@Test(priority = 12, description = "TA-314 Verify Careers")
	public void verifyCareers() {

		click(home.getCareers(), "Careers");

		if (!getText(home.getCareersHeader()).equalsIgnoreCase("ENVISION YOUR FUTURE WITH A CAREER AT TUMI")) {

			Assert.fail("Careers redirection unsuccessful");
		}

	}

	@Test(priority = 13, description = "TA-315 Verify Corporate Contacts")
	public void verifyCorporateContacts() {

		click(home.getCorporateContacts(), "Corporate Contacts");

		for (int i = 1; i < home.getCorporateOfficeAddress().size(); i++) {

			String region = driver.findElement(By.xpath("//h3[@id='region'][" + i + "]")).getText();

			if (region.equalsIgnoreCase("UNITED STATES")) {

				logger.log(Status.INFO, "UnitedStates address is available");

			} else if (region.equalsIgnoreCase("CANADA")) {

				logger.log(Status.INFO, "Canada address is available");

			} else if (region.equalsIgnoreCase("EUROPE")) {

				logger.log(Status.INFO, "Europe address is available");

			} else if (region.equalsIgnoreCase("ASIA")) {

				logger.log(Status.INFO, "Asia address is available");

			} else {

				Assert.fail("Corporate Contacts is not available");

			}
		}
	}

	@Test(priority = 14, description = "TA-317 Verify Corporate Gifts & Incentives")
	public void VerifyCorporateGiftsIncentives() {

		click(home.getCorporateGiftsIncentives(), "Corporate Gifts Incentives");

		String tabName = driver.getTitle();

		if (tabName.equalsIgnoreCase("Tumi Corporate Gifts and Incentives")) {

			logger.log(Status.INFO, "Corporate Gifts Incentives redirection is success");
		}
	}

	@Test(priority = 15, description = "TA-297 Verify Replacement Parts")
	public void verifyReplacementParts() {

		click(home.getReplacementParts(), "Replacement Parts");

		click(home.getReplacementItem(), "Replacement Item");

		click(home.getQuickShopAddToCart(), "Add To Cart");

		click(minicart.getProceedCheckOut(), "Proceed to Checkout");

		click(mainCart.getProceedCart(), "Proceed to Checkout");

		input(home.getGuestEmail(), testData.get("EmailID"), "Guest Email Address");

		click(home.getContinueAsGuest(), "Continue as Guest");

		UIFunctions.addGuestDetails();

		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");

		click(shipMethod.getProceedToPayment(), "Proceed to Payment");

		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");

		UIFunctions.completeOrder();
	}

	@Test(priority = 16, description = "TA-300 Verify Gift Card/Services")
	public void verifyGiftCardServices() {

		click(home.getGiftCardSerivices(), "Gift Card Services");

		for (int i = 1; i <= home.getGiftCardValues().size(); i++) {

			WebElement value = driver.findElement(By.xpath("//ul[@id='giftCardAmountOptions']/li[" + i + "]"));
			value.click();
			addNextValue();
		}

		click(home.getMinicartButton(), "minicart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(home.getGuestEmail(), testData.get("EmailID"), "Guest Email Address");
		click(home.getContinueAsGuest(), "Continue as Guest");
		UIFunctions.addGuestDetails();

		domClick(shipping.getContinueShippingMethod(), "Contiue Shipping");

		click(shipMethod.getProceedToPayment(), "Proceed to Payment");

		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");

		UIFunctions.completeOrder();
	}

	// This method has been used in TA-300 Verify Gift Card/Services
	public static void addNextValue() {

		click(home.getGiftCardValuesAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");
		driver.switchTo().defaultContent();
	}

	@Test(priority = 17, description = "TA-321 SIGN UP FOR NEWSLETTER")
	public void verifySignUpForNewsLetter() {

		input(home.getSignUpForNewsLetterWithEmail(), testData.get("EmailID"), "SIGN UP FOR NEWSLETTER");

		if (home.getMessegeThrownl().isDisplayed()) {

			logger.log(Status.INFO, "SignUP with E-mail verification is success");
		}
	}

	@Test(priority = 18, description = "TA-321 SIGN UP FOR NEWSLETTER")
	public void verifyTumiLogo() {

		click(home.getTumiLogo(), "Tumi Logo");

		String tabName = driver.getTitle();

		if (tabName.equalsIgnoreCase("Luggage, Backpacks, Bags & More - TUMI US")) {

			logger.log(Status.INFO, "Homepage redirection is success");
		}
	}

}
