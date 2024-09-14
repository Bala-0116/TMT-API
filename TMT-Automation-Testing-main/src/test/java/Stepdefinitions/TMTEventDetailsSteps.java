
package Stepdefinitions;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;

import java.time.Duration;
import java.util.List;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.pages.TMTEventDetails;
import com.qa.factory.DriverFactory;
import com.qa.util.WebKeywordHelper;


import AppHooks.ApplicationHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;

import static AppHooks.ApplicationHooks.scenarioName;

public class TMTEventDetailsSteps extends WebKeywordHelper {

	TMTEventDetails Eventdetail = new TMTEventDetails(DriverFactory.getDriver());
	public final Logger Log = LogManager.getLogger(TMTEventDetailsSteps.class);
	//
	WebDriver driver = DriverFactory.getDriver();

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@When("Login to Secondary Portal")
	public void Log_into_SecondaryPortal() throws InterruptedException {
        Thread.sleep(1000);
		Eventdetail.btnsignin.click();
		Thread.sleep(5000);
		Eventdetail.btncontinueTestlogin.click();
//		Log.info("Click on next page validation is Pass");
	}

	@Given("^Updating details on Whats your event about page Visibility:\"([^\"]*)\" and Eventtype:\"([^\"]*)\"$")
	public void Updating_Users_Details(String Visibility, String Eventtype) {

		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Eventdetail.btncreateevent.click();
		Eventdetail.txtEventName.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Eventdetail.txtEventName.sendKeys("HaveFun");
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis() + "_Updating_Users_Details_top", scenarioName);
		driver.findElement(By.xpath("//*[contains(text(),'" + Visibility + "')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'" + Eventtype + "')]")).click();
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis() + "_Updating_Users_Details_bottom", scenarioName);

		Log.info("Eventdetail page validation is pass");

	}


	@When("Click on next page")
	public void Navigatetonextpage() {

		Eventdetail.btnNexttab.click();

		Log.info("Click on next page validation is Pass");
	}

	@And("^Updating details on Whenandwhere page for Eventtype:\"([^\"]*)\" and location:\"([^\"]*)\"$")
	public void Whenandwhere(String Eventtype, String location) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Eventdetail.btnStartDate.click();
		selectDateandtime(driver, "FromDate", "yyyy-MM-dd HH:mm:00.0;month=0,day=5,year=0", "5:00 PM");
		Eventdetail.btnToDate.click();
		Thread.sleep(3000);
		selectDateandtime(driver, "ToDate", "yyyy-MM-dd HH:mm:00.0;month=0,day=6,year=0", "8:00 PM");
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis() + "_Updating_fromdate", scenarioName);

		Actions hover = new Actions(driver);
		hover.moveToElement(Eventdetail.txtEventLink).build().perform();
		if (Eventtype.equalsIgnoreCase("Online")) {
			if (location.equalsIgnoreCase("NA")) {

			}

			Eventdetail.txtEventLink.sendKeys("https://teams.meeting/019374");
			Eventdetail.txtMeetingid.click();
			Eventdetail.txtMeetingid.sendKeys("TMTTEAM01");
			Eventdetail.txtMeetingid.click();
			Eventdetail.txtpassword.sendKeys("TMTTEAM01");
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis() + "_Updating_foronlline", scenarioName);

			Log.info("Updating details on Whenandwhere page is Pass");
		} else if (Eventtype.equalsIgnoreCase("In person")) {

//		 js.executeScript("arguments[0].click();", Eventdetail.btnEnterlocationManually);
			if (location.equalsIgnoreCase("NotListed")) {
				Eventdetail.txtEventLink.sendKeys("Marina beach");
				js.executeScript("arguments[0].scrollIntoView(true);", Eventdetail.btnEnterlocationManually);
				Thread.sleep(3000);
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Eventdetail.btnEnterlocationManually.click();
				Thread.sleep(5000);
				driver.navigate().back();
				Thread.sleep(3000);
				js.executeScript("arguments[0].scrollIntoView(true);", Eventdetail.txtVenueName);
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Eventdetail.txtVenueName.sendKeys("The Little Gardens");
				Eventdetail.txtstreetline1.sendKeys("Rajaji street");
				Eventdetail.txtstreetline2.sendKeys("CPS Nagar");
				Eventdetail.txtcitytown.sendKeys("Guindy");

//		    	 Navigatetonextpage();

				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

			}
			if (location.equalsIgnoreCase("Listed")) {
				Eventdetail.txtEventLink.sendKeys("Marina beach");


				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis() + "Screenshot", scenarioName);

				js.executeScript("arguments[0].scrollIntoView(true);", Eventdetail.btnEnterlocationManually);
//				 js.executeScript("arguments[0].click();", Eventdetail.btnEnterlocationManually);	
				Thread.sleep(3000);
				Eventdetail.btnMarinabrachtextsuggestion.click();


				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

				Navigatetonextpage();
				Navigatetonextpage();
			}

		}
	}

	@And("Uploading Main Event Image")
	public void MainEventImage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String path = System.getProperty("user.dir");
		Eventdetail.btnfileupload.sendKeys(path + "\\src\\test\\resources\\Images\\images.jpg");
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Log.info("Uploading Main Event Image validation is Pass");
	}

	@And("Image Selection")
	public void ImageSelection() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Eventdetail.btnimageframedone.click();
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Log.info("Image Selection validation is Pass");
	}

	@And("Add Event Description")
	public void AddEventDescription() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Eventdetail.txtaddeventdesctption.sendKeys("Test Msg");
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Log.info("Add Event Description validation is Pass");
	}


	@And("Add Phone Number")
	public void AddPhoneNUmber() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Eventdetail.txtphonenumber.sendKeys("7200510995");
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Log.info("Add Phone Number validation is Pass");
	}


	@And("Fetch OTP")
	public void FetchOTP() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> otp = driver.findElements(By.xpath("//input[contains(@class,'otp-input')]"));
		String otpvalue = "123456";
		int i = 0;
		for (WebElement eachvalue : otp) {
			eachvalue.sendKeys(String.valueOf(otpvalue.charAt(i)));
			i++;
		}
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Eventdetail.btnotpsubmit.click();
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Log.info("Otp submitted successfully");
	}

	@And("^Lets Add tickets type as \"([^\"]*)\" and payer is \"([^\"]*)\" and Available for sale:\"([^\"]*)\"$")
	public void Letsaddtickets(String flowtype, String payer, String Avlforsale) {
		Eventdetail.btnAddtickets.click();
		switch (flowtype) {

			case "Free": {

				Eventdetail.btntickettype.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.findElement(By.xpath("//*[contains(@class,'menu-item flex items-center justify-between p-5') and(contains(text(),'" + flowtype + "'))]")).click();
				Eventdetail.txtaddticketdetailsname.sendKeys("TMT test");


				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

				Eventdetail.txttickettypequantity.sendKeys("10");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				WebElement slider = Eventdetail.btnsliderange;

				int minValue = Integer.parseInt(slider.getAttribute("min"));
				int maxValue = Integer.parseInt(slider.getAttribute("max"));

				Actions actions = new Actions(driver);

				// Assuming you want to set the slider to a specific value
				int desiredValue = 5; // Adjust this value as needed

				// Calculate the position to move the slider to
				double offset = (double) (desiredValue - minValue) / (maxValue - minValue);
				System.out.println("offsettvalue======" + offset);
				int sliderWidth = slider.getSize().getWidth();

				System.out.println("sliderwidth======" + sliderWidth);
//				WebKeywordHelper.captureScreenshot(driver, ""+System.currentTimeMillis(),scenarioName);
				// Move slider
				actions.clickAndHold(slider).moveByOffset((int) (sliderWidth * offset), 0).release().perform();
				System.out.println("finalvalue======" + sliderWidth * offset);
				Log.info("Add tickets steps completed before Advance settings step");
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);


				break;
			}
			case "Paid": {
				Eventdetail.btntickettype.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.findElement(By.xpath("//*[contains(@class,'menu-item flex items-center justify-between p-5') and(contains(text(),'" + flowtype + "'))]")).click();
				Eventdetail.txtaddticketdetailsname.sendKeys("TMT test");
//				WebKeywordHelper.captureScreenshot(driver, ""+System.currentTimeMillis(),scenarioName);
				Eventdetail.txttickettypequantity.sendKeys("10");
				Eventdetail.txttickettypeprice.sendKeys("100");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				WebElement slider = Eventdetail.btnsliderange;
				int minValue = Integer.parseInt(slider.getAttribute("min"));
				int maxValue = Integer.parseInt(slider.getAttribute("max"));
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Actions actions = new Actions(driver);

				// Assuming you want to set the slider to a specific value
				int desiredValue = 5; // Adjust this value as needed

				// Calculate the position to move the slider to
				double offset = (double) (desiredValue - minValue) / (maxValue - minValue);
				System.out.println("offsettvalue======" + offset);
				int sliderWidth = slider.getSize().getWidth();
//				WebKeywordHelper.captureScreenshot(driver, ""+System.currentTimeMillis(),scenarioName);
				System.out.println("sliderwidth======" + sliderWidth);
				// Move slider
				actions.clickAndHold(slider).moveByOffset((int) (sliderWidth * offset), 0).release().perform();
				System.out.println("finalvalue======" + sliderWidth * offset);
				Log.info("Add tickets steps completed before Advance settings step");
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Eventdetail.btnAdvancesettings.click();
				Log.info("Advance settings step initiated");
				if (payer.equalsIgnoreCase("ME")) {
					Eventdetail.btnAdvancesettingsmewillpay.click();
//				Eventdetail.btnAdvancesettingsdescription.sendKeys("Nanae pay panren:)");
					Eventdetail.btnviewbreakup.click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					Eventdetail.btnokaygotit.click();

//				WebKeywordHelper.captureScreenshot(driver, ""+System.currentTimeMillis(),scenarioName);
//				Eventdetail.btnAdvancesettingsdescription.sendKeys("Nanae pay panren:)");
					Eventdetail.btnviewbreakup.click();
//				WebKeywordHelper.captureScreenshot(driver, ""+System.currentTimeMillis(),scenarioName);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
					Eventdetail.btnokaygotit.click();


					Log.info("Advance settings step completed for payer" + payer);
				} else if (payer.equalsIgnoreCase("Buyer")) {
					Eventdetail.btnAdvancesettingsmewillpay.click();

//				Eventdetail.btnAdvancesettingsdescription.sendKeys("Buyer will pay");
					Eventdetail.btnviewbreakup.click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

					WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
//				Eventdetail.btnAdvancesettingsdescription.sendKeys("Buyer will pay");
					Eventdetail.btnviewbreakup.click();
//				WebKeywordHelper.captureScreenshot(driver, ""+System.currentTimeMillis(),scenarioName);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

					Eventdetail.btnokaygotit.click();

					Log.info("Advance settings step completed for payer" + payer);
				}
				break;
			}

		}

		Eventdetail.btnsaveticketdetail.click();

		if (Avlforsale.equalsIgnoreCase("Yes")) {
			Eventdetail.btnavailableforsale.click();
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

		}

		//Advance settings
		Log.info("Ticket added successfully");
	}


	@And("^Get to know your Audience-Questiontype:\"([^\"]*)\" and listtype \"([^\"]*)\"$")
	public void Gettoknowaudiance(String questiontype, String dropdowntype) throws InterruptedException {


		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Eventdetail.btnAddquestion.click();
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);


		if (questiontype.equals("Email")) {
			Eventdetail.btnaddquestionlist.click();
			Eventdetail.lstquestiontype.click();

			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
			if (dropdowntype.equals("Dropdown")) {
				WebElement fieldvalue = driver.findElement(By.xpath("//div[contains(text(),'" + dropdowntype + "')]/."));
				fieldvalue.click();
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

			} else {
				System.out.println("given input isIncorrect field value");
			}
			Eventdetail.btnEmailoption.click();
			Eventdetail.chkshowquestionforspecficticketstype.click();
			Eventdetail.selectspecificticket.click();
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
			Eventdetail.chkAllowspecificMailIDspurchasetickets.click();
			Eventdetail.btnaddmailid.click();
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
			Eventdetail.txtinputvalueid.sendKeys("Aforapple.com");
			Eventdetail.btndeletefield.click();
			Eventdetail.btnaddmailid.click();
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
			Eventdetail.txtinputvalueid.sendKeys("Aforapple.com");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", Eventdetail.btnsaveaddquestion);
			js.executeScript("arguments[0].click();", Eventdetail.btnsaveaddquestion);
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);


			Log.info("Get to know ypur audiance page is Pass");
		} else if (questiontype.equalsIgnoreCase("New")) {

			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
			Eventdetail.txtaddnewquestion.sendKeys("Nationality");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			   WebKeywordHelper.captureScreenshot(driver, ""+System.currentTimeMillis(),scenarioName);
			Eventdetail.btnaskanewquestion.click();
//			   WebKeywordHelper.captureScreenshot(driver, ""+System.currentTimeMillis(),scenarioName);
			Eventdetail.lstquestiontype.click();
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

			if (dropdowntype.equals("Dropdown")) {
				WebElement fieldvalue = driver.findElement(By.xpath("//div[contains(text(),'" + dropdowntype + "')]/."));
				fieldvalue.click();
			} else {
				System.out.println("given input isIncorrect field value");
			}
			Eventdetail.chkshowquestionforspecficticketstype.click();
			Eventdetail.selectspecificticket.click();


			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);


			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
			Eventdetail.btnaddoption.click();
			String Nat1 = "Indian";
			Eventdetail.txtinputvalueid.sendKeys(Nat1);

			Eventdetail.btnaddoption.click();
