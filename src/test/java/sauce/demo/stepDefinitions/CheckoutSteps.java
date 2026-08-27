package sauce.demo.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sauce.demo.factory.DriverFactory;
import sauce.demo.pages.CartPage;
import sauce.demo.pages.CheckoutPage;
import sauce.demo.pages.ProductsPage;
import sauce.demo.utils.PageManager;

public class CheckoutSteps {

	private PageManager pages = new PageManager();

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {

    	pages.getCartPage().clickCheckout();
    }

    @When("I enter checkout information")
    public void i_enter_checkout_information() {

    	pages.getCheckoutPage().enterFirstName("Dheena");
    	pages.getCheckoutPage().enterLastName("Automation");
        pages.getCheckoutPage().enterPostalCode("600001");
    }

    @When("I continue to order overview")
    public void i_continue_to_order_overview() {

    	pages.getCheckoutPage().clickContinue();
    }

    @When("I finish the order")
    public void i_finish_the_order() {

    	pages.getCheckoutPage().clickFinish();
    }

    @Then("the order should be successfully completed")
    public void the_order_should_be_successfully_completed() {

        Assert.assertEquals(
        		pages.getCheckoutPage().getConfirmationMessage(),
                "Thank you for your order!"
        );
    }

    @Then("I should see the checkout information page")
    public void i_should_see_the_checkout_information_page() {

        Assert.assertEquals(
        		pages.getCheckoutPage().getCheckoutTitle(),
                "Checkout: Your Information"
        );
    }

    @Then("I should see a checkout error")
    public void i_should_see_a_checkout_error() {

        Assert.assertTrue(
        		pages.getCheckoutPage().getErrorMessage()
                        .contains("First Name"),
                "Checkout error was not displayed"
        );
    }

    @When("I cancel checkout")
    public void i_cancel_checkout() {

    	pages.getCheckoutPage().clickCancel();
    }

    @Then("I should be on the cart page")
    public void i_should_be_on_the_cart_page() {

        Assert.assertTrue(
                DriverFactory.getDriver()
                        .getCurrentUrl()
                        .contains("cart.html"),
                "User is not on the cart page"
        );
    }
}
