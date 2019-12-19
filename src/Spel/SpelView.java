/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spel;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author michi
 */
public class SpelView extends Region{
    private PersoonModel pModel;

    public SpelView(PersoonModel pModel) {
        this.pModel = pModel;
        update();
        
    }
    
    public void update(){
        getChildren().clear();
        Rectangle persoon1 = new Rectangle(pModel.getX(), pModel.getY(), 10,10);
        
        getChildren().add(persoon1);
    }
    
    
}