//			   WebKeywordHelper.captureScreenshot(driver, ""+System.currentTimeMillis(),scenarioName);
			String Nat2 = "Russian";
			Eventdetail.txtinputvalueid2.sendKeys(Nat2);
			Eventdetail.btnaddoption.click();
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
			String Nat3 = "American";
			Eventdetail.txtinputvalueid3.sendKeys(Nat3);
			// Add a conditional sub-question
			Thread.sleep(3000);
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
			Eventdetail.btncondtionalsubquestion1.click();
			Eventdetail.lstcondtionalsubquestiondropdown1.click();
			driver.findElement(By.xpath("//*[contains(text(),'" + Nat1 + "')]")).click();
			Eventdetail.txtcondtionalsubquestionquestion1.sendKeys("Do you know about chennai?");
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
			Eventdetail.lstdropdownfield1.click();
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
			Eventdetail.lstdropdownshorttext1.click();
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

			js.executeScript("arguments[0].scrollIntoView(true);", Eventdetail.btnsaveaddquestion);
			js.executeScript("arguments[0].click();", Eventdetail.btnsaveaddquestion);
			WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

			Eventdetail.btnavailableforsale.click();

			Log.info("Get to know ypur audiance page is Pass");
		}
	}


	@And("^Identity verificationtype:\"([^\"]*)\"$")
	public void Identityverification(String Registrationtype) throws InterruptedException {

		switch (Registrationtype) {
			case "Not-Registered": {


				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				Eventdetail.btnradionotRegistered.click();
				Eventdetail.txtnotregisteredname.sendKeys("TMT testing Team");
				Eventdetail.txtnotRegisteredAddress.sendKeys("No.2, Rajaji street,vpg avenue,chennai,600003");
				Eventdetail.txtnotRegisteredAadharnumber.sendKeys("222244446666");
				JavascriptExecutor js = (JavascriptExecutor) driver;


				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				js.executeScript("arguments[0].scrollIntoView(true);", Eventdetail.btnmainuploadaadhar);
				js.executeScript("arguments[0].click();", Eventdetail.btnmainuploadaadhar);
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

//	    		   Eventdetail.btnmainuploadaadhar.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				String path = System.getProperty("user.dir");
				Eventdetail.btnAaadharfrontend.sendKeys(path + "\\src\\test\\resources\\Images\\Aadharfront.jpg");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Eventdetail.btnAaadharbackendend.sendKeys(path + "\\src\\test\\resources\\Images\\Aadharbackside.jpg");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Eventdetail.btnsubmit.click();
				Eventdetail.chkAcknowledge.click();
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Eventdetail.btnpublishevent.click();
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Eventdetail.btnconfirmevent.click();
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);


				break;
			}

			case "Registered": {


				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				Eventdetail.btnradioRegistered.click();
				Eventdetail.txtregisteredname.sendKeys("TMT testing Team");
				Eventdetail.txtnotRegisteredAddress.sendKeys("No.2, Rajaji street,vpg avenue,chennai,600003");


				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);

				Eventdetail.btnStatedropdown.click();
				Eventdetail.lstchattisgarh.click();
				Eventdetail.txtpannumber.sendKeys("LAMPS0000M");
				Eventdetail.txtGSTRegisterednumber.sendKeys("AAAAA0000A1Z5");


				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Eventdetail.btnuploadmainGSTcertificate.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				String path = System.getProperty("user.dir");
				Eventdetail.btnuploadgstfile.sendKeys(path + "\\src\\test\\resources\\Images\\GSTRegistrationCertificate.jpg");
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Eventdetail.btnsubmit.click();
				Eventdetail.chkAcknowledge.click();
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Eventdetail.btnpublishevent.click();
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Eventdetail.btnconfirmevent.click();
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);


			}
		}
	}


	@And("^Validate Event submitted confirmation$")
	public void Eventsubmittedverification() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String Eventmsg = Eventdetail.lbleventsuccessfulmsg.getText();
		String Eventteammsg = Eventdetail.lbleventsuccessfulintimationmsg.getText();
		Assert.assertEquals(Eventmsg, "Your event has been successfully submitted for review!");
		Assert.assertEquals(Eventteammsg, "Our team will notify you by mail within 60 mins once the event is made live.");
		Eventdetail.btngotit.click();
	}

	@Given("^Select\"([^\"]*)\" City$")
	public void Selectcity(String City) throws InterruptedException {

		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Thread.sleep(5000);

		Eventdetail.btnselectcity.click();
		WebElement city = driver.findElement(By.xpath("//*[contains(text(),'" + City + "')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", city);
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		city.click();

	}
	@And("^Select event name:\"([^\"]*)\" using \"([^\"]*)\" flow$")
	public void Selecteventname(String Eventname , String Flow) throws Exception {
		switch(Flow) {
			case "First": {
				Thread.sleep(3000);
				Eventdetail.txtsrchbyeventlandingpage.click();
				Eventdetail.txtsrchbyevent.sendKeys(Eventname);
				Thread.sleep(5000);
				Eventdetail.lstsuggestionitem.click();
				Thread.sleep(5000);
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				break;
			}

			case "Second":{
				Thread.sleep(3000);
				js.executeScript("arguments[0].scrollIntoView(true);", Eventdetail.sellticketsnow);
				js.executeScript("arguments[0].click();", Eventdetail.sellticketsnow);
				Eventdetail.txtsrchbyevent.sendKeys(Eventname);
				Thread.sleep(5000);
				Eventdetail.lstsuggestionitem2.click();
				Thread.sleep(5000);
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				break;
			}
		}
	}



	@And("^Navigate to Sell your tickets quickly and select platform type \"([^\"]*)\" and using \"([^\"]*)\" flow$")
	public void Sellyourticketsquickly(String Platform, String flow) throws Exception {
		switch (flow) {

			case "First": {
				js.executeScript("arguments[0].scrollIntoView(true);", Eventdetail.btnticetsalert);
				Thread.sleep(5000);
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				js.executeScript("arguments[0].click();", Eventdetail.btnticetsalert);
				Thread.sleep(5000);
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				js.executeScript("arguments[0].click();", Eventdetail.btnticetsalert);

				js.executeScript("arguments[0].scrollIntoView(true);", Eventdetail.btnselltickets);
				Thread.sleep(5000);
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				js.executeScript("arguments[0].click();", Eventdetail.btnselltickets);
				Navigatetonextpage();Navigatetonextpage();
				//BookMyShow/   Paytm Insider
				driver.findElement(By.xpath("//*[contains(text(),'" + Platform + "')]")).click();
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
			break;
			}
			case "Second":
			{
				Navigatetonextpage();
				Thread.sleep(5000);
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				Navigatetonextpage();
				Thread.sleep(5000);
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				//BookMyShow/   Paytm Insider
				driver.findElement(By.xpath("//*[contains(text(),'" + Platform + "')]")).click();
				Thread.sleep(5000);
				WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
				break;
			}
		}
	}
	@And("^Verifying Ticket$")
	public void VerifyingTicket() throws Exception {
		Thread.sleep(15000);
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
	}




	@And("^Forwarding Tickets$")
	public void Forwardingtickets() throws Exception {
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Thread.sleep(3000);
		Eventdetail.btnforwdedmytickets.click();

	}

	@And("^Price your Tickets based on  ticket count:\"([^\"]*)\" and ticket per ticket price:\"([^\"]*)\"$")
	public void Priceyourtickets(String count, String price) throws Exception {
		Eventdetail.lstticketcounttosell.click();

		driver.findElement(By.xpath("//*[contains(@class,'menu-item flex items-center justify-between p-5') and contains(text(),'"+count+"')]")).click();
		Eventdetail.txtpriceperticket.sendKeys(price);
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Navigatetonextpage();
//       Eventdetail.txtwhatsappnumber.sendKeys("9876543210");

		Eventdetail.chksellAckge.click();
		Eventdetail.btnlstmytickets.click();

	}

	@And("^My Listings$")
	public void MyListings() throws Exception {
		Thread.sleep(5000);
		Eventdetail.btnViewmylisting.click();
		Thread.sleep(5000);
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		//*[contains(@class,'menu-item flex items-center justify-between p-5') and contains(text(),'5')]
	}

	@And("^Update List price per ticket:\"([^\"]*)\" and ticket count:\"([^\"]*)\"$")
	public void EditListings(String ticketprice, String count) throws Exception {
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Eventdetail.btnEditlist.click();
		Eventdetail.txtticketprice.clear();
		Eventdetail.txtticketprice.sendKeys(ticketprice);
		Thread.sleep(1000);
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Eventdetail.btndropdownselectlist.click();
		driver.findElement(By.xpath("//*[contains(@class,'menu-item flex items-center justify-between p-5') and contains(text(),'" + count + "')]")).click();
		Eventdetail.btnUpdateList.click();
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
        Thread.sleep(3000);
		Eventdetail.btnmarkassold.click();
		Thread.sleep(5000);
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Eventdetail.btnmarkassoldpopup.click();
		Thread.sleep(5000);
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
	}


	@And("^Buying ticket$")
	public void Buyerflow() throws Exception {
		js.executeScript("arguments[0].scrollIntoView(true);", Eventdetail.btnselectticketselectioninevent);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", Eventdetail.btnselectticketselectioninevent);
		Thread.sleep(2000);
		Assert.assertTrue(Eventdetail.lstSortby.isEnabled());
		Eventdetail.btnselecttickettosell.click();
		Eventdetail.btnwhatsappgetintouch.click();
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Eventdetail.btnakckgesaynotoscreenshot.click();
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		Eventdetail.btngetintouchafterackge.click();
		WebKeywordHelper.captureScreenshot(driver, "" + System.currentTimeMillis(), scenarioName);
		//*[contains(@class,'menu-item flex items-center justify-between p-5') and contains(text(),'5')]
	}

}
