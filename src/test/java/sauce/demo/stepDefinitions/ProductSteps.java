package sauce.demo.stepDefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sauce.demo.factory.DriverFactory;

import sauce.demo.utils.PageManager;

public class ProductSteps {

	private PageManager pages = new PageManager();
	

    @Then("I should see the products page")
    public void i_should_see_the_products_page() {
        Assert.assertEquals(
                pages.getProductsPage().getPageTitle(),
                "Products"
        );
    }

    @Then("I should see multiple products")
    public void i_should_see_multiple_products() {

        Assert.assertTrue(
        		pages.getProductsPage().getProductCount() > 1,
                "Products are not displayed"
        );
    }

    @When("I sort products by {string}")
    public void i_sort_products_by(String sortingOption) {
        pages.getProductsPage().sortProducts(sortingOption);
        //wait to let UI update
        try { Thread.sleep(1000); 
        } catch (InterruptedException e) 
        { e.printStackTrace(); }
    }
    @Then("the products should be sorted by {string}")
    public void the_products_should_be_sorted_by(String sortingOption) {
        if (sortingOption.equals("Name (A to Z)")) {
            List<String> actual = pages.getProductsPage().getProductNames();
            List<String> expected = new ArrayList<>(actual);
            Collections.sort(expected);
            Assert.assertEquals(actual, expected, "Products are not sorted A to Z");
        }
        else if (sortingOption.equals("Name (Z to A)")) {
            List<String> actual = pages.getProductsPage().getProductNames();
            List<String> expected = new ArrayList<>(actual);
            expected.sort(Collections.reverseOrder());
            Assert.assertEquals(actual, expected, "Products are not sorted Z to A");
        }
        else if (sortingOption.equals("Price (low to high)")) {
            List<Double> actual = pages.getProductsPage().getProductPrices();
            List<Double> expected = new ArrayList<>(actual);
            Collections.sort(expected);
            Assert.assertEquals(actual, expected, "Products are not sorted low to high");
        }
        else if (sortingOption.equals("Price (high to low)")) {
            List<Double> actual = pages.getProductsPage().getProductPrices();
            List<Double> expected = new ArrayList<>(actual);
            expected.sort(Collections.reverseOrder());
            Assert.assertEquals(actual, expected, "Products are not sorted high to low");
        }
    }

    @When("I open the first product")
    public void i_open_the_first_product() {

    	pages.getProductsPage().clickFirstProduct();
    }

    @Then("I should see the product details")
    public void i_should_see_the_product_details() {

        Assert.assertTrue(
                DriverFactory.getDriver()
                        .getCurrentUrl()
                        .contains("inventory-item"),
                "Product details page was not opened"
        );
    }
}
