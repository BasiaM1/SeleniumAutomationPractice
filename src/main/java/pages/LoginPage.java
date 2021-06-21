package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitTypes;

public class LoginPage extends BasePage {
    public WaitTypes wt;

    public LoginPage(WebDriver driver) {
        super(driver);
        wt = new WaitTypes(driver);
    }

    @FindBy(css = ".page-heading")
    private WebElement pageHeading;

    @FindBy(css ="#email_create")
    private WebElement emailInput;

    @FindBy(css = "[name='SubmitCreate']")
    private WebElement createAccountBtn;

    @FindBy(css = "#email")
    private WebElement emailLogin;

    @FindBy(css = "#passwd")
    private WebElement passwordLogin;

    @FindBy(css = "#SubmitLogin")
    private WebElement signInButton;

    public HomePage login(User user) {
        sendKeys(emailLogin, user.getEmail());
        sendKeys(passwordLogin, user.getPassword());
        click(signInButton);
        return new HomePage(getDriver());

    }


    public RegistrationPage openRegisterPage(User user) {
        wt.waitForElementFluent(getDriver(),pageHeading,40,2);
        sendKeys(emailInput, user.getEmail());
        click(createAccountBtn);
        return new RegistrationPage(getDriver());
    }
}
