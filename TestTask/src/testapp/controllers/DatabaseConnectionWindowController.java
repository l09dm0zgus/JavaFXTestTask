package testapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import testapp.database.DatabasePropertiesFile;

import java.sql.SQLException;

public class DatabaseConnectionWindowController {
    @FXML
    private TextField ipInput;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField loginInput;
    @FXML
    private TextField passwordInput;
    @FXML
    private  void connectToDatabase(ActionEvent event) throws SQLException {
        DatabasePropertiesFile.save(ipInput.getText(),nameInput.getText(),loginInput.getText(),passwordInput.getText());
        //create new stage
        Stage stage = (Stage)passwordInput.getScene().getWindow();
        stage.close();
        MainWindowController.showCategories();
    }
}
