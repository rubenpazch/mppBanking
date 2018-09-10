/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author USER
 */
public class CheckingAccount  extends Account{
	private double balance;
	private double monthyFee;
	private String acctId;
	
	public CheckingAccount (String oacctId, double fee, double startBalance){
		this.acctId= oacctId;
		this.monthyFee = fee;
		this.balance = startBalance;
	}

	@Override
	public String getAccountID() {
		// TODO Auto-generated method stub
		return acctId;
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	@Override
	public double computeUpdatedBalance() {
		// TODO Auto-generated method stub
		return balance-monthyFee;
	}
}
