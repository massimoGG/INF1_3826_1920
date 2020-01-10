package Game;

import Game.Objects.*;
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
    private UpgradeView uView;
    
    public GameView(GameModel model) {
        this.model = model;
    }
    
    // Render alle objected die op het scherm moeten verschijnen
    public void render() {
        getChildren().clear();
        
        if (model.getEntities().isEmpty()) {
            return;
        }
        for (Entity e : model.getEntities()) {
            if (e!=null) {
                if (e instanceof Bullet) {
                    Bullet p = (Bullet) e;
                    BulletView bView = new BulletView(p);
                    getChildren().add(bView);
                } 
                else if (e instanceof Enemy) {
                    Enemy p = (Enemy) e;
                    EnemyView eView = new EnemyView(p);
                    getChildren().add(eView);
                }
                else if (e instanceof Upgrade) {
                    Upgrade p  = (Upgrade) e;
                    UpgradeView uView = new UpgradeView(p);
                    getChildren().add(uView); 
                }
            }
        }
        
        // Speler tekenen
        PlayerView pView = new PlayerView(model.getPlayer());
        getChildren().add(pView);
       
         // p = rectangle ofzo
         
        
    }
    
}
