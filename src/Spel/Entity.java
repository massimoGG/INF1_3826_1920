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
abstract public class Entity {
    abstract public boolean walkable();
    abstract public Color getTexture();
}
