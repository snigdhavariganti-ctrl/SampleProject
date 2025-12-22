package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
	
	private By searchBox =  By.id("twotabsearchtextbox");
	private By continueButton =By.xpath("//button[contains(text(),'Continue')]");
    private By searchBtn = By.id("nav-search-submit-button");
    
    public  SearchResultsPage  search(String product) throws InterruptedException {
    	   
    	
    	click(continueButton);
    	Thread.sleep(500);
    	
    	input(searchBox,product);
    	
    	click(searchBtn);
    	
    	return new SearchResultsPage();
    	
        }
    	
    
    
}
