package pages;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
  @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement name;

    @FindBy(css = "#our_price_display")
    private WebElement price;

    public String getProductName() {
        wt.waitForElement(getDriver(), price, 10);
        return name.getText();
    }

    public String getProductPrice() {
        wt.waitForElement(getDriver(), name, 15);
        return price.getText();
    }
//page object zamienia na model
    public Product toProduct(){
        return new Product(getProductName(),getProductPrice());
    }
}
