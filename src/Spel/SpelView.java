/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spel;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author michi
 */
public class SpelView extends Region{
    private PersoonModel pModel;
    private VastVW vastVW;
    private Oorsprong oorsprong;
    
    

    public SpelView(PersoonModel pModel, VastVW vastVW, Oorsprong oorsprong) {
        this.pModel = pModel;
        this.vastVW = vastVW;
        this.oorsprong = oorsprong;
        
        update();
        
    }
    
    public void update(){
        getChildren().clear();
        Rectangle persoon1 = new Rectangle(395, 195, 10,10);
        
        
        Rectangle vorm = vastVW.vorm(oorsprong);
        vorm.setFill(Color.BLUE);
        
        
        
        getChildren().add(vorm);
        getChildren().add(persoon1);
    }
    
    
}
