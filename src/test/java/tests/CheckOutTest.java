package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.ProductPage;
import pages.AddToCartPage;
import pages.CartPage;
<<<<<<< HEAD
import pages.CheckoutPage;
=======
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050

public class CheckOutTest extends TestBase {

    @Test(groups = {"regression"})
    public void testCheckoutFlow() throws Exception {

        // 1️⃣ Search product
        SearchResultsPage results = new HomePage()
                .search("Laptop");

<<<<<<< HEAD
        Assert.assertTrue(results.titleContains("Laptop"), "Search results did not match!");
=======
        Assert.assertTrue(results.titleContains("Laptop"), 
                "❌ Search results did not match!");
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050

        // 2️⃣ Click first product
        ProductPage product = results.clickFirstProduct();

        // 3️⃣ Add to Cart
        AddToCartPage atc = product.addToCart();

<<<<<<< HEAD
        Assert.assertTrue(atc.isProductAdded(), "❌ Add to Cart message did not appear!");
=======
        Assert.assertTrue(atc.isProductAdded(), 
                "❌ Add to Cart confirmation message NOT shown!");
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050

        // 4️⃣ Go to Cart
        CartPage cart = atc.clickCart();

<<<<<<< HEAD
        Assert.assertTrue(cart.getCartCount() > 0, "❌ Cart is empty after adding product!");

        // 5️⃣ Proceed to Checkout
        CheckoutPage checkout = cart.proceedToCheckout();

        Assert.assertTrue(checkout.isCheckoutPageLoaded(),
                "❌ Checkout page did not load correctly!");

        // 6️⃣ Select delivery address (if present)
        if (checkout.isAddressVisible()) {
            checkout.selectAddress(0);
        }

        // 7️⃣ Select delivery option (if present)
        try {
            checkout.selectDeliveryOption(0);
        } catch (Exception e) {
            System.out.println("⚠ No delivery options found. Continuing...");
        }

        // 8️⃣ Select payment method (optional)
        try {
            checkout.selectPaymentMethod(0);
        } catch (Exception e) {
            System.out.println("⚠ No payment options available / login required.");
        }

        // 9️⃣ Validate order total section
        String total = checkout.getOrderTotal();
        Assert.assertTrue(total.contains("₹") || total.length() > 0,
                "❌ Order total not visible!");

        // ️🔟 Place order (DISABLED – will charge real money!)
        // checkout.placeOrder();
        // Assert.fail("Order placed — disable this line for safety!");

        System.out.println("✅ Checkout flow reached payment page successfully.");
=======
        Assert.assertTrue(cart.getCartCount() > 0, 
                "❌ Cart is empty after adding product!");

        // 5️⃣ Proceed to Checkout (expected → goes to Login Page)
        cart.proceedToCheckout();
        


        // 🌟 Expected: Amazon redirects to Sign-in page
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("signin") || url.contains("ap/signin"),
                "❌ Checkout did NOT redirect to Login Page!");

        System.out.println("✅ Checkout redirected to Login Page (Expected behavior).");
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
    }
}
