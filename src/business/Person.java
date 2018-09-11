package business;

public class Person {

	String firstName;
	String midleName;
	String lastName;
	String address;
	
	Person(String firstName,String midleName,String lastName)
	{
		this.firstName=firstName;
		this.midleName =midleName;
		this.lastName=lastName;
	}
	
	public String getAdrress()
	{
		return address;
	}
	
	public void setAdrress(String address)
	{
		this.address=address;
	}
}
