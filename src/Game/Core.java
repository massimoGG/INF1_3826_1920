package Game;
import javafx.application.Platform;

public class Core implements Runnable {
    GameModel model;
    GameView view;
    GameController controller;
    
    public Core(GameModel model, GameView view,GameController controller) {
        this.model = model;
        this.view = view;
        this.controller = controller;
    }
    
    @Override
    public void run() {
        int err = 0;
        while (true) {
            try {
                // Run dit in de JavaFX thread
                Platform.runLater(() -> {
                    view.render();
                    controller.lblScore.setText(""+model.getPlayer().getX());
                 });
                 model.update(); 
                 Thread.sleep(20);
                // Spawn a new enemy
            }catch(Exception e) {
                err++;
                System.out.println("ERROR : run() : "+e.getMessage());
                if (err > 100){
                    System.out.println("ERROR: run() : Too many errors! :(");
                    return;
                }
            }
        }
    }
}
