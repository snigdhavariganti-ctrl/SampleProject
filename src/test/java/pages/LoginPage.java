package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	
	
<<<<<<< HEAD
	private By email = By.id("user-name");
	private By password = By.id("password");
	private  By btnlogin = By.id("login-button");
	
	public void login(String user,String pass) {
		
		input(email,user);
		input(password,pass);
		click(btnlogin);
=======
	 private By emailField = By.id("ap_email");
	    private By continueBtn = By.id("continue");
	    private By passwordField = By.id("ap_password");
	    private By signInBtn = By.id("signInSubmit");

	    // Successful login indicator
	    private By accountName = By.id("nav-link-accountList-nav-line-1");

	    // Error indicator
	    private By loginError = By.cssSelector("span.a-list-item");

	
	public void login(String email,String password) {
		
		input(emailField,email);
		input(passwordField,password);
		click(continueBtn);
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
		
		
		
		
	}

}
