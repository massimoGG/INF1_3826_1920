/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wandelaar;

import java.util.TimerTask;
import javafx.application.Platform;

/**
 *
 * @author michi
 */
public class WandelaarBot extends TimerTask{
    private WandelaarModel model;
    private WandelaarController controller;

    public WandelaarBot(WandelaarModel model, WandelaarController controller) {
        this.model = model;
        this.controller = controller;
             
        
    }
    
    public void run(){
        model.tick();
        Platform.runLater(() -> controller.update());
        
    }
    
    
}
