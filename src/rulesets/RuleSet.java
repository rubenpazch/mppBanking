package rulesets;

import javafx.application.Application;

public interface RuleSet {
	public void applyRules(Application ap) throws RuleException;
}
