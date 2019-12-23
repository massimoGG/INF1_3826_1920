package Game;

import Game.Objects.Entity;
import Game.Objects.Player;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// Core van het spel
// @author Massimo
public class GameModel {
    
    private Stage stage;
    private GameView view;
    
    // De volledige map
    public Entity[][] map;
    // Onze speler
    public Player player;
    
    // Afmetingen van het scherm
    public int maxHeight, maxWidth;
    // Afmetingen van de map
    public int mapMaxHeight=50, mapMaxWidth=50;
    public int tileSize = 16;
    
    public void GameModel() {
        // Maak een nieuwe speler aan
        player = new Player(1,1);
    }
    
    // Tick update for entities
    public void update() {
        
    }
    
    public void move(KeyEvent e) {
        try {
            switch (e.getCode()) {
                case LEFT:
                case A:

                    break;
                case UP:
                case W:

                    break;
                case RIGHT:
                case D:

                    break;
                case DOWN:
                case S:

                    break;
                case ESCAPE:
                    // Escape -> Close game
                    stage.close();
                    break;
            }
        } catch (Exception a) {}
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
