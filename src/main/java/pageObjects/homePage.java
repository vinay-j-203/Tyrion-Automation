package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class homePage extends Base {

	public WebDriver driver;

	@FindBy(css = "li.onhover-dropdown")
	private WebElement profilebutton;

	@FindBy(linkText = "Login")
	private WebElement loginbutton;

	public homePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public WebElement getProfileButton() {

		return profilebutton;
	}

	public WebElement getLoginButton() {
		return loginbutton;
	}

}
