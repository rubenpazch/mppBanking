package application;
import java.sql.*;;
public class sample {

	public static void main( String args[] ) {
	      Connection c = null;
	 
	      Statement stmt = null;
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:d:/BANKING.db");
	         
	         c.setAutoCommit(false);
	         
	         stmt = c.createStatement();
	         
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM Customer;" );
	         
	         while ( rs.next() ) {
	            int id = rs.getInt("CustomerID");
	            String  name = rs.getString("FirstName");
	            
	            
	            System.out.println( "ID = " + id );
	            System.out.println( "NAME = " + name );
	      
	            System.out.println();
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	         
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	   }
	
}
