package ge.tbcitacademy.swoop.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GoCartPage extends BasePage{
    @FindBy(xpath = ".//div[@class='category-filter-desk']//span[contains(@class, 'searched-category')]")
    public WebElement getGoCartAnchorOpen;
    public GoCartPage(WebDriver driver) {
        super(driver);
    }
}
