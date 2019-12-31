package Game;

import Game.Objects.Entity;
import Game.Objects.Bullet;
import Game.Objects.Enemy;
import Game.Objects.PlayerView;
import Game.Objects.BulletView;
import Game.Objects.EnemyView;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

public class GameView extends Region{
    

    private GameModel model;
    private PlayerView pView;
    private BulletView bView;
    private EnemyView eView;
    
    public GameView(GameModel model) {
        this.model = model;
    }
    
    // Render alle objected die op het scherm moeten verschijnen
    public void render() {
        getChildren().clear();
        
        for (Entity e : model.getEntities()) {
            if (e!=null) {
                if (e instanceof Bullet) {
                    Bullet p = (Bullet) e;
                    BulletView bView = new BulletView(p);
                    getChildren().add(bView);
                } else if (e instanceof Enemy) {
                    Enemy p = (Enemy) e;
                    EnemyView eView = new EnemyView(p);
                    getChildren().add(eView);
                    
                }
            }
        }
        
        // Speler tekenen
        PlayerView pView = new PlayerView(model.getPlayer());
        getChildren().add(pView);
       
         // p = rectangle ofzo
         
        
    }
    
}
