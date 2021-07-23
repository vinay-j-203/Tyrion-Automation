package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class search extends Base {

	public WebDriver driver;

	@FindBy(xpath = "//input[@type=\"text\"]")
	private WebElement searchkeyword;

	@FindBy(css = "img.search.img-lazy-loading-effect")
	private WebElement searchicon;

	public search(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchKeyword() {
		return searchkeyword;
	}

	public WebElement getSearchIcon() {
		return searchicon;
	}

}
