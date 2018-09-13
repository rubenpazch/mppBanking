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

public class WithdrawController extends Application{

	private Stage primaryStage;
	private TextField accoutID;
	private TextField balance;
	private TextField withdrawAmount;
	
	public static void main(String[] args) {
		Application.launch(WithdrawController.class, args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				this.primaryStage = stage;
				Parent root = FXMLLoader.load(getClass().getResource("/ui/Withdraw.fxml"));

				stage.setTitle("Withdraw");
				stage.setScene(new Scene(root));

				accoutID = (TextField) root.lookup("#txtAccout");
				balance = (TextField) root.lookup("#txtPwd");
				withdrawAmount = (TextField) root.lookup("#txtWithdrawAmount");
				Label lblsmg = (Label) root.lookup("#lblsmg");
				
				Button button = (Button) root.lookup("#btnApply");
				Contact c =  ContactDAO.getContact("1"); // pass customer login to here
				AccountService aservice = new AccountService(c);
				Account acc = aservice.getAccount(2);
				
				accoutID.setText(String.format("%d", acc.getAccountId()));
				balance.setText(String.valueOf( acc.getBalance()));
				
				button.setOnAction((event) -> {
				RuleSet rules = RuleSetFactory.getRuleSet(WithdrawController.this);
			   try {
			         rules.applyRules(WithdrawController.this);
			         balance.setText(String.valueOf( acc.getBalance()));
			         TransactionService transervive = new TransactionService(acc);
			         transervive.createWithdrawal(getAmount(),TransactionStatus.COMPLETED);
			         lblsmg.setText("Withdraw completed");
			         
					} catch (RuleException e1 ) {
						// TODO Auto-generated catch block
						Util.showAlert(e1.getMessage(), "Error login", AlertType.ERROR);
					}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
				stage.show();
	}

	
	public double getAmount()
	{
		if (withdrawAmount.getText()=="") return 0;
		return Double.parseDouble( withdrawAmount.getText());
	}
	
	public double getRemainBalance()
	{
		return Double.parseDouble( balance.getText()) - Double.parseDouble( withdrawAmount.getText());
	}
	
}
