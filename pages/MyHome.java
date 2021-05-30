package pages;

import hooks.TestNGHooks;


public class MyHome extends TestNGHooks {
	public MyLeads clickLeadsTab() {
		click(locateElement("link", "Leads"));
		return new MyLeads();
	}

}