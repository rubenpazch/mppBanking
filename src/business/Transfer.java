package business;

import java.util.Date;

public class Transfer extends Transaction {
	private double amount;
	private Account receiver;
	
	Transfer(String transactionId, Account account, double amount, Account receiver, Date transactionDate, TransactionStatus status) {
		super(transactionId, account, transactionDate, status);
		this.amount = amount;
		this.receiver = receiver;
	}

	public double getAmount() {
		return amount;
	}
	
	public Account getReceiver() {
		return receiver;
	}
}