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
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import business.Auth;
import business.User;
import util.Util;

public class MainMenuController extends Application{

	private Stage primaryStage;
	private User user;

	public static void main(String[] args) {
		Application.launch(MainMenuController.class, args);
	}

/*	public MainMenuController(User user) {
		this.user = user;
	}*/

	public void start(Stage stage) throws Exception {

		this.primaryStage = stage;

		Parent root = FXMLLoader.load(getClass().getResource("/ui/main.fxml"));
		stage.setTitle("FXML");

		Button btnRegisterCustomer = (Button) root.lookup("#btnRegisterCustomer");
		Button btnRegisterTransaction = (Button) root.lookup("#btnRegisterTransaction");
		Button btnRegisterAccount = (Button) root.lookup("#btnRegisterAccount");
		Button btnSignOut = (Button) root.lookup("#btSignOut");

		stage.setScene(new Scene(root));

		//MainMenuController secondWindow = new MainMenuController();
		//secondWindow.start(this.primaryStage);

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
				CustomerController customerController = new CustomerController();
				customerController.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});



		btnRegisterAccount.setOnAction((event) -> {
			try {
				AccountController accountController = new AccountController();
				accountController.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});


		btnRegisterTransaction.setOnAction((event) -> {
			try {
				TransactionController transactionController = new TransactionController();
				transactionController.start(stage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});


		stage.show();
	}


}
