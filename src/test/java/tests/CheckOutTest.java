package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.ProductPage;
import pages.AddToCartPage;
import pages.CartPage;

public class CheckOutTest extends TestBase {

    @Test(groups = {"regression"})
    public void testCheckoutFlow() {

        // 1️⃣ Search product
        SearchResultsPage results = new HomePage()
                .search("Laptop");

        Assert.assertTrue(
                results.titleContains("Laptop"),
                "Search results did not match!"
        );

        // 2️⃣ Click first product
        ProductPage product = results.clickFirstProduct();

        // 3️⃣ Add to Cart
        AddToCartPage atc = product.addToCart();

        Assert.assertTrue(
                atc.isProductAdded(),
                "Add to Cart confirmation message NOT shown!"
        );

        // 4️⃣ Go to Cart
        CartPage cart = atc.clickCart();

        Assert.assertTrue(
                cart.getCartCount() > 0,
                "Cart is empty after adding product!"
        );

        // 5️⃣ Proceed to Checkout
        cart.proceedToCheckout();

        // 🌟 Expected: Amazon redirects to Sign-In page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains("signin") || currentUrl.contains("ap/signin"),
                "Checkout did NOT redirect to Login Page!"
        );

        System.out.println("Checkout redirected to Login Page (Expected behavior).");
    }
}
