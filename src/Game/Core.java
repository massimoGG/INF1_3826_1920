package Game;
import javafx.application.Platform;

public class Core implements Runnable {
    private GameModel model;
    private GameView view;
    private GameController controller;
    private long totalTime = 0;
    private long dtime = 20;
    
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
                    controller.lblScore.setText(""+model.getAmount());
                 });

                // Bereken de volgende posities van alle objecten
                 model.update();
                 
                // totale_tijd % 500 == 0 -> kogel schieten
                if (totalTime % 200 == 0) {
                    // 500ms -> 0.5 s
                    model.addBullet();
                }
                
                // Wacht dtime miliseconden
                Thread.sleep(dtime); 
                // Voeg dat toe aan de totale teller.
                totalTime = totalTime + dtime;

            }catch(Exception e) {
                err++;
                if (err > 100){
                    // CPU saver
                    System.out.println("ERROR: run() : Too many errors! ("+e.getMessage()+")");
                    return;
                }
            }
        }
    }
}
