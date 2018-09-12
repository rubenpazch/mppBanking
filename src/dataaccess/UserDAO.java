package dataaccess;
import business.*;
import java.sql.*;

public class UserDAO  {
	/*
	public static User GetUser(String UserID)
	{
		User user = new User();
		Connection con = DBHelper.GetConnection();
	    Statement stmt = null;
		 
		try {
			stmt = con.createStatement();
	
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM USER WHERE ID="+ UserID);
	  
	    	 if(rs.next())
	            {
	                user.setId( rs.getString("ID") );
	                user.setPass( rs.getString("PASSWORD"));
	                return user;
	            }
	      
	      rs.close();
	      stmt.close();
	      con.close();
	    
		return user;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
*/
}
