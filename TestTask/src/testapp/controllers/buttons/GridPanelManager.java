package testapp.controllers.buttons;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import testapp.controllers.modal.RandomWeight;
import testapp.database.Database;

import java.sql.SQLException;

/**
 * Create GridPane with CategoriesButtons or ProductButtons.
 */
public class GridPanelManager {
    public GridPanelManager(){
        nextButton = new Button();
        previousButton = new Button();
        categoriesButtons = new CategoriesButtons();
        productsButtons = new ProductsButtons();
        searchButton = new Button();
    }
    private Button nextButton;
    private Button previousButton;
    private GridPane gridPane;
    private CategoriesButtons categoriesButtons;
    private ProductsButtons productsButtons;
    private Button searchButton;
    private Label weightLabel;
    private Button showCategoriesButtons;
    private int page = 0;
    public void setDatabase(Database database) {
        categoriesButtons.setDatabase(database);
        productsButtons.setDatabase(database);
    }

    public void setNextButton(Button nextButton) {
        this.nextButton = nextButton;
    }

    public void setWeightLabel(Label weightLabel) {
        this.weightLabel = weightLabel;
    }

    public void setPreviousButton(Button previousButton) {
        this.previousButton = previousButton;
    }

    public void setGridPane(GridPane gridPane) {
        categoriesButtons.setGridPane(gridPane);
        productsButtons.setGridPane(gridPane);
    }

    public void setAnchorPane(AnchorPane anchorPane){
        categoriesButtons.setAnchorPane(anchorPane);
        productsButtons.setAnchorPane(anchorPane);
    }

    public void setSearchButton(Button searchButton) {
        this.searchButton = searchButton;
    }

    public void setShowCategoriesButton(Button showCategoriesButton) {
        this.showCategoriesButtons = showCategoriesButton;
        productsButtons.setShowCategoriesButton(showCategoriesButton);
    }

    /**
     * Show GridPane with CategoriesButtons or ProductsButtons.
     * @throws SQLException
     */
    public void show() throws SQLException {
        RandomWeight.start(weightLabel);
        showCategoriesButtons.setVisible(false);
        categoriesButtons.setNumberOfDisplayingButtons(9);
        categoriesButtons.setPage(page);
        productsButtons.setNumberOfDisplayingButtons(9);
        productsButtons.setPage(page);
        categoriesButtons.showCategoriesButtons("SELECT * FROM `categories`",productsButtons);
        nextButton.setDisable(false);
    }

    /**
     * Show next page.
     * @param buttons - CategoryButtons or ProductsButtons object.
     */
    private void nextPage(Buttons buttons){
        if(page <= (buttons.getCountOfButtons()-9)){
            page += 9;
            buttons.setPage(page);
            previousButton.setDisable(false);
        }else {
            nextButton.setDisable(true);
        }
    }

    /**
     * Show previous page.
     * @param buttons - CategoryButtons or ProductsButtons object.
     */
    public void previousPage(Buttons buttons){
        if(page>0){
            page-=9;
            buttons.setPage(page);
            nextButton.setDisable(false);
        }else {
            previousButton.setDisable(true);
        }
    }


    /**
     * When pressed button,shows next nine categories or products.
     */
    public void nextButtonEvent(){
       if(productsButtons.isProductsLoaded()){
           page = 0;
           nextPage(productsButtons);
       }else {
           nextPage(categoriesButtons);
       }
    }

    /**
     * When prssed button,shows previous nine categories or products.
     */
    public void previousButtonEvent(){
        if(productsButtons.isProductsLoaded()){
            page = 0;
            previousPage(productsButtons);
        }else {
            previousPage(categoriesButtons);
        }
    }

    /**
     * Search product by code.
     * @param code - code for search.
     * @throws SQLException
     */
    public void searchButtonEvent(String code) throws SQLException {
        page = 0;
        productsButtons.setPage(page);
        productsButtons.searchInProducts(code);
    }
}
