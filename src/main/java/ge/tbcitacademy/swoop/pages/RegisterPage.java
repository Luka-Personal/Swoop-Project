package ge.tbcitacademy.swoop.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    @FindBy(css = "input#email")
    public WebElement emailInput;
    @FindBy(css = "input#password")
    public WebElement passwordInput1;
    @FindBy(css = "input#PasswordRetype")
    public WebElement passwordInput2;
    @FindBy(css = "input#Gender1")
    public WebElement genderRadio;
    @FindBy(css = "input#name")
    public WebElement nameInput;
    @FindBy(css = "input#surname")
    public WebElement surnameInput;
    @FindBy(name = "birth_year")
    public WebElement birthYearSelect;
    @FindBy(css = "input#Phone")
    public WebElement phoneNumberInput;
    @FindBy(css = "input#PhoneCode")
    public WebElement smsCodeInput;
    private final String checkboxSpan = "//parent::label/span[@class='checkmark']";
    @FindBy(xpath = ".//input[@name='agree_terms']"+checkboxSpan)
    public WebElement agreeRulesCheckBox1;
    @FindBy(xpath = ".//input[@id='tbcAgreement']"+checkboxSpan)
    public WebElement agreeRulesCheckBox2;
    @FindBy(css = "button#registrationBtn")
    public WebElement buttonSubmit;
    @FindBy(css = "p#input-error-email")
    public WebElement emailInvalidMessageBy;
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
}
