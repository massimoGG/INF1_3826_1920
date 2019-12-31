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
public class EnemyView extends Region{
    private Enemy e;
    public EnemyView(Enemy e) {
        this.e = e;
    }
    
    public Polyline getFig(){
        Polyline pl = new Polyline();
        pl.getPoints().addAll(new Double[] {
            (e.getBreedte()/2)+e.getX(), e.getY(),
            e.getX(), e.getHoogte() + e.getY(),
            e.getBreedte() + e.getX(), e.getHoogte() + e.getY(),
        });
        pl.setFill(Color.RED);
        return pl;
    }
    
}
