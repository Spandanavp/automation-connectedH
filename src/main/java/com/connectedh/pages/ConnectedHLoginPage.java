package com.connectedh.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ConnectedHLoginPage extends BaseConnectedHAutomationPage {

	// private By location = By.xpath("//android.widget.Button[@text = 'ALLOW ONLY
	// WHILE USING THE APP']");

	private By allow = By.xpath("//android.widget.Button[@text = 'ALLOW ONLY WHILE USING THE APP']");

	private By newBooking = By.xpath("//android.widget.TextView[@text = 'New Booking']");

	private By enterMobileNumber = By.xpath("//android.view.ViewGroup[1]/android.widget.EditText");

	private By enterAlternateMobileNumber = By.xpath("//android.view.ViewGroup[2]/android.widget.EditText");

	private By name = By.xpath("//android.view.ViewGroup[3]/android.widget.EditText");

	private By clickGender = By.xpath("//android.widget.TextView[@text = 'Male']");

	private By selectGender = By.xpath("//android.widget.CheckedTextView[@text = 'Female']");

	private By clickDate = By.xpath("//android.view.ViewGroup[5]");

	private By ok = By.xpath("//android.widget.Button[@text = 'OK']");

	private By collDateClick = By.xpath("//android.view.ViewGroup[6]");

	private By clearMapAddress = By.xpath("//android.view.ViewGroup[2]/android.widget.TextView");

	private By toggle = By.id("android:id/toggle_mode");

	private By hour = By.id("android:id/input_hour");

	private By minute = By.id("android:id/input_minute");

	private By address = By.xpath("//android.widget.EditText");

	private By mapSearch = By.xpath("//android.widget.TextView[@text = 'Search on Map']");

	private By searchPlaces = By.xpath("//android.widget.EditText[@text = 'Search Places']");

	private By selectMapAddress = By.xpath(
			"//android.widget.TextView[@text = 'Narayana Junior College, Sanjeeva Reddy Nagar, Hyderabad, Telangana, India']");

	private By done = By.xpath("//android.widget.TextView[@text = 'Done']");

	private By mapBack = By.xpath(
			"//android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]");
	// private By mapBack =
	// By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]");

	private By clickAtt = By.xpath("//android.widget.TextView[@text = 'Attach prescription']");

	private By clickFile = By.xpath("//android.widget.TextView[@text = 'File Manager']");

	private By selectFile = By.xpath(
			"//android.widget.FrameLayout[1]/com.google.android.material.card.MaterialCardView[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.ImageView[1]");

	private By comments = By.xpath("//android.widget.EditText[@text = 'Add your comment']");

	//private By errorText = By.id("android:id/title_template");

	private By permissionAllowButton = By.xpath("//android.widget.Button[@text = 'ALLOW']");

	//private By errorTestMessage = By.xpath("//android.widget.TextView[@text = 'Atleast one test is required']");
	
	// android.widget.TextView[@text = 'Done']

	public MobileElement scrollEle = null;

	private static final Logger logger = Logger.getLogger(ConnectedHLoginPage.class.getName());

	public ConnectedHLoginPage(AppiumDriver<MobileElement> driver) {

		super(driver);

		visualComparision = new VisualComparisionPage(driver);
	}

	public void clickOnAllow() throws InterruptedException {

		logger.info("Starting of clickOnAllow method");

		sleep(3000);

		driver.findElement(allow).click();

		logger.info("Ending of clickOnAllow method");

	}

	public void visualComparisionOfLoginScreen(Enum<?> SCREEN_ID, String pDeviceName) {
		logger.info("Starting of visualComparisionOfLoginScreen method");

		sleep(3000);

		visualComparision.takeScreenShot(SCREEN_ID, pDeviceName);

		logger.info("Ending of visualComparisionOfLoginScreen method");

	}

	public void clickOnNewBooking() {

		logger.info("Starting of clickOnNewBooking method");

		sleep(2000);

		driver.findElement(newBooking).click();

		logger.info("Ending of clickOnNewBooking method");

	}

	public void clickOnPhoneNumber(String pPhone, String aPhone) {

		logger.info("Starting of clickOnPhoneNumber method");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(enterMobileNumber).sendKeys(pPhone);

		sleep(2000);

		driver.findElement(enterAlternateMobileNumber).sendKeys(aPhone);

		logger.info("Ending of clickOnPhoneNumber method");

	}

	public void clickOnName(String pName) {

		logger.info("Starting of clickOnName method");

		sleep(2000);

		driver.findElement(name).sendKeys(pName);

		driver.hideKeyboard();

		logger.info("Ending of clickOnName method");

	}

	public void clickOnGender() {

		logger.info("Starting of clickOnGender method");

		sleep(2000);

		driver.findElement(clickGender).click();

		sleep(2000);

		driver.findElement(selectGender).click();

		logger.info("Ending of clickOnGender method");

	}

	public void clickOnDOB(String dateValue) {

		logger.info("Starting of clickOnDOB method");

		sleep(2000);

		driver.findElement(clickDate).click();

		sleep(2000);

		WebElement date = driver.findElement(By.xpath("//android.view.View[@content-desc = '" + dateValue + "']"));

		date.click();

		sleep(2000);

		driver.findElement(ok).click();

		// private By selectDate = By.xpath("//android.view.View[@content-desc = '26
		// October 2021']");

		logger.info("Ending of clickOnDOB method");

	}

	public void collDateAndTime(String collDate, String hourValue, String minValue) {

		logger.info("Starting of collDateAndTime method");

		driver.findElement(collDateClick).click();

		sleep(2000);

		WebElement colldate = driver.findElement(By.xpath("//android.view.View['" + collDate + "']"));

		colldate.click();

		sleep(2000);

		// private By collDateSelect = By.xpath("//android.view.View[@content-desc = '26
		// October 2021']");

		driver.findElement(ok).click();

		sleep(2000);

		driver.findElement(toggle).click();

		sleep(2000);

		driver.findElement(hour).sendKeys(hourValue);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.findElement(minute).sendKeys(minValue);

		sleep(2000);

		driver.findElement(ok).click();

		// Need to Implement Scroll Here

		logger.info("Ending of collDateAndTime method");

	}

	public void clickOnAddress(String pAddress) throws InterruptedException {

		logger.info("Starting of clickOnAddress method");

		Thread.sleep(2000);

		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;

		int endX = startX;

		int startY = (int) (size.height * 0.7);

		int endY = (int) (size.height * 0.2);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		driver.findElement(address).sendKeys(pAddress);

		driver.hideKeyboard();

		logger.info("Ending of clickOnAddress method");

	}

	public void clickOnMapAddress(String pAddress) {

		logger.info("Starting of clickOnMapAddress method");

		driver.findElement(mapSearch).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}

		driver.findElement(clearMapAddress).click();

		driver.findElement(searchPlaces).sendKeys(pAddress);

		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, 45);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//android.widget.TextView[@text = 'Narayana Junior College, Sanjeeva Reddy Nagar, Hyderabad, Telangana, India']")));
		driver.findElement(selectMapAddress).click();

		try {
			driver.findElement(mapBack).click();
		} catch (Exception e) {
			driver.findElement(done).click();
		}

		logger.info("Ending of clickOnMapAddress method");

	}

	public void clickOnAttachment() {
		logger.info("Starting of clickOnAttachment Method");

		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;

		int endX = startX;

		int startY = (int) (size.height * 0.7);

		int endY = (int) (size.height * 0.2);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		driver.findElement(clickAtt).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(clickFile).click();

		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text = 'ALLOW']")));

		if (driver.findElement(permissionAllowButton).isDisplayed()) {
			driver.findElement(permissionAllowButton).click();
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(selectFile).click();
		
		logger.info("Ending of clickOnAttachment Method");

	}

	public void clickOnComments(String commentValue) {

		logger.info("Starting of clickOnComments method");
		
		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;

		int endX = startX;

		int startY = (int) (size.height * 0.7);

		int endY = (int) (size.height * 0.2);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		driver.findElement(comments).sendKeys(commentValue);

		driver.hideKeyboard();

		logger.info("Ending of clickOnComments method");

	}

	public void clickOnDone() {

		logger.info("Starting of clickOnComments method");

		driver.findElement(done).click();

		logger.info("Ending of clickOnComments method");

	}

}
