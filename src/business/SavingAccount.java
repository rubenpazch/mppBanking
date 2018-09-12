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
public class SavingAccount extends Account {
	private double interestRate;

	public SavingAccount (Contact contact, double interestRate, double startBalance){
		super(contact, startBalance);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public double computeUpdatedBalance() {
		double balance = getBalance();
		return balance + (interestRate * balance);
	}
}
