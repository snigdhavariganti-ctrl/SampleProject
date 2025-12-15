package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class logInTest extends TestBase {
	
	@Test
	@Parameters({"username","password"})
    public void loginTest(String username,String password) {

	LoginPage login = new LoginPage();
  
  login.login(username,password);
  

}
}
