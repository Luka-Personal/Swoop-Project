package ge.tbcitacademy.swoop.tests;
import ge.tbcitacademy.swoop.steps.GoCartSteps;
import ge.tbcitacademy.swoop.steps.HolidaysPageSteps;
import ge.tbcitacademy.swoop.steps.LandingPageSteps;
import ge.tbcitacademy.swoop.tests.config.WebDriverFactory;
import org.testng.annotations.Test;
import static ge.tbcitacademy.swoop.data.Constants.*;

public class LandingPageTests extends WebDriverFactory {
    @Test
    public void activeCategoryTest() {
        LandingPageSteps landingPageSteps = new LandingPageSteps(driver);
        landingPageSteps.clickCategoriesButton();
        landingPageSteps.hoverOnSports();
        GoCartSteps goCartSteps = landingPageSteps.clickGoCartAnchor();
        softAssert.assertEquals(goCartSteps.getCurrentURL(), EXPECTED_CART_URL, CART_URL_MISMATCH_MSG);
        softAssert.assertEquals(goCartSteps.getSiteGoCartColor(), EXPECTED_GO_CART_COLOR, GO_CART_COLOR_MISMATCH_MSG);
        softAssert.assertAll();
    }
    @Test
    public void logoTest() {
        LandingPageSteps landingPageSteps = new LandingPageSteps(driver);
        String currentPageTitleBefore = landingPageSteps.getCurrentPageTitle();
        HolidaysPageSteps holidaysPageSteps = landingPageSteps.clickHolidaysButton();
        landingPageSteps = holidaysPageSteps.clickHomeButton();
        String currentPageTitleAfter = landingPageSteps.getCurrentPageTitle();
        softAssert.assertEquals(currentPageTitleBefore, currentPageTitleAfter, PAGE_TITLE_MISMATCH_MSG);
        softAssert.assertTrue(landingPageSteps.isHomepageBannerDisplayed(), HOMEPAGE_BANNER_MISMATCH_MSG);
        softAssert.assertAll();
    }
}
