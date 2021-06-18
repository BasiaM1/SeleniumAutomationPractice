package pages;

import models.Gender;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WaitTypes;


public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#id_gender1")
    WebElement maleRBtn;

    @FindBy(css="#id_gender2")
    WebElement femaleRBtn;

    @FindBy(css="#customer_firstname")
    WebElement firstNameInput;

    @FindBy(css="#customer_lastname")
    WebElement lastNameInput;

    @FindBy(css="#passwd")
    WebElement passwordInput;

    @FindBy(css="#address1")
    WebElement addrStreetInput;

    @FindBy(css="#city")
    WebElement addrCityInput;

    @FindBy(css="#id_state")
    WebElement addrStateSelect;

    @FindBy(css="#postcode")
    WebElement addrPostalCodeInput;

    @FindBy(css="#id_country")
    WebElement addrCountrySelect;

    @FindBy(css="#phone_mobile")
    WebElement addrPhoneInput;

    @FindBy(css="#alias")
    WebElement addrAliasInput;

    @FindBy(css="#submitAccount")
    WebElement registerBtn;

    public void registerUser(User user) {

        sendKeys(firstNameInput, user.getFirstName());
        sendKeys(lastNameInput, user.getLastName());
        sendKeys(passwordInput, user.getPassword());
        sendKeys(addrStreetInput, user.getStreet());
        sendKeys(addrCityInput, user.getCity());
        selectElement(addrStateSelect,user.getState());
        sendKeys(addrPostalCodeInput, user.getPostalCode());
        selectElement(addrCountrySelect, user.getCountry());
        sendKeys(addrPhoneInput, user.getPhone());
        sendKeys(addrAliasInput, user.getAlias());
        if(user.getGender() == Gender.FEMALE){
            click(femaleRBtn);
        }else{
            click(maleRBtn);
        }
        click(registerBtn);
    }

}
