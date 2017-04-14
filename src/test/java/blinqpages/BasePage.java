package blinqpages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static utils.SeleniumDriver.getDriver;

public abstract class BasePage {

    public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    private static final int LOAD_TIMEOUT = Integer.parseInt(System.getProperty("seleniumTimeout", "60"));
    private static final int REFRESH_RATE = 2;
    public static String BASE_URL = System.getProperty("test.env", "https://www.blinq.com");

    {
        initBaseURL();
    }

    public static void initBaseURL() {
        String baseUrl = System.getProperty("test.env");
        if (baseUrl != null) {
            BASE_URL = baseUrl;
        }
    }

    /**
     * Provides condition when page can be considered as fully loaded.
     *
     * @return Condition meaning that a page is fully loaded.
     */
    protected abstract ExpectedCondition getPageLoadCondition();

    /**
     * Provides page relative URL.
     *
     * @return Page relate URL
     */
    public abstract String getPageUrl();

    private ExpectedCondition getExpConditionBy(By wel) {
        return ExpectedConditions.elementToBeClickable(wel);
    }

    private ExpectedCondition getExpCondition(WebElement wel) {
        return ExpectedConditions.elementToBeClickable(wel);
    }

    private ExpectedCondition getExpCondition(final List<WebElement> webElements) {
        return ExpectedConditions.visibilityOfAllElements(webElements);
    }

    public void waitForCondition(ExpectedCondition<?> condition) {
        waitForCondition(condition, LOAD_TIMEOUT);
    }

    public void waitForCondition(ExpectedCondition<?> condition, int timeout) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver()).withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(REFRESH_RATE, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        LOGGER.info("timeout: " + timeout + "  until " + condition);
        wait.until(condition);
    }

    private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
        LOGGER.info("on page {}", getDriver().getTitle());
        waitForCondition(pageLoadCondition);
    }

    public void waitForLoad() {
        waitForPageToLoad(getPageLoadCondition());
    }

    public void waitForWebElement(WebElement wel) {
        waitForCondition(getExpCondition(wel));
    }

    public void waitForWebElementInvisibility(By locator) {
        waitForCondition(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForWebElementInvisibility(By locator, int timeout) {
        waitForCondition(ExpectedConditions.invisibilityOfElementLocated(locator), timeout);
    }

    public void waitForWebElements(final List<WebElement> webElements) {
        waitForCondition(getExpCondition(webElements));
    }

    public void waitForWebElementBy(By by) {
        waitForCondition(getExpConditionBy(by));
    }

    public String getWebElementValue(WebElement element) {
        return element.getAttribute("value");
    }

    public void waitForSeconds(int seconds) {
        LOGGER.warn("wait for " + seconds + " seconds");
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            // Do nothing.
        }
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public void goToPageUrl(String pageURL) {
        getDriver().get(BASE_URL + pageURL);
    }


    public void driverNavigateBack() {
        getDriver().navigate().back();
    }

    public void refresh() {
        getDriver().navigate().refresh();
    }

}