package AutomationPractice;

import TestBase.TestBase;
import models.Product;
import org.junit.jupiter.api.Test;
import pages.ProductDetailsPage;
import pages.ProductMiniaturePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class ProductTest extends TestBase {

    @Test
    public void shouldVerifyRandomProduct() {
        ProductMiniaturePage miniaturePage = homePage.getRandomProduct();
        String expectedName = miniaturePage.getProductName();
        String expectedPrice = miniaturePage.getProductPrice();

        ProductDetailsPage productDetailsPage = miniaturePage.openProduct();

        assertThat(productDetailsPage.getProductName(), equalTo(expectedName));
        assertThat(productDetailsPage.getProductPrice(), equalTo(expectedPrice));
    }

    @Test
    //with using model
    public void shouldVerifyRandomProductAlternative() {
        ProductMiniaturePage miniaturePage = homePage.getRandomProduct();
        Product expectedProduct = miniaturePage.toProduct();

        Product actualProduct = miniaturePage.openProduct()
                .toProduct();

        assertThat(actualProduct, samePropertyValuesAs(expectedProduct));


    }
}
