package testapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import testapp.controllers.modal.RandomWeight;
import testapp.database.Database;
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.setTitle("Categories");
        stage.setWidth(600);
        stage.setHeight(400);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        RandomWeight.stop();
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {

        launch(args);
    }
}
