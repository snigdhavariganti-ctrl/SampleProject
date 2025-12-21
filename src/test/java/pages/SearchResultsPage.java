package pages;

import org.openqa.selenium.By;

<<<<<<< HEAD
public class SearchResultsPage extends BasePage {
	
    private By resultsTitle = By.cssSelector("span.a-color-state");
    private By firstProduct = By.cssSelector("div[data-component-type='s-search-result'][data-index='1']");
=======
import utilities.WaitUtils;

public class SearchResultsPage extends BasePage {
	
    private By resultsTitle = By.cssSelector("span.a-color-state");
    private By firstProduct = By.xpath("(//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal'])[1]");
    
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
    public boolean titleContains(String product) {
    	
    	return getText(resultsTitle).contains(product);
    }

    public ProductPage clickFirstProduct() {
<<<<<<< HEAD
    	
  	  click(firstProduct);
=======
    	WaitUtils.waitforVisibility(By.xpath("//div[@data-component-type='s-search-result']"));

        // scroll to the first result
        scrollIntoView(firstProduct);

        // wait until this element is visible + clickable
        WaitUtils.waitforVisibility(firstProduct);
        WaitUtils.waitforClickable(firstProduct);
    	
        click(firstProduct);
        switchToNewTabIfOpened();   // <- You MUST add this

>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
  	  
  	  return new ProductPage();
  }


}
