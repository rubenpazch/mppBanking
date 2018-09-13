package business;

import java.sql.Date;

import dataaccess.AccountDAO;
import dataaccess.TransDAO;

public class TransactionService {
	private Account account;
	
	public TransactionService(Account account) {
		this.account = account;
	}
	
	private Date getNow() {
		java.util.Date now = new java.util.Date();
		return new Date(now.getTime());
	}
	
	public Transaction createBalanceInquired(TransactionStatus status) {
		java.util.Date now = new java.util.Date();
		Transaction newTransaction = new BalanceInquired(account, getNow(), status);
		account.addTransaction(newTransaction);
		TransDAO.insert(newTransaction, TransactionType.BALANCE_INQUIRED);
		return newTransaction;
	}
	
	public Transaction createDeposit(double amount, TransactionStatus status) {
		Transaction newTransaction = new Deposit(account, amount, getNow(), status);
		account.addTransaction(newTransaction);
		TransDAO.insert(newTransaction, TransactionType.DEPOSIT);
		
		account.setBalance(account.getBalance() + amount);
		AccountDAO.update(account);
		
		return newTransaction;
	}
	
	public Transaction createWithdrawal(double amount, TransactionStatus status) {
		Transaction newTransaction = new Withdrawal(account, amount, getNow(), status);
		account.addTransaction(newTransaction);
		TransDAO.insert(newTransaction, TransactionType.WITHDRAW);
		
		account.setBalance(account.getBalance() - amount);
		AccountDAO.update(account);
		
		return newTransaction;
	}
}
