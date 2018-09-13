package business;

import dataaccess.CustomerDAO;

public class CustomerService {
	public void createCustomer(Customer customer) {
		CustomerDAO.insert(customer);
	}
	public String getNextId() {
		return new StringBuilder(CustomerDAO.GetNextId()).toString() ;
	}


}
