package com.gmail.step_defs;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestSteps {
 private WebDriver driver;
//if you got here some error please add maven-when7-2-3
 @Given("I am on the Gmail login page")
 public void i_am_on_the_Gmail_login_page() {
  System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
  driver = new ChromeDriver();
  driver.get("https://accounts.google.com");
 }

 @When("I enter my username and password")
 public void i_enter_my_username_and_password() {
  // Find an email and password fields and enter values
  driver.findElement(By.id("identifierId")).sendKeys("myusername");
  driver.findElement(By.id("identifierNext")).click();
  driver.findElement(By.name("password")).sendKeys("mypassword");
  driver.findElement(By.id("passwordNext")).click();
 }

 @Then("I should be logged in")
 public void i_should_be_logged_in() {
  // Verify  the user is logged in by checking for presence of account button
  WebElement accountButton = driver.findElement(By.id("gb"));
  Assert.assertTrue(accountButton.isDisplayed());
 }

 @After
 public void tearDown() {
  // Close  browser window after each scenario which is important
  driver.quit();
 }
}
