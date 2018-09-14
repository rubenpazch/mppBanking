package controller;

import javafx.application.Application;
//import controller.BookController;
//import control.CheckEntriesMemberController;
//import control.CheckoutController;
//import control.LibraryMemberController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import rulesets.RuleSet;
import rulesets.RuleSetFactory;

import business.Auth;
import business.User;
import business.UserType;
import util.Util;

public class MainMenuController extends Application{

	private Stage primaryStage;
	private User user;

	public static void main(String[] args) {
		Application.launch(MainMenuController.class, args);
	}

	public MainMenuController(User user) {
		this.user = user;
	}

	public void start(Stage stage) throws Exception {

		this.primaryStage = stage;

		Parent root = FXMLLoader.load(getClass().getResource("/ui/main.fxml"));
		//FXMLLoader loader= new FXMLLoader(getClass().getResource("/ui/main.fxml"));
		stage.setTitle("FXML");

		Label lblRole = (Label)root.lookup("#lblRole");
		lblRole.setText(this.user.getRole());

		Button btnWithdraw = (Button) root.lookup("#btnWithdraw");
		Button btnDeposit = (Button) root.lookup("#btnDeposit");
		Button btnRegisterAccount = (Button) root.lookup("#btnRegisterAccount");
		Button btnRegisterCustomer = (Button) root.lookup("#btnRegisterCustomer");
		Button btnSignOut = (Button) root.lookup("#btSignOut");

		stage.setScene(new Scene(root));

		if (user.getAuthorization().equals(UserType.USER)) {
			btnRegisterAccount.setVisible(false);
			btnRegisterCustomer.setVisible(false);

		}
		if (user.getAuthorization().equals(UserType.BANK_EMPLOYEE)) {
			btnDeposit.setVisible(false);
			btnWithdraw.setVisible(false);

		}

		btnRegisterAccount.setOnAction((event) -> {

			try {
				RegisterAccountController register =  new RegisterAccountController(user);
				register.start(stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		btnRegisterCustomer.setOnAction((event) -> {

			try {

				RegisterCustomerController customerController = new RegisterCustomerController(user);
				//CustomerController customerController =new CustomerController(user);
				customerController.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		stage.show();
		btnWithdraw.setOnAction((event) -> {
			try {


				WithdrawController transactionController = new WithdrawController(user);
				transactionController.start(stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		btnDeposit.setOnAction((event) -> {
			try {


				DepositController depositController = new DepositController(user);
				depositController.start(stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		btnSignOut.setOnAction((event) -> {
			try {
				LoginController login = new LoginController();
				login.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		stage.show();
	}

	 User getUser(User u) {
		return user=u;
	}


}