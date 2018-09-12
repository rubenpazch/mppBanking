package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerController extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/ui/RegisterCustomer.fxml"));

		primaryStage.setTitle("Register Customer");
		primaryStage.setScene(new Scene(root, 600, 400));


		Button btReturnMainRegisterCustomer = (Button) root.lookup("#btReturnMainRegisterCustomer");
		Button btnSaveCustomer = (Button) root.lookup("#btnSaveCustomer");


		TextField txtId = (TextField) root.lookup("#txtId");;
		TextField txtFirstName = (TextField) root.lookup("#txtFirstName");;
		TextField txtMidleName = (TextField) root.lookup("#txtMidleName");;
		TextField txtLastName = (TextField) root.lookup("#txtLastName");;
		TextField txtAddress = (TextField) root.lookup("#txtAddress");;


		btnSaveCustomer.setOnAction((event) -> {
			try {
				//MainMenuController mainMenuController = new MainMenuController();
				//mainMenuController.start(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});



		btReturnMainRegisterCustomer.setOnAction((event) -> {
			try {
				MainMenuController mainMenuController = new MainMenuController();
				mainMenuController.start(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});


		primaryStage.show();




	}



}
