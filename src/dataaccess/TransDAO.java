package dataaccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;

import business.*;

public class TransDAO {
	//type = 0 : Transfer
	//type = 1 : Deposit
	//type = 2 : Withdraw
	//type = 3 : BalanceInquired
	public static boolean insert(Transaction trans, TransactionType type) {
	    Connection connection = DBHelper.GetConnection();
	    try {
	    	PreparedStatement ps = connection.prepareStatement("INSERT INTO Trans VALUES (NULL,?,?,?,?,?,?)");
	    	//PreparedStatement ps = connection.prepareStatement("INSERT INTO Account VALUES (NULL,?,?,?,?,?)");
	        ps.setLong(1, trans.getAccount().getAccountId());
	        ps.setDate(2, trans.getTransactionDate());
	        ps.setInt(3, trans.getStatus().ordinal());
	        ps.setInt(4, type.ordinal());
	        
	        if (type == TransactionType.TRANSFER) {
	        	Transfer transfer = (Transfer)trans;
	        	ps.setDouble(5, transfer.getAmount());
	        	ps.setLong(6, transfer.getReceiver().getAccountId());
	        }
	        
	        if (type == TransactionType.DEPOSIT) {
	        	Deposit deposit = (Deposit)trans;
	        	ps.setDouble(5, deposit.getAmount());
	        	ps.setNull(6, Types.INTEGER);
	        }
	        
	        if (type == TransactionType.WITHDRAW) {
	        	Withdrawal withdrawal = (Withdrawal)trans;
	        	ps.setDouble(5, withdrawal.getAmount());
	        	ps.setNull(6, Types.INTEGER);
	        }
	
	        int i = ps.executeUpdate();
	        if(i == 1) {
	        	try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                	trans.setTransactionId(generatedKeys.getLong(1));
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
}
