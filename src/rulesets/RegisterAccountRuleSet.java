package rulesets;

import controller.RegisterAccountController;
import javafx.application.Application;

public class RegisterAccountRuleSet implements RuleSet {

	private RegisterAccountController register;

	@Override
	public void applyRules(Application ap) throws RuleException {
		// TODO Auto-generated method stub
		register = (RegisterAccountController) ap;
		isEmptyFieldsRule();
		isPasswordNumericRule();
		isFloatPriceRule();
	}

	private void isEmptyFieldsRule() throws RuleException {
		// TODO Auto-generated method stub
		if(register.getTxtAccountNumber().getText()== null || register.getTxtInitialAmount().getText()==null  || 
				register.getTxtInterestRate().getText()==null||register.getTxtMonthlyFee().getText()==null||
				register.getTxtAccountNumber().getText().isEmpty() || register.getTxtInitialAmount().getText().isEmpty() || 
				register.getTxtInterestRate().getText().isEmpty()||register.getTxtMonthlyFee().getText().isEmpty() ||
				register.getDdlTypeAccounts().getSelectionModel().isEmpty()) {
			throw new RuleException("All fields must be filled");
		}
	}
	private void isPasswordNumericRule() throws RuleException {
		try {
			Float.parseFloat(register.getTxtInitialAmount().getText().trim());
		} catch (Exception e) {
			throw new RuleException("The Initial Amount must be numeric !");
		}
		try {
			Float.parseFloat(register.getTxtInterestRate().getText().trim());
		} catch (Exception e) {
			throw new RuleException("The Interest Rate must be numeric !");
		}
		try {
			Float.parseFloat(register.getTxtMonthlyFee().getText().trim());
		} catch (Exception e) {
			throw new RuleException("The Monthly Fee must be numeric !");
		}
	}
	private void isFloatPriceRule() throws RuleException {



		if (!register.getTxtInitialAmount().getText().trim().matches("[+]?[0-9]*\\.[0-9]{2}")) {
			throw new RuleException("Initial Amount must be a number with two decimal places ");
		}
		if (!register.getTxtInterestRate().getText().trim().matches("[+]?[0-9]*\\.[0-9]{2}")) {
			throw new RuleException("Interest Rate must be a number with  two decimal places ");
		}
		if(!register.getTxtMonthlyFee().getText().trim().matches("[+]?[0-9]*\\.[0-9]{2}")) {
			throw new RuleException("Monthly Fee must be a number with two decimal places");
		}
	}

}