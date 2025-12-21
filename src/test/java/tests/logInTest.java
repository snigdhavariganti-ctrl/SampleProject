package tests;

<<<<<<< HEAD
=======
import java.io.IOException;

import org.testng.annotations.DataProvider;
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
<<<<<<< HEAD

public class logInTest extends TestBase {
	
	@Test
	@Parameters({"username","password"})
    public void loginTest(String username,String password) {

	LoginPage login = new LoginPage();
  
  login.login(username,password);
  

}
}
=======
import utilities.ExcelUtils;

public class logInTest extends TestBase {
	
	
	@DataProvider(name="loginData")
	
	public Object[][] getLoginData(){
		return  new Object[][] {
			 {"wrongemail@gmail.com", "wrongpass", false},
             {"testuser@gmail.com", "wrongpass", false},
             {"validuser@gmail.com", "validpassword", true}

     };
		}
	
	@DataProvider(name = "excelLoginData")
	public Object[][] excelLoginData() throws IOException {
	String path =	System.getProperty("user.dir") + ".testdata/loginData.xlsx";
	return ExcelUtils.getSheetData(path, "LoginData");
		
	}

 	
	
	
	@Test(dataProvider = "loginData", groups = "login")

    public void loginTest(String username,String password,boolean expectedResult) {

	LoginPage logintest = new LoginPage();
  
  logintest.login(username,password);
  

}
	@Test(dataProvider = "excelLoginData",groups ="login")
	public void testLoginExcel(String email, String password, String expectedResult) {
		LoginPage logintest = new LoginPage();

		  logintest.login(email,password);
		  
	}
	
}

	
	
	

>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
