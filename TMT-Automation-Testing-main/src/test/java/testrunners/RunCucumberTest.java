package testrunners;
import com.pages.TMTEventDetails;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.WebKeywordHelper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Properties;

import static com.qa.util.WebKeywordHelper.EmailUtil;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Feature"},
		glue = {"Stepdefinitions", "AppHooks"},
//		tags= "@Smoke",
		tags= "@buyerandseller",
//		tags="buyerandseller",
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
		}

)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
	WebKeywordHelper Webapp = new WebKeywordHelper();

	@BeforeClass
	public void DeletingTestresults()
	{
		Properties prop ;
		ConfigReader configReader;
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		if (prop.getProperty("IsScreenshotrequired").equalsIgnoreCase("true")) {
		Webapp.DeleteFolder();
	}
	}
	@AfterClass
	public void afterAllScenarios() throws InterruptedException {
		Thread.sleep(8000);
		Properties prop ;
		ConfigReader configReader;
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		if (prop.getProperty("IsScreenshotrequired").equalsIgnoreCase("true")) {
			String zipDirName = "./StaticReport/TestReports.zip";
			File dir = new File("./FinalReport");
			Webapp.zipDirectory(dir, zipDirName);
			System.out.println("Zipped files for scenario: Con");

			// Code to execute after all scenarios
			System.out.println("All scenarios completed. Executing final condition.Selvaaatest");
			Thread.sleep(5000);
			Runtime.getRuntime().addShutdownHook(new Thread() {

				public void run() {
					System.out.println("====Showdown initated=====");
					System.out.println("Shutdown Selva Server down Hook is running !");
                    try {
                        EmailUtil();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
			});
		}
//		EmailUtil();
	}
}
