package sauce.demo.stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import sauce.demo.factory.DriverFactory;
import sauce.demo.pages.LoginPage;
import sauce.demo.utils.ConfigReader;

public class CommonSteps {

	WebDriver driver;
	
	@Given("I am logged into SauceDemo")
    public void i_am_logged_into_saucedemo() {

        DriverFactory.getDriver()
                .get(ConfigReader.getProperty("url"));

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
                
        );
        System.out.println("Successfully logged in");
    }
}
