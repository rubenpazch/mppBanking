package business;

import java.util.Date;
import dataaccess.TransDAO;

public class TransactionService {
	private Account account;
	
	public TransactionService(Account account) {
		this.account = account;
	}
	
	private String generateTransactionId() {
		return "";
	}
	
	public Transaction createBalanceInquired(Account account, TransactionStatus status) {
		Transaction newTransaction = new BalanceInquired(generateTransactionId(), account, new Date(), status);
		account.addTransaction(newTransaction);
		TransDAO.insert(newTransaction, TransactionType.BALANCE_INQUIRED);
		return newTransaction;
	}
	
	public Transaction createDeposit(Account account, double amount, TransactionStatus status) {
		Transaction newTransaction = new Deposit(generateTransactionId(), account, amount, new Date(), status);
		account.addTransaction(newTransaction);
		TransDAO.insert(newTransaction, TransactionType.DEPOSIT);
		return newTransaction;
	}
	
	public Transaction createWithdrawal(Account account, double amount, TransactionStatus status) {
		Transaction newTransaction = new Withdrawal(generateTransactionId(), account, amount, new Date(), status);
		account.addTransaction(newTransaction);
		TransDAO.insert(newTransaction, TransactionType.WITHDRAW);
		return newTransaction;
	}
	
	public Transaction createTransfer(Account account, double amount, Account receiver, TransactionStatus status) {
		Transaction newTransaction = new Transfer(generateTransactionId(), account, amount, receiver, new Date(), status);
		account.addTransaction(newTransaction);
		TransDAO.insert(newTransaction, TransactionType.TRANSFER);
		return newTransaction;
	}
}
