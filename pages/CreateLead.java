package pages;

import hooks.TestNGHooks;

public class CreateLead extends TestNGHooks {
	
	public CreateLead typeCompanyName(String compName) {
		type(locateElement("id", "createLeadForm_companyName"), compName);
		return this;
	}
	
	public CreateLead typeFirstName(String firstName) {
		type(locateElement("id", "createLeadForm_firstName"), firstName);
		return this;
	}
	

	public CreateLead typeLastName(String lastName) {
		type(locateElement("id", "createLeadForm_lastName"), lastName);
		return this;
	}
	
	public ViewLead clickCreateLeadButton() {
		click(locateElement("class", "smallSubmit"));
		return new ViewLead();
	}
	}