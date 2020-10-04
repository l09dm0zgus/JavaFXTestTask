package testapp.controllers.modal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.EventObject;

/**
 * Class for Creating Modal window.
 */
public class ModalWindow {
    private String fxmlFile;
    protected FXMLLoader loader;
    public void setFxmlFile(String fxmlFile) {
        this.fxmlFile = fxmlFile;
    }

    /**
     * Create Modal Window where parent Button.
     * @param title Window title.
     * @param event event from button.
     * @throws IOException
     */
    public void create(String title, EventObject event) throws IOException {
        Stage stage = new Stage();
        loader = new  FXMLLoader(getClass().getResource(fxmlFile));
        System.out.println(fxmlFile);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        stage.show();
    }

    /**
     * Create Modal Window where parent GridPane.
     * @param title Window title.
     * @param pane  GridPane object.
     * @throws IOException
     */
    public void create(String title, GridPane pane) throws IOException {
        Stage stage = new Stage();
        loader = new  FXMLLoader(getClass().getResource(fxmlFile));
        System.out.println(fxmlFile);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)pane).getScene().getWindow());
        stage.show();
    }
}
