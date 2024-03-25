package ge.tbcitacademy.swoop.steps;
import ge.tbcitacademy.swoop.pages.RegisterPage;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import static ge.tbcitacademy.swoop.data.Constants.*;

public class RegisterPageSteps extends BasePageSteps {
    public RegisterPage registerPage;
    private final Capabilities capabilities;

    protected RegisterPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        registerPage = new RegisterPage(driver);
        capabilities = ((RemoteWebDriver) driver).getCapabilities();
    }

    public void fillRegistrationData() {
        registerPage.emailInput.sendKeys(USER_EMAIL);
        registerPage.passwordInput1.sendKeys(USER_PASSWORD1);
        registerPage.passwordInput2.sendKeys(USER_PASSWORD2);
        registerPage.genderRadio.click();
        registerPage.nameInput.sendKeys(USER_NAME);
        registerPage.surnameInput.sendKeys(USER_SURNAME);
        if(capabilities.getBrowserName().equalsIgnoreCase(BROWSER_FIREFOX)) {
            js.executeScript(FIREFOX_SET_BIRTH_YEAR_SCRIPT, registerPage.birthYearSelect);
        } else {
            Select select = new Select(registerPage.birthYearSelect);
            select.selectByValue(USER_BIRTH_YEAR);
        }
        registerPage.phoneNumberInput.sendKeys(USER_PHONE_NUMBER);
        registerPage.smsCodeInput.sendKeys(USER_PHONE_NUMBER);

        moveToElementAndClick(registerPage.agreeRulesCheckBox1, true);
        moveToElementAndClick(registerPage.agreeRulesCheckBox2, true);
        moveToElementAndClick(registerPage.buttonSubmit, true);
    }
    public String returnInvalidEmailPageMsg() {
        WebElement invalidEmailMessage = waitForElementToAppear(registerPage.emailInvalidMessageBy);
        return invalidEmailMessage.getText();
    }
}
