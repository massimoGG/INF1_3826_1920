package Game;

import Game.Objects.Bullet;
import Game.Objects.Enemy;
import Game.Objects.Entity;
import Game.Objects.Player;

public class Collision {
    private GameModel model;
    
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
                if (en.getX() == model.getPlayer().getX() && en.getY() == model.getPlayer().getY()) {
                    // Dood! OF een hartje minder
                    
                }
            }
        }
        return false;
    }
}
