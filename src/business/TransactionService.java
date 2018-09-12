package business;

import java.util.Date;

import dataaccess.AccountDAO;
import dataaccess.TransDAO;

public class TransactionService {
	private Account account;
	
	public TransactionService(Account account) {
		this.account = account;
	}
	
	public Transaction createBalanceInquired(TransactionStatus status) {
		Transaction newTransaction = new BalanceInquired(account, new Date(), status);
		account.addTransaction(newTransaction);
		TransDAO.insert(newTransaction, TransactionType.BALANCE_INQUIRED);
		return newTransaction;
	}
	
	public Transaction createDeposit(double amount, TransactionStatus status) {
		Transaction newTransaction = new Deposit(account, amount, new Date(), status);
		account.addTransaction(newTransaction);
		TransDAO.insert(newTransaction, TransactionType.DEPOSIT);
		
		account.setBalance(account.getBalance() + amount);
		AccountDAO.update(account);
		
		return newTransaction;
	}
	
	public Transaction createWithdrawal(double amount, TransactionStatus status) {
		Transaction newTransaction = new Withdrawal(account, amount, new Date(), status);
		account.addTransaction(newTransaction);
		TransDAO.insert(newTransaction, TransactionType.WITHDRAW);
		
		account.setBalance(account.getBalance() - amount);
		AccountDAO.update(account);
		
		return newTransaction;
	}
	
	public Transaction createTransfer(double amount, Account receiver, TransactionStatus status) {
		Transaction newTransaction = new Transfer(account, amount, receiver, new Date(), status);
		account.addTransaction(newTransaction);
		TransDAO.insert(newTransaction, TransactionType.TRANSFER);
		return newTransaction;
	}
}
