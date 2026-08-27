package sauce.demo.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import sauce.demo.factory.DriverFactory;
import sauce.demo.utils.ScreenshotUtils;

public class Hooks {
	
	@Before
    public void setUp() {

	    DriverFactory.initializeDriver();

    }

    @After
    public void tearDown(Scenario scenario) {

    	if (scenario.isFailed()) {

            ScreenshotUtils.takeScreenshot(
                    scenario.getName()
            );
        }

        DriverFactory.quitDriver();
    }
}	
