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
import business.SavingAccount;

public class CustomerDAO {

	public static boolean insert(Account account, Contact contact, AccountType accountType) {
		Connection connection = DBHelper.GetConnection();
	    try {
	    	PreparedStatement ps = connection.prepareStatement("INSERT INTO Account VALUES (NULL,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
	        ps.setString(1, contact.getContactId());
	        ps.setInt(2, accountType.ordinal());
	        ps.setDouble(3, account.getBalance());

	        if (accountType == AccountType.SAVING) {
	        	SavingAccount savingAccount = (SavingAccount)account;
	        	ps.setDouble(4, savingAccount.getInterestRate());
	        	ps.setDouble(5, 0.0);
	        }

	        if (accountType == AccountType.CHECKING) {
	        	CheckingAccount checkingAccount = (CheckingAccount)account;
	        	ps.setDouble(4, 0.0);
	        	ps.setDouble(5, checkingAccount.getMonthlyFee());
	        }

	        int i = ps.executeUpdate();
	        if(i == 1) {
	        	try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                	account.setAccountId(generatedKeys.getLong(1));
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
