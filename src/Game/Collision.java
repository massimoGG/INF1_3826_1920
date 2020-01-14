package Game;

import Game.Objects.*;
import java.util.ArrayList;

/**
 * Via deze classe is het mogelijk om te bepalen als er objecten overlappen.
 * We hebben er voor gekozen om dit in een apparte classe te steken omdat dit een moeilijk stuk code is.
 * @author michi
 */

public class Collision {

    private GameModel model;
    private ArrayList<Entity> lijst;
    public boolean UpgradeOn;
    public Collision(GameModel model) {
        this.model = model;
    }

    /**
     * Deze functie kijkt na als er 2 entities zijn die overlappen met elkaar.
     * Indien deze overlappen word er gekeken afhangkelijk van de Entity wat er
     * moet gebeuren.
     */
    public void isOverlappend() {
        lijst = model.getEntities();
        for (Entity e : lijst) {
            for (Entity e2 : lijst) {
                if (!(e2 instanceof Player)) {
                    if (!(e.equals(e2))) {
                        /* 
                        Deze eerste if statement controleert als er collisie zou kunnen zijn volgens de Y richting.
                         */
                        if ((e.getMaxY() >= e2.getY() && e.getMaxY() <= e2.getMaxY()) || (e.getY() >= e2.getY() && e.getY() <= e2.getMaxY()) || (e2.getMaxY() >= e.getY() && e2.getMaxY() <= e.getMaxY()) || (e2.getY() >= e.getY() && e2.getY() <= e.getMaxY())) {
                            /* 
                            Deze twee if statement controleert als er collisie zou kunnen zijn volgens de X richting.
                             */
                            if ((e.getMaxX() >= e2.getX() && e.getMaxX() <= e2.getMaxX()) || (e.getX() >= e2.getX() && e.getX() <= e2.getMaxX()) || (e2.getMaxX() >= e.getX() && e2.getMaxX() <= e.getMaxX()) || (e2.getX() >= e.getX() && e2.getX() <= e.getMaxX())) {
                                /*
                                Als de eerste Entity de Player is mag hij deze niet verwijderen maar wel een leven afnemen.
                                 */
                                if (e instanceof Player) {
                                    if (e2 instanceof Upgrade) {
                                        UpgradeOn = true;
                                        
                                    } 
                                    else {
                                        model.setLevens(model.getLevens() - 1);
                                        System.out.println("neer geschoten");
                                    }
                                    model.removeEntity(e2);
                                } 
                                else {
                                    if (!(e instanceof Upgrade || e2 instanceof Upgrade)) {
                                        model.removeEntity(e);
                                        model.removeEntity(e2);
                                        model.setScore(model.getScore() + 5);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
