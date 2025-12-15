package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private By addToCartBtn = By.id("add-to-cart-button");
    private By productTitle = By.id("productTitle");
    private By price = By.cssSelector("#corePrice_desktop span.a-price-whole");
    private By buyNowBtn = By.id("buy-now-button");

    public String getProductName() {
        return getText(productTitle);
    }

    public AddToCartPage addToCart() {
        click(addToCartBtn);
        return new AddToCartPage();
    }
    
    public String getProductPrice() {
	return getText(price);
    }
    
    public void clickbuyNow() {
    	click(buyNowBtn);
    }
    
    public boolean titleContains(String expectedtitle) {
    	
    return	getProductName().toLowerCase().contains(expectedtitle.toLowerCase());
    }
    
    
}
