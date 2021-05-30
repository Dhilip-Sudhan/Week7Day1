package pages;

import hooks.TestNGHooks;

public class MyLeads extends TestNGHooks {
	
	public CreateLead clickCreateLeadMenu() {
		click(locateElement("link", "Create Lead"));
		return new CreateLead();
	}
	
	}