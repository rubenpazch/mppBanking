/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author USER
 */
public abstract class Account {
    
    private static final long serialVersionUID = 6110690276685962829L;
    private double balance;
    	
    public abstract String getAccountID();
    public abstract double getBalance();
    public abstract double computeUpdatedBalance();
        
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }        
    
}
