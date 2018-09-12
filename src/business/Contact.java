package business;

import java.util.List;
import java.util.ArrayList;

public class Contact {
	private String contactId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	
	private List<Account> accounts;
	
	public Contact(String contactId, String firstName, String middleName, String lastName, String address) {
		this.contactId = contactId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.accounts = new ArrayList<Account>();
	}
	
	public String getContactId() {
		return contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}
	
	void addAccount(Account account) {
		accounts.add(account);
	}
}
