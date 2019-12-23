package Game;

import Game.Objects.Entity;
import Game.Objects.Player;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class GameView extends Region{

    private GameModel model;
    
    public GameView(GameModel model) {
        this.model = model;
    }
    
    // Render alle objected die op het scherm moeten verschijnen
    public void render() {
        getChildren().clear();

//        getChildren().add(p); // p = rectangle ofzo
        
    }
}
