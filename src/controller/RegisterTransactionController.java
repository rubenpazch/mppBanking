package controller;

import business.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import rulesets.RuleException;
import rulesets.RuleSet;
import rulesets.RuleSetFactory;
import util.Util;

public class RegisterTransactionController extends Application{

	private TextField txtTransactionId;
	private TextField txtAmounTransaction;
	private User user;


	public RegisterTransactionController(User user) {
		super();
		this.user = user;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("/ui/RegisterTransaction.fxml"));
		primaryStage.setTitle("Register Transaction");
		primaryStage.setScene(new Scene(root, 600, 400));

		txtTransactionId = (TextField) root.lookup("#txtTransactionId");
		txtAmounTransaction = (TextField) root.lookup("#txtAmounTransaction");
		Button btnSaveTransaction = (Button) root.lookup("#btnSaveTransaction");
		Button btnReturnMainRegisterTransaction = (Button) root.lookup("#btnReturnMainRegisterTransaction");

		btnSaveTransaction.setOnAction((event) -> {
			RuleSet rules = RuleSetFactory.getRuleSet(RegisterTransactionController.this);
			try {
				rules.applyRules(RegisterTransactionController.this);

				//------------------------------------
				//CONNECT WITH THE LOGIC OF BUSINESS/*
				//------------------------------------

				MainMenuController mainMenuController = new MainMenuController(user);
				mainMenuController.start(primaryStage);

			}catch (RuleException e1) {
				Util.showAlert(e1.getMessage(), "Error login", AlertType.ERROR);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		primaryStage.show();

		btnReturnMainRegisterTransaction.setOnAction((event) -> {
			try {
				MainMenuController mainMenuController = new MainMenuController(user);
				mainMenuController.start(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		primaryStage.show();
	}

	public TextField getTxtTransactionId() {
		return txtTransactionId;
	}

	public TextField getTxtAmounTransaction() {
		return txtAmounTransaction;
	}

}
