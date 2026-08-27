package sauce.demo.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sauce.demo.factory.DriverFactory;
import sauce.demo.pages.LoginPage;
import sauce.demo.utils.ConfigReader;
import sauce.demo.utils.PageManager;

public class LoginSteps {
		
	PageManager pages = new PageManager();

	@Given("I am on the SauceDemo login page")
	public void i_am_on_the_sauce_demo_login_page() {

        DriverFactory.getDriver()
                .get(ConfigReader.getProperty("url"));

    }

	@When("I login with valid credentials")
	public void i_login_with_valid_credentials() {

		pages.getLoginPage().login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
    }

	@Then("I should be logged into the application")
	public void i_should_be_logged_into_the_application() {

        String currentUrl =
                DriverFactory.getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentUrl.contains("inventory.html"),
                "User was not successfully logged in"
                
        );
        System.out.println("Successfully logged in");
    }
}
