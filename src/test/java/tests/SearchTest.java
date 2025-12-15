package tests;

import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.SearchResultsPage;

public class SearchTest extends TestBase {
	@Test
	public void titleContains() {
	
		SearchResultsPage results = new HomePage().search("Laptop");
	
	
	
	assert results.titleContains("Laptop") :
        "Search results do not contain expected product!";
	}	
	
	

}
