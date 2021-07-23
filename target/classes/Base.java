package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.homePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Base {
	private static Logger log = (Logger) LogManager.getLogger(Base.class.getName());
	public static WebDriver driver;
	public static Properties prop;

	public static WebDriver getDriver() throws Exception {

		prop = new Properties();
		String filepath = System.getProperty("user.dir") + "/src/main/java/resources/config.properties";

		FileInputStream fis = new FileInputStream(filepath);
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();

			// To run in headless

			/*
			 * ChromeOptions options=new ChromeOptions(); options.addArguments("headless");
			 * options.addArguments("window-size=1920,1080"); driver = new
			 * ChromeDriver(options);
			 */

			driver = new ChromeDriver();
			log.info("chrome driver initialized");
			

		}

		else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
			log.info("Firefox driver initialized");

		}

		else if (browserName.equals("IE")) {
			WebDriverManager.iedriver().setup();

			driver = new InternetExplorerDriver();
			log.info("IE driver initialized");

		}

		driver.get(url);
		log.info("URL launched");
		driver.manage().window().maximize();
		log.info("Window maximized");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return driver;

	}

}
