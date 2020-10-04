package testapp.controllers.modal;

import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 * Static class generating random weight.
 */
public class RandomWeight {
    private static boolean isRunning = true;
    private static long w = 0;

    /**
     * Start generating weight.
     * @param weight Label for displaying weight.
     */
    public static void start(Label weight){
            isRunning = true;
            Thread t = new Thread(()->{
            while (isRunning){
                try {
                    Platform.runLater(()->{
                        w = Math.round(Math.random()*30);
                        weight.setText(w+" kg");
                    });
                    Thread.sleep(300);
                }
                catch (Exception e){}
            }
        });
        //start new thread
        t.start();
    }

    /**
     * Stop thread and generating weight
     * @return generated weight.
     */
    public static long stop(){
        isRunning = false;
        return w;
    }



}
