package pages;

import org.openqa.selenium.By;

public class AddToCartPage extends BasePage {

    private By addedMessage = By.cssSelector("#NATC_SMART_WAGON_CONF_MSG_SUCCESS");
    private By goToCartBtn = By.id("nav-cart");
    private By cartCount = By.id("nav-cart-count");

    /**
     * Waits for the success message that confirms product added to cart.
     */
    public boolean isProductAdded() {
        return isDisplayed(addedMessage);
    }

    /**
     * Clicks cart icon and navigates to CartPage.
     */
    public CartPage clickCart() {
        click(goToCartBtn);
        return new CartPage();
    }

    /**
     * Returns the cart count displayed in the top-right Amazon cart icon.
     */
    public int getCartCount() {
        String count = getText(cartCount).trim();

        if (count.equals("")) return 0;

        return Integer.parseInt(count);
    }
}
