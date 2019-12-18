/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wandelaar;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author michi
 */
public class WandelaarView extends Region {
    private WandelaarModel model;

    public WandelaarView(WandelaarModel model) {
        this.model = model;
        update();

    }
    
    public void update(){
        getChildren().clear();
        Rectangle wandelaar = new Rectangle(model.getX(), model.getY(), 10, 10);
        Rectangle wandelaar3 = new Rectangle(model.getX(), model.getY()+10, 2, 10);
        Rectangle wandelaar4 = new Rectangle(model.getX()+8, model.getY()+10, 2, 10);
        Circle wandelaar2 = new Circle(model.getX()+5, model.getY()-5, 5);
        Circle wandelaar7 = new Circle(model.getX()+3, model.getY()-7, 1);
        wandelaar7.setFill(Color.WHITE);
        Circle wandelaar8 = new Circle(model.getX()+7, model.getY()-7, 1);
        wandelaar8.setFill(Color.WHITE);
        
        Rectangle wandelaar5 = new Rectangle(model.getX()-10, model.getY()+1, 10, 2);
        Rectangle wandelaar6 = new Rectangle(model.getX()+10, model.getY()+1, 10, 2);
        wandelaar5.setRotate(180+30);
        wandelaar6.setRotate(0-30);
        getChildren().addAll(wandelaar);
        getChildren().addAll(wandelaar2);
        getChildren().addAll(wandelaar3);
        getChildren().addAll(wandelaar4);
        getChildren().addAll(wandelaar5);
        getChildren().addAll(wandelaar6);
        getChildren().addAll(wandelaar7);
        getChildren().addAll(wandelaar8);
        
    }
    
}
