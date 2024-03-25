package ge.tbcitacademy.swoop.tests.config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import static ge.tbcitacademy.swoop.data.Constants.*;

public class WebDriverFactory {
    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void openURL() {
        driver.get(SWOOP_URL);
    }

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase(BROWSER_CHROME)){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase(BROWSER_EDGE)){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase(BROWSER_FIREFOX)){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException(INVALID_BROWSER_MESSAGE);
        }
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
    }
    @AfterClass
    public void teardown() {
        driver.quit();
    }
}