package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    // Locators
    private By addToCartBtn =
            By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']");
    private By productTitle = By.id("productTitle");
    private By price = By.cssSelector("#corePrice_desktop span.a-price-whole");
    private By buyNowBtn = By.id("buy-now-button");

    /**
     * Get product name.
     */
    public String getProductName() {
        return getText(productTitle);
    }

    /**
     * Add product to cart.
     */
    public AddToCartPage addToCart() {
        scrollIntoView(addToCartBtn);
        click(addToCartBtn);
        return new AddToCartPage();
    }

    /**
     * Get product price.
     */
    public String getProductPrice() {
        return getText(price);
    }

    /**
     * Click Buy Now button.
     */
    public void clickBuyNow() {
        click(buyNowBtn);
    }

    /**
     * Verify product title contains expected text.
     */
    public boolean titleContains(String expectedTitle) {
        return getProductName()
                .toLowerCase()
                .contains(expectedTitle.toLowerCase());
    }
}
