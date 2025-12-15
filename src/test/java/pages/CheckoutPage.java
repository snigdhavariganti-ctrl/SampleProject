package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    // -----------------------------
    // ADDRESS SECTION
    // -----------------------------
    private By addressContainer = By.id("address-book-entry-0");
    private By changeAddressBtn = By.id("addressChangeLinkId");
    private By allAddresses = By.cssSelector(".address-book-entry");

    // -----------------------------
    // DELIVERY OPTIONS
    // -----------------------------
    private By deliveryOptions = By.cssSelector(".shipping-speeds .a-form-radio");

    // -----------------------------
    // PAYMENT SECTION
    // -----------------------------
    private By paymentSection = By.id("payment-information");
    private By paymentOptions = By.cssSelector("input[type='radio'][name='ppw-instrumentRowSelection']");
    private By addNewCardBtn = By.id("pp-add-card-button");

    // -----------------------------
    // ORDER SUMMARY
    // -----------------------------
    private By orderSummaryBox = By.id("subtotals-marketplace-table");
    private By orderTotal = By.cssSelector("#subtotals-marketplace-table span.a-color-price");

    // -----------------------------
    // PLACE ORDER BUTTON
    // -----------------------------
    private By placeOrderBtn = By.name("placeYourOrder1");

    // -----------------------------
    // COMMON METHODS
    // -----------------------------

    /** Check if address section is visible */
    public boolean isAddressVisible() {
        return isDisplayed(addressContainer);
    }

    /** Select an address by index */
    public void selectAddress(int index) {
        List<WebElement> addressList = getElements(allAddresses);

        if (addressList.size() == 0) {
            throw new RuntimeException("❌ No addresses found on Checkout Page");
        }

        scrollIntoView(paymentOptions);
        addressList.get(index).click();
    }

    /** Select delivery option by index */
    public void selectDeliveryOption(int index) {
        List<WebElement> options = getElements(deliveryOptions);

        if (options.size() == 0) {
            throw new RuntimeException("❌ Delivery options not found!");
        }

        scrollIntoView(paymentOptions);
        options.get(index).click();
    }

    /** Select payment method by index */
    public void selectPaymentMethod(int index) {
        List<WebElement> payments = getElements(paymentOptions);

        if (payments.size() == 0) {
            throw new RuntimeException("❌ No payment options visible!");
        }

        scrollIntoView(paymentOptions);
        payments.get(index).click();
    }

    /** Return the Order Total as displayed */
    public String getOrderTotal() {
        scrollIntoView(orderSummaryBox);
        return getText(orderTotal);
    }

    /** Click on Place Order Button */
    public void placeOrder() {
        click(placeOrderBtn);
    }

    /** Validate checkout page elements loaded */
    public boolean isCheckoutPageLoaded() {
        return isAddressVisible() && isDisplayed(paymentSection);
    }
}
