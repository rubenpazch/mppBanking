package annotation;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TypesAccountController {

    @FXML
    // fx:id="combo"
    private ComboBox<String> combo; // Value injected by FXMLLoader

    @FXML
    // fx:id="text"
    private TextField text; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
   void initialize() {
       assert combo != null : "fx:id=\"ddlTypeAccounts\" was not injected: check your FXML file 'RegisterAccount.fxml'.";
       assert text != null : "fx:id=\"text\" was not injected: check your FXML file 'ComboboxExample.fxml'.";

       // Initialize your logic here: all @FXML variables will have been injected
       combo.getItems().clear();
       combo.getItems().addAll("John Lennon","Mick Jagger","David Bowie");
       combo.getItems().add("Others...");

       text.setText("List : ");
   }
}
