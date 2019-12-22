/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spel;

/**
 *
 * @author michi
 */
public class Oorsprong {
    private int x,y,x0,y0;
    public Oorsprong(int x, int y) {
        this.x0=x;
        this.y0=y;
        this.x = x;
        this.y = y;
                
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public void omhoog(){
        y-=4;
    }
    public void omlaag(){
        y+=4;
                
    }
    public void rechts(){
        x+=4;
    }
    public void links(){
        x-=4;
    }
            
    public void reset(){
        x=x0;
        y=y0;
    }
    
    
}
