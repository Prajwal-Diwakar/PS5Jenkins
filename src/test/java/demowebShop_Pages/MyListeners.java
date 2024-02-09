package demowebShop_Pages;

	import org.testng.ITestListener;
	import org.testng.ITestResult;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.OutputType;
	import org.apache.commons.io.FileUtils;
	import java.io.File;
	import java.io.IOException;
	import demowebShop_Pages.PS3_Listeners;

	public class MyListeners implements ITestListener {

	    // WebDriver instance

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	
	    	 WebDriver driver = PS3_Listeners.driver;
	        System.out.println("Test Failed: " + result.getName());
	        
	        // Capturing screenshot
	        
	        File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            
	           
	            try {
	                FileUtils.copyFile(source, new File("/Users/Dell/eclipse-workspace/Selenium_S2_PracticeExcercises/screenshots/"+result.getName()+".png"));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        
	    }
	}


