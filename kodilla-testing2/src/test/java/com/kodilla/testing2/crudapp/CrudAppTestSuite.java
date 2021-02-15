package com.kodilla.testing2.crudapp;

import config.WebDriverConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CrudAppTestSuite {

    private static final String BASE_URL = "http://hamonnah.github.io";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        assert driver != null;
        driver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]//input[1]";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_TASK_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_TASK_BUTTON));
        addButton.click();
        Thread.sleep(3000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {

        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath(".//p[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                            buttonCreateCard.click();
                });
        Thread.sleep(6000);
    }

    private boolean checkTaskExistInTrello(String taskName) throws InterruptedException {

        final String XPATH_CONTINUE_BUTTON = "//*[@id=\"login-submit\"]";
        final String TRELLO_URL = "https://id.atlassian.com/login/select-account?application=trello&continue=https%3A//trello.com/auth/atlassian/callback?returnUrl%3D%252F%26display%3D";
        boolean result = true;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        assert driverTrello != null;
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("username")).sendKeys("hamonnah@gmail.com");

        Thread.sleep(3000);

        driverTrello.findElement(By.id("login-submit")).submit();

        Thread.sleep(3000);

        driverTrello.findElement(By.id("password")).sendKeys("jozefina12");
        driverTrello.findElement(By.id("login-submit")).submit();


        Thread.sleep(6000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size()>0)
                .forEach(WebElement::click);

        Thread.sleep(6000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));
        System.out.println("checkTaskExistsInTrello: taskName= " + taskName + " ,result= " + result);
        driverTrello.close();

        return result;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {

        String taskName = createCrudAppTestTask();
        System.out.println("task name: " + taskName);
        sendTestTaskToTrello(taskName);
        Assert.assertTrue(checkTaskExistInTrello(taskName));
        deleteTestTask(taskName);
    }

    private void deleteTestTask(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement buttonDelete = theForm.findElement(By.xpath(".//button[4]"));
                    buttonDelete.click();
                });
        Thread.sleep(6000);
    }

}