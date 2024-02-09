package demowebShop_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PS1_pages {
	 WebDriver driver;

		public PS1_pages(WebDriver driver) {   // constructor
			super();
			this.driver = driver;
		}
		
		By register=By.xpath("//a[text()='Register']");
		By gender=By.id("gender-male");
		By firstname=By.id("FirstName");
		By LastName=By.id("LastName");
		By Email=By.id("Email");
		By Password=By.id("Password");
		By ConfirmPassword=By.id("ConfirmPassword");
		By registerButton=By.id("register-button");
		
		By login=By.xpath("//a[text()='Log in']");
		
		By loginButton= By.xpath("//input[@class='button-1 login-button']");
		
		By logout=By.xpath("//a[@class='ico-logout']");
		
		
		public void registerPage() {
			driver.findElement(register).click();
			driver.findElement(gender).click();
			driver.findElement(firstname).sendKeys("demo");
			driver.findElement(LastName).sendKeys("user");
			driver.findElement(Email).sendKeys("demouser12@gmail.com");
			driver.findElement(Password).sendKeys("demo@1234");
			driver.findElement(ConfirmPassword).sendKeys("demo@1234");
			driver.findElement(registerButton).submit();	
		}
		
		public void loginpage() {
			driver.findElement(login).click();
			driver.findElement(Email).sendKeys("Itest@test.com");
			driver.findElement(Password).sendKeys("Itest@test");
			driver.findElement(loginButton).submit();
		}
		
		public void logoutpage() {
			driver.findElement(logout).click();
		}
		
}
