package Game;

import Game.Objects.Bullet;
import Game.Objects.Enemy;
import Game.Objects.Entity;
import Game.Objects.Player;

public class Collision {
    private GameModel model;
    private double XminEntity, XmaxEntity,XminPlayer, XmaxPlayer;
    
    public Collision(GameModel model) {
        this.model = model;
    }
    
    // Kogel Kogel // Gebruik dy
    // speler kogel
    // kogel enemy
    public boolean isOverlappend() {
        for (Entity en : model.getEntities()) { // Advanced for loop
            if (en instanceof Bullet || en instanceof Enemy) {
                // Rekeneing houden met dikte objecten
                XminEntity = en.getX();
                XmaxEntity = en.getX() + en.getBreedte();
                XminPlayer = model.getPlayer().getBreedte();
                XmaxPlayer = model.getPlayer().getBreedte()+ model.getPlayer().getBreedte();
                
                if(XminPlayer < XminEntity && XmaxPlayer > XminEntity && en.getY() + en.getdy() == model.getPlayer().getY()){
                    System.out.println("collision");
                    return true;
                }
            }
        }
        return false;
    }
}
