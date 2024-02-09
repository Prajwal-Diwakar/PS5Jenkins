package demowebShop_Pages;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PS4_ExtentReport{
	
//	ExtentSparkReporter spark = new ExtentSparkReporter("extent-report.html");
//	ExtentReports extent = new ExtentReports();
	
	ExtentSparkReporter htmlReporter;
	ExtentReports extentReports;
	ExtentTest test ;

    
	public static WebDriver driver;
	PS3_Listeners login;
	WebDriverWait wait;
	
	@BeforeClass
	public void beforeTest() {
		
		htmlReporter = new ExtentSparkReporter("extentReport.html");

		// create ExtentReport and attach this reports
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);

		
		//extent.attachReporter(spark);
		/*ExtentTest test= extentReports.createTest("Environment Details that has been used to run the test cases");
		test.log(Status.INFO, "OS: Windows 10");
		test.log(Status.INFO, "Java version: 1.8.0_201");
		test.log(Status.INFO, "Host name: LTPPUN052363123");
		test.log(Status.INFO, "Browser: Chrome"); */
		
	}
	@AfterClass
	public void afterClass() {
		
		extentReports.flush();
	}
	
	@BeforeMethod
	public void beforemethod() {
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/login");
		
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		login = new PS3_Listeners(driver);
	}
	@AfterMethod
	public void aftermethod() {
		driver.quit();
	}
	
	@Test 
	public void testLogin1() throws InterruptedException {
		
		test= extentReports.createTest("Test Login 1");
		test.log(Status.INFO, "Starting test case");
		login.login1();
		
		Assert.assertNotEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
		test.fail("User credentials are invalid");
		test.log(Status.INFO, "End test case");
		Thread.sleep(8000);
	}
	
	@Test
	public void testLogin2() throws InterruptedException {
		
		test= extentReports.createTest("Test Login 2");
		test.log(Status.INFO, "Starting test case");
		login.login2();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
		test.pass("User credentials are valid");
		test.log(Status.INFO, "End test case");
		Thread.sleep(4000);
	}
	
	@Test
	public void testLogin3() throws InterruptedException {
		
		test= extentReports.createTest("Test Login 3");
		test.log(Status.INFO, "Starting test case");
		login.login3();
		
		Assert.assertNotEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
		test.fail("User credentials are invalid");
		test.log(Status.INFO, "End test case");
		Thread.sleep(8000);
	}
	
	/*@Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	 extentTest.log(Status.FAIL, "Test Case Failed: " + result.getName());
    	
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	extentTest.log(Status.SKIP, "Test Case Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(ITestContext context) {
    	ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Dell\\eclipse-workspace\\Selenium_S2_PracticeExcercises\\ExtentReport\\extent-report.html");
         extentReports = new ExtentReports();
         extentReports.attachReporter(spark);
         extentTest = extentReports.createTest("Test Execution Report");

         // Logging environment-related details
         extentTest.log(Status.INFO, "OS: " + System.getProperty("os.name"));
         extentTest.log(Status.INFO, "Java version: " + System.getProperty("java.version"));
         try {
             extentTest.log(Status.INFO, "Host name: " + InetAddress.getLocalHost().getHostName());
         } catch (UnknownHostException e) {
             extentTest.log(Status.INFO, "Host name: Unknown");
         }
         extentTest.log(Status.INFO, "Browser: Chrome"); // Assuming Chrome is being used
     }

    @Override
    public void onFinish(ITestContext context) {
    	extentReports.flush();
    }*/
}