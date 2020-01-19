package Game;

import Game.Objects.*;
import java.util.Iterator;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

public class GameView extends Region {

    private GameModel model;
    private PlayerView pView;
    private BulletView bView;
    private EnemyView eView;
    private UpgradeView uView;
    private Iterator<Entity> lijst;
    private Entity e;
    private GameController controller;

    /**
     *constructor voor de view
     * @param model
     * @param controller
     */
    public GameView(GameModel model, GameController controller) {
        this.model = model;
        this.controller = controller;

    }

    // Render alle objected die op het scherm moeten verschijnen

    /**
     *renderd de view
     */
    public void render() {
        try {
            controller.setTekstScore("Score: " + model.getScore());
            controller.setTekstLevens("Levens: " + model.getPlayer().getLevens());
            updateHighscore();

            getChildren().clear();
            lijst = model.getEntities();
            while (lijst.hasNext()) {
                e = lijst.next();
                if (e instanceof Bullet) {
                    Bullet p = (Bullet) e;
                    BulletView bView = new BulletView(p);
                    getChildren().add(bView);
                } else if (e instanceof Enemy) {
                    Enemy p = (Enemy) e;
                    EnemyView eView = new EnemyView(p);
                    getChildren().add(eView);
                } else if (e instanceof Upgrade) {
                    Upgrade p = (Upgrade) e;
                    UpgradeView uView = new UpgradeView(p);
                    getChildren().add(uView);
                }
            }

            // Speler tekenen
            PlayerView pView = new PlayerView(model.getPlayer());
            getChildren().add(pView);

            // p = rectangle ofzo
        } catch (Exception e) {

        }
    }

    /**
     *updates highscore
     */
    public void updateHighscore() {
        Highscore highscore = model.getHighscore();
        controller.setTekstHighscore1("Highscore 1:" + highscore.getHighscore1());
        controller.setTekstHighscore2("Highscore 2:" + highscore.getHighscore2());
        controller.setTekstHighscore3("Highscore 3:" + highscore.getHighscore3());
    }

}
