package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(

		features = "src/test/resources/parallel", glue = "parallel", stepNotifications = true, monochrome = true,
		plugin = {
				"pretty", "html:target/cucumber.html", "junit:target/cukes.xml", "json:target/cucu.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/",
				"timeline:target/timeline-report" 
				 }, publish = true)

public class MyTestRunnerTest {

}
