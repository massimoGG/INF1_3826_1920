package Game;

import Game.Objects.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.*;
// Core van het spel
// @author Massimo
public class GameModel {
    
    private Stage stage;
    private GameView view;

    private ArrayList<Entity> entities;
    private Collision col;
    
    public ArrayList<Entity> getEntities() {
        return entities;
    }
    
    // Onze speler
    public int score = 0;
    private static Player player;
    public Player getPlayer() {return player;}
    
    // Afmetingen van het scherm
    public double minX = 0;
    public double maxX;

    // Constructor
    public GameModel() {        
        // Maak een nieuwe speler aan
        player = new Player(50,50);
        // Al uw objecten
        entities = new ArrayList<Entity>();
        col = new Collision(this); 
    }
    
    // Tick update for entities
    public void update() {
        
        if (player.getX()+player.getdx() > minX && player.getX()+player.getdx() < maxX) 
        {
            player.setX(player.getX()+player.getdx());
        }
        // Doorloop alles om het te updaten
        for (Entity e : getEntities()) {
            if (e!=null) {
                // Hou de vijanden binnen het scherm?
                if(e.getY() > stage.getHeight()-e.getHoogte()-50 || e.getY()<0){
                    if(e instanceof Enemy){
                        score = score-1;
                    }
                    entities.remove(e);
                    continue;
                }else{
                    // UPdate positie van entitie
                    e.setY(e.getY()+e.getdy());
                    e.setX(e.getX()+e.getdx());
                }
                
                // Controlleert of we met iets botsen
                if (col.isKillshot()){
                    // Als dit een vijand/kogel is met de speler
                    if( e instanceof Player){
                        // Speler verliest een leven + we verwijderen de entitie
                        player.setLevens(player.getLevens()-1);
                    } else {
                        // Speler zijn kogel tegen een andere vijand
                        score = score +1;
                    }
                    // We verwijderen de entitie
                    //entities.remove(e);
                }
            }
        }
        if (player.getLevens() <= 0){
            System.out.println("Oei mnsieur. Tu es mort!");
            player.setLevens(5);
            entities.clear();
        }
    }
    
    // Add bullets
    public void addBullets(long totalTime) {
        ArrayList<Entity>bullets  = new ArrayList<Entity>();
        Bullet p = new Bullet(player.getX()+player.getBreedte()/2, player.getY(), true);
        entities.add(p);
        for (Entity en : entities){
            if (en instanceof Enemy && totalTime % 1500 ==0){
                Bullet be = new Bullet(en.getX()+en.getBreedte()/2, en.getY(), false);
                
                bullets.add(be);
                
            }
        } 
        entities.addAll(bullets);
    }
    
    // Add enemy
    public void addEnemy(double x, double breedte) {
        Enemy e = new Enemy(x, 20, breedte, 20);
        e.setdy(2);
        entities.add(e);
    }
    /**
     * adds upgrade
     * @param e 
     */
    public void addUpgrade(double x, double breedte) {
        Upgrade u = new Upgrade(x, 20, breedte, 20);
        u.setdy(3);
        entities.add(u);
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
    public int getScore(){
        return score;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        player.setY(stage.getHeight()-150);
        
    }

    
}
