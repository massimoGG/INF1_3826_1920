package Game.Objects;

public class Bullet extends Entity {
    public Bullet(double x, double y) {
        super(x,y);
        this.dy = -15;
    }
}
