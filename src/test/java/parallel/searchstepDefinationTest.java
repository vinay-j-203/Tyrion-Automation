package parallel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.search;
import resources.Base;

public class searchstepDefinationTest extends Base {
	private static Logger log = (Logger) LogManager.getLogger(searchstepDefinationTest.class.getName());
	private search s;

	@When("^user is on landing page and search for \"([^\"]*)\"$")
	public void user_is_on_landing_page_and_search_for_something(String strArg1) throws Throwable {

		s = new search(driver);
		s.getSearchKeyword().sendKeys(strArg1);
		log.info("Search keyword is entered");
		
		

	}

	@Then("^search results for Bosch should be displayed$")
	public void search_results_for_bosch_should_be_displayed() throws Throwable {
		System.out.println("search results displayed");
		log.info("search results are displayed");
		

	}

	@And("^click on search icon$")
	public void click_on_search_icon() throws Throwable {
		s.getSearchIcon().click();
		log.debug("clicked on search icon");

	}
	

}
