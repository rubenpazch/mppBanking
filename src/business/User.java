/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package business;

import java.io.Serializable;


/**
 *
 * @author USER
 */
public class User implements Serializable {

	private static final long serialVersionUID = 5147265048973262104L;

	private String id;
	private String password;
	//private Auth authorization;
	private UserType userType;

	public User(String id, String pass, UserType  auth) {
		this.id = id;
		this.password = pass;
		this.userType = auth;
	}
	public User(String id, String pass) {
		this.id = id;
		this.password = pass;
	}


	public User(){}

	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setPass(String pass){
		this.password = pass;
	}
	public void setUserType(int usertype){

		if(usertype==0){
			this.userType = UserType.BANK_EMPLOYEE;
		}else{
			this.userType =UserType.USER;
		}
	}

	public UserType getAuthorization() {
		return userType;
	}
	public String getRole(){

		if(this.userType==UserType.BANK_EMPLOYEE){
			return "Employee";
		}else{
			return "Customer";
		}
	}
	@Override
	public String toString() {
		return "[" + id + ":" + password + ", " + userType.toString() + "]";
	}

	//new methods
	public boolean authenticate(String id, String Password) {
		return this.id.equals(id) && this.password.equals(password);

	}
}
