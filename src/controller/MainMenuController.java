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

		Button btnRegisterTransaction = (Button) root.lookup("#btnRegisterTransaction");
		Button btnRegisterAccount = (Button) root.lookup("#btnRegisterAccount");
		Button btnRegisterCustomer = (Button) root.lookup("#btnRegisterCustomer");
		Button btnSignOut = (Button) root.lookup("#btSignOut");

		stage.setScene(new Scene(root));

		btnRegisterAccount.setOnAction((event) -> {

			try {
				if (user.getAuthorization().equals(UserType.USER)) {
					Util.showAlert("Customer can not register account", "Permission denied", AlertType.ERROR);
					return;
				}

				RegisterAccountController register =  new RegisterAccountController(user);
				register.start(stage);
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



		btnRegisterCustomer.setOnAction((event) -> {

			try {

				if (user.getAuthorization().equals(UserType.USER)) {
					Util.showAlert("Customer can not register customer", "Permission denied", AlertType.ERROR);
					return;
				}

				//RegisterCustomerController customerController = new RegisterCustomerController(user);
				CustomerController customerController =new CustomerController(user);
				customerController.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		btnRegisterTransaction.setOnAction((event) -> {
			try {


				RegisterTransactionController transactionController = new RegisterTransactionController(user);
				transactionController.start(stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});


		stage.show();
	}

	 User getUser(User u) {
		return user=u;
	}


}
