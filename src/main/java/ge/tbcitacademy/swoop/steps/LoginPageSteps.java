package ge.tbcitacademy.swoop.steps;
import ge.tbcitacademy.swoop.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps extends BasePageSteps{
    private final WebDriver driver;
    public LoginPage loginPage;
    protected LoginPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }
    public RegisterPageSteps clickRegisterButton() {
        loginPage.registerButton.click();
        return new RegisterPageSteps(driver);
    }
}
