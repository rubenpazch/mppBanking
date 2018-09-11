package rulesets;

import java.util.HashMap;

import business.User;
import controller.LoginController;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.application.Application;

public class LoginRuleSet implements RuleSet {

	private LoginController login;

	@Override
	public void applyRules(Application ap) throws RuleException {
		// TODO Auto-generated method stub
		login = (LoginController) ap;
		isEmptyFieldsRule();
	//	isPasswordNumericRule();
		authenticationUserRule();

	}

	private void isEmptyFieldsRule() throws RuleException {
		// TODO Auto-generated method stub
		if(login.getUserId().getText()== null || login.getPassword().getText()==null  ||
				login.getUserId().getText().isEmpty() || login.getPassword().getText().isEmpty()) {
			throw new RuleException("All fields must be filled");
		}
	}

	private void authenticationUserRule() throws RuleException {
		// TODO Auto-generated method stub
		DataAccess db = new DataAccessFacade();
		HashMap<String, User> users = db.readUserMap();
		User user = users.get(login.getUserId().getText());

		if(user==null || !user.authenticate(login.getUserId().getText(), login.getPassword().getText())) {
			throw new RuleException("User id or password Wrong");
		}
	}	
	/*private void isPasswordNumericRule() throws RuleException {
		char[] range_array = login.getPassword().getText().trim().toCharArray();
		for (int i = 0; i < range_array.length; i++) {
			if (!Character.isDigit(range_array[i])) {
				throw new RuleException("The password must be numeric !");
			}
		}
	}*/
}
