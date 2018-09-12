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
    
    BalanceInquired(Account account, Date transactionDate, TransactionStatus status) {
    	super(account, transactionDate, status);
    	this.balance = account.getBalance();
    }
    
    BalanceInquired(Account account, Date transactionDate) {
    	this(account, transactionDate, TransactionStatus.PENDING);
    }
    
    public double getBalance() {
    	return balance;
    }
}
