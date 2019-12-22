package Spel.Objecten;

import javafx.scene.paint.Color;

/**
 *
 * @author massi
 */
public class Grass extends Entity {
    public boolean walkable() {
        return true;
    }

    public Color getTexture() {
        return Color.GREEN;
    }
}
