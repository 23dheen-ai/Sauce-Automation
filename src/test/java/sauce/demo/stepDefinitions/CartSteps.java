package sauce.demo.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sauce.demo.factory.DriverFactory;
import sauce.demo.utils.PageManager;

public class CartSteps {
	
	private PageManager pages = new PageManager();

    @When("I add the first product to the cart")
    public void i_add_the_first_product_to_the_cart() throws InterruptedException {
    	Thread.sleep(3000);
    	pages.getProductsPage().addFirstProductToCart();
    }

    @When("I add the second product to the cart")
    public void i_add_the_second_product_to_the_cart() {
    	

    	pages.getProductsPage().addSecondProductToCart();
    }

    @When("I open the shopping cart")
    public void i_open_the_shopping_cart() {

    	pages.getProductsPage().openCart();
    }

    @Then("the cart should contain one product")
    public void the_cart_should_contain_one_product() {

        Assert.assertEquals(
        		pages.getCartPage().getCartItemCount(),
                1,
                "Cart should contain one product"
        );
    }

    @Then("the product name should be displayed")
    public void the_product_name_should_be_displayed() {

        Assert.assertFalse(
        		pages.getCartPage().getFirstProductName().isEmpty(),
                "Product name is not displayed"
        );
    }

    @Then("the product price should be displayed")
    public void the_product_price_should_be_displayed() {

        Assert.assertTrue(
        		pages.getCartPage().getFirstProductPrice()
                        .startsWith("$"),
                "Product price is not displayed correctly"
        );
    }

    @Then("the product quantity should be 1")
    public void the_product_quantity_should_be_1() throws InterruptedException {
    	Thread.sleep(3000);
        Assert.assertEquals(
        		pages.getCartPage().getFirstProductQuantity(),
                "1"
        );
    }

    @When("I remove the first product")
    public void i_remove_the_first_product() {

    	pages.getCartPage().removeFirstProduct();
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {

        Assert.assertEquals(
        		pages.getCartPage().getCartItemCount(),
                0,
                "Cart is not empty"
        );
    }

    @When("I continue shopping")
    public void i_continue_shopping() {

    	pages.getCartPage().continueShopping();
    }

    @Then("I should be on the products page")
    public void i_should_be_on_the_products_page() {

        Assert.assertTrue(
                DriverFactory.getDriver()
                        .getCurrentUrl()
                        .contains("inventory.html")
        );
    }

    @Then("the cart should contain 2 products")
    public void the_cart_should_contain_2_products() {

        Assert.assertEquals(
        		pages.getCartPage().getCartItemCount(),
                2,
                "Cart should contain two products"
        );
    }
}
