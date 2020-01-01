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
public class PlayerView extends Region{
    private Player p;
    public PlayerView(Player p) {
        this.p = p;
        Polyline pl = new Polyline();
        pl.getPoints().addAll(new Double[] {
            (p.getBreedte()/2)+p.getX(), p.getY(),
            p.getX(), p.getHoogte() + p.getY(),
            p.getBreedte() + p.getX(), p.getHoogte() + p.getY(),
        });
        pl.setFill(Color.RED);
        getChildren().add(pl);
    }
        
}
