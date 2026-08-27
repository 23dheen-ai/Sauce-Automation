package sauce.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sauce.demo.factory.DriverFactory;

public class CheckoutPage extends BasePage{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
        driver = DriverFactory.getDriver();
        this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first-name")
	WebElement firstName;

	@FindBy(id = "last-name")
    WebElement lastName;

	@FindBy(id = "postal-code")
    WebElement postalCode;

	@FindBy(id = "continue")
    WebElement continueButton;

	@FindBy(css = ".cart_button")
    WebElement finishButton;

	@FindBy(id = "cancel")
    WebElement cancelButton;

	@FindBy(className = "title")
    WebElement checkoutTitle;

	@FindBy(className = "complete-header")
    WebElement confirmationMessage;

	@FindBy(xpath = "//div[@class='error-message-container error']")
    WebElement errorMessage;

    public String getCheckoutTitle() {

        return getText(checkoutTitle);
    }

    public void enterFirstName(String value) {

        enterText(firstName, value);
    }

    public void enterLastName(String value) {

        enterText(lastName, value);
    }

    public void enterPostalCode(String value) {

        enterText(postalCode, value);
    }

    public void clickContinue() {

        click(continueButton);
    }

    public void clickFinish() {

        click(finishButton);
    }

    public void clickCancel() {

        click(cancelButton);
    }

    public String getConfirmationMessage() {

        return getText(confirmationMessage);
    }

    public String getErrorMessage() {

        return getText(errorMessage);
    }
}

