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
	public boolean insert(Transaction trans,int type) {
    Connection connection = DBHelper.GetConnection();
    try {
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO Transaction VALUES (NULL, ?, ?, ?,?,?,?)");
	        ps.setDate(1, (Date) trans.getTransactionDate());
	        ps.setInt(2, trans.getStatus().ordinal());
	        //ps.setDouble(3,trans.getAmount());
	        //ps.setString(4,trans.getAccount().getAccountId());
	
	        int i = ps.executeUpdate();
	        if(i == 1) {
	       return true;	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}
}
