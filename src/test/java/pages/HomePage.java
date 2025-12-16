package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
	
	private By searchBox =  By.id("twotabsearchtextbox");
    private By searchBtn = By.id("nav-search-submit-button");
    
    public  SearchResultsPage  search(String product) {
    	
    	input(searchBox,product);
    	
    	click(searchBtn);
    	
    	return new SearchResultsPage();
    	
        }
    	
    
    
}
