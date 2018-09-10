/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Deposit extends Transaction{
    
    private double amount;
    private int transactionId;
    private boolean status;
    private Date dateOfTransaction;
    private double currentBalance;
    
    @Override
    public double getAmountTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
