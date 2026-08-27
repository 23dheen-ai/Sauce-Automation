package sauce.demo.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\test\\resources\\features",
		glue = {"sauce.demo.stepDefinitions"
				, "sauce.demo.hooks"},
		plugin = {"pretty","html:target/cucumber-report.html"},
		monochrome = true		
		)
public class TestRunner extends AbstractTestNGCucumberTests{

	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

        return super.scenarios();
    }
}

