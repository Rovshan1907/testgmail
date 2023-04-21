package com.gmail.runners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRunner {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    @Test
    public void sendAndVerifyEmail() {
        // Navigate to Gmail login page
        driver.get("https://mail.google.com");

        // Log in with valid credentials
        WebElement emailField = driver.findElement(By.name("identifier"));
        emailField.sendKeys("example@gmail.com");
        WebElement nextButton = driver.findElement(By.id("identifierNext"));
        nextButton.click();
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("password");
        WebElement loginButton = driver.findElement(By.id("passwordNext"));
        loginButton.click();

        // Compose and send email
        WebElement composeButton = driver.findElement(By.xpath("//div[text()='Compose']"));
        composeButton.click();
        WebElement toField = driver.findElement(By.name("to"));
        toField.sendKeys("example@gmail.com");
        WebElement subjectField = driver.findElement(By.name("subjectbox"));
        subjectField.sendKeys("Test email subject");
        WebElement bodyField = driver.findElement(By.xpath("//div[@role='textbox']"));
        bodyField.sendKeys("Test email body");
        WebElement sendButton = driver.findElement(By.xpath("//div[text()='Send']"));
        sendButton.click();

        // Verify email was sent successfully
        WebElement confirmationMessage = driver.findElement(By.xpath("//span[text()='Message sent.']"));
        Assert.assertEquals(confirmationMessage.getText(), "Message sent.");

        // Verify email was received
        driver.get("https://mail.google.com/mail/u/0/#inbox");
        WebElement receivedEmail = driver.findElement(By.xpath("//span[text()='Test email subject']/ancestor::tr"));
        Assert.assertTrue(receivedEmail.isDisplayed());
        WebElement emailBody = receivedEmail.findElement(By.xpath("//div[contains(@class, 'y6')]//span[@dir='ltr']"));
        Assert.assertEquals(emailBody.getText(), "Test email body");
    }

    @Test
    public void invalidLogin() {
        // Navigate to Gmail login page
        driver.get("https://mail.google.com");

        // Enter invalid credentials and attempt to log in
        WebElement emailField = driver.findElement(By.name("identifier"));
        emailField.sendKeys("invalid@gmail.com");
        WebElement nextButton = driver.findElement(By.id("identifierNext"));
        nextButton.click();
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("password");
        WebElement loginButton = driver.findElement(By.id("passwordNext"));
        loginButton.click();

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='o6cuMc']"));
        Assert.assertEquals(errorMessage.getText(), "Wrong password. Try again or click Forgot password to reset it.");
    }
}


