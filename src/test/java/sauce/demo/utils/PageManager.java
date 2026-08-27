package sauce.demo.utils;

import org.openqa.selenium.WebDriver;

import sauce.demo.pages.*;


public class PageManager {

	private LoginPage loginPage;;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private WebDriver driver;
    private ProductsPage productsPage;
    
    public LoginPage getLoginPage() {

        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }

        return loginPage;
    }

    public ProductsPage getProductsPage() {

        if (productsPage == null) {
            productsPage = new ProductsPage(driver);
        }

        return productsPage;
    }

    public CartPage getCartPage() {

        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }

        return cartPage;
    }

    public CheckoutPage getCheckoutPage() {

        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage(driver);
        }

        return checkoutPage;
    }
}
