package tests;

import base.TestBase;
import pages.AddToCartPage;
import pages.HomePage;
import pages.ProductPage;

public class ProductTest extends TestBase {
	
	public void testAddToCart() {
	
	ProductPage productpage = new HomePage().search("Laptop").clickFirstProduct();
	
	AddToCartPage cart = productpage.addToCart();
	 
	 cart.clickCart();
	 
	 assert cart.getCartCount()>0;	
	}
 
}
