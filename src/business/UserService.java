package business;

import java.util.Date;

import dataaccess.UserDAO;

public class UserService {
	public User getUser(User userin) {
		return UserDAO.GetUser(userin);
	}
}
