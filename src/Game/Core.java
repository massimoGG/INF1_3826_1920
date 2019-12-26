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
<<<<<<< Updated upstream
                    controller.lblScore.setText(""+model.getPlayer().getX());
                 });
                 model.update(); 
                 Thread.sleep(20);
                // Spawn a new enemy
=======
                    controller.lblScore.setText(""+ model.getAmount());
                 });
                // Bereken de volgende posities van alle objecten
                 model.update();
                // totale_tijd % 500 == 0 -> kogel schieten
                if (totalTime % 200 == 0) {
                    // 500ms -> 0.5 s
                    model.addBullet();
                }
                // Spawn a new enemy
                // Algorithme voor random positie
                
                if (totalTime % 1000 ==0){ 
                    // Plaats een random enemy
                    
                }
                
                // Wacht dtime miliseconden
                Thread.sleep(dtime); 
                // Voeg dat toe aan de totale teller.
                totalTime = totalTime + dtime;
>>>>>>> Stashed changes
            }catch(Exception e) {
                err++;
                //System.out.println("ERROR : run() : "+e.getMessage());
                if (err > 100){
                    // CPU saver
                    System.out.println("ERROR: run() : Too many errors! ("+e.getMessage()+")");
                    return;
                }
            }
        }
    }
}
