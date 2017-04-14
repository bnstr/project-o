package utils;


import static utils.SeleniumDriver.getDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blinqpages.BasePage;


public class PageFactory {
	
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PageFactory.class);

    public static <T extends BasePage> T openPage(Class<T> pageClass) {
        T page = org.openqa.selenium.support.PageFactory.initElements(getDriver(), pageClass);
        String env = System.getProperty("test.env", "https://www.blinq.com");
        getDriver().get(env + page.getPageUrl());
        page.refresh();
        page.waitForLoad();
        return page;
    }
    
    public static <T extends BasePage> T initPage(Class<T> pageClass) {
        T page = org.openqa.selenium.support.PageFactory.initElements(getDriver(), pageClass);
        page.waitForLoad();
        return page;
    }
    
    
}
