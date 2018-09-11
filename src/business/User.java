/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import business.RuleException;


/**
 *
 * @author USER
 */
public class User implements Serializable {

	private static final long serialVersionUID = 5147265048973262104L;

	private String id;
	private String password;
	private Auth authorization;

	public User(String id, String pass, Auth  auth) {
		this.id = id;
		this.password = pass;
		this.authorization = auth;
	}

	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public Auth getAuthorization() {
		return authorization;
	}
	@Override
	public String toString() {
		return "[" + id + ":" + password + ", " + authorization.toString() + "]";
	}

	//new methods
	public boolean authenticate(String id, String Password) {
		return this.id.equals(id) && this.password.equals(password);

	}
}
