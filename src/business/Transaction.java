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
public abstract class Transaction {
	private String transactionId;
	private Date transactionDate;
	private TransactionStatus status;
	
	private Account account;
	
	Transaction(String transactionId, Account account, Date transactionDate, TransactionStatus status) {
		this.transactionId = transactionId;
		this.account = account;
		this.transactionDate = transactionDate;
		this.status = status;
	}
	
	Transaction(String transactionId, Account account, Date transactionDate) {
		this(transactionId, account, transactionDate, TransactionStatus.PENDING);
	}
	
	public String getTransactionId() {
		return transactionId;
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
