package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class loginandlogout extends Base {

	public WebDriver driver;

	@FindBy(id = "email")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(css = "button.btn.btn-solid")
	private WebElement loginbtn;

	@FindBy(linkText = "Logout")
	private WebElement logout;

	public loginandlogout(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName() {
		return username;
	}

	public WebElement getPwd() {
		return password;
	}

	public WebElement getLoginbtn() {

		return loginbtn;
	}

	public WebElement getLogOut() {

		return logout;
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

}
