package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private String usernameInput = "input[name='identifier']";
    private String nextButton = "div[id='identifierNext']";
    private String passwordInput = "input[name='password']";
    private String signinButton = "div[id='passwordNext']";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.get("https://www.gmail.com");
        driver.findElement(By.cssSelector(usernameInput)).sendKeys(username);
        driver.findElement(By.cssSelector(nextButton)).click();
        driver.findElement(By.cssSelector(passwordInput)).sendKeys(password);
        driver.findElement(By.cssSelector(signinButton)).click();
    }
}

