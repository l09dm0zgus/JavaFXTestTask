package testapp.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import testapp.controllers.buttons.GridPanelManager;
import testapp.controllers.modal.ModalWindow;
import testapp.database.Database;
import testapp.database.DatabasePropertiesFile;

import java.io.IOException;
import java.sql.SQLException;
public class MainWindowController {
    private static Database db = new Database();
    private static GridPanelManager gridPanelManager = new GridPanelManager();
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button showCategoriesButton;
    @FXML
    private Label weight;
    @FXML
    private Button previousButton;;
    @FXML
    private Button nextButton;
    @FXML
    private GridPane gridPane;
    @FXML
    private TextField searchBox;
    @FXML
    private void click(ActionEvent event) throws SQLException {
        String code = searchBox.getText();
        gridPanelManager.searchButtonEvent(code);
    }

    public static void showCategories() throws SQLException {
        db.newConnection(DatabasePropertiesFile.read("db.ip"),DatabasePropertiesFile.read("db.name"),DatabasePropertiesFile.read("db.login"),DatabasePropertiesFile.read("db.password"));
        gridPanelManager.show();
    }
    private void setProperties(){
        gridPanelManager.setDatabase(db);
        gridPanelManager.setGridPane(gridPane);
        gridPanelManager.setNextButton(nextButton);
        gridPanelManager.setPreviousButton(previousButton);
        gridPanelManager.setShowCategoriesButton(showCategoriesButton);
        gridPanelManager.setWeightLabel(weight);
        gridPanelManager.setAnchorPane(anchorPane);
    }
    private void openNewConnectionWindow(ActionEvent event) throws IOException {
        ModalWindow newConnection = new  ModalWindow();
        newConnection.setFxmlFile("/testapp/controllers/modal/DatabaseConnectionWindow.fxml");
        newConnection.create("Create new connection",gridPane);
    }
    @FXML
    private void showCategories(ActionEvent event) throws SQLException {
        showCategories();
    }
    @FXML
    private void newConnection(ActionEvent event) throws SQLException,IOException {
        setProperties();
        if(!DatabasePropertiesFile.isFileExist()){
            openNewConnectionWindow(event);
        }
        else {
            showCategories();
        }



    }


    @FXML
    private void nextButtonPressed(ActionEvent event){
        gridPanelManager.nextButtonEvent();
    }
    @FXML
    private void  previousButtonPressed(ActionEvent event){
        gridPanelManager.previousButtonEvent();
    }

}
