package controller;

import business.Customer;
import business.CustomerService;
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

public class RegisterCustomerController extends Application{
	private TextField txtId;
	private TextField txtFirstName;
	private TextField txtMidleName;
	private TextField txtLastName;
	private TextField txtAddress;
	private User user;


	public RegisterCustomerController(User user) {
		this.user = user;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/ui/RegisterCustomer.fxml"));

		primaryStage.setTitle("Register Customer");
		primaryStage.setScene(new Scene(root, 600, 400));

		txtId = (TextField) root.lookup("#txtId");
		txtFirstName = (TextField) root.lookup("#txtFirstName");
		txtMidleName = (TextField) root.lookup("#txtMidleName");
		txtLastName = (TextField) root.lookup("#txtLastName");
		txtAddress = (TextField) root.lookup("#txtAddress");
		Button btReturnMainRegisterCustomer = (Button) root.lookup("#btReturnMainRegisterCustomer");
		Button btnSaveCustomer = (Button) root.lookup("#btnSaveCustomer");




		btnSaveCustomer.setOnAction((event) -> {
			RuleSet rules = RuleSetFactory.getRuleSet(RegisterCustomerController.this);
			try {
				rules.applyRules(RegisterCustomerController.this);


				//------------------------------------
				//CONNECT WITH THE LOGIC OF BUSINESS/*
				//------------------------------------
				Customer c = new Customer();
				c.setFirstName(txtFirstName.getText());
				c.setMidleName(txtMidleName.getText());
				c.setLastName(txtLastName.getText());
				c.setAddress(txtAddress.getText());

				CustomerService cs  = new CustomerService();
				cs.createCustomer(c);


				MainMenuController mainMenuController = new MainMenuController(user);
				mainMenuController.start(primaryStage);

			} catch (RuleException e1) {
				Util.showAlert(e1.getMessage(), "Error login", AlertType.ERROR);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});



		btReturnMainRegisterCustomer.setOnAction((event) -> {
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
	public TextField getTxtId() {
		return txtId;
	}


	public TextField getTxtFirstName() {
		return txtFirstName;
	}


	public TextField getTxtMidleName() {
		return txtMidleName;
	}


	public TextField getTxtLastName() {
		return txtLastName;
	}


	public TextField getTxtAddress() {
		return txtAddress;
	}
}
