package Spel.Objecten;

import javafx.scene.paint.Color;

/**
 *
 * @author massi
 */
public class Wall extends Entity {
    public boolean walkable() {
        return false;
    }

    public Color getTexture() {
        return Color.LIGHTGRAY;
    }
}
