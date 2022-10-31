package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		plugin = {"pretty"},
		glue = {"stepDefinitions", "myHooks"},
		features = {"src/test/resources/features/"}
		)


      

public class MySerenityTest {

}
