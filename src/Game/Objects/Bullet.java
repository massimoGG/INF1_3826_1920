package Game.Objects;

public class Bullet extends Entity {
    /**
     * Constructor voor een bullet, deze neemt alles van een Entity over
     * @param x De x positie van de Bullet
     * @param y De y positie van de Bullet
     */
    public Bullet(double x, double y) {
        super(x,y,2,2);
    }
}
