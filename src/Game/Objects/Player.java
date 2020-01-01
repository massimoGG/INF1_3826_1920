package Game.Objects;

public class Player extends Entity {
    private int levens;
    public Player(double x, double y) {
        super(x, y, 20, 20);
        levens = 5;
    }

    public int getLevens() {
        return levens;
    }

    public void setLevens(int levens) {
        this.levens = levens;
    }
    
}
