package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TransactionController extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("/ui/RegisterTransaction.fxml"));
		primaryStage.setTitle("Register Transaction");
		primaryStage.setScene(new Scene(root, 600, 400));

		Button btnReturnMainRegisterTransaction = (Button) root.lookup("#btnReturnMainRegisterTransaction");




		btnReturnMainRegisterTransaction.setOnAction((event) -> {
			try {
				//MainMenuController mainMenuController = new MainMenuController();
				//mainMenuController.start(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		primaryStage.show();
	}

}
