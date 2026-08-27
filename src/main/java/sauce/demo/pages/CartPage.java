package sauce.demo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sauce.demo.factory.DriverFactory;

public class CartPage extends BasePage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
        driver = DriverFactory.getDriver();
        this.driver=driver;
        PageFactory.initElements(driver, this);
	}

	@FindBy(className = "cart_item")
	List<WebElement> cartItems;

	@FindBy(className = "inventory_item_name")
	List<WebElement> productNames;

	@FindBy(className = "inventory_item_price")
	List<WebElement> productPrices;

	@FindBy(css = ".cart_quantity")
	List<WebElement> quantities;

	@FindBy(xpath = "//button[contains(@id,'remove')]")
	List<WebElement> removeButtons;

	@FindBy(id = "continue-shopping")
	WebElement continueShoppingButton;

	@FindBy(id = "checkout")
	WebElement checkoutButton;

	public int getCartItemCount() {

		return cartItems.size();
	}

	public String getFirstProductName() {

		return getText(productNames.get(0));
	}

	public String getFirstProductPrice() {

		return getText(productPrices.get(0));
	}

	public String getFirstProductQuantity() {

		return getText(quantities.get(0));
	}

	public void removeFirstProduct() {
		click(removeButtons.get(0));
	}

	public void continueShopping() {

		click(continueShoppingButton);
	}

	public void clickCheckout() {

		click(checkoutButton);
	}
}
