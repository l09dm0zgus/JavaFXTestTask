package testapp.controllers.modal;
import testapp.controllers.ProductInformationController;

/**
 * Modal Window with product information
 */
public class ProductInformationWindow extends ModalWindow{
    /**
     * Getting substring with  product code from event name.
     * @param s event name.
     * @return product code.
     */
    private String getCategoriesNameSubstring(String s)
    {
        int i = s.indexOf("'");
        return s.substring(i);
    }

    /**
     * Show product information.
     * @param code event name.
     */
    public void showInformation(String code)  {
        String s = getCategoriesNameSubstring(code);
        ProductInformationController controller = (ProductInformationController)loader.<ProductInformationController>getController();
        controller.initialize(s);
    }
}
