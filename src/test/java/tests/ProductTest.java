package tests;

<<<<<<< HEAD
=======
import org.testng.annotations.Test;

>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
import base.TestBase;
import pages.AddToCartPage;
import pages.HomePage;
import pages.ProductPage;

public class ProductTest extends TestBase {
<<<<<<< HEAD
	
=======
	@Test
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
	public void testAddToCart() {
	
	ProductPage productpage = new HomePage().search("Laptop").clickFirstProduct();
	
	AddToCartPage cart = productpage.addToCart();
	 
	 cart.clickCart();
	 
	 assert cart.getCartCount()>0;	
	}
 
}
