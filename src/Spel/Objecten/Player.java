package Spel.Objecten;

import javafx.scene.paint.Color;

/**
 *
 * @author massi
 */
public class Player extends Entity {
    
    public boolean walkable() {
        return true;
    }

    public Color getTexture() {
        return Color.BLUE;
    }
    
    // Positie van de speler (in grids) op de volledige map
    private int x;
    private int y;
    
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
