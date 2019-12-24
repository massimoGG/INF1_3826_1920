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
    private Entity[][] entities;
    // Onze speler
    private static Player player;
    public Player getPlayer() {return player;}
    
    // Afmetingen van het scherm
    public double minX = 10,maxX;

    public GameModel() {        
        // Maak een nieuwe speler aan
        player = new Player(50,200);
    }
    
    // Tick update for entities
    public void update() {
        if (player.getX()+player.getdx() > minX && player.getX()+player.getdx() < maxX) {
            player.setX(player.getX()+player.getdx());
        }
    }
    
    public void addEntity() {
        
    }
    
    public void move(KeyEvent e) {
        try {
            switch (e.getCode()) {
                case LEFT:
                case A:
                    player.setdx(-5);
                    break;
                case RIGHT:
                case D:
                    player.setdx(5);
                    break;
                case SPACE:
                    // SHOOT!
                    // Addentity
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
                case RIGHT:
                case D:
                    player.setdx(0);
                    break;
                case SPACE:
                    break;
            }
        } catch (Exception a) {}
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
