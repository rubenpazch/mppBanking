package rulesets;

import controller.RegisterCustomerController;
import javafx.application.Application;

public class RegisterCustomerRuleSet implements RuleSet {

	private RegisterCustomerController register;

	@Override
	public void applyRules(Application ap) throws RuleException {
		// TODO Auto-generated method stub
		register =  (RegisterCustomerController) ap;
		isEmptyFieldsRule();

	}

	private void isEmptyFieldsRule() throws RuleException {
		// TODO Auto-generated method stub
		if(register.getTxtId().getText()== null || register.getTxtFirstName().getText()==null  || 
				register.getTxtMidleName().getText()==null||register.getTxtLastName().getText()==null||
				register.getTxtAddress().getText()==null||
				register.getTxtId().getText().isEmpty() || register.getTxtFirstName().getText().isEmpty() || 
				register.getTxtMidleName().getText().isEmpty()||register.getTxtLastName().getText().isEmpty()||
				register.getTxtAddress().getText().isEmpty()) {
			throw new RuleException("All fields must be filled");
		}
	}

}
