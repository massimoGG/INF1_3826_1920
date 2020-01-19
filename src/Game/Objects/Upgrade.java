/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Objects;

/**
 *klasse upgrade
 * @author royve
 */
public class Upgrade extends Entity{
    private boolean isUpgrade = true;

    /**
     *looks upgrade
     * @param x
     * @param y
     * @param breedte
     * @param hoogte
     */
    public Upgrade(double x, double y, double breedte, double hoogte) {
        super(x,y, breedte, hoogte);
    }
}
