package tests;

import org.testng.annotations.Test;

import hooks.TestNGHooks;
import pages.Login;

public class CreateLead extends TestNGHooks{
	
	@Test(dataProvider = "FetchExcelData")
	public void login(String compName,String firstName,String lastName) {

		new Login()
			.typeUserName("DemoSalesManager")
			.typePassword("crmsfa")
			.clickLogin()
			.verifyWelcomeMessage()
			.clickCRMSFALink()
			.clickLeadsTab()
			.clickCreateLeadMenu()
			.typeCompanyName(compName)
			.typeFirstName(firstName)
			.typeLastName(lastName)
			.clickCreateLeadButton()
			.verifyLeadIsCreated();
			

	}

}
