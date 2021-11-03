package com.connectedh.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import com.connectedh.test.BaseConnectedHAutomationTest;
import com.connectedh.vo.MobileConfigurationVO;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseConnectedHAutomationTest {
private static final Logger logger = Logger.getLogger(BaseConnectedHAutomationTest.class.getName());
	
	protected static AppiumDriver<MobileElement> driver = null;
	
	protected static Map<String, AppiumDriver<MobileElement>> driversMap = new HashMap<String, AppiumDriver<MobileElement>>();
	
	protected static Properties testDataProp = null;
	
	protected static Properties expectedAssertionsProp = null;
	
	public enum SCREEN_ID {
		
		LOGIN_SCREEN	
		}

	@BeforeSuite
	public void initTestData() {

		if (testDataProp == null) {
			FileReader testDataReader = null;
			FileReader assertionsReader = null;
			try {
				testDataReader = new FileReader("src/main/resources/testdata.properties");
				assertionsReader = new FileReader("src/main/resources/expectedassertions.properties");

				testDataProp = new Properties();
				testDataProp.load(testDataReader);

				expectedAssertionsProp = new Properties();
				expectedAssertionsProp.load(assertionsReader);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					testDataReader.close();
					assertionsReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	protected synchronized void initMobileDriver(MobileConfigurationVO mobileConfigurationVO) {
		
		logger.info("Starting of method initMobileDriver");
		
		AppiumDriver<MobileElement> driver = null;
		
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", mobileConfigurationVO.getDeviceName());
		
		cap.setCapability("udid", mobileConfigurationVO.getUdId());
		
		cap.setCapability("platformName", mobileConfigurationVO.getPlatformName());
		
		cap.setCapability("platformVersion", mobileConfigurationVO.getPlatformVersion());
		
		cap.setCapability("appPackage", "com.phlebo.android");
		
		cap.setCapability("appActivity", "com.phlebo.android.MainActivity");
		
		driver = new AppiumDriver<MobileElement>(cap);
		
		driversMap.put(mobileConfigurationVO.getUdId(), driver);
		
		logger.info("Ending of method initMobileDriver");
		
	}

	protected synchronized AppiumDriver<MobileElement> getMobileDriver(String driverKey) throws Exception {
		
		logger.info("Starting of method getMobileDriver");
		
		AppiumDriver<MobileElement> driver = null;

		driver = (AppiumDriver<MobileElement>) driversMap.get(driverKey);

		// Use existing driver
		if (driver == null) {
			
			logger.error("Driver not initialized, Please call initDriver Method. Before calling getDriver ");
			
			throw new Exception("Drivier not initialized");
			// driver = initMobileDriver();
		}

		// Otherwise create new driver
		logger.info("Ending of method getMobileDriver");
		
		return driver;
		
	}

	protected synchronized void quitMobileDriver(String driverKey) {
		
		logger.info("Starting of method quitDriver in BaseInstallationProcessTest ");
		
		AppiumDriver<MobileElement> driver = null;
		
		driver = (AppiumDriver<MobileElement>) driversMap.get(driverKey);
		
		try {
			
			if (driver != null) {
				
				driver.quit();
				
				driver = null;

			}
			
		} catch (Exception ex) {
			
			logger.error(ex.getMessage());
			
			driver = null;
			
		}
		
		logger.info("Ending of method quitDriver in BaseInstallationProcessTest");
	}
	
	public void resetApp() {
		
		driver.resetApp();
		
	}
}
