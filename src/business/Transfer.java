/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Transfer extends Transaction {
    private double amount;
    private Account receiver;
    
    Transfer(String transactionId, Account account, Account receiver, double amount, Date transactionDate, TransactionStatus status) {
    	super(transactionId, account, transactionDate, status);
    	this.amount = amount;
    	this.receiver = receiver;
    }
    
    Transfer(String transactionId, Account account, Account receiver, double amount, Date transactionDate) {
    	this(transactionId, account, receiver, amount, transactionDate, TransactionStatus.PENDING);
    }
    
    public Account getReceiver() {
		return receiver;
	}

	public double getAmount() {
    	return amount;
    }
}
