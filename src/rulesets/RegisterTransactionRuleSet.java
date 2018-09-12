package rulesets;

import controller.RegisterTransactionController;
import javafx.application.Application;

public class RegisterTransactionRuleSet implements RuleSet {

	private RegisterTransactionController register;

	@Override
	public void applyRules(Application ap) throws RuleException {
		// TODO Auto-generated method stub
		register =  (RegisterTransactionController) ap;
		isEmptyFieldsRule();
		isPasswordNumericRule();
		isFloatPriceRule();
	}

	private void isEmptyFieldsRule() throws RuleException {
		// TODO Auto-generated method stub
		if(register.getTxtTransactionId().getText()== null || register.getTxtAmounTransaction().getText()==null  || 
			register.getTxtTransactionId().getText().isEmpty() || register.getTxtAmounTransaction().getText().isEmpty()) {
			throw new RuleException("All fields must be filled");
		}
	}
	private void isPasswordNumericRule() throws RuleException {
		try {
			Float.parseFloat(register.getTxtTransactionId().getText().trim());
		} catch (Exception e) {
			throw new RuleException("The Transaction ID must be numeric !");
		}
		try {
			Float.parseFloat(register.getTxtAmounTransaction().getText().trim());
		} catch (Exception e) {
			throw new RuleException("The Amount Transaction must be numeric !");
		}

	}
	private void isFloatPriceRule() throws RuleException {

		if (!register.getTxtAmounTransaction().getText().trim().matches("[+]?[0-9]*\\.[0-9]{2}")) {
			throw new RuleException("Amount Transaction must be a number with  two decimal places ");
		}

	}

}
