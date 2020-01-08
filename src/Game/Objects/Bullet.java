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
        this.isVanPlayer = isVanPlayer;
        
        if (isVanPlayer){
            super.setdy(-2);
            super.setY(y-5);
        }else{
            super.setY(y+5);
            super.setdy(3);
            
            
        }
    }
    
    public boolean isVanPlayer(){
        return isVanPlayer;
    }
}
