package hooks;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ReadExcelForDataProvider;
import wrappers.BaseDriver;

public class TestNGHooks extends BaseDriver {
	
	@BeforeSuite
	public void init() {
	// Start Reporting	
	}
	
	@BeforeTest
	public void setUpTests() {
		// Later, lets do it
	}
	
	@BeforeClass
	public void beforeClass() {
		// Later, lets do it
	}
	
	@BeforeMethod
	public void invoke() {
		// start the application
		startApp("chrome","http://leaftaps.com/opentaps/control/main");
	}
	
	@AfterMethod
	public void close() {
		//close the browser
		closeActiveBrowser();
	}
	
	@AfterClass
	public void afterClass() {
		// Later, lets do it
	}
	
	@AfterTest
	public void completeTests() {
		// Later, lets do it
	}
	
	@AfterSuite
	public void tearDown() {
		// Publish the report
	}
	
	@Before
	public void initBefore() {
		invoke();
	}
	
	@After
	public void afterclose() {
		close();
	}
	
	@DataProvider(name="FetchExcelData")
	public Object[][] readExcelData() {
		try {
			return ReadExcelForDataProvider.readExcelData("Create Lead");
		} catch (InvalidFormatException e) {
			System.err.println("The Excel is in invalid format. Looks corrupted");
		} catch (IOException e) {
			System.err.println("The file does not exist");
		}
		return null;
		
	}

}

