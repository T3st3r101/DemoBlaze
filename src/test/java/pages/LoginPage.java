package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver Demo; 

	public LoginPage(WebDriver driver) {
		this.Demo = driver;
	}

	By Username = By.id("loginusername");
	By Password = By.id("loginpassword");
	By buttonLogin = By.cssSelector("button[onclick='logIn()']");
	By welcomeLogin = By.linkText("Welcome Blazetest@gmail.com"); // By.id("nameofuser");

	public void login(String user, String pass) {
		Demo.findElement(Username).sendKeys(user);
		Demo.findElement(Password).sendKeys(pass);
	}

	public void clickOnLoginButton() {
		Demo.findElement(buttonLogin).click();
	}

	public boolean iswelcomeDisplayed() {
		return Demo.findElement(welcomeLogin).isDisplayed();

	}

}
