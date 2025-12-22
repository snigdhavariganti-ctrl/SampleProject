package tests;

import org.testng.annotations.Test;

import base.TestBase;
import pages.AddToCartPage;
import pages.HomePage;
import pages.ProductPage;

public class ProductTest extends TestBase {

    @Test
    public void testAddToCart() {

        ProductPage productPage =
                new HomePage().search("Laptop").clickFirstProduct();

        AddToCartPage cart = productPage.addToCart();

        cart.clickCart();

        assert cart.getCartCount() > 0 : "❌ Cart count is zero after adding product";
    }
}
