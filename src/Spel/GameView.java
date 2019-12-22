package Spel;

import Spel.Objecten.Entity;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class GameView extends Region{
    
    // Wat we op het scherm zien
    private Entity[][] screen;
    
    private GameModel model;
    
    public GameView(GameModel model) {
        this.model = model;
    }
    
    // Render alle objected die op het scherm moeten verschijnen
    public void render() {
        getChildren().clear();
        
        for (int y=0;y<model.maxHeight;y++) {
            for (int x=0;x<model.maxWidth;x++) {
                // Now draw the individual entities
                Rectangle r = new Rectangle(x*model.tileSize,y*model.tileSize,model.tileSize,model.tileSize);
                if (screen[y][x] != null) r.setFill(screen[y][x].getTexture()); // Check what color
                getChildren().add(r);
            }
        }
        
        // Draw player at the center of the screen
        //Rectangle p = new Rectangle(,,model.textureSize,model.textureSize);
        Circle p = new Circle(model.player.getX()*model.tileSize, model.player.getY()*model.tileSize, model.tileSize);
        p.setFill(model.player.getTexture());
        getChildren().add(p);
        
    }
}
