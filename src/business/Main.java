/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Main {

    public static void main(){
    	Contact contact = new Contact("C1", "John", "Mc", "Doe", "Somewhere in the earth");
        List<Account> accounts = new ArrayList<>();

        Account acct1= new CheckingAccount("ACC1", contact,4,100);
        Account acct2= new CheckingAccount("ACC2", contact,8,200);
        Account acct3= new CheckingAccount("ACC3", contact,10,300);

        Account acct4= new SavingAccount("ACC4", contact,4,600);
        Account acct5= new SavingAccount("ACC5", contact,8,700);
        Account acct6= new SavingAccount("ACC6", contact,10,800);

        accounts.add(acct1);
        accounts.add(acct2);
        accounts.add(acct3);
        accounts.add(acct4);
        accounts.add(acct5);
        accounts.add(acct6);


    }

}
