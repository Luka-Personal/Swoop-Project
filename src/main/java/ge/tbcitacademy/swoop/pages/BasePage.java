package ge.tbcitacademy.swoop.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public By closeCookieButtonBy = By.xpath(".//div[@class='acceptCookie']");
    public WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
