package ge.tbcitacademy.swoop.steps;
import ge.tbcitacademy.swoop.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static ge.tbcitacademy.swoop.data.Constants.*;

public class BasePageSteps {
    protected WebDriver driver;
    protected WebDriverWait waitLong;
    protected JavascriptExecutor js;
    protected Actions action;
    public BasePage basePage;
    protected BasePageSteps(WebDriver driver) {
        basePage = new BasePage(driver);
        this.driver = driver;
        waitLong = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
        dismissCookieBanner();
    }
    public void waitForSpinnerElementToAppearAndDisappear(By element) {
        try {
            WebElement spinner = waitLong.until(ExpectedConditions.presenceOfElementLocated(element));
            waitLong.until(ExpectedConditions.invisibilityOf(spinner));
        } catch (TimeoutException e) {
            System.err.println(LOADING_TIMEOUT_ERROR_MESSAGE);
        }
    }
    public WebElement waitForElementToBeClickable(WebElement element) {
        return waitLong.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void dismissCookieBanner() {
        try {
            driver.findElement(basePage.closeCookieButtonBy).click();
        } catch (NoSuchElementException ignored) {}
    }
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
    public void moveToElementAndClick(WebElement element, boolean useJS) {
        if(useJS) {
            js.executeScript(SCROLL_AND_CLICK_SCRIPT, element);
        } else {
            action.moveToElement(element).click().perform();
        }
    }
    public WebElement waitForElementToAppear(WebElement element) {
        return waitLong.until(ExpectedConditions.visibilityOf(element));
    }
    public void sendKeysToElement(WebElement element, String string) {
        element.sendKeys(string);
    }
}
