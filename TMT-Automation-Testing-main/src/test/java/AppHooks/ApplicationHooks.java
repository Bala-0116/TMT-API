package AppHooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.WebKeywordHelper;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public class ApplicationHooks extends WebKeywordHelper {

	private DriverFactory driverFactory;
	private static WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	public static Logger Log = LogManager.getLogger(ApplicationHooks.class);

	//

	public static String scenarioName;

	@Before
	public void beforeScenario(Scenario scenario) {
		if (prop.getProperty("IsScreenshotrequired").equalsIgnoreCase("true")) {
			scenarioName = scenario.getName();
			System.out.println("Scenario Name: " + scenarioName);

			// Custom directory name
			String customDirName = scenarioName;

			// Create a File object representing the directory
			File directory = new File("./FinalReport/" + customDirName);
			File directory2 = new File("./StaticReport");
			File Screenshot = new File("./FinalReport/" + customDirName + "/" + "Screenshots/");
//	WebKeywordHelper.PDFGenerator("./FinalReport/"+customDirName+"/" + "Screenshots/test_report.pdf");
			// Attempt to create the directory
			if (!directory.exists()) {
				if (directory.mkdirs()) {
					if (Screenshot.mkdirs()) {
						System.out.println("Directory created successfully for Screenshot!");
					}

					System.out.println("Directory created successfully!");
				} else {
					System.out.println("Failed to create directory.");
				}
			} else {
				System.out.println("Directory already exists.");
			}
			if (!directory2.exists()) {
				if (directory2.mkdirs()) {
					System.out.println("Directory created successfully for Static ReportSelvaa!");
				} else {
					System.out.println("Directory created successfully for Static ReportSelvaa");
				}
			} else {
				System.out.println("Directory already exists.");
			}

		}
	}
	public static String getScenarioName() {
		return scenarioName;
	}


	@Before(order = 0)

	public void getProperty() {

		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		Log.info("Browser initated and browser type: " + browserName);

	}


	@Before(order = 2)
	public void launchURL() {
		String URLName = prop.getProperty("URL");
		driver.get(URLName);
		Log.info("Launching url: " + URLName);
	}


	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
		Log.info("Closing the browser");

	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			Log.info("Scenario Failed: " + screenshotName);
		}
	}

	//	@AfterStep
//	public void afterStep(Scenario scenario) {
//		String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + System.currentTimeMillis();
//		WebKeywordHelper.captureScreenshot(driver, screenshotName);
//	}
	@After
	@Order(1)
	public void afterScenario(Scenario scenario) {
		if (prop.getProperty("IsScreenshotrequired").equalsIgnoreCase("true")) {
		PDFGenerator("./FinalReport/" + scenarioName + "/" + scenarioName + "test_report.pdf");
	}
		}

//	@After
//	@Order(2)
//	public static void JDKshutdown(Scenario scenario) {
//		scenarioName = scenario.getName();
////		System.out.println("Scenario Name: " + scenarioName);
//		System.out.println("testselva==0000000loopstart===");
////		WebKeywordHelper.PDFGenerator("./screenshots/test_report.pdf");
//		PDFGenerator("./FinalReport/" + scenarioName + "/" + scenarioName + "test_report.pdf");
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//
//			public void run() {
//				System.out.println("testselva=====");
//				System.out.println("Shutdown Selva Server down Hook is running !");
//
//
//				try {
//					EmailUtil();
//				} catch (InterruptedException e) {
//					throw new RuntimeException(e);
//				}
//
//			}
//		});
//		System.out.println("Application Terminating ...");
//
//
//	}


	public static void PDFGenerator(String pdfPath) {

		ConfigReader configReader;
		configReader = new ConfigReader();
		Properties prop = configReader.init_prop();
		if (prop.getProperty("IsScreenshotrequired").equalsIgnoreCase("true")) {
			Document document = new Document(PageSize.A4);
			Set<String> addedImages = new HashSet<>();
			try {
				PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(pdfPath)));
				document.open();
//				File folder = new File("./screenshots/");
				File folder = new File("./FinalReport/" + scenarioName + "/Screenshots/");


				File[] listOfFiles = folder.listFiles();
				System.out.println(listOfFiles + "Selvaaaaimagessssssssss");
				for (File file : listOfFiles) {
					if (file.isFile() && file.getName().endsWith(".png") && !addedImages.contains(file.getName())) {
						Image img = Image.getInstance(file.getAbsolutePath());
						img.scaleToFit(PageSize.A4.getWidth() - 20, PageSize.A4.getHeight() - 20);
						img.setAlignment(Image.ALIGN_CENTER);
						document.add(img);
						addedImages.add(file.getName());
					}
				}
				document.close();
				Thread.sleep(5000);
				System.out.println("Selva-Passsssssssssssssssssssssss");
			} catch (Exception e) {
				System.out.println("Selva-errr-rrrrrrrrrrrrrrrrrrrrrrrr" + e);
			}
		}


	}

}
	//@AfterSuite
//	public void afterAllScenarios() {
//		// Code to execute after all scenarios
//		System.out.println("All scenarios completed. Executing final condition.Selvaaatest");
//	}
//}

//	@AfterSuite


