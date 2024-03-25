package ge.tbcitacademy.swoop.steps;
import org.openqa.selenium.By;
import ge.tbcitacademy.swoop.pages.MoviesPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import org.testng.asserts.SoftAssert;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import static ge.tbcitacademy.swoop.data.Constants.*;

public class MoviesPageSteps extends BasePageSteps{
    private final WebDriver driver;
    public MoviesPage moviesPage;
    private WebElement lastSeanceElement = null;
    private WebElement lastDateElement = null;
    List<String> actualCinemaNames = new ArrayList<>();
    protected MoviesPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        moviesPage = new MoviesPage(driver);
    }
    public void hoverFirstMovie() {
        action.moveToElement(moviesPage.firstEastPointMovie).perform();
    }
    public void clickBuyButton() {
        waitForElementToAppear(moviesPage.buyButton);
        moviesPage.buyButton.click();
    }
    public void scrollIntoViewAndClick(String cinemaName) {
        WebElement eastPointCinemaElement = driver.findElement(By.xpath("//li/a[text()='" + cinemaName + "']"));
        action.moveToElement(eastPointCinemaElement).click().perform();
    }
    public void setEsatPointSeances() {
        for (WebElement dateButton : moviesPage.movieDateButtons) {
            moveToElementAndClick(dateButton, true);
            lastDateElement = dateButton;
            for (WebElement seanceElement : moviesPage.movieSeancesToCheck) {
                actualCinemaNames.add(seanceElement.findElement(moviesPage.movieSeanceTitleBy).getText().trim());
                lastSeanceElement = seanceElement;
            }
        }
    }
    public boolean validateIsAllCaveaSeances(String cinemaName) {
        return actualCinemaNames.stream().allMatch(s -> s.equalsIgnoreCase(cinemaName));
    }
    public void openVeryLastSeance() {
        action.moveToElement(lastDateElement).click().perform();
        action.moveToElement(lastSeanceElement).click().perform();
        waitForSpinnerElementToAppearAndDisappear(moviesPage.spinnerBy);
    }
    public void assertPopUpInfo(SoftAssert softAssert) {
        String dateHref = lastDateElement.getAttribute(HREF_ATTRIBUTE);
        int lastDotIndex = dateHref.lastIndexOf('.');
        String dateMonth = dateHref.substring(lastDotIndex - 2, lastDotIndex);
        Month month = Month.of(Integer.parseInt(dateMonth));

        String dayDate = lastDateElement.getText().split(" ")[0];
        String monthDate = month.getDisplayName(TextStyle.FULL_STANDALONE, new Locale(LANGUAGE_CODE_GEORGIAN, COUNTRY_CODE_GEORGIA));
        String cinemaName = lastSeanceElement.findElement(moviesPage.movieSeanceTitleBy).getText();
        String dayHour = lastSeanceElement.findElement(moviesPage.movieSeanceHrTimeBy).getText();

        softAssert.assertEquals(moviesPage.movieName.getText(), moviesPage.cinemaTitle.getText());
        softAssert.assertEquals(cinemaName, moviesPage.cinemaName.getText());
        softAssert.assertEquals(dayDate+ " " +monthDate+ " " +dayHour,  moviesPage.movieDate.getText());
    }
    public LoginPageSteps clickFreeSeat() {
        try {
            moviesPage.freeSeat.click();
        } catch (NoSuchElementException e) {
            System.out.println(NO_FREE_SEAT_MESSAGE);
        }
        return new LoginPageSteps(driver);
    }
}
