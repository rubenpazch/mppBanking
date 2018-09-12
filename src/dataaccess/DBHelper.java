package dataaccess;
import java.sql.*;;

public class DBHelper {
	
	public static Connection GetConnection()
	{
		Connection con = null;
	      try {
	         Class.forName("org.sqlite.JDBC");
	         con = DriverManager.getConnection("jdbc:sqlite:d:/BANKING.db");
	         con.setAutoCommit(false);
	         return con;
	         
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      
	      return null;
	}

    
	
}
