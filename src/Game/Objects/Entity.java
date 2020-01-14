package Game.Objects;

abstract public class Entity {
    double x,y;
    double dx,dy;
    double breedte, hoogte;
    
    public Entity(double x, double y, double breedte, double hoogte) {
        this.x = x; 
        this.y = y;
        this.dx = 0;
        this.dy=0;
        this.breedte = breedte;
        this.hoogte = hoogte;
                
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

    public double getBreedte() {
        return breedte;
    }

    public double getHoogte() {
        return hoogte;
    }
    
    public double getMaxX(){
        return x + breedte;
    }
    
    public double getMaxY(){
        return y + hoogte;
    }
    
}
