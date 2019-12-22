package Spel;

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
    
    private int x;
    private int y;
    
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
