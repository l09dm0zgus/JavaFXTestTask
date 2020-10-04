package testapp.controllers.buttons;
import java.io.IOException;
import java.sql.SQLException;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import testapp.controllers.modal.ProductInformationWindow;

public class ProductsButtons extends Buttons {
    public ProductsButtons(){
        modalWindow = new ProductInformationWindow();
    }
    private ProductInformationWindow modalWindow;
    private Button showCategoriesButton;


    public void setShowCategoriesButton(Button showCategoriesButton) {
        this.showCategoriesButton = showCategoriesButton;
    }


    /**
     * Getting substring with category name from event name.
     * @param s event name.
     * @return category name.
     */
    private String getCategoriesNameSubstring(String s)
    {
        int i = s.indexOf("'");
        return s.substring(i);
    }

    private boolean isProductsLoaded = false;

    public boolean isProductsLoaded(){
        return isProductsLoaded;
    }

    private void buttonsCreate(){
        buttonsCreator.setButtonsCount(buttonsNames.size());
        buttonsCreator.setNumberOfDisplayingButtons(9);
        modalWindow.setFxmlFile("ProductInfo.fxml");
        buttonsCreator.create(buttonsNames, event-> {
            try {
                modalWindow.create("Product",event);
                modalWindow.showInformation(event.getSource().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonsCreator.display(gridPane,page);
    }
    /**
     * Show product buttons.
     * @param eventSourceName - event name.
     */
    public void showProductsButtons(String eventSourceName) throws SQLException {
        String categoriesName = getCategoriesNameSubstring(eventSourceName);
        anchorPane.setDisable(true);
        buttonsNames.clear();
        buttonsNames = database.executeQuery("SELECT * FROM `goods` `categories` WHERE categories.name="+categoriesName,"code");
        buttonsCreate();
        showCategoriesButton.setVisible(true);
        isProductsLoaded = true;
    }

    public void searchInProducts(String code) throws SQLException {
        buttonsNames.clear();
        buttonsNames = database.executeQuery("SELECT * FROM `goods` WHERE goods.code="+code,"code");
        buttonsCreate();
    }


}
