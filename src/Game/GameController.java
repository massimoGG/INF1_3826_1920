package Game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class GameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneMain;

    @FXML
    private AnchorPane paneGame;

    @FXML
    private Button btnPlay;

    @FXML
    public Label lblScore;

    @FXML
    void initialize() {
        assert paneMain != null : "fx:id=\"paneMain\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert paneGame != null : "fx:id=\"paneGame\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert btnPlay != null : "fx:id=\"btnPlay\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert lblScore != null : "fx:id=\"lblScore\" was not injected: check your FXML file 'FXMLView.fxml'.";

        btnPlay.setOnAction(e->{
            
            // Toggle de play knop
            if (btnPlay.isVisible()) {
                
                // Verstop de knop
                btnPlay.setVisible(false);
                
                // Start het spel! 
                view = new GameView(model);
                paneGame.getChildren().add(view);
                
                // Maximum X
                model.maxX = (int)paneGame.getWidth() - 10;
                
                // De updater (50 TPS)
                Core core = new Core(model, view, this);
                Thread t = new Thread(core);
                t.setDaemon(true);
                t.start();
                
                // Key events nog accepteren wanneer het spel gestart is
                paneGame.setOnKeyPressed(ev -> {
                    model.move(ev);
                });
                paneGame.setOnKeyReleased(ev -> {
                    model.demove(ev);
                });
                
            } else
                btnPlay.setVisible(true);
        });
    }

    private GameModel model;
    private GameView view;

    public void  setModel(GameModel model) {
        this.model = model;
        //view = new GameView(model);
        // Key events
        paneGame.setFocusTraversable(true);
    }
}
