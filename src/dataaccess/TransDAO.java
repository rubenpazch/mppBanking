package dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import business.*;

public class TransDAO {
	//type = 0 : Transfer
	//type = 1 : Deposit
	//type = 2 : Withdraw
	//type = 3 : BalanceInquired
	public static boolean insert(Transaction trans, TransactionType type) {
	    Connection connection = DBHelper.GetConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO Transaction VALUES (NULL, ?, ?, ?,?,?,?)");
	        ps.setDate(1, (Date) trans.getTransactionDate());
	        ps.setInt(2, trans.getStatus().ordinal());
	        ps.setInt(3,type.ordinal());
	        
	        if (type == TransactionType.TRANSFER) {
	        	Transfer transfer = (Transfer)trans;
	        	ps.setDouble(4, transfer.getAmount());
	        	ps.setString(5,transfer.getReceiver().getAccountId());
	        }
	        
	        if (type == TransactionType.DEPOSIT) {
	        	Deposit deposit = (Deposit)trans;
	        	ps.setDouble(4, deposit.getAmount());
	        }
	        
	        if (type == TransactionType.WITHDRAW) {
	        	Withdrawal withdrawal = (Withdrawal)trans;
	        	ps.setDouble(4, withdrawal.getAmount());
	        }
	
	        int i = ps.executeUpdate();
	        if(i == 1) {
	       return true;	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
}
