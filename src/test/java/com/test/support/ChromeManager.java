package com.test.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeManager extends DriverManager {

     protected ChromeDriver driver;


         @Override
         protected WebDriver createDriver() {
        /*
                     String driverPath = "src/test/resources/drivers/chromedriver";
                     if (System.getProperty("os.name").contains("Windows")) {
                         driverPath += ".exe";
                    }
                    */
                    System.setProperty("webdriver.chrome.driver", "/Users/amit/Desktop/amit/projects/misc/chromedriver");
                    return driver = new ChromeDriver(ChromeDriverService.createDefaultService());
        }

        @Override
         public WebDriver getDriver() {
                 if (driver == null) {
                             this.createDriver();
                }
                return driver;
        }

}
