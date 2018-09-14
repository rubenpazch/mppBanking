package dataaccess;

import business.*;
import java.util.*;
import java.sql.*;

public class ContactDAO {


	public static Contact getContact(String contactId) {
		Contact contact = null;
		
		try {
			Connection con = DBHelper.GetConnection();
		    Statement stmt = null;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Customer WHERE CustomerID=" + contactId);
			if(rs.next()) {
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String middleName = rs.getString("MidleName");
				String address = rs.getString("Address");

				contact = new Contact(Integer.parseInt(contactId), firstName, middleName, lastName, address);
			}
			  
			rs.close();
			stmt.close();
			con.close();
			
			return contact;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}

	public static List<Contact> GetContactList()
	{
	    Connection connection = DBHelper.GetConnection();
	    try {
	    	
	    	
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
	        
	        List<Contact> contacts = new ArrayList<Contact>();
	        
	        while(rs.next())
	        {
	        	int contactId = Integer.parseInt(rs.getString("CustomerID"));
	        	String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String middleName = rs.getString("MidleName");
				String address = rs.getString("Address");

	        	Contact contact = new Contact(contactId, firstName, middleName, lastName, address);
	        	contacts.add(contact);
	        }
	        return contacts;
	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}
	
	
	

	
}
