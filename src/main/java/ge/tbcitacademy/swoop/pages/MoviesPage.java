package ge.tbcitacademy.swoop.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MoviesPage extends BasePage {
    private final String movieXpath = "(.//div[@data-filt='384933'] | .//div[img[contains(translate(@src, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'istfointi')]])//ancestor::div[@class='movies-deal']";
    @FindBy(xpath = movieXpath+"//div[@class='info-cinema-ticket']")
    public WebElement buyButton;
    @FindBy(xpath = movieXpath)
    public WebElement firstEastPointMovie;
    @FindBy(xpath = ".//div[@class='movie_first_section']//p[@class='name']")
    public WebElement movieName;
    @FindBy(css = ".movie-title + .movie-cinema")
    public WebElement cinemaName;
    @FindBy(css = ".movie-title")
    public WebElement cinemaTitle;
    @FindBy(css = ".movie-cinema + .movie-cinema")
    public WebElement movieDate;
    @FindBy(css = ".seat.free")
    public WebElement freeSeat;
    @FindBy(xpath = ".//div[contains(@class, 'all-cinemas')]/div[@aria-expanded='true']//li/a")
    public List<WebElement> movieDateButtons;
    @FindBy(xpath = ".//div[contains(@class, 'all-cinemas')]/div[@aria-expanded='true']//div[@aria-hidden='false']/a")
    public List<WebElement> movieSeancesToCheck;
    public final By movieSeanceHrTimeBy = By.cssSelector("p:not([class])");
    public final By movieSeanceTitleBy = By.cssSelector(".cinema-title");
    public final By spinnerBy = By.xpath("//div[@class='spinner']");

    public MoviesPage(WebDriver driver) {
        super(driver);
    }
}
