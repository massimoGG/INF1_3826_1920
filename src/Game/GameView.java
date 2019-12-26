package Game;

import Game.Objects.Entity;
import Game.Objects.Bullet;
import Game.Objects.Enemy;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

public class GameView extends Region{

    private GameModel model;
    
    public GameView(GameModel model) {
        this.model = model;
    }
    
    // Render alle objected die op het scherm moeten verschijnen
    public void render() {
        getChildren().clear();
        
        for (Entity e : model.getEntities()) {
            if (e!=null) {
                if (e instanceof Bullet) {
                    Rectangle r = new Rectangle();
                    r.setX(e.getX()-3);
                    r.setY(e.getY()-3);
                    r.setWidth(6);
                    r.setHeight(6);
                    r.setFill(Color.RED);
                    getChildren().add(r);
                } else if (e instanceof Enemy) {
                    // Tegen overgestelde v/d player?
                    
                }
            }
        }
        
        Polyline pl = new Polyline();
        int playerThickness = 10;
        pl.getPoints().addAll(new Double[] {
            model.getPlayer().getX(), -playerThickness+model.getPlayer().getY(),
            -playerThickness+model.getPlayer().getX(), playerThickness+model.getPlayer().getY(),
            playerThickness+model.getPlayer().getX(), playerThickness+model.getPlayer().getY(),
        });
        pl.setFill(Color.RED);
        getChildren().add(pl);
    }
}
