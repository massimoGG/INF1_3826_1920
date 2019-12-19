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
public class PersoonModel {
    
    private int x,y;

    /**
     * Constructor die een persoon maakt met een vast X en Y coördinaat
     */
    public PersoonModel() {
        y = x = 100;
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    /**
     * Deze functie zorgt er voor dat de persoon omhoog kan gaan
     */
    public void omhoog(){
        y -=4;
    }
    
    /**
     * Deze functie zorgt er voor dat de persoon omlaag kan gaan
     */
    public void omlaag(){
        y +=4;
    }
    
    /**
     * Deze functie zorgt er voor dat de persoon naar rechts kan gaan
     */    
    public void rechts(){
        x+=4;
    }
    
    /**
     * Deze functie zorgt er voor dat de persoon naar links kan gaan
     */    
    public void links(){
        x-=4;
    }
    
    public void printAll(){
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
                
    }
    
}
