package rulesets;
import controller.WithdrawController;
import javafx.application.Application;

public class WithdrawRuleSet implements RuleSet {

	private WithdrawController withdraw;
	
	@Override
	public void applyRules(Application ap) throws RuleException {

		       // TODO Auto-generated method stub
		         withdraw = (WithdrawController) ap;
				isEmptyFieldsRule();
				isOverWithdraw();
	}
	
	private void isEmptyFieldsRule() throws RuleException {
		// TODO Auto-generated method stub
		if(withdraw.getAmount()== 0 || withdraw.getAmount()<0) {
			throw new RuleException("Amount must not be empty or less than 0");
		}
	}

	
	private void isOverWithdraw()throws RuleException {
		// TODO Auto-generated method stub
		if(withdraw.getRemainBalance() <0) {
			throw new RuleException("Amount must not be empty or less than 0");
		}
	}
	
}
