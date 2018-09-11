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
public class BalanceInquired extends Transaction {
    private double balance;
    
    BalanceInquired(String transactionId, Account account, Date transactionDate, TransactionStatus status) {
    	super(transactionId, account, transactionDate, status);
    	this.balance = account.getBalance();
    }
    
    BalanceInquired(String transactionId, Account account, Date transactionDate) {
    	this(transactionId, account, transactionDate, TransactionStatus.PENDING);
    }
    
    public double getBalance() {
    	return balance;
    }
}
