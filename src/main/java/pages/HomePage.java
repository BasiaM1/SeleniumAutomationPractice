package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        menuPage = new MenuPage(driver); //menuPage dorzucone jest tu jako pole tek klasy HomePage
    }
    private final MenuPage menuPage;

    public MenuPage getMenu() {
        return menuPage;
    }
}
