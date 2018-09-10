/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import business.Auth;
import business.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class TestData {

    @SuppressWarnings("serial")
    List<User> allUsers = new ArrayList<User>() {
        {
            add(new User("101", "xyz", Auth.BUSINESS));
            add(new User("102", "abc", Auth.ADMIN));
            add(new User("103", "111", Auth.CUSTOMER));
        }
    };
    public void userData() {
    	DataAccessFacade.loadUserMap(allUsers);
    }

    public static void main(String[] args) {
        TestData td = new TestData();
        //td.bookData();
        //td.libraryMemberData();
        td.userData();
        DataAccess da = new DataAccessFacade();
        //System.out.println(da.readBooksMap());
        System.out.println(da.readUserMap());
    }

}
