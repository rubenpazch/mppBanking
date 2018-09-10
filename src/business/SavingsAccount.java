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
public class SavingsAccount extends Account {
	private double balance;
	private double interestRate;
	private String acctId;
	
	public SavingsAccount (String oacctId, double ointerestRate, double startBalance){
		this.acctId= oacctId;
		this.interestRate = ointerestRate;
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
		return balance+(interestRate*balance);
	}
}
