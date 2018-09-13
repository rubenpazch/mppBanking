package dataaccess;
import business.*;
import java.sql.*;

public class UserDAO  {

	public static User GetUser(User user)
	{
		User newuser = new User();
		Connection con = DBHelper.GetConnection();
	    Statement stmt = null;

		try {
			stmt = con.createStatement();

	         ResultSet rs = stmt.executeQuery( "SELECT ID,PASSWORD,USERTYPE FROM USER WHERE ID = '"+ user.getId() + "' AND PASSWORD ='"+ user.getPassword()+"'");

	    	 if(rs.next())
	            {
	    		 newuser.setId( rs.getString("ID") );
	    		 newuser.setPass( rs.getString("PASSWORD"));
	    		 newuser.setUserType(rs.getInt("USERTYPE") );
	                return newuser;
	            }

	      rs.close();
	      stmt.close();
	      con.close();

		return newuser;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
