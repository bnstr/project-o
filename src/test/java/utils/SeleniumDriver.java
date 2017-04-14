package utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumDriver {

    public static final String WEBDRIVER_CHROME_DRIVER_PATH = "webdriver.chrome.driver";
    public static WebDriver driver;
    private static int DEFAULT_WAIT_TIME = 30;


    public static WebDriver getDriver() {
        return driver;
    }

    public static void createDriver(){

        if(System.getProperty(WEBDRIVER_CHROME_DRIVER_PATH) != null){
            createChromeDriver();
        }else{
            createFirefoxDriver();
        }
    }

    public static void createFirefoxDriver() {

        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1280, 1024));
        setDefaultDriverTimeout();
    }

    public static void createChromeDriver() {

        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 1024));
        setDefaultDriverTimeout();
    }

    public static void shutdownDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void setDefaultDriverTimeout() {
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
    }

    public static void changeDriverTimeout(int myTime) {
        driver.manage().timeouts().implicitlyWait(myTime, TimeUnit.SECONDS);
    }

    public static void get(String url) {
        driver.get(url);
    }

    public static WebElement waitForElement(By by) {
        return waitForCondition(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static List<WebElement> waitForAllElements(By by) {
        return waitForCondition(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static <T> T waitForCondition(ExpectedCondition<T> condition) {
        return (new WebDriverWait(driver, DEFAULT_WAIT_TIME)).until(condition);
    }

    public static boolean isElementPresent(By locator, int timeout) {
        changeDriverTimeout(timeout);
        boolean found = driver.findElements(locator).size() > 0;
        setDefaultDriverTimeout();
        return found;
    }
}