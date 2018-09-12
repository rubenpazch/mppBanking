package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CustomerController extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/ui/RegisterCustomer.fxml"));

		primaryStage.setTitle("Register Customer");
		primaryStage.setScene(new Scene(root, 600, 400));


		Button btReturnMainRegisterCustomer = (Button) root.lookup("#btReturnMainRegisterCustomer");
		Button btnSaveCustomer = (Button) root.lookup("#btnSaveCustomer");




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
