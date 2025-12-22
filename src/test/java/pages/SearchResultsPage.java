package pages;

import org.openqa.selenium.By;

import utilities.WaitUtils;

public class SearchResultsPage extends BasePage {

    // Locators
    private By resultsTitle = By.cssSelector("span.a-color-state");
    private By firstProduct = By.xpath(
            "(//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal'])[1]"
    );

    /**
     * Verify search results title contains product name.
     */
    public boolean titleContains(String product) {
        return getText(resultsTitle).contains(product);
    }

    /**
     * Click the first product in search results.
     */
    public ProductPage clickFirstProduct() {

        // Wait for search results to load
        WaitUtils.waitforVisibility(By.xpath("//div[@data-component-type='s-search-result']"));

        // Scroll to the first result
        scrollIntoView(firstProduct);

        // Ensure element is visible & clickable
        WaitUtils.waitforVisibility(firstProduct);
        WaitUtils.waitforClickable(firstProduct);

        // Click product
        click(firstProduct);

        // Switch to new tab if Amazon opens it
        switchToNewTabIfOpened();

        return new ProductPage();
    }
}
