package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComposeEmailPage {
    private WebDriver driver;
    private String toInput = "textarea[name='to']";
    private String subjectInput = "input[name='subjectbox']";
    private String bodyInput = "div[role='textbox']";
    private String sendButton = "div[class='T-I J-J5-Ji aoO T-I-atl L3']";

    public ComposeEmailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillOutEmail(String to, String subject, String body) {
        driver.findElement(By.cssSelector(toInput)).sendKeys(to);
        driver.findElement(By.cssSelector(subjectInput)).sendKeys(subject);
        driver.findElement(By.cssSelector(bodyInput)).sendKeys(body);
    }

    public void sendEmail() {
        driver.findElement(By.cssSelector(sendButton)).click();
    }
}

