package pages;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ProductMiniaturePage extends BasePage {
    public ProductMiniaturePage(WebDriver driver, WebElement productMiniature) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature), this);
    }

    @FindBy(css = "#homefeatured .right-block .product-name")
    private WebElement name;

    @FindBy(css = "#homefeatured .right-block .price")
    private WebElement price;

    public String getProductName() {
        return name.getText();
    }

    public String getProductPrice() {
        return price.getText();
    }

    public ProductDetailsPage openProduct(){
        click(name);
        return new ProductDetailsPage(getDriver());
    }

//to co widzi na naszym PO wrzuci do obiektu modelu
    public Product toProduct(){
        return new Product(getProductName(),getProductPrice());
    }
}
