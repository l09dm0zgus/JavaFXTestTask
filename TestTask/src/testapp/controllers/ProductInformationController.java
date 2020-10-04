package testapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import testapp.controllers.modal.RandomWeight;
import testapp.database.Database;

import javafx.event.ActionEvent;
import testapp.database.DatabasePropertiesFile;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProductInformationController  {
    @FXML
    private Label categoryLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label costLabel;
    @FXML
    private Button printButton;
    @FXML
    private void onPrintButtonPressed(ActionEvent event) throws SQLException {
        Stage stage = (Stage) printButton.getScene().getWindow();
        stage.close();
        MainWindowController.showCategories();
    }
    private String category;
    private long weight;
    private float price;
    private  List<String> result = new ArrayList<>();
    private  String code = "";
    private Database db = new Database();


    private void getPriceFromDatabase() throws SQLException {
        result.clear();
        result = db.executeQuery("SELECT * FROM `goods` WHERE goods.code = "+code,"price");
        price = Float.parseFloat(result.get(0));
    }

    private void getCategoryFromDatabase() throws SQLException {
        result.clear();
        result = db.executeQuery("SELECT * FROM `goods` WHERE goods.code = "+code,"name");
        category = result.get(0);
    }

    private float getCost(){
        return weight*price;
    }

    private void getDataFromDataBase(){
        db.newConnection(DatabasePropertiesFile.read("db.ip"),DatabasePropertiesFile.read("db.name"),DatabasePropertiesFile.read("db.login"),DatabasePropertiesFile.read("db.password"));
        getCost();
        try {
            getPriceFromDatabase();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            getCategoryFromDatabase();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setLabelsValue(){
        categoryLabel.setText("Category:"+category);
        priceLabel.setText("Price:"+price);
        weightLabel.setText("Weight:"+weight);
        costLabel.setText("Cost:"+getCost());
    }

    public void initialize(String code) {
        weight = RandomWeight.stop();
        this.code = code;
        if(!code.isEmpty()){
            getDataFromDataBase();
            setLabelsValue();
        }

        System.out.println(code);
    }



}
