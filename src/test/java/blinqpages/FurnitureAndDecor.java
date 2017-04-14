package blinqpages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class FurnitureAndDecor extends BasePage {

    @FindBy(id = "")
    WebElement productItem;


	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPageUrl() {
		// TODO Auto-generated method stub
		return null;
	}

   
}