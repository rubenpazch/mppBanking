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
public abstract class Transaction {
	private long transactionId;
	private Date transactionDate;
	private TransactionStatus status;
	
	private Account account;
	
	Transaction(Account account, Date transactionDate, TransactionStatus status) {
		this.account = account;
		this.transactionDate = transactionDate;
		this.status = status;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public long getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public TransactionStatus getStatus() {
		return status;
	}
	
	public void setStatus(TransactionStatus newStatus) {
		status = newStatus;
	}
}
