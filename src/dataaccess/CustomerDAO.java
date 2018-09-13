package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.xml.internal.ws.org.objectweb.asm.Type;

import business.Account;
import business.AccountType;
import business.CheckingAccount;
import business.Contact;
import business.Customer;
import business.SavingAccount;
import business.User;

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
			if (i != 1) {
				connection.close();
				return false;
			}
			else {
				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						c.setCustomerId(generatedKeys.getLong(1));
					}
					else {
						throw new SQLException("Creating user failed, no ID obtained.");
					}
				}
				connection.close();
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}


	public static int GetNextId()
	{
		int result=0;
		Connection con = DBHelper.GetConnection();
		Statement stmt = null;

		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT  customerId, firstName, midlename, lastname,address FROM CUSTOMER  order by customerid desc");

			if(rs.next())
			{
				result= rs.getInt("customerId");

			}

			rs.close();
			stmt.close();
			con.close();
			return result;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}



}
