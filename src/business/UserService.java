package business;

import java.util.Date;

import dataaccess.UserDAO;

public class UserService {
	public User getUser(User userin) {
		UserDAO userDAO = new UserDAO();
		return userDAO.GetUser(userin);
	}
}
