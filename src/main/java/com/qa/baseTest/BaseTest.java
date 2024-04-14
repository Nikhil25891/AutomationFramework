package com.qa.baseTest;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpExtentReport() 
	{
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"NikhilExtentReport.html");
		extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    sparkReporter.config().setTheme(Theme.DARK);
	    extent.setSystemInfo("HostName", "RHEL8");
	    extent.setSystemInfo("UserName", "Nikhil");
	    sparkReporter.config().setDocumentTitle("Automation Report");
	    sparkReporter.config().setReportName("Automation Test Results by Nikhil Chandane");
	}

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser, Method testMethod) 
	{
		logger = extent.createTest(testMethod.getName());
		setUpDriver(browser);
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		// Capture test result and log in Extent Report
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case Failed: ", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "Test Case Failed: ", ExtentColor.RED));
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) 
		{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case PASS: ", ExtentColor.GREEN));
		} 
		else if (result.getStatus() == ITestResult.SKIP) 
		{
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test Case Skipped: ", ExtentColor.ORANGE));
		}

		// Close the WebDriver
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterSuite
	public void tearDownExtentReport() {
		extent.flush();
	}
	
	public void setUpDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

}
