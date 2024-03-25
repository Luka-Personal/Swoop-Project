package ge.tbcitacademy.swoop.data;
public class Constants {
    public static final String SWOOP_URL = "https://www.swoop.ge/",
    SCROLL_AND_CLICK_SCRIPT =
            "arguments[0].scrollIntoView();" + "arguments[0].click();",
    LOADING_TIMEOUT_ERROR_MESSAGE =
            "Loading took too long. Potential error.",
    NEXT_BUTTON_ENABLED_STYLE = "pointer-events: auto;",
    GET_ATTR_STYLE = "style",
    MIN_PRICE_MISMATCH_ERROR = "Expected minimum price did not match. Expected: %s, Actual: %s",
    MAX_PRICE_MISMATCH_ERROR = "Expected maximum price did not match. Expected: %s, Actual: %s",
    CSS_COLOR_PROPERTY = "color",
    HREF_ATTRIBUTE = "href",
    FILTER_ASCENDING_VALUE = "2",
    FILTER_DESCENDING_VALUE = "1",
    INVALID_BROWSER_MESSAGE = "Browser is not correct",
    LANGUAGE_CODE_GEORGIAN = "ka",
    COUNTRY_CODE_GEORGIA = "GE",
    BROWSER_CHROME = "chrome",
    BROWSER_EDGE = "edge",
    BROWSER_FIREFOX = "firefox",
    NO_FREE_SEAT_MESSAGE = "NO FREE SEAT AVAILABLE!!!",
    USER_EMAIL = "luka111com.gmail",
    USER_PASSWORD1 = "Password123",
    USER_PASSWORD2 = "Password123",
    USER_NAME = "luka",
    USER_SURNAME = "tsinaridze",
    USER_BIRTH_YEAR = "2003",
    USER_PHONE_NUMBER = "579020004",
    FIREFOX_SET_BIRTH_YEAR_SCRIPT = "arguments[0].value='2003'; arguments[0].dispatchEvent(new Event('change'))",
    COTTAGE_WORD = "კოტეჯი",
    COTTAGE_VALIDATION_MSG =
            "Expected '" + COTTAGE_WORD + "' to be present in all holiday listings, but it was not the case.",
    FILTER_SORT_MISMATCH_MSG_DESC = "Filter and sorting mismatch: Expected highest price from filter: %d, but first house on sorted page shows: %d",
    FILTER_SORT_MISMATCH_MSG_ASC= "Filter and sorting mismatch: Expected lowest price from filter: %d, but first house on sorted page shows: %d",
    EXPECTED_CART_URL = "https://www.swoop.ge/category/2058/sporti/kartingi",
    CART_URL_MISMATCH_MSG = "Go-Cart page URL mismatch.",
    EXPECTED_GO_CART_COLOR = "#6E7CFA".toUpperCase(), // for safety.
    GO_CART_COLOR_MISMATCH_MSG = "Go-Cart color mismatch.",
    PAGE_TITLE_MISMATCH_MSG = "Page title mismatch.",
    HOMEPAGE_BANNER_MISMATCH_MSG = "Homepage banner visibility mismatch.",
    CINEMA_NAME = "კავეა ისთ ფოინთი",
    CAVEA_SEANCES_VALIDATION_ERROR = "Not all seances belong to 'კავეა ისთ ფოინთი'.",
    EXPECTED_EMAIL_ERROR_MSG = "მეილის ფორმატი არასწორია!",
    EMAIL_ERROR_MISMATCH_MSG = "Email error msg mismatch.";
    public static final int MIN_PRICE = 50,
    MAX_PRICE = 70,
    DRIVER_WAIT_TIME = 10;
}
