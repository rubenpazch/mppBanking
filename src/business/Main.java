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
        List<Account> accounts = new ArrayList<>();
        
        Account acct1= new CheckingAccount("Acct1",4,100);
        Account acct2= new CheckingAccount("Acct2",8,200);
        Account acct3= new CheckingAccount("Acct3",10,300);
        
        Account acct4= new SavingsAccount("Acct4",4,600);
        Account acct5= new SavingsAccount("Acct5",8,700);
        Account acct6= new SavingsAccount("Acct6",10,800);
        
    }
    
}
