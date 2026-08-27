package sauce.demo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import sauce.demo.factory.DriverFactory;

public class ProductsPage extends BasePage {
	WebDriver driver;
	public ProductsPage(WebDriver driver) {
        super(driver);
        driver = DriverFactory.getDriver();
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
	// Page title
	@FindBy(className = "title")
	WebElement pageTitle;

	// Product cards
	@FindBy(className = "inventory_item")
	List<WebElement> products;

	// Product names
	@FindBy(className = "inventory_item_name")
	List<WebElement> productNames;

	// Product prices
	@FindBy(className = "inventory_item_price")
	List<WebElement> productPrices;

	// Sorting dropdown
	@FindBy(className = "product_sort_container")
	WebElement sortDropdown;

	// Add to cart buttons
	@FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
	List<WebElement> addToCartButtons;

	// Cart badge
	@FindBy(css = ".shopping_cart_badge")
	WebElement cartBadge;

	// Go to cart
	@FindBy(className = "shopping_cart_link")
	WebElement cartPage;

	public String getPageTitle() {

		return getText(pageTitle);
	}

	public int getProductCount() {

		return products.size();
	}

	public List<String> getProductNames() {

		return productNames.stream().map(element -> element
						.getText()).toList();
	}

	public List<Double> getProductPrices() {

		return productPrices
	            .stream()
	            .map(element ->
	                    Double.parseDouble(
	                            element.getText()
	                                    .replace("$", ""))).toList();
	}

	public void sortProducts(String sortingOption) {

		Select select = new Select(sortDropdown);

		select.selectByVisibleText(sortingOption);
	}

	public void clickFirstProduct() {
		WebElement firstProduct =
		        productNames.get(0);

		click(firstProduct);
		
	}

	public void addFirstProductToCart(){
		
		click(addToCartButtons.get(0));
	}

	public int cartBadgeCheck() {
		return Integer.parseInt(getText(cartBadge));
	}

	public void openCart() {

		click(cartPage);
	}

	public void addSecondProductToCart() {
		click(addToCartButtons.get(1));

	}

}
