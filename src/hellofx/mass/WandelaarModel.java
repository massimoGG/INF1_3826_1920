/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wandelaar;

/**
 *
 * @author Seppe
 */
public class WandelaarModel {
    
    private int x,y,dx,dy; 

    
    
    /**
     * constuctor van de wandelaar met vast x en y coordinaat
     */
    
    public WandelaarModel() {
        x = 100;
        y = 100;
    }
    
    /**
     * De functie zorgt ervoor dat het mannetje naar rechts kan gaan
     */
    public void rechts(){
        x++;
        dx++;
        dy=0;
    }
    
    /**
     * De functie zorgt ervoor dat het mannetje naar links kan gaan
     */    
    public void links(){
        x--;
        dx--;
        dy=0;
    }
    
    /**
     * De functie zorgt ervoor dat het mannetje naar onder kan gaan
     */  
    public void onder(){
        y++;
        dy++;
        dx=0;
      
    }
    
    /**
     * De functie zorgt ervoor dat het mannetje naar boven kan gaan
     */  
    public void boven(){
        y--;
        dy--;
        dx=0;
    }
    
    public void reset(){
        x=100;
        y=100;
        dx = 0;
        dy = 0;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void tick(){
        x = x + dx;
        y = y + dy;
                
    }
}
