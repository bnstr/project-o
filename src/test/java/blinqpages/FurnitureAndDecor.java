package blinqpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FurnitureAndDecor extends BasePage {

	@FindBy(id = "site-content")
	WebElement siteContent;


	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.and(ExpectedConditions.visibilityOf(siteContent), ExpectedConditions.textToBe(
				By.cssSelector(".sli_bct_categories .sli_subcategory span[itemprop='title']"), "Furniture & Decor"));
	}

	@Override
	public String getPageUrl() {
		return "/cat/home-garden/furniture-decor/";
	}

	

}