package controller;

import java.util.HashMap;

import business.User;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rulesets.RuleException;
import rulesets.RuleSet;
import rulesets.RuleSetFactory;
import util.Util;


public class LoginController extends Application {


	private Stage primaryStage;
	private TextField userId ;;
	private TextField password;

	@Override
	public void start(Stage stage) throws Exception {

		// TODO Auto-generated method stub
		this.primaryStage = stage;
		Parent root = FXMLLoader.load(getClass().getResource("/ui/login.fxml"));

		stage.setTitle("Welcome Bank System");
		stage.setScene(new Scene(root));

		userId = (TextField) root.lookup("#txtUser");
		password = (TextField) root.lookup("#txtPwd");

		Button button = (Button) root.lookup("#btLogin");

		button.setOnAction((event) -> {
			RuleSet rules = RuleSetFactory.getRuleSet(LoginController.this);
			try {
				rules.applyRules(LoginController.this);
				DataAccess db = new DataAccessFacade();
				HashMap<String, User> users = db.readUserMap();
				User user = users.get(getUserId().getText());
				//MainMenuController secondWindow = new MainMenuController(user);
				//secondWindow.start(this.primaryStage);

			} catch (RuleException e1) {
				Util.showAlert(e1.getMessage(), "Error login", AlertType.ERROR);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		});
		stage.show();
	}



	public TextField getUserId() {
		return userId;
	}

	public TextField getPassword() {
		return password;
	}

	public static void main(String[] args) {
		Application.launch(LoginController.class, args);
	}

}
