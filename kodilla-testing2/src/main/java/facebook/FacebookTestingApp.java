package facebook;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookTestingApp {

    public static final String XPATH_ACCEPT_ALL_BUTTON = "//div[contains(@class, \"_9fiw\")]/button[2]";
    public static final String XPATH_REGISTRATION_FORM_BUTTON = "//div[contains(@class, \"6ltg\")]/a[1]";
    public static final String XPATH_REGISTRATION_BOX = "//*[@id=\"reg_box\"]/div[1]";
    public static final String XPATH_SELECT_DAY_COMBOBOX = "//select[@id=\"day\"]";
    public static final String XPATH_SELECT_MONTH_COMBOBOX = "//div[contains(@class, \"_5k_5\")]/span/select[2]";
    public static final String XPATH_SELECT_YEAR_COMBOBOX = "//div[contains(@class, \"_5k_5\")]/span/select[3]";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");

        WebElement acceptAll = driver.findElement(By.xpath(XPATH_ACCEPT_ALL_BUTTON));
        acceptAll.click();

        WebElement register = driver.findElement(By.xpath(XPATH_REGISTRATION_FORM_BUTTON));
        register.click();

        while (!driver.findElement(By.xpath(XPATH_REGISTRATION_BOX)).isDisplayed());

        WebElement dayOfBirth = driver.findElement(By.xpath(XPATH_SELECT_DAY_COMBOBOX));
        Select selectDay = new Select(dayOfBirth);
        selectDay.selectByIndex(4);

        WebElement monthOfBirth = driver.findElement(By.xpath(XPATH_SELECT_MONTH_COMBOBOX));
        Select selectMonth = new Select(monthOfBirth);
        selectMonth.selectByIndex(4);

        WebElement yearOfBirth = driver.findElement(By.xpath(XPATH_SELECT_YEAR_COMBOBOX));
        Select selectYear = new Select(yearOfBirth);
        selectYear.selectByIndex(1990);
    }

}
