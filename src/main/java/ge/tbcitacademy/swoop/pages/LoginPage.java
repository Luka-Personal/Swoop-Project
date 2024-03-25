package ge.tbcitacademy.swoop.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = ".//div[contains(@class, 'create')]")
    public WebElement registerButton;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
