package blinqpages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	@FindBy(id = "site-content")
	WebElement siteContent;
	
	@FindBy(id = "homepage-how-blinq-works")
	WebElement homepageBlinq;

	@FindBy(id = "featured-anchor")
	WebElement featuredAnchor;

	@FindBy(id = "carousel-")
	List<WebElement> carouselItems;

	@FindBy(id = "sli_search_1")
	WebElement searchInput;

	@FindBy(css = "[id='searchForm'] button[type='submit']")
	WebElement searchSubmit;
	
	@FindBy(css = ".results-text")
	WebElement results;
	
	@FindBy(id = "saved-search-btn")
	List<WebElement> createAlert;

	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.and(
				ExpectedConditions.visibilityOf(siteContent), 
				ExpectedConditions.visibilityOf(homepageBlinq));
	}

	@Override
	public String getPageUrl() {
		return "/";
	}

	public List<String> getAllCarouselsTitles() {
		List<String> carouselTitles = new ArrayList<String>();
		for (WebElement carousel : carouselItems) {
			carouselTitles.add(carousel.findElement(By.cssSelector("[data-feed$='/carousel_feed'] h2")).getText());
		}
		return carouselTitles;
	}

	public void search(String arg1) {
		waitForWebElement(searchInput);
		searchInput.click();
		searchInput.clear();
		searchInput.sendKeys(arg1);
		searchSubmit.click();
		waitForWebElement(results);
	}
	
	public boolean createAlertButtonNotDisplayed() {
		return createAlert.isEmpty();
	}
}