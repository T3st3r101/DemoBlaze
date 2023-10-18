package com.edureka.blaze_demo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SigninPage;
import utilities.BrowserUtil;

public class StepDefinitions {
	
	@Test
	@BeforeTest
	public void setup() throws Exception {
		// browser setup
		driver = BrowserUtil.getDriver();
	}

	@AfterTest
	public void tearDown() {
		// quit browser
		driver.quit();
	}
	WebDriver driver;
	// TestCase 1

	@Given("the user is on webBrowser")
	public void the_user_is_on_web_browser() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		driver = BrowserUtil.getDriver();
	}

	@When("to validate if the user is able to access Demo_blaze website in the Google browser")
	public void to_validate_if_the_user_is_able_to_access_demo_blaze_website_in_the_google_browser() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://www.google.com");
	}

	@When("user opens the Google browser and types : {string} into search field")
	public void user_opens_the_google_browser_and_types_into_search_field(String searchString) {
		// Locate the search input field and enter the search string
		WebElement searchField = driver.findElement(By.name("q"));
		searchField.sendKeys(searchString);
	}

	@Then("it will navigate to Google search page results")
	public void

			it_will_navigate_to_google_search_page_results() {
		// Google Search click
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).click();

	}

	@Then("click Demo Blaze link to go to the Demo Blaze website")
	public void click_demo_blaze_link_to_go_to_the_demo_blaze_website() { // Demo Blaze link
		driver.findElement(By.xpath("//h3")).click();

	}
	// TestCase 2

	@Given("the user is on webBrowser and giving the greetings")
	public void the_user_is_on_web_browser_and_giving_the_greetings() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		driver = BrowserUtil.getDriver();
	}

	@When("enter the URL")
	public void enter_the_url() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://www.demoblaze.com");
	}

	@When("the user registers a new account")
	public void the_user_registers_a_new_account() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[@id='signin2']")).click();
	}

	@When("the user enters the valid username {string} and password {string} credentials")
	public void the_user_enters_the_valid_username_and_password_credentials(String Username, String Password) {
		// Write code here that turns the phrase above into concrete actions
		SigninPage signinPage = new SigninPage(driver);
		signinPage.login(Username, Password);
 
	}

	@Then("alert will generate saying user already exists")
	public void

			alert_will_generate_saying_user_already_exists() {
		// Write code here that turns the phrase above into concrete actions

		SigninPage signinPage = new SigninPage(driver);
		signinPage.clickOnLoginButton();
		try {
			// Explicitly wait for the alert to be present

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			// Adjust the timeout as needed

			wait.until(ExpectedConditions.alertIsPresent());

			// Switch to the alert
			Alert alert = driver.switchTo().alert();
			// Get the alert message

			String alertMessage = alert.getText();

			System.out.println("Alert message is: " + alertMessage);

			// Accept the alert (click OK) alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert not found.");
		} finally {

		}

	}

	// TestCase 3

	@Given("user opens the browser")
	public void user_opens_the_browser() throws Exception {
		// Write code here that turns the phrase above into concrete
		driver = BrowserUtil.getDriver();
	}

	@When("user validates the sucessful navigation to Demo_blaze Home Page")

	public void user_validates_the_sucessful_navigation_to_demo_blaze_home_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://www.demoblaze.com");
	}

	@When("enter login user {string} and pass {string} credentials")
	// Write code here that turns the phrase above into concrete actions
	public void enter_login_user_and_pass_credentials(String user, String pass) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[@id='login2']")).click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(user, pass);
	}

	@When("clicks log in")
	public void clicks_log_in() {
		// Write code here that turns the phrase above into concrete actions
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnLoginButton();

	}

	@Then("welcome the user to the site")
	public void welcome_the_user_to_the_site() {
		// Write code here that turns the phrase above into concrete actions
		LoginPage loginPage = new LoginPage(driver);
		boolean flag = loginPage.iswelcomeDisplayed();
		Assert.assertEquals(flag, true);

	}

}
