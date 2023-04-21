package com.gmail.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
    public static WebDriver getDriver() {
        String browserName = System.getProperty("browser");
        if (browserName == null) {
            browserName = "chrome";
        }  //here we are cheking with chrome
        if (browserName.equalsIgnoreCase("chrome")) {
            assert WebDriverManager.chromedriver() != null;
            WebDriverManager.chromedriver().notify();
            return new ChromeDriver();
            //for another browser
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().notify();
            return new FirefoxDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browserName);
        }
    }

    private static Object firefoxdriver() {
        return null;
    }

    public static Object chromedriver() {
        return null;
    }
}
