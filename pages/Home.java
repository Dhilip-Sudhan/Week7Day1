package pages;

import hooks.TestNGHooks;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;

public class Home extends TestNGHooks{
	
	
	@Then("Verify the welcome message")
	public Home verifyWelcomeMessage() {
		verifyPartialText(locateElement("tag","h2"), "Welcome");
		return this;
	}
	
	
	@And("Click Logout")
	public Login clickLogout() {
		click(locateElement("class", "decorativeSubmit"));
		return new Login();

	}

	public Home getHomePageUserTitle() 
	{
		String userTitle=driver.findElementByTagName("//h2").getText();
		if(userTitle.contains("Welcome"))
		{
			System.out.println("HomePage test passed");
		}else
		{
			System.out.println("HomePage test failed");
		}
		
		return this;	
	}
	
	public MyHome clickCRMSFALink()
	{
		driver.findElementByLinkText("CRM/SFA").click();
		System.out.println("CRM/SFA link clicked successfully");
		//MyHomePage MyMenu=new MyHomePage();
		return new MyHome();
		
	}
	
	
}