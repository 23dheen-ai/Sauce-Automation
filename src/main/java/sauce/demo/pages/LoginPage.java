package sauce.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sauce.demo.factory.DriverFactory;

public class LoginPage extends BasePage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		driver = DriverFactory.getDriver();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginButton;
//
//    public void enterUsername(String usernameValue) {
//
//        driver.findElement(username)
//              .sendKeys(usernameValue);
//    }
//
//    public void enterPassword(String passwordValue) {
//
//        driver.findElement(password)
//              .sendKeys(passwordValue);
//    }
//
//    public void clickLogin() {
//
//        driver.findElement(loginButton)
//              .click();
//    }

	public void login(String user, String pass) {

		enterText(username, user);
		enterText(password, pass);
		click(loginButton);
	}
}
