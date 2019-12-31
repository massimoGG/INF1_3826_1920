/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Objects;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author michi
 */
public class BulletView extends Region{
    private Bullet b;
    public BulletView(Bullet b) {
        this.b = b;
    }
    
    public Rectangle getFig(){
        Rectangle r = new Rectangle(b.getX(),b.getY(),b.getBreedte(),b.getHoogte());
        r.setFill(Color.RED);
        return r;
    }
    
}
