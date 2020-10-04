package testapp.controllers.buttons;

import java.sql.SQLException;

/**
 * Class creating buttons with Category information from database
 */
public class CategoriesButtons extends Buttons {
    /**
     * Create buttons.
     * @param prod - ProductionButtons object.
     */
    private void createButtons(ProductsButtons prod){
        buttonsCreator.setButtonsCount(buttonsNames.size());
        buttonsCreator.setNumberOfDisplayingButtons(displayingButtons);
        buttonsCreator.create(buttonsNames, event-> {
            try
            {
                prod.setNumberOfDisplayingButtons(displayingButtons);
                prod.showProductsButtons(event.getSource().toString());
            }
            catch (SQLException throwables)
            {
                throwables.printStackTrace();
            }
        });
    }

    /**
     * Displaying Categories buttons.
     * @param query - SQL query.
     * @param productsButtons - ProductsButtons object.
     * @throws SQLException
     */
    public void showCategoriesButtons(String query, ProductsButtons productsButtons) throws SQLException {
        buttonsNames  = database.executeQuery(query,"name");
        anchorPane.setDisable(false);
        createButtons(productsButtons);
        buttonsCreator.display(gridPane,page);
    }
}
