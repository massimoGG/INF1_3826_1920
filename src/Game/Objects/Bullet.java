package Game.Objects;

public class Bullet extends Entity {
    private boolean isVanPlayer;
    /**
     * Constructor voor een bullet, deze neemt alles van een Entity over
     * @param x De x positie van de Bullet
     * @param y De y positie van de Bullet
     */
    public Bullet(double x, double y, boolean isVanPlayer) {
        super(x,y,2,2);
        //this.isVanPlayer = isVanPlayer;
        this.isVanPlayer = true;
        if (isVanPlayer){
            // Nr boven
            super.setdy(-2);
            super.setY(y-5);
        }else{
            // Nr beneden
            super.setdy(3);  
            super.setY(y+5);
        }
    }
    
    public boolean isVanPlayer(){
        return isVanPlayer;
    }
}
