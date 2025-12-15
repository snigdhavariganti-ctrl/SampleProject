package pages;

import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {
	
    private By resultsTitle = By.cssSelector("span.a-color-state");
    private By firstProduct = By.cssSelector("div[data-component-type='s-search-result'][data-index='1']");
    public boolean titleContains(String product) {
    	
    	return getText(resultsTitle).contains(product);
    }

    public ProductPage clickFirstProduct() {
    	
  	  click(firstProduct);
  	  
  	  return new ProductPage();
  }


}
