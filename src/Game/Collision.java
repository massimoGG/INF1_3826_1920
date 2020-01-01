package Game;

import Game.Objects.Bullet;
import Game.Objects.Enemy;
import Game.Objects.Entity;
import Game.Objects.Player;

public class Collision {
    private GameModel model;
    private double XminEntity, XmaxEntity,XminPlayer, XmaxPlayer;
    private Entity e;
    private Player p;
    
    public Collision(GameModel model) {
        this.model = model;
        p = model.getPlayer();
    }
    
    // Kogel Kogel // Gebruik dy
    // speler kogel
    // kogel enemy
    public boolean isOverlappend(Entity e) {
        this.e = e;
        XminPlayer = p.getX();
        XmaxPlayer = p.getBreedte() + p.getX();
        XminEntity = e.getX();
        XmaxEntity = e.getBreedte() + e.getX();
        if(e.getY()+e.getHoogte() >= p.getY() && e.getY()<= p.getY()+p.getHoogte()){
            if(XminEntity >= XminPlayer && XminEntity <= XmaxPlayer){
                return true;
            }else if(XmaxEntity >= XminPlayer && XmaxEntity <= XmaxPlayer){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
