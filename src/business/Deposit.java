/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Deposit extends Transaction {
    private double amount;
    
    Deposit(Account account, double amount, Date transactionDate, TransactionStatus status) {
    	super(account, transactionDate, status);
    	this.amount = amount;
    }
    
    public double getAmount() {
    	return amount;
    }
}
