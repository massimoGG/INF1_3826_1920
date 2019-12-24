package Game;

import Game.Objects.Bullet;
import Game.Objects.Enemy;
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
    
    private int maxEntities = 100;
    private Entity[] entities;
    public Entity[] getEntities() {
        return entities;
    }
    
    // Onze speler
    private static Player player;
    public Player getPlayer() {return player;}
    
    // Afmetingen van het scherm
    public double minX = 0,maxX;

    // Constructor
    public GameModel() {        
        // Maak een nieuwe speler aan
        player = new Player(50,50);
        // Al uw objecten
        entities = new Entity[maxEntities];
    }
    
    // Tick update for entities
    public void update() {
        if (player.getX()+player.getdx() > minX && player.getX()+player.getdx() < maxX) {
            player.setX(player.getX()+player.getdx());
        }
    }
    
    // Add bullets
    public void addEntity() {
        
    }
    
    // Add enemy
    public void addEnemy() {
        
    }
    
    public void move(KeyEvent e) {
        try {
            switch (e.getCode()) {
                case LEFT:
                case A:
                case Q: // Azerty
                    player.setdx(-5);
                    break;
                case RIGHT:
                case D:
                    player.setdx(5);
                    break;
                case ESCAPE:
                    // Escape -> Close game
                    stage.close();
                    break;
            }
        } catch (Exception a) {}
    }
    
    public void demove(KeyEvent e) {
        try {
            switch (e.getCode()) {
                case LEFT:
                case A:
                case Q:
                case RIGHT:
                case D:
                    player.setdx(0);
                    break;
            }
        } catch (Exception a) {}
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        player.setY(stage.getHeight()-150);
    }
}
