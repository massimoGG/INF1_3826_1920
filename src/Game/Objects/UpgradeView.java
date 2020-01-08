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
 * @author royve
 */
public class UpgradeView extends Region{
    private Upgrade u;
    public UpgradeView(Upgrade u) {
        this.u = u;
        Polyline pl = new Polyline();
        pl.getPoints().addAll(new Double[] {
            (u.getBreedte()/2)+u.getX(), u.getHoogte()+ u.getY(),
            u.getX(),   u.getY(),
            u.getBreedte() + u.getX(),  u.getY(),
        });
        pl.setFill(Color.GREEN);
        getChildren().add(pl);
    }
    
    
}
