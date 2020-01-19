package Game.Objects;

/**
 * abstracte klasse entity
 * @author royve
 */
abstract public class Entity {
    double x,y;
    double dx,dy;
    double breedte, hoogte;
    
    /**
     *afmetingen en positie entity
     * @param x
     * @param y
     * @param breedte
     * @param hoogte
     */
    public Entity(double x, double y, double breedte, double hoogte) {
        this.x = x; 
        this.y = y;
        this.dx = 0;
        this.dy=0;
        this.breedte = breedte;
        this.hoogte = hoogte;
                
    }
    
    /**
     * getter x positie
     * @return x positie
     */
    public double getX() {
        return x;
    }

    /**
     *getter y positie
     * @return y positie
     */
    public double getY() {
        return y;
    }

    /**
     *setter x positie
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * setter y positie
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * getter x snelheid
     * @return x snelheid
     */
    public double getdx() {
        return dx;
    }

    /**
     *getter y snelheid
     * @return ysnelheid
     */
    public double getdy() {
        return dy;
    }

    /**
     * setter x snelheid
     * @param dx
     */
    public void setdx(double dx) {
        this.dx = dx;
    }

    /**
     *setter y snelheid
     * @param dy
     */
    public void setdy(double dy) {
        this.dy = dy;
    }

    /**
     *getter breedte object
     * @return breedte
     */
    public double getBreedte() {
        return breedte;
    }

    /**
     *getter hoogte object
     * @return hoogte
     */
    public double getHoogte() {
        return hoogte;
    }
    
    /**
     * get maximum x positie
     * @return x + breedte
     */
    public double getMaxX(){
        return x + breedte;
    }
    
    /**
     * get maximum y positie
     * @return y+ hoogte
     */
    public double getMaxY(){
        return y + hoogte;
    }
    
}
