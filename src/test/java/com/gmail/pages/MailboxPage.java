package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailboxPage {
    private WebDriver driver;
    private String composeButton = "div[class='T-I T-I-KE L3']";

    public MailboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void composeEmail() {
        driver.findElement(By.cssSelector(composeButton)).click();
    }
}
