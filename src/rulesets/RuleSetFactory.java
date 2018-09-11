package rulesets;

import java.util.HashMap;

import controller.LoginController;
import javafx.application.Application;


final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<Class<? extends Application>, RuleSet> map = new HashMap<>();
	
	static {
		map.put(LoginController.class, new LoginRuleSet());
		//map.put(CDWindow.class, new CDRuleSet());
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
