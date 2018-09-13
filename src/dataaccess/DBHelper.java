package dataaccess;
import java.sql.*;;

public class DBHelper {

	public static final String OUTPUT_DIR = System.getProperty("user.dir")+ "\\src\\dataaccess\\storage\\BANKING.db";
	//public static final String OUTPUT_DIR = "C:\\Users\\USER\\Documents\\programs\\db\\BANKING.db";

	public static Connection GetConnection() {
		Connection con = null;
	      try {
	         Class.forName("org.sqlite.JDBC");
	         con = DriverManager.getConnection("jdbc:sqlite:"+OUTPUT_DIR);
	         con.setAutoCommit(true);
	         return con;

	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }

	      return null;
	}
}
