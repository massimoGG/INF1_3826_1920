package Game.Objects;

/**
 * klasse player
 * @author royve
 */
public class Player extends Entity {
    private int levens, score = 0;
    public Player(double x, double y) {
        super(x, y, 20, 20);
        levens = 5;
    }

    /**
     *getter voor levens
     * @return levens
     */
    public int getLevens() {
        return levens;
    }

    /**
     *setter voor levens
     * @param levens
     */
    public void setLevens(int levens) {
        this.levens = levens;
    }
    
    /**
     *getter score
     * @return score
     */
    public int getScore(){
        return score;
    }
    
    /**
     *setter score
     * @param score
     */
    public void setScore(int score){
        this.score = score;
    }
    
}
