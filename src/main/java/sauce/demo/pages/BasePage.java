package sauce.demo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sauce.demo.factory.DriverFactory;

public class BasePage {

	protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void enterText(WebElement locator, String text) {

        wait.until(ExpectedConditions.visibilityOf(locator)).clear();
        wait.until(ExpectedConditions.visibilityOf(locator)).sendKeys(text);
    }

    protected String getText(WebElement locator) {

        return wait.until(ExpectedConditions.visibilityOf(locator)).getText();
    }

    protected boolean isDisplayed(WebElement locator) {

        return wait.until(ExpectedConditions.visibilityOf(locator)).isDisplayed();
    }

    protected void waitForElement(WebElement locator) {

        wait.until(ExpectedConditions.visibilityOf(locator));
    }	
}
