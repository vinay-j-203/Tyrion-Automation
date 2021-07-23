
package parallel;

import java.io.File;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import resources.Base;

public class hooksTest extends Base {
	private static Logger log = (Logger) LogManager.getLogger(hooksTest.class.getName());

	@Before
	public void launchBrowser() throws Exception {

		Base.getDriver();
		log.info("driver & Browser is initialized");
		

	}

	@After(order = 0)
	public void quitBrowser() throws Exception {
		driver.close();
		log.info("Browser is closed");
		
		

	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(source, "image/png", screenshotName);
			
		}
      log.error("screenshot of the error is taken");
	}

}
