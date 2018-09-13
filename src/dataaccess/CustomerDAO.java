package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import business.Account;
import business.AccountType;
import business.CheckingAccount;
import business.Contact;
import business.Customer;
import business.SavingAccount;

public class CustomerDAO {

	public static boolean insert(Customer c) {
		Connection connection = DBHelper.GetConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Customer VALUES (NULL,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getMidleName());
			ps.setString(3, c.getLastName());
			ps.setString(4, c.getAddress());

			int i = ps.executeUpdate();
			if(i == 1) {
				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						c.setCustomerId(generatedKeys.getLong(1));
					}
					else {
						throw new SQLException("Creating user failed, no ID obtained.");
					}
				}
				return true;
			}
			connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}


}
