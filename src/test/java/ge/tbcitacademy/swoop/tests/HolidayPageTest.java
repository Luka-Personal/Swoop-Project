package ge.tbcitacademy.swoop.tests;
import ge.tbcitacademy.swoop.steps.HolidaysPageSteps;
import ge.tbcitacademy.swoop.steps.LandingPageSteps;
import ge.tbcitacademy.swoop.tests.config.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import static ge.tbcitacademy.swoop.data.Constants.*;

public class HolidayPageTest extends WebDriverFactory {
    @Test
    public void descendingOrderTest() {
        LandingPageSteps landingPageSteps = new LandingPageSteps(driver);
        HolidaysPageSteps holidaysPageSteps = landingPageSteps.clickHolidaysButton();
        holidaysPageSteps.getHousePriceOrHouseDes(true, false);
        int maxPrice = holidaysPageSteps.getHighestPriceHouse();
        holidaysPageSteps.selectFilterDesc();
        int maxPricePageSort = holidaysPageSteps.getFirstHouseElement();
        Assert.assertEquals(maxPrice, maxPricePageSort, String.format(FILTER_SORT_MISMATCH_MSG_DESC, maxPrice, maxPricePageSort));
    }

    @Test
    public void ascendingOrderTest() {
        LandingPageSteps landingPageSteps = new LandingPageSteps(driver);
        HolidaysPageSteps holidaysPageSteps = landingPageSteps.clickHolidaysButton();
        holidaysPageSteps.getHousePriceOrHouseDes(true, false);
        int minPrice = holidaysPageSteps.getLowestPriceHouse();
        holidaysPageSteps.selectFilterAsc();
        int minPricePageSort = holidaysPageSteps.getFirstHouseElement();
        Assert.assertEquals(minPrice, minPricePageSort, String.format(FILTER_SORT_MISMATCH_MSG_ASC, minPrice, minPricePageSort));
    }

    @Test
    public void filterTest() {
        LandingPageSteps landingPageSteps = new LandingPageSteps(driver);
        HolidaysPageSteps holidaysPageSteps = landingPageSteps.clickHolidaysButton();
        holidaysPageSteps.selectCheckBoxFilter();
        holidaysPageSteps.getHousePriceOrHouseDes(true, true);
        softAssert.assertTrue(holidaysPageSteps.validateContainsWord(COTTAGE_WORD), COTTAGE_VALIDATION_MSG);
        int minPrice = holidaysPageSteps.getLowestPriceHouse();
        holidaysPageSteps.selectFilterAsc();
        int minPricePageSort = holidaysPageSteps.getFirstHouseElement();
        softAssert.assertEquals(minPrice, minPricePageSort, String.format(FILTER_SORT_MISMATCH_MSG_ASC, minPrice, minPricePageSort));
        softAssert.assertAll();
    }

    @Test
    public void priceRangeTest() {
        LandingPageSteps landingPageSteps = new LandingPageSteps(driver);
        HolidaysPageSteps holidaysPageSteps = landingPageSteps.clickHolidaysButton();
        holidaysPageSteps.inputPriceRangeAndSubmit(MIN_PRICE, MAX_PRICE);
        holidaysPageSteps.getHousePriceOrHouseDes(true, false);
        holidaysPageSteps.assertPriceRange();
    }
}
