package business;

import dataaccess.AccountDAO;

public class AccountService {
	private Contact contact;
	
	public AccountService(Contact contact) {
		this.contact = contact;
	}
	
	public Account createSavingAccount(double interestRate, double startBalance) {
		Account account = new SavingAccount(contact, interestRate, startBalance);
		contact.addAccount(account);
		AccountDAO.insert(account, contact, AccountType.SAVING);
		return account;
	}
	
	public Account createCheckingAccount(double monthlyFee, double startBalance) {
		Account account = new CheckingAccount(contact, monthlyFee, startBalance);
		contact.addAccount(account);
		AccountDAO.insert(account, contact, AccountType.CHECKING);
		return account;
	}
	
	public Account getAccount(int accountType) {
		
		return AccountDAO.GetAccount(contact.getContactId(), accountType);
	}
}
