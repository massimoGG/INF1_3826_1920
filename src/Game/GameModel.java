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

    public GameModel() {        
        // Maak een nieuwe speler aan
        player = new Player(50,50);
        entities = new Entity[maxEntities];
        
    }
    
    // Tick update for entities
    public void update() {
        if (player.getX()+player.getdx() > minX && player.getX()+player.getdx() < maxX) {
            player.setX(player.getX()+player.getdx());
        }
        for (Entity e : entities) {
            // Bullets can only go upwards or downwards. Not sideways. So no e.setX()
            if (e!=null) e.setY(e.getY()+e.getdy());
        }
        rearrangeArray();
    }
    
    public int getAmount() {
        int t=0;
        for (int i=0;i< entities.length; i++) {
            if (entities[i]!=null) t++;
        }
        return t;
    }
    
    // alle "dode" kogels verwijderen
    private void rearrangeArray() {
        for (int i=0;i<entities.length; i++) {
            if (entities[i] !=null && entities[i].getY()<-100) {
                // Off screen -> Remove it from the array
                for (int j=i; j<entities.length-1;j++) {
                    entities[j] = entities[j+1];
                }
                // Or just
                //entities[i]=null;
            }
        }
    }
    
    // Add bullets
    public boolean addBullet() {
        Bullet b = new Bullet(player.getX(),player.getY());
        
        for (int i=0;i<entities.length; i++) {
            if (entities[i]==null) {
                entities[i]=b;
                return true;
            }
        }
        return false;
    }
    
    // Add enemy
    public void addEnemy() {
        
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
            }
        } catch (Exception a) {}
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        player.setY(stage.getHeight()-150);
    }
}
