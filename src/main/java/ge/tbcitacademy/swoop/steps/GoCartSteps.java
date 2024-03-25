package ge.tbcitacademy.swoop.steps;
import ge.tbcitacademy.swoop.pages.GoCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import static ge.tbcitacademy.swoop.data.Constants.*;

public class GoCartSteps extends BasePageSteps{
    public GoCartPage goCartPage;
    protected GoCartSteps(WebDriver driver) {
        super(driver);
        goCartPage = new GoCartPage(driver);
    }
    public String getSiteGoCartColor() {
        String siteColorRGB = goCartPage.getGoCartAnchorOpen.getCssValue(CSS_COLOR_PROPERTY);
        return Color.fromString(siteColorRGB).asHex().toUpperCase();
    }
}
