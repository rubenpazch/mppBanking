package controller;

import business.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import rulesets.RuleException;
import rulesets.RuleSet;
import rulesets.RuleSetFactory;
import util.Util;

public class RegisterAccountController  extends Application{

	private User user;
	private Stage primaryStage;
	private TextField txtAccountNumber;
	private ComboBox<String> comboBoxType;
	private TextField txtCustomer;
	private TextField txtInitialAmount;
	private TextField txtInterestRate;
	private TextField txtMonthlyFee;
	private Button btnRegister;
	private Button btnBackMenu;


	public RegisterAccountController(User user) {
		this.user=user;
	}
	@SuppressWarnings("unchecked")
	@Override

	public void start(Stage stage) throws Exception {

		// TODO Auto-generated method stub
		this.primaryStage = stage;
		Parent root = FXMLLoader.load(getClass().getResource("/ui/RegisterAccount.fxml"));

		stage.setTitle("Register Account");
		stage.setScene(new Scene(root));

		txtAccountNumber = (TextField) root.lookup("#txtAccountNumber");
		comboBoxType = (ComboBox<String>) root.lookup("#comboBoxType");
		txtCustomer = (TextField) root.lookup("#txtCustomer");
		txtInitialAmount = (TextField) root.lookup("#txtInitialAmount");
		txtInterestRate = (TextField) root.lookup("#txtInterestRate");
		txtMonthlyFee = (TextField) root.lookup("#txtMonthlyFee");
		Button btnRegister = (Button) root.lookup("#btnRegister");
		Button btnBackMenu = (Button) root.lookup("#btnBackMenu");

		txtCustomer.setText(user.getId());


		btnRegister.setOnAction((event) -> {
			RuleSet rules = RuleSetFactory.getRuleSet(RegisterAccountController.this);
			try {
				rules.applyRules(RegisterAccountController.this);


				//------------------------------------
				//CONNECT WITH THE LOGIC OF BUSINESS/*
				//------------------------------------

				MainMenuController mainMenuController = new MainMenuController(user);
				mainMenuController.start(primaryStage);


			} catch (RuleException e1) {
				Util.showAlert(e1.getMessage(), "Error login", AlertType.ERROR);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		});
		stage.show();

		btnBackMenu.setOnAction((event) -> {

			MainMenuController mainMenuController = new MainMenuController(user);
			try {
				mainMenuController.start(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		});
		stage.show();
	}

	public TextField getTxtAccountNumber() {
		return txtAccountNumber;
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
