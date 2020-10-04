package testapp.controllers.buttons;
import  javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

/**
 * Create buttons in GridPane.
 */
public class ButtonsCreator {
    private int buttonsRows = 0;
    private int buttonsColumns = 0;
    private int numberOfDisplayingButtons;
    private int buttonsCount;
    private List<Button> buttonList = new ArrayList<>();
    public void setButtonsCount(int buttonsCount){
        this.buttonsCount = buttonsCount;
    }

    /**
     * Fill GridPane with buttons.
     * @param buttonsNames Array with buttons names.
     * @param e EventHandler
     */
    public void create(List<String> buttonsNames, EventHandler<ActionEvent> e){
        setNumberOfRowsAndColumns(buttonsCount);
        for(int i = 0;i<buttonsCount;i++){
            Button btn = new Button(buttonsNames.get(i));
            btn.setOnAction(e);
            buttonList.add(btn);
        }
    }

    /**
     * Display 9 buttons in GridPane.
     * @param gridPane GridPane object.
     * @param page - variable for displaying part of buttons.
     */
    private void displayAllButtons(GridPane gridPane,int page){
        int iterator = 0;
        for(int i = 0;i<buttonsColumns;i++) {
            for (int j = 0; j < buttonsRows; j++) {
                if (page + iterator < buttonsCount) {
                    gridPane.add(buttonList.get(page + iterator), i, j);
                }
                iterator++;
            }
        }
    }

    /**
     * Display buttons in one line.
     * @param gridPane - GridPane object.
     */
    private void displayButtons(GridPane gridPane){
        for (int i = 0;i<buttonsCount;i++){
            gridPane.add(buttonList.get(i), i, 0);
        }
    }

    /**
     * Display buttons.
     * @param gridPane gridPane object.
     * @param page - riable for displaying part of buttons.
     */
    public void display(GridPane gridPane,int page){
        gridPane.getChildren().clear();
        if(buttonsCount < Math.round(Math.sqrt(numberOfDisplayingButtons)))
        {
            displayButtons(gridPane);
        }
        else
        {
            displayAllButtons(gridPane,page);
        }
    }

    public void setNumberOfDisplayingButtons(int numberOfDisplayingButtons) {
        this.numberOfDisplayingButtons = numberOfDisplayingButtons;
    }
    private void setNumberOfRowsAndColumns(int buttonsCount){
        /**
         *  i - used for calculating rows and columns.
         *  buttonsCount = number of field from database.
         *  numberOfDisplaying - value for count displaying button in GridPane.
         *  if  get value  from database  less than numberOfDisplayingButtons , we calculate rows and columns
         *  using variable i,else we just set i at buttonsColumns and buttonsRows variables.
         */
        int i =(int)Math.round(Math.sqrt(numberOfDisplayingButtons));
        if(buttonsCount < numberOfDisplayingButtons){
            while(buttonsCount >= i){
                buttonsCount -=i;
                buttonsRows++;
                buttonsColumns  = buttonsCount;
            }
        }
        else {
            buttonsColumns = i;
            buttonsRows = i;
        }

    }

}
