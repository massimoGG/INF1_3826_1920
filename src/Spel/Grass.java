/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spel;

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
