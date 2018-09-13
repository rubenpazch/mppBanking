package rulesets;
import controller.DepositController;
import javafx.application.Application;

public class DepositRuleSet implements RuleSet {

	private DepositController deposit;
	
	@Override
	public void applyRules(Application ap) throws RuleException {

		       // TODO Auto-generated method stub
		         deposit = (DepositController) ap;
				isEmptyFieldsRule();
				isOverWithdraw();
	}
	
	private void isEmptyFieldsRule() throws RuleException {
		// TODO Auto-generated method stub
		if(deposit.getAmount()== 0 || deposit.getAmount()<0) {
			throw new RuleException("Amount must not be empty or less than 0");
		}
	}

	
	private void isOverWithdraw()throws RuleException {
		// TODO Auto-generated method stub
		if(deposit.getRemainBalance() <0) {
			throw new RuleException("Amount must not be empty or less than 0");
		}
	}
	
}
