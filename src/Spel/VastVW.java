/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spel;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author michi
 */
public class VastVW {
/**
 * Dit is de classe waarin iedere vast voorwerp staat.
 * @param x de linker boven coördinaat volgens de x-as
 * @param y de linker boven coördinaat volgens de y-as
 * @param dx is de breedte van een voorwerp
 * @param dy is de lengte van een voorwerp
 */
    private int x,y,dx,dy;
    public VastVW(int x,int y,int dx,int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
               
               
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
    
    public Rectangle vorm(){
        return new Rectangle(x,y,dx,dy);
    }

    
    
    
}
