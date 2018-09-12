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
	private double monthyFee;
	
	public CheckingAccount (String accountId, Contact contact, double monthlyFee, double startBalance){
		super(accountId, contact, startBalance);
		this.monthyFee = monthlyFee;
	}
	
	public double getMonthlyFee() {
		return monthyFee;
	}
	
	@Override
	public double computeUpdatedBalance() {
		return getBalance() - monthyFee;
	}
}
