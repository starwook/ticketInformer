package com.example.ticketInformer.crawling;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Selenium {
    private WebDriver driver;
    public static String WEB_DRIVER_ID="webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH= "/usr/bin/chromedriver";//"src/main/java/com/example/ticketInformer/crawling/chromedriver"; //""; 서로바꾸기 //
    public Selenium(){
        System.setProperty(WEB_DRIVER_ID,WEB_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.53 Safari/537.36");
        options.addArguments("lang=ko");
        options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    public WebDriver getDriver(){
        return driver;
    }
}
