package Game;

import javafx.application.Platform;
import java.util.*;
import Game.Objects.*;

public class Core implements Runnable {

    GameModel model;
    GameView view;
    GameController controller;
    private long dtime = 20;
    private long totalTime = 0;
    private double random;
    public boolean upgradeOn;

    // Constructor
    public Core(GameModel model, GameView view, GameController controller) {
        this.model = model;
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void run() {
        int err = 0;
        while (true) {
            while (!controller.statusMenu) {
                try {
                    /**
                     * Wacht even voor geen 100% cpu
                     */
                    Thread.sleep(dtime);
                    totalTime = totalTime + dtime;

                    // Run dit in de JavaFX thread
                    Platform.runLater(() -> {
                        view.render();
                    });
                    if (model.isSaving()) {
                    } else {
                        model.update();

                        /**
                         * Random vijand toevoegen
                         */
                        if (totalTime % 1000 == 0) {
                            random = Math.random() * 20;
                            if (random < 10) {
                                random = 10;
                            }
                            model.addEnemy(Math.random() * 360, random);
                        }

                        /**
                         * Random upgrade toevoegen om de 10 seconden
                         */
                        if (totalTime % 10000 == 0) {
                            random = Math.random() * 20;
                            if (random < 10) {
                                random = 10;
                            }
                            model.addUpgrade(Math.random() * 380, random);
                            /*if(upgradeOn = true){
                        model.setUpgradeOn();
                    }*/
                        }

                        /**
                         * Automatisch schieten voor de speler
                         */
                        if (totalTime % 500 == 0) {
                            model.addBullets(totalTime);
                        }

                    }
                } catch (Exception e) {
                    /*   err++;
                System.out.println("ERROR : run() : "+e.getMessage());
                if (err > 100){
                    System.out.println("ERROR: run() : Too many errors! :(");
                    return;
                }*/
                }
            }
            try {
                Thread.sleep(dtime);
            } catch (Exception e) {
            }
        }
    }
}
