package Game.Objects;

/**
 * specs van de enemy
 * @author royve
 */
public class Enemy extends Entity {
    private boolean isEnemy = true;
    public Enemy(double x, double y, double breedte, double hoogte) {
        super(x,y, breedte, hoogte);
    }

}
