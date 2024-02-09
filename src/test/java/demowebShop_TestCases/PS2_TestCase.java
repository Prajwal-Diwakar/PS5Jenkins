package demowebShop_TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demowebShop_Pages.PS2_ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PS2_TestCase {
	
	String siteUrl = "https://demowebshop.tricentis.com/login";
	String driverPath = "drivers/windows/geckodriver.exe";
	
	WebDriver driver;
	PS2_ExcelUtility login;
	WebDriverWait wait;
	
	@BeforeMethod
	
	public void beforemethod() {
		
		// step2: set system properties for selenium dirver
		//System.setProperty("webdriver.geckodriver.driver", driverPath);
				
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get(siteUrl);
		
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		login= new PS2_ExcelUtility(driver);
	}
	
	@AfterMethod
	public void aftermethod() {
		driver.close();
	}
	
	@Test
	public void loginUsingExcelSheet() throws IOException, InterruptedException {
		
		//login.LoginField();
		
		try {
			File src= new File("src\\test\\resource\\PS2LoginDetailsSheet.xlsx");
			FileInputStream fileInput=new FileInputStream(src);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
			XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFCell cell;
            
            for (int row = 1; row <=sheet.getLastRowNum(); row++) {
            	
            	cell= sheet.getRow(row).getCell(0);
            	cell.setCellType(CellType.STRING);
            	login.EnterUsername(cell.getStringCellValue());
            	
            	cell=sheet.getRow(row).getCell(1);
            	cell.setCellType(CellType.STRING);
            	login.EnterPassword(cell.getStringCellValue());
            	
            	Thread.sleep(2000);
            	
            	login.ClickLogin();
            	
            	Thread.sleep(2000);
           	
            	boolean isLoginSuccessful = driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/");
            	Thread.sleep(2000);
            	
            	String message = isLoginSuccessful ? "Success" : "Failure";
            	System.out.println(message);
            	if(message.equals("Success")) {
            		login.ClickLogout();
            		Thread.sleep(4000);
            		login.LoginField();
            	}
            	else {
            		login.clearFields();
            	}

            	sheet.getRow(row).createCell(2).setCellValue(message);
            	 
            	 FileOutputStream fileOutput = new FileOutputStream(src);
                 workbook.write(fileOutput);
                
                 fileOutput.close();
                 Thread.sleep(4000);
           
            } 
            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
