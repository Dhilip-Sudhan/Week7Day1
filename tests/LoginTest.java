package tests;

import org.testng.annotations.Test;

import hooks.TestNGHooks;
import pages.Login;

public class LoginTest extends TestNGHooks{
	
	@Test(dataProvider = "FetchExcelData")
	public void login(String username, String password) {
		new Login()
			.typeUserName(username)
			.typePassword(password)
			.clickLogin()
			.verifyWelcomeMessage()
			.clickLogout();
			
	}

}
