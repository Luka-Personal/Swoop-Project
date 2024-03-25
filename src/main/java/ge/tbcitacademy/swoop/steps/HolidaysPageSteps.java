package ge.tbcitacademy.swoop.steps;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import ge.tbcitacademy.swoop.pages.HolidaysPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static ge.tbcitacademy.swoop.data.Constants.*;

public class HolidaysPageSteps extends BasePageSteps{
    private final SoftAssert softAssert;
    private final WebDriver driver;
    public HolidaysPage holidaysPage;
    private int userPriceRangeEnd;
    private int userPriceRangeStart;
    private final List<Integer> housePrices = new ArrayList<>();
    private final ListMultimap<String, String> headingDescPairs = ArrayListMultimap.create();
    private Select select;

    public HolidaysPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        holidaysPage = new HolidaysPage(driver);
        softAssert = new SoftAssert();
    }
    public void setPriceSelect() {
        select = new Select(waitForElementToBeClickable(holidaysPage.filterSelect));
    }
    public void getHousePriceOrHouseDes(boolean getHousePriceData, boolean getHouseDescriptionData) {
        while (true) {
            if (getHousePriceData) {
                holidaysPage.housePrice.forEach(webElementPrice -> {
                    String priceText = webElementPrice.getText();
                    housePrices.add(rmCharAndParseInt(priceText));
                });
            }
            if (getHouseDescriptionData) {
                for (int i = 0; i < holidaysPage.houseHeadings.size(); i++) {
                    String heading = holidaysPage.houseHeadings.get(i).getText();
                    String desc = holidaysPage.houseDescriptions.get(i).getText();
                    headingDescPairs.put(heading, desc);
                }
            }
            if (holidaysPage.nextButton.getAttribute(GET_ATTR_STYLE).toLowerCase().contains(NEXT_BUTTON_ENABLED_STYLE)) {
                holidaysPage.nextButton.click();
            } else {
                break;
            }
        }
    }
    public int getHighestPriceHouse() {
        return Collections.max(housePrices);
    }
    public int getLowestPriceHouse() {
        return Collections.min(housePrices);
    }
    public int rmCharAndParseInt(String housePrice) {
        return Integer.parseInt(housePrice.replaceAll("\\D", ""));
    }
    public int getFirstHouseElement() {
        return rmCharAndParseInt(holidaysPage.firstHouseElement.getText());
    }
    public void assertPriceRange() {
        int maxPrice = getHighestPriceHouse();
        int minPrice = getLowestPriceHouse();
        softAssert.assertEquals(minPrice, userPriceRangeStart,
                String.format(MIN_PRICE_MISMATCH_ERROR, userPriceRangeStart, minPrice));
        softAssert.assertEquals(maxPrice, userPriceRangeEnd,
                String.format(MAX_PRICE_MISMATCH_ERROR, userPriceRangeEnd, maxPrice));
        softAssert.assertAll();
    }
    public boolean validateContainsWord(String containsKeyword) {
        return headingDescPairs.entries().stream()
                .allMatch(entry -> entry.getKey().contains(containsKeyword) ||
                        entry.getValue().contains(containsKeyword));
    }
    public void inputPriceRangeAndSubmit(int priceStart, int priceEnd) {
        holidaysPage.filterInputMinPrice.sendKeys(String.valueOf(priceStart));
        holidaysPage.filterInputMaxPrice.sendKeys(String.valueOf(priceEnd));
        holidaysPage.submitPriceRangeButton.click();
        userPriceRangeEnd = priceEnd;
        userPriceRangeStart = priceStart;
        waitForSpinnerElementToAppearAndDisappear(holidaysPage.loadingDotsBy);
    }
    public void selectFilterAsc() {
        setPriceSelect();
        select.selectByValue(FILTER_ASCENDING_VALUE);
        waitForSpinnerElementToAppearAndDisappear(holidaysPage.loadingDotsBy);
    }
    public void selectFilterDesc() {
        setPriceSelect();
        select.selectByValue(FILTER_DESCENDING_VALUE);
        waitForSpinnerElementToAppearAndDisappear(holidaysPage.loadingDotsBy);
    }
    public void selectCheckBoxFilter() {
        holidaysPage.filterCheckbox.click();
        waitForSpinnerElementToAppearAndDisappear(holidaysPage.loadingDotsBy);
    }
    public LandingPageSteps clickHomeButton() {
        holidaysPage.homeButton.click();
        return new LandingPageSteps(driver);
    }
}
