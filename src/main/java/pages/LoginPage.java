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

    @FindBy(css = "#email_create")
    WebElement emailInput;

    @FindBy(css = "[name='SubmitCreate'] span")
    WebElement createAccountBtn;

    @FindBy(css = "#email")
    WebElement emailLogin;

    @FindBy(css = "#passwd")
    WebElement passwordLogin;

    @FindBy(css = "#SubmitLogin")
    WebElement signInButton;

    public HomePage login(User user) {
        sendKeys(emailLogin, user.getEmail());
        sendKeys(passwordLogin, user.getPassword());
        click(signInButton);
        return new HomePage(getDriver());

    }


    public RegistrationPage openRegisterPage(User user) {
        sendKeys(emailInput, user.getEmail());
        click(createAccountBtn);
        wt.pageAvailable(getDriver(),15,"http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        return new RegistrationPage(getDriver());
    }
}
