package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import business.Customer;
import business.CustomerService;
import business.User;

public class CustomerController extends Application{

	private User user;

	public CustomerController(User user){
		this.user=user;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/ui/RegisterCustomer.fxml"));

		primaryStage.setTitle("Register Customer");
		primaryStage.setScene(new Scene(root, 600, 400));


		Button btReturnMainRegisterCustomer = (Button) root.lookup("#btReturnMainRegisterCustomer");
		Button btnSaveCustomer = (Button) root.lookup("#btnSaveCustomer");



		TextField txtId = (TextField) root.lookup("#txtId");;

		CustomerService cstemp = new CustomerService();
		txtId.setText(cstemp.getNextId());

		TextField txtFirstName = (TextField) root.lookup("#txtFirstName");;
		TextField txtMidleName = (TextField) root.lookup("#txtMidleName");;
		TextField txtLastName = (TextField) root.lookup("#txtLastName");;
		TextField txtAddress = (TextField) root.lookup("#txtAddress");;


		btnSaveCustomer.setOnAction((event) -> {
			try {

				Customer c = new Customer();
				c.setFirstName(txtFirstName.getText());
				c.setMidleName(txtMidleName.getText());
				c.setLastName(txtLastName.getText());
				c.setAddress(txtAddress.getText());

				CustomerService cs  = new CustomerService();
				cs.createCustomer(c);

				MainMenuController mainMenuController = new MainMenuController(user);
				mainMenuController.start(primaryStage);
			} catch (Exception e) {
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



}
