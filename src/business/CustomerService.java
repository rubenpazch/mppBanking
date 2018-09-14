package business;

import dataaccess.CustomerDAO;

public class CustomerService {
	public void createCustomer(Customer customer) {
		CustomerDAO.insert(customer);
	}


}
