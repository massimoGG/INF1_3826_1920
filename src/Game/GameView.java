package Game;

import Game.Objects.Entity;
import Game.Objects.Player;
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
            
        }
        
        Polyline pl = new Polyline();
        pl.getPoints().addAll(new Double[] {
            10+model.getPlayer().getX(), model.getPlayer().getY(),
            0+model.getPlayer().getX(), 20+model.getPlayer().getY(),
            20+model.getPlayer().getX(), 20+model.getPlayer().getY(),
        });
        pl.setFill(Color.RED);
        getChildren().add(pl); // p = rectangle ofzo
        
    }
}
