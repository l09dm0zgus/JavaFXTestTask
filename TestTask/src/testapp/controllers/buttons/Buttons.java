package testapp.controllers.buttons;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import testapp.database.Database;

import java.util.ArrayList;
import java.util.List;

/**
 * Parent class for CategoriesButtons,ProductsButtons.
 */
public class Buttons {
    public Buttons(){
        this.gridPane = new GridPane();
        this.database = new Database();
        this.buttonsCreator = new ButtonsCreator();
    }
    protected GridPane gridPane;
    protected int page = 0;
    protected int displayingButtons = 0;
    protected List<String> buttonsNames = new ArrayList<>();
    protected ButtonsCreator buttonsCreator;
    protected Database database;

    protected AnchorPane anchorPane;

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }
    public void setPage(int page) {
        this.page = page;
        buttonsCreator.display(gridPane,page);
    }
    public void setNumberOfDisplayingButtons(int displayingButtons) {
        this.displayingButtons = displayingButtons;
    }
    public int getCountOfButtons(){
        return buttonsNames.size();
    }



    public void setDatabase(Database database) {
        this.database = database;
    }
}
