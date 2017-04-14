package blinqpages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	@FindBy(id = "session_email")
	WebElement sessionEmail;

	@FindBy(id = "session_password")
	WebElement sessionPassword;

	@FindBy(css = "input[value='Sign in']")
	WebElement signInButton;

	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.and(
				ExpectedConditions.visibilityOf(sessionEmail), 
				ExpectedConditions.visibilityOf(sessionPassword), 
				ExpectedConditions.textToBe(By.id("forgot_password"), "Forgot your password?"));
	}

	@Override
	public String getPageUrl() {
		return "/sign-in";
	}

	public void basicLogin(String username, String password) {
		waitForWebElement(sessionEmail);
		sessionEmail.click();
		sessionEmail.clear();
		sessionEmail.sendKeys(username);
		sessionPassword.click();
		sessionPassword.clear();
		sessionPassword.sendKeys(password);
		signInButton.click();
	}
	
}