package business;
import java.util.*;

public class Customer extends Person {

	String customerID;
	List<Account> accounts;
	Customer(String customerID,String firstName, String midleName, String lastName) {
		super(firstName, midleName, lastName);
		// TODO Auto-generated constructor stub
		this.customerID=customerID;
		accounts = new ArrayList<Account>();
	}

	
}
