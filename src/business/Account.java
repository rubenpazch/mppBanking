/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//carlos
package business;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public abstract class Account {
	private static final long serialVersionUID = 6110690276685962829L;
	
	private String accountId;
    private double balance;
    
    private Contact contact;
    private List<Transaction> transactions;
    
    Account(String accountId, Contact contact, double startBalance) {
    	this.accountId = accountId;
    	this.balance = startBalance;
    	this.transactions = new ArrayList<Transaction>();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAccountId() {
		return accountId;
	}
    
    public double getBalance() {
		return balance;
	}
    
    public Contact getContact() {
    	return contact;
    }
    
    public Collection<Transaction> getTransactions() {
    	return Collections.unmodifiableCollection(transactions);
    }
    
    void addTransaction(Transaction transaction) {
    	transactions.add(transaction);
    }
    
    public abstract double computeUpdatedBalance();
}
