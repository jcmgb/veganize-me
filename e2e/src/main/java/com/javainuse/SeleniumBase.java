package com.javainuse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URI;
import java.net.URISyntaxException;

public class SeleniumBase {

    // Selenium driver setup vars
    public String CHROME_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver";
    public String CHROME_DRIVER_EXE_PATH = "src\\test\\resources\\chromedriver\\chromedriver.exe";
    public static ChromeDriver startChromeDriver() {
        System.setProperty("webdriver.chrome.driver",
                "src\\test\\resources\\chromedriver\\chromedriver.exe");
        return new ChromeDriver();
    }

    public static void navigateTo(WebDriver driver, String linkTxt) {
        try {
            new URI(linkTxt);
            driver.get(linkTxt);

        } catch (URISyntaxException e) {
            System.out.println("Invalid URL: " + linkTxt);
        }
    }
}
