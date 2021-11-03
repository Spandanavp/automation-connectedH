package com.connectedh.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.connectedh.pages.ConnectedHLoginPage;
import com.connectedh.pages.VisualComparisionPage;
import com.connectedh.vo.MobileConfigurationVO;

public class ConnectedHLoginTest extends BaseConnectedHAutomationTest {

	public static final Logger logger = Logger.getLogger(ConnectedHLoginTest.class.getName());

	ConnectedHLoginPage loginPage = null;
	
	VisualComparisionPage visualComparision = null;

	@BeforeClass
	@Parameters({ "deviceName", "udid", "platformName", "platformVersion" })
	public void initClass(String deviceName, String udid, String platformName, String platformVersion)
			throws Exception {

		logger.info("Starting of initClass method");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(deviceName, udid, platformName,
				platformVersion);

		this.initMobileDriver(mobileConfigurationVO);

		this.loginPage = new ConnectedHLoginPage(this.getMobileDriver(udid));
		
		this.visualComparision = new VisualComparisionPage(driver);

		logger.info("Ending of initClass method");

	}

	@Parameters({ "deviceName", "udid" })
	@Test(priority = 1, description = "Launch Application")
	public void launchApplication(String deviceName, String udid) {

		logger.info("Starting of launchApplication method");

		try {
			loginPage.clickOnAllow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		loginPage.visualComparisionOfLoginScreen(SCREEN_ID.LOGIN_SCREEN, deviceName);

		logger.info("Ending of launchApplication method");

	}

	@Test(priority = 2, description = "Launch Application")
	public void clickOnNewBookingTest() {

		logger.info("Starting of clickOnNewBookingTest method");

		loginPage.clickOnNewBooking();

		logger.info("Ending of clickOnNewBookingTest method");
	}

	@Test(priority = 3, description = "Launch Application")
	public void clickOnNewPhoneNumberTest() {

		logger.info("Starting of clickOnNewPhoneNumberTest method");

		loginPage.clickOnPhoneNumber(testDataProp.getProperty("pPhone"), testDataProp.getProperty("aPhone"));

		logger.info("Ending of clickOnNewPhoneNumberTest method");
	}

	@Test(priority = 4, description = "Launch Application")
	public void clickOnNameTest() {

		logger.info("Starting of clickOnNameTest method");

		loginPage.clickOnName(testDataProp.getProperty("pname"));

		logger.info("Ending of clickOnNameTest method");
	}

	@Test(priority = 5, description = "Launch Application")
	public void clickOnGenderTest() {

		logger.info("Starting of clickOnGenderTest method");

		loginPage.clickOnGender();

		logger.info("Ending of clickOnGenderTest method");
	}

	@Test(priority = 6, description = "Launch Application")
	public void clickOnDOBTest() {

		logger.info("Starting of clickOnDOBTest method");

		loginPage.clickOnDOB(testDataProp.getProperty("date"));

		logger.info("Ending of clickOnDOBTest method");
	}

	@Test(priority = 7, description = "Launch Application")
	public void collDateAndTimeTest() {

		logger.info("Starting of collDateAndTimeTest method");

		loginPage.collDateAndTime(testDataProp.getProperty("collDate"), testDataProp.getProperty("hourValue"),
				testDataProp.getProperty("minValue"));

		logger.info("Ending of collDateAndTimeTest method");
	}

	@Test(priority = 8, description = "Launch Application")
	public void clickOnAddressTest() throws InterruptedException {

		logger.info("Starting of clickOnAddressTest method");

		loginPage.clickOnAddress(testDataProp.getProperty("pAddress"));

		logger.info("Ending of clickOnAddressTest method");
	}

	@Test(priority = 9, description = "Launch Application")
	public void clickOnMapAddressTest() throws InterruptedException {

		logger.info("Starting of clickOnMapAddressTest method");

		loginPage.clickOnMapAddress(testDataProp.getProperty("pAddress"));

		logger.info("Ending of clickOnMapAddressTest method");
	}

	@Test(priority = 10, description = "Launch Application")
	public void clickOnAttachmentTest() {

		logger.info("Starting of clickOnAttachmentTest method");

		loginPage.clickOnAttachment();

		logger.info("Ending of clickOnAttachmentTest method");
	}

	@Test(priority = 11, description = "Launch Application")
	public void clickOnCommentsTest() throws InterruptedException {

		logger.info("Starting of clickOnCommentsTest method");

		loginPage.clickOnComments(testDataProp.getProperty("commentValue"));

		logger.info("Ending of clickOnCommentsTest method");
	}

	@Test(priority = 12, description = "Launch Application")
	public void clickOnDoneTest() {

		logger.info("Starting of clickOnDoneTest method");

		loginPage.clickOnDone();

		logger.info("Ending of clickOnDoneTest method");
	}
	
	@Parameters({ "expected", "deviceName", "udid", "screenId" })

	@Test(priority = 13, description = "Login screen visual testcomparision")
	public void loginVisualTest(double expected, String deviceName, String udid,

			@Optional("LOGIN_SCREEN") String screenId) throws Exception {

		logger.info("Starting of loginVisualTest method");

		visualComparision.visualComparision(SCREEN_ID.LOGIN_SCREEN, deviceName);

		double actual = visualComparision.visualDifference(SCREEN_ID.LOGIN_SCREEN, deviceName);

		if (actual < expected) {
			actual = expected;
		}

		Assert.assertEquals(actual, expected);

		logger.info("Ending of loginVisualTest method");
	}

}
