package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverConfig {

    public final static String CHROME = "CHROME_DRIVER";
    public static WebDriver getDriver(final String driver) {

        System.setProperty("webdriver.chrome.driver", "/Users/hamonnah/Documents/Development/Selenium-drivers/Chrome/chromedriver");

        if(driver.equals(CHROME)){
            return new ChromeDriver();
        } else {
            return null;
        }
    }

}
