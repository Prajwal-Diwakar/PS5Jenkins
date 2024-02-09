package demowebShop_Pages;


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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;


	import io.github.bonigarcia.wdm.WebDriverManager;

	public class DataDrivenTestExcel {
		
		WebDriver driver;
		PS2_ExcelUtility login;
		WebDriverWait wait;
		
		@BeforeMethod
		
		public void beforemethod() {
			
			WebDriverManager.firefoxdriver().setup();
			
			driver=new FirefoxDriver();
			
			driver.get("https://demowebshop.tricentis.com/login");
			
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
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
	            	//login.LoginField();
	            	cell= sheet.getRow(row).getCell(0);
	            	cell.setCellType(CellType.STRING);
	            	driver.findElement(By.id("Email")).sendKeys(cell.getStringCellValue());
	            	
	            	cell=sheet.getRow(row).getCell(1);
	            	cell.setCellType(CellType.STRING);
	            	driver.findElement(By.id("Password")).sendKeys(cell.getStringCellValue());
	            	
	            	Thread.sleep(4000);
	            	
	            	driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	            	
	            	
	            	Thread.sleep(4000);
	            	
	            	driver.findElement(By.id("Email")).clear();
	            	driver.findElement(By.id("password")).clear();

	                Thread.sleep(4000);
	            	
	            	// Check if login is successful
	            	boolean isLoginSuccessful = driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/");
	            	Thread.sleep(4000);
	            	
	            	String message = isLoginSuccessful ? "Success" : "Failure";

	            	 sheet.getRow(row).createCell(2).setCellValue(message);
	            	 
	            	 FileOutputStream fileOutput = new FileOutputStream(src);
	                 workbook.write(fileOutput);
	                
	                 fileOutput.close();
	                 Thread.sleep(4000);
	           
	            }
	            
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}



