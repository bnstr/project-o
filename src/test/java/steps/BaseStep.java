package steps;

import static utils.PageFactory.openPage;
import static utils.PageFactory.initPage;
import static utils.SeleniumDriver.createDriver;
import static utils.SeleniumDriver.driver;
import static utils.SeleniumDriver.shutdownDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blinqpages.BasePage;
import blinqpages.HomePage;
import blinqpages.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class BaseStep {
	
	LoginPage loginPage;
    HomePage homePage;

    private static final String TEST_USER = System.getProperty("test.user", "provide valid username");
    private static final String TEST_PASS = System.getProperty("test.pass", "provide valid password");
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    @Before(value = {"~@excludeme"},order = 99)
    public void launchBrowser() {
        createDriver();
    }
    
    @Before(value = {"~@excludeme","~@base"},order = 100)
    public void login() {
    	loginPage = openPage(LoginPage.class);
        loginPage.basicLogin(TEST_USER, TEST_PASS);
        LOGGER.info("Login with user:"+TEST_USER);
        homePage = initPage(HomePage.class);
    }
    
    @After(value = {"~@excludeme"},order = 1)
    public void closeDriver(Scenario scenario) {
        shutdownDriver();
    }

    @After(value = {"~@excludeme"},order = 100)
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.write("Current Page URL is " + driver.getCurrentUrl());
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                File f = new File("./target/cucumber-html-report/" + scenario.getName() + "_scr.png");
                f.getParentFile().mkdirs();
                FileUtils.copyFile(scrFile, f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
