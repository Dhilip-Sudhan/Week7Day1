package pages;

import hooks.TestNGHooks;


public class ViewLead extends TestNGHooks{
	
	public ViewLead verifyLeadIsCreated() {
		verifyPartialTitle("View Lead");
		return this;
	}

}
