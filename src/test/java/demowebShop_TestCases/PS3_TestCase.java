package demowebShop_TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentReporter;

import demowebShop_Pages.PS3_Listeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import demowebShop_Pages.MyListeners;

@Listeners(MyListeners.class)
public class PS3_TestCase implements ITestListener {
	
	public static WebDriver driver;
	PS3_Listeners login;
	WebDriverWait wait;
	
	//String driverPath = "drivers/windows/geckodriver.exe";
	
	@BeforeMethod
	public void beforemethod() {
		
		//System.setProperty("webdriver.geckodriver.driver", driverPath);
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/login");
		
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		login = new PS3_Listeners(driver);
	}
	
	@AfterMethod
	public void aftermethod() {
		driver.close();
	}
	
	@Test 
	public void testLogin1() throws InterruptedException {
		login.login1();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
		Thread.sleep(8000);
	}
	
	@Test
	public void testLogin2() throws InterruptedException {
		login.login2();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
		Thread.sleep(4000);
	}
	
	@Test
	public void testLogin3() throws InterruptedException {
		login.login3();
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
		Thread.sleep(8000);
	}
	
	@Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext context) {
    	 
    }
}
	


