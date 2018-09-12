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
		Account acount=null;
		switch(accoutType)
		{
		  case 1:
			  acount = new SavingAccount(rs.getString("AccountID"),contact,rs.getDouble("InterestRate"),rs.getDouble("Balance"));
			  break;
		  case 2:
			  acount = new CheckingAccount(rs.getString("AccountID"),contact,rs.getDouble("MonthyFee"),rs.getDouble("Balance"));
			  break;
		  case 3:
			  //acount = new FlexibleSavingAccount(rs.getString("AccountID"),contact,rs.getDouble("Balance"));
			  break;
		}

	    return acount;
	}

	public static boolean insert(Account account, Contact contact, AccountType accountType) {
		Connection connection = DBHelper.GetConnection();
	    try {
	    	//PreparedStatement ps = connection.prepareStatement("INSERT INTO Account VALUES (?, ?, ?, ?,?,?)");
	    	PreparedStatement ps = connection.prepareStatement("INSERT INTO Account VALUES (?, ?, ?, ?)");
	        ps.setString(1, account.getAccountId());
	        ps.setString(2, contact.getContactId());
	        ps.setInt(3, accountType.ordinal());
	        
	        if (accountType == AccountType.SAVING) {
	        	SavingAccount savingAccount = (SavingAccount)account;
	        	ps.setDouble(4, savingAccount.getInterestRate());
	        }
	        
	        if (accountType == AccountType.CHECKING) {
	        	CheckingAccount checkingAccount = (CheckingAccount)account;
	        	ps.setDouble(4, checkingAccount.getMonthlyFee());
	        }
	        
	        int i = ps.executeUpdate();
	        if(i == 1) {
	        	return true;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
	
	public boolean update(Account account)
	{
	    Connection connection =  DBHelper.GetConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("UPDATE Account SET Balance=? WHERE AccountID=?");
	        ps.setString(1, account.getAccountId());
	        ps.setDouble(2, account.getBalance());
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
