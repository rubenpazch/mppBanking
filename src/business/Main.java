/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.List;

import dataaccess.ContactDAO;

public class Main {

    public static void main(String[] args) {
    	Contact contact = ContactDAO.getContact("1");
    	
    	AccountService accountService = new AccountService(contact);
    	Account checkingAccount = accountService.createCheckingAccount(5, 100);
    	
    	TransactionService transactionService = new TransactionService(checkingAccount);
    	transactionService.createDeposit(100, TransactionStatus.COMPLETED);
    }
}
