package ge.tbcitacademy.swoop.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HolidaysPage extends BasePage {
    public final String categorySection = ".//div[@class='category-filter-desk']";
    @FindBy(xpath = categorySection + "//label[text() = 'კოტეჯი']")
    public WebElement filterCheckbox;
    @FindBy(xpath = categorySection + "//input[@id='minprice']")
    public WebElement filterInputMinPrice;
    @FindBy(xpath = categorySection + "//input[@id='maxprice']")
    public WebElement filterInputMaxPrice;
    @FindBy(xpath = categorySection + "//div[@class='submit-button']")
    public WebElement submitPriceRangeButton;
    @FindBy(css = ".pagination .pager-filter:nth-last-child(2) a")
    public WebElement nextButton;
    @FindBy(xpath = ".//div[@class='discounted-prices']//p[@class='deal-voucher-price' and not(@style='text-decoration: line-through;')]")
    public List<WebElement> housePrice;
    @FindBy(xpath = ".//div[@class='special-offer-title']/a/p")
    public List<WebElement> houseHeadings;
    @FindBy(xpath = ".//div[contains(@class, 'special-offer-text')]")
    public List<WebElement> houseDescriptions;
    @FindBy(css = ".Newlogo")
    public WebElement homeButton;
    @FindBy(css = ".deal-container .special-offer:first-child .discounted-prices p:first-child")
    public WebElement firstHouseElement;
    @FindBy(css = "select#sort")
    public WebElement filterSelect;
    public final By loadingDotsBy = By.xpath("//div[@class='spinner']");
    public HolidaysPage(WebDriver driver) {
        super(driver);
    }

}