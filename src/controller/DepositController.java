package controller;

import business.*;
import dataaccess.ContactDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import rulesets.RuleException;
import rulesets.RuleSet;
import rulesets.RuleSetFactory;
import util.Util;

public class DepositController extends Application{

	private Stage primaryStage;
	private TextField accoutID;
	private TextField balance;
	private TextField depositAmount;
	
	public static void main(String[] args) {
		Application.launch(DepositController.class, args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		this.primaryStage = stage;
		Parent root = FXMLLoader.load(getClass().getResource("/ui/Deposit.fxml"));

		stage.setTitle("Deposit");
		stage.setScene(new Scene(root));

		accoutID = (TextField) root.lookup("#txtAccout");
		balance = (TextField) root.lookup("#txtBalance");
		depositAmount = (TextField) root.lookup("#txtDepositAmount");
		
		Button button = (Button) root.lookup("#btnApply");
		Contact c =  ContactDAO.getContact(1); // pass customer login to here
		AccountService aservice = new AccountService(c);
		Account acc = aservice.getAccount(2);
		
		accoutID.setText(String.format("%d", acc.getAccountId()));
		balance.setText(String.valueOf( acc.getBalance()));
		
		button.setOnAction((event) -> {
			RuleSet rules = RuleSetFactory.getRuleSet(this);
			try {
				rules.applyRules(DepositController.this);

				TransactionService transervive = new TransactionService(acc);
				transervive.createDeposit(getAmount(),TransactionStatus.COMPLETED);
				
				balance.setText(String.valueOf(acc.getBalance()));
				 
				Label lblsmg = (Label) root.lookup("#lblsmg");
				lblsmg.setText("Deposit completed");
				lblsmg.setVisible(true);
			} catch (RuleException e1 ) {
				Util.showAlert(e1.getMessage(), "Error login", AlertType.ERROR);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		stage.show();
	}

	
	public double getAmount() {
		if (depositAmount.getText()=="") return 0;
		return Double.parseDouble(depositAmount.getText());
	}
	
	public double getRemainBalance() {
		return Double.parseDouble(balance.getText()) - Double.parseDouble(depositAmount.getText());
	}
}
