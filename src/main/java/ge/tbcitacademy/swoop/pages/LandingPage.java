package ge.tbcitacademy.swoop.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
    @FindBy(xpath = ".//li[@class='MoreCategories']//a[normalize-space(.)='დასვენება']")
    public WebElement holidaysButton;
    @FindBy(xpath = ".//div[contains(@class, 'NewCategories')]")
    public WebElement categoriesButton;
    @FindBy(xpath = ".//a[@class='mainCategories' and normalize-space(text())='სპორტი']")
    public WebElement sportsAnchor;
    @FindBy(xpath = ".//a[text()='კარტინგი']")
    public WebElement goCartAnchor;
    @FindBy(xpath = ".//div[contains(@class, 'TopBannersNew')]")
    public WebElement homePageBanner;
    @FindBy(xpath = ".//li[@class='MoreCategories']//a[normalize-space(.)='კინო']")
    public WebElement moviesButton;
    public LandingPage(WebDriver driver) {
        super(driver);
    }
}
