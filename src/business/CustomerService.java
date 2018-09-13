package business;

import dataaccess.CustomerDAO;

public class CustomerService {
	private Customer customer;

	public void createCustomer(Customer customer) {
		Customer newcustomer = new Customer();
		//contact.addAccount(account);

		CustomerDAO.insert(customer);
		//return newcustomer;
	}


}
