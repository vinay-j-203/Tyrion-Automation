package parallel;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.loginandlogout;
import resources.Base;


public class loginstepDefinationTest extends Base {
	private static Logger log = (Logger) LogManager.getLogger(loginstepDefinationTest.class.getName());
	private homePage hm = new homePage(driver);

	private loginandlogout lp = new loginandlogout(driver);

	private String logintitle = "ShakeDeal - Procurement Made Easy";

	private String homeTitle = "Home Page | ShakeDeal";

	@When("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {

		WebElement element = hm.getProfileButton();
		Actions actions = new Actions(driver);
		actions.moveToElement(element, 0, 0).build().perform();
		
		hm.getLoginButton().click();
		log.debug("clicked on login button");
		
		FluentWait wait = new FluentWait(driver);
		wait.until(ExpectedConditions.titleContains(logintitle));

		String loginPageTitle = lp.getPageTitle();
		// System.out.println("My Login Page title is" + loginPageTitle);
		Assert.assertTrue(loginPageTitle.contains(logintitle));
		log.info("Login page title grabed successfully");
		
	}

	@Then("^navigate to home page$")
	public void navigate_to_home_page() throws Throwable {
		FluentWait wait = new FluentWait(driver);
		wait.until(ExpectedConditions.titleContains(homeTitle));
		String homepageTitle = lp.getPageTitle();
		// System.out.println("user is logged in successfully"+ homeTitle);
		Assert.assertTrue(homepageTitle.contains(homeTitle));
		log.info("Navigated to home page and grabed the title");
		
	}

	@And("^user enters username (.+) and pwd (.+)$")
	public void user_enters_username_and_pwd(String username, String password) throws Throwable {

		lp.getUserName().sendKeys(username);
		lp.getPwd().sendKeys(password);
		log.debug("username and pwd sent");
		

	}

	@And("^clicks on login button$")
	public void clicks_on_login_button() throws Throwable {
		lp.getLoginbtn().click();
		log.debug("entered uname and pwd and clicked on login");
		

	}

	@Then("^logout of the application$")
	public void logout_of_the_application() throws Throwable {
		WebElement element = hm.getProfileButton();
		Actions actions = new Actions(driver);
		actions.moveToElement(element, 0, 0).build().perform();
		lp.getLogOut().click();
		log.debug("logged out of application successfully");
		

	}

}
