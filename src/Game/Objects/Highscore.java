/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Objects;

/**
 *
 * @author michi
 */
public class Highscore {
    private int highscore1, highscore2, highscore3;
    
    /**
     * Het object wat de highscores bijhoud
     * @param highscore1 De hoogst gehaalde score
     * @param highscore2 De tweede hoogste score
     * @param highscore3 De derde hoogste score
     */
    public Highscore(int highscore1, int highscore2, int highscore3) {
        this.highscore1 = highscore1;
        this.highscore2 = highscore2;
        this.highscore3 = highscore3;
    }
    
    public void addHighscore(int newHighscore){
        if (newHighscore > highscore1){
            highscore3 = highscore2;
            highscore2 = highscore1;
            highscore1 = newHighscore;
        }
        else if (newHighscore > highscore2){
            highscore3 = highscore2;
            highscore2 = newHighscore;
        }
        else if (newHighscore > highscore3){
            highscore3 = newHighscore;
        }
    }

    public int getHighscore1() {
        return highscore1;
    }

    public int getHighscore2() {
        return highscore2;
    }

    public int getHighscore3() {
        return highscore3;
    }
    
    
    
    
}
