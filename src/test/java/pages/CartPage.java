package pages;

import org.openqa.selenium.By;

<<<<<<< HEAD
=======
import utilities.WaitUtils;

>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
public class CartPage extends BasePage {

    // Locators
    private By cartItems = By.cssSelector(".sc-list-item-content");
    private By firstItemTitle = By.cssSelector("span.a-truncate-cut");
    private By deleteButtons = By.xpath("//input[@value='Delete']");
    private By proceedToCheckoutBtn = By.name("proceedToRetailCheckout");
    private By cartCount = By.id("nav-cart-count");
<<<<<<< HEAD
=======
    private By signInHeader = By.tagName("h1"); // text = "Sign in"

>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050

    /**
     * Get number of items shown in cart icon.
     */
    public int getCartCount() {
        String count = getText(cartCount).trim();
        if (count.equals("")) return 0;
        return Integer.parseInt(count);
    }

    /**
     * Get the title of the first item present in cart.
     */
    public String getFirstItemName() {
        return getText(firstItemTitle).trim();
    }

    /**
     * Delete the first available item in cart.
     */
    public CartPage deleteFirstItem() {
        click(deleteButtons);
        return this;
    }

    /**
     * Proceed to checkout page.
     */
    public CheckoutPage proceedToCheckout() {
        scrollIntoView(proceedToCheckoutBtn);
        click(proceedToCheckoutBtn);
<<<<<<< HEAD
=======
        WaitUtils.waitforVisibility(signInHeader);
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
        return new CheckoutPage();
    }

    /**
     * Check if cart is empty.
     */
    public boolean isCartEmpty() {
        return getCartCount() == 0;
    }

    /**
     * Check if any cart item exists.
     */
    public boolean hasItems() {
        return !driver.findElements(cartItems).isEmpty();
    }
}
