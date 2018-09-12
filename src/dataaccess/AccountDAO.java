package dataaccess;

import business.*;
import java.util.*;
import java.sql.*;

public class AccountDAO {

	public static List<Account> GetAccountList(String CustomerID)
	{
	    Connection connection = DBHelper.GetConnection();
	    try {
	    	Contact contact = ContactDAO.getContact(CustomerID);
	    	
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Account where CustomerID="+CustomerID);
	        
	        List<Account> accounts = new ArrayList<Account>();
	        while(rs.next())
	        {
	            Account account = extractAccountFromResultSet(contact, rs);
	            accounts.add(account);
	        }
	        return accounts;
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	
	public static Account extractAccountFromResultSet(Contact contact, ResultSet rs) throws SQLException {
		int accoutType = rs.getInt("AccountType");
		Account account=null;
		switch(accoutType)
		{
		  case 1:
			  account = new SavingAccount(contact,rs.getDouble("InterestRate"),rs.getDouble("Balance"));
			  break;
		  case 2:
			  account = new CheckingAccount(contact,rs.getDouble("MonthyFee"),rs.getDouble("Balance"));
			  break;
		  case 3:
			  //account = new FlexibleSavingAccount(contact,rs.getDouble("Balance"));
			  break;
		}
		
		if(account != null) {
			account.setAccountId(rs.getLong("AccountID"));
		}

	    return account;
	}

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
			connection.close();
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
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    
	    return false;
	}
	
	public static boolean update(Account account)
	{
	    Connection connection =  DBHelper.GetConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("UPDATE Account SET Balance=? WHERE AccountID=?");
	        ps.setDouble(1, account.getBalance());
	        ps.setLong(2, account.getAccountId());
	        int i = ps.executeUpdate();
	      if(i == 1) {
	    return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
}
