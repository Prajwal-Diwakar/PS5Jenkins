package demowebShop_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PS2_ExcelUtility {
	
	WebDriver driver;
	
	public PS2_ExcelUtility(WebDriver driver) {
		super();
		this.driver=driver;
	}
	
	By login=By.xpath("//a[text()='Log in']");
	By username= By.id("Email");
	By password=By.id("Password");
	By loginButton= By.xpath("//input[@class='button-1 login-button']");
	By logout=By.xpath("//a[@class='ico-logout']");
	
	public void LoginField(){
		driver.findElement(login).click();
	}
	public void EnterUsername(String Username) {
			driver.findElement(username).sendKeys(Username);;
	}
	
	public void EnterPassword(String Password) {
		driver.findElement(password).sendKeys(Password);
	}
	
	public void ClickLogin() {
			driver.findElement(loginButton).click();
	}
	
	public void ClickLogout() {
		driver.findElement(logout).click();
	}
	
	public void clearFields() {
        driver.findElement(username).clear();
        driver.findElement(password).clear();
    }

}
