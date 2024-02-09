package demowebShop_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demowebShop_Pages.PS1_pages;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PS1_TestCase {
	WebDriver driver;
	PS1_pages Pages; // Declare Pages object at the class level

	@BeforeTest
	public void beforetest() {
		
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.get("https://demowebshop.tricentis.com/");
		
		Pages=new PS1_pages(driver);  // Initialize the Pages object
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
	
	@Test(priority=0)
	public void registerpageTest() throws InterruptedException {
		Pages.registerPage();
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void loginpageTest() throws InterruptedException {
		                         //pages Pages=new pages(driver);
		Pages.loginpage();
		Thread.sleep(2000);
		Pages.logoutpage();
	}

}
