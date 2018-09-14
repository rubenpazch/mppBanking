package controller;

import java.awt.List;
import java.util.ArrayList;

import business.Account;
import business.AccountService;
import business.Contact;
import business.User;
import dataaccess.ContactDAO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rulesets.RuleException;
import rulesets.RuleSet;
import rulesets.RuleSetFactory;
import util.Util;

public class RegisterAccountController  extends Application{

	private User user;
	private int contactID;
	private Stage primaryStage;
	private ComboBox<Contact> listCustomer;
	private ComboBox<String> ddlTypeAccounts;
	private TextField txtCustomerName;
	private TextField txtInitialAmount;
	private TextField txtInterestRate;
	private TextField txtMonthlyFee;



	public RegisterAccountController(User user) {
		this.user=user;
	}
	public RegisterAccountController(int contact) {
		this.contactID=contact;
	}
	
	//@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {
		this.primaryStage = stage;
		Parent root = FXMLLoader.load(getClass().getResource("/ui/RegisterAccount.fxml"));

		stage.setTitle("Register Account");
		stage.setScene(new Scene(root));

		listCustomer = (ComboBox<Contact>) root.lookup("#listCustomer");
		ddlTypeAccounts = (ComboBox<String>) root.lookup("#ddlTypeAccounts");
		txtCustomerName = (TextField) root.lookup("#txtCustomerName");
		txtInitialAmount = (TextField) root.lookup("#txtInitialAmount");
		txtInterestRate = (TextField) root.lookup("#txtInterestRate");
		txtMonthlyFee = (TextField) root.lookup("#txtMonthlyFee");
		Button btnReturnMainRegisterAccount = (Button) root.lookup("#btnReturnMainRegisterAccount");
		Button btnSaveAccount = (Button) root.lookup("#btnSaveAccount");
		Button btnSearch = (Button) root.lookup("#btnSearch");
		
	
				
		ObservableList<Contact> items = FXCollections.observableArrayList();
		items.addAll(ContactDAO.GetContactList());
		listCustomer.getItems().addAll(items);		
		

		ddlTypeAccounts.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if(newSelection.equals("SAVING")) {
				txtInterestRate.setText("");
	    		txtMonthlyFee.setText("0.00");
	    		txtMonthlyFee.setEditable(false);
	    		
	    		txtInterestRate.setText("");
	    		txtInterestRate.setEditable(true);
	    	}
			if(newSelection.equals("CHECKING")) {
	    		txtInterestRate.setText("0.00");
	    		txtInterestRate.setEditable(false);
	    		
	    		txtMonthlyFee.setText("");
	    		txtMonthlyFee.setEditable(true);
	    		
	    	}
		});

		
		btnSaveAccount.setOnAction((event) -> {
			RuleSet rules = RuleSetFactory.getRuleSet(RegisterAccountController.this);
			
			try {
				rules.applyRules(RegisterAccountController.this);


				//------------------------------------
				//CONNECT WITH THE LOGIC OF BUSINESS/*
				//------------------------------------

				Contact contact = ContactDAO.getContact(String.valueOf(listCustomer.getValue().getContactId()));// SHOULD BE THE CUSTOMER'ID, NOT LIKE THAT
		    	AccountService accountService = new AccountService(contact);
		    	double startBalance = Double.parseDouble(txtInitialAmount.getText());
		    	double monthlyFee = Double.parseDouble(txtMonthlyFee.getText());
		    	double interestRate = Double.parseDouble(txtInterestRate.getText());
		    	if(ddlTypeAccounts.getValue().equals("SAVING")) {
			    	Account checkingAccount = accountService.createSavingAccount(interestRate, startBalance);
		    	}
		    	else if(ddlTypeAccounts.getValue().equals("CHECKING")){
			    	Account checkingAccount = accountService.createCheckingAccount(monthlyFee, startBalance);
		    	}


				MainMenuController mainMenuController = new MainMenuController(user);
				mainMenuController.start(stage);


			} catch (RuleException e1) {
				Util.showAlert(e1.getMessage(), "Error login", AlertType.ERROR);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		


		btnReturnMainRegisterAccount.setOnAction((event) -> {

			MainMenuController mainMenuController = new MainMenuController(user);
			try {
				mainMenuController.start(stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		stage.show();
	}


	public ComboBox<String> getDdlTypeAccounts() {
		return ddlTypeAccounts;
	}
	public TextField getTxtCustomerName() {
		return txtCustomerName;
	}
	public TextField getTxtInitialAmount() {
		return txtInitialAmount;
	}
	public TextField getTxtInterestRate() {
		return txtInterestRate;
	}
	public TextField getTxtMonthlyFee() {
		return txtMonthlyFee;
	}

	public static void main(String[] args) {
		Application.launch(RegisterAccountController.class, args);
	}

}
