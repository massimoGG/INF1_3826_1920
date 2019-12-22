package Spel;

import Spel.Objecten.Entity;
import Spel.Objecten.Player;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// Core van het spel
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
    
    public void move(KeyEvent e) {
        try {
            switch (e.getCode()) {
                case LEFT:
                case A:
                    // Check if we can move to the left
                    if (map[player.getY()][player.getX()-1].walkable()) {
                        // Move the player if we can
                        player.setX(player.getX()-1);
                    }
                    break;
                case UP:
                case W:
                    if (map[player.getY()-1][player.getX()].walkable()) {
                        player.setY(player.getY()-1);
                    }
                    break;
                case RIGHT:
                case D:
                    if (map[player.getY()][player.getX()+1].walkable()) {
                        player.setX(player.getX()+1);
                    }
                    break;
                case DOWN:
                case S:
                    if (map[player.getY()+1][player.getX()].walkable()) {
                        player.setY(player.getY()+1);
                    }
                    break;
                case ESCAPE:
                    // Escape -> Close game
                    stage.close();
                    break;
            }
        } catch (Exception a) {}
    }
    
    public void reload(AnchorPane a) {
        maxWidth = (int)a.getWidth()/tileSize;
        maxHeight = (int)a.getHeight()/tileSize;
    } 
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
}
