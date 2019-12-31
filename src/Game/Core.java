package Game;
import javafx.application.Platform;

public class Core implements Runnable {
    GameModel model;
    GameView view;
    GameController controller;
    private long dtime = 20;
    private long totalTime = 0;
    
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
            try {
                // Run dit in de JavaFX thread
                Platform.runLater(() -> {
                    view.render();
                    
                    controller.lblScore.setText(""+model.getEntities().size());
                 });
                 model.update(); 
                 
                 
                // totale_tijd % 500 == 0 -> kogel schieten
                // Spawn a new enemy
                // Algorithme voor random positie
                
                if (totalTime % 1000 ==0){ 
                    model.addEnemy(20,20);
                    // Plaats een random enemy
                    
                }
                
                Thread.sleep(dtime); 
                totalTime = totalTime + dtime;
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
