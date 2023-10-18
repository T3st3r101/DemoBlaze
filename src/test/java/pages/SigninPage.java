package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage {
	WebDriver Blaze;
	  
	public SigninPage(WebDriver driver) {
		this.Blaze = driver;
	} 


	By Username = By.id("sign-username");
	By Password = By.id("sign-password");
	By buttonLogin = By.xpath("//button[@onclick='register()']");

	public void login(String username, String password) {
		Blaze.findElement(Username).sendKeys(username);
		Blaze.findElement(Password).sendKeys(password);
	}

	

	public void clickOnLoginButton() {
		Blaze.findElement(buttonLogin).click();
	}
		
	
}
