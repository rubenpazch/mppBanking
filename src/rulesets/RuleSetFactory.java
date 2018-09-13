package rulesets;

import java.util.HashMap;

import controller.LoginController;
import controller.RegisterAccountController;
import controller.RegisterCustomerController;
import controller.RegisterTransactionController;
import controller.WithdrawController;
import controller.DepositController;
import javafx.application.Application;


final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<Class<? extends Application>, RuleSet> map = new HashMap<>();
	
	static {
		map.put(LoginController.class, new LoginRuleSet());
		map.put(RegisterAccountController.class, new RegisterAccountRuleSet());
		map.put(RegisterCustomerController.class, new RegisterCustomerRuleSet());
		map.put(RegisterTransactionController.class, new RegisterTransactionRuleSet());
		map.put(WithdrawController.class, new WithdrawRuleSet());
		map.put(DepositController.class, new DepositRuleSet());
	}
	
	
	public static  RuleSet getRuleSet(Application ap)
	 {
		 Class<? extends Application> ap1 = ap.getClass();
		 
			if(!map.containsKey(ap1)) 
			{
				throw new IllegalArgumentException("RuleSet not found for your entry");
			}
			return map.get(ap1); 
	 }
}
