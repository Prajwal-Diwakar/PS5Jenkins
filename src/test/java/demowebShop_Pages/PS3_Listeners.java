package demowebShop_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PS3_Listeners {
	
	static WebDriver driver;
	
	public PS3_Listeners(WebDriver driver) {
			this.driver=driver;
	}
	
	By username= By.id("Email");
	By password=By.id("Password");
	By loginButton= By.xpath("//input[@class='button-1 login-button']");
	
	public void login1() {
		driver.findElement(username).sendKeys("mercury");
		driver.findElement(password).sendKeys("mercury123");
		driver.findElement(loginButton).click();
	}
	
	public void login2() {
		driver.findElement(username).sendKeys("Itest@test.com");
		driver.findElement(password).sendKeys("Itest@test");
		driver.findElement(loginButton).click();
	}
	
	public void login3() {
		driver.findElement(username).sendKeys("admin");
		driver.findElement(password).sendKeys("admin123");
		driver.findElement(loginButton).click();
	}

}

