package Game;

import Game.Objects.Bullet;
import Game.Objects.BulletView;
import Game.Objects.Enemy;
import Game.Objects.EnemyView;
import Game.Objects.Entity;
import Game.Objects.Player;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.*;
// Core van het spel
// @author Massimo
public class GameModel {
    
    private Stage stage;
    private GameView view;
    private boolean isVanPlayer;
    private int test = 0;
    private int maxEntities = 100;
    private ArrayList<Entity> entities;
    private Collision col;
    public ArrayList<Entity> getEntities() {
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
        entities = new ArrayList<Entity>();
        Collision colli = new Collision(this);
        col = colli;
        
    }
    
    // Tick update for entities
    public void update() {
        
        if (player.getX()+player.getdx() > minX && player.getX()+player.getdx() < maxX) {
            player.setX(player.getX()+player.getdx());
        }
        for (Entity e : getEntities()) {
            if (e!=null) {
                if(e.getY() > stage.getHeight()+100){
                    entities.remove(e);
                }else{
                e.setY(e.getY()+e.getdy());
                e.setX(e.getX()+e.getdx());
                }
                
                if (col.isOverlappend(e)){
                    player.setLevens(player.getLevens()-1);
                    entities.remove(e);
                }   
            }
        }
        if (player.getLevens() == 0){
            player.setLevens(5);
            entities.clear();
        }
        
    }
    
    // Add bullets
    public void addBullet(double x, double y, boolean isVanPlayer) {
        Bullet e = new Bullet(x, y, isVanPlayer);
        
        
        entities.add(e);
        
    }
    
    // Add enemy
    public void addEnemy(double x, double breedte) {
        Enemy e = new Enemy(x, 20, breedte, 20);
        e.setdy(2);
        entities.add(e);
        
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
