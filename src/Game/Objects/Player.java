package Game.Objects;

public class Player extends Entity {
    
    double x,y;
    double dx,dy;
    
    public Player(double x, double y) {
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
    }
    
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    
    public double getdx() {
        return dx;
    }
    public double getdy() {
        return dy;
    }
    public void setdx(double dx) {
        this.dx = dx;
    }
    public void setdy(double dy) {
        this.dy = dy;
    }
}
