package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	
	
	private By email = By.id("user-name");
	private By password = By.id("password");
	private  By btnlogin = By.id("login-button");
	
	public void login(String user,String pass) {
		
		input(email,user);
		input(password,pass);
		click(btnlogin);
		
		
		
		
	}

}
