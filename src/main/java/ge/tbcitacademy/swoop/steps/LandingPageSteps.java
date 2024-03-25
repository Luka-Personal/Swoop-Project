package ge.tbcitacademy.swoop.steps;
import ge.tbcitacademy.swoop.pages.LandingPage;
import org.openqa.selenium.WebDriver;

public class LandingPageSteps extends BasePageSteps{
    private final WebDriver driver;
    public LandingPage landingPage;
    public LandingPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        landingPage = new LandingPage(driver);
    }
    public HolidaysPageSteps clickHolidaysButton() {
        landingPage.holidaysButton.click();
        return new HolidaysPageSteps(driver);
    }
    public MoviesPageSteps clickMovieButton() {
        landingPage.moviesButton.click();
        return new MoviesPageSteps(driver);
    }
    public void clickCategoriesButton() {
        landingPage.categoriesButton.click();
    }
    public void hoverOnSports() {
        action.moveToElement(landingPage.sportsAnchor).perform();
    }
    public GoCartSteps clickGoCartAnchor() {
        landingPage.goCartAnchor.click();
        return new GoCartSteps(driver);
    }
    public boolean isHomepageBannerDisplayed() {
        return landingPage.homePageBanner.isDisplayed();
    }
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

}
