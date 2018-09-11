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
public class Withdrawal extends Transaction {
    private double amount;
    
    Withdrawal(String transactionId, Account account, double amount, Date transactionDate, TransactionStatus status) {
    	super(transactionId, account, transactionDate, status);
    	this.amount = amount;
    }
    
    Withdrawal(String transactionId, Account account, double amount, Date transactionDate) {
    	this(transactionId, account, amount, transactionDate, TransactionStatus.PENDING);
    }
    
    public double getAmount() {
    	return amount;
    }
}
