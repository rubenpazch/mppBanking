package business;

import dataaccess.AccountDAO;

public class AccountService {
	private Contact contact;
	
	public AccountService(Contact contact) {
		this.contact = contact;
	}
	
	private String generateAccountId() {
		return "";
	}
	
	public Account createSavingsAccount(double interestRate, double startBalance) {
		Account account = new SavingAccount(generateAccountId(), contact, interestRate, startBalance);
		contact.addAccount(account);
		AccountDAO.insert(account, contact, AccountType.SAVING);
		return account;
	}
	
	public Account createCheckingAccount(double monthlyFee, double startBalance) {
		Account account = new CheckingAccount(generateAccountId(), contact, monthlyFee, startBalance);
		contact.addAccount(account);
		AccountDAO.insert(account, contact, AccountType.CHECKING);
		return account;
	}
}
