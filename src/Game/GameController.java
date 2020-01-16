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
    public Label lblScore;

    @FXML
    public Label lblLevens;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnLoad;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnSave;

    @FXML
    private Label lblHS;

    @FXML
    private Label lblHS1;

    @FXML
    private Label lblHS3;

    @FXML
    private Label lblHS2;

    @FXML
    void initialize() {
        assert paneMain != null : "fx:id=\"paneMain\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert paneGame != null : "fx:id=\"paneGame\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert btnPlay != null : "fx:id=\"btnPlay\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert btnLoad != null : "fx:id=\"btnLoad\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert btnQuit != null : "fx:id=\"btnquit\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert lblHS != null : "fx:id=\"lblHS\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert lblHS1 != null : "fx:id=\"lblHS1\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert lblHS2 != null : "fx:id=\"lblHS2\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert lblHS3 != null : "fx:id=\"lblHS3\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert lblScore != null : "fx:id=\"lblScore\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert lblLevens != null : "fx:id=\"lblLevens\" was not injected: check your FXML file 'FXMLView.fxml'.";

        btnPlay.setOnAction(e -> {

            // Toggle de play knop
            if (btnPlay.isVisible()) {

                // Verstop de knop
                showMenu(false);
                model.setController(this);

                // Start het spel! 
                view = new GameView(model, this);
                paneGame.getChildren().add(view);

                // Maximum X
                model.maxX = (int) paneGame.getWidth() - 10;

                // De updater (50 TPS)
                Core core = new Core(model, view, this);
                Thread t = new Thread(core);
                t.setDaemon(true);
                t.start();

                // Key events nog accepteren wanneer het spel gestart is
                paneGame.setOnKeyPressed(ev -> {
                    model.KeyEvent(ev);
                });
                paneGame.setOnKeyReleased(ev -> {
                    model.deKeyEvent(ev);
                });

            } else {
                btnPlay.setVisible(true);
            }
        });
    }

    private GameModel model;
    private GameView view;
    public boolean statusMenu = true;
    
         
    /**
     * laat het menu zien
     * @param statusMenu
     */
    public void showMenu(boolean statusMenu) {
         btnPlay.setVisible(statusMenu);
         btnLoad.setVisible(statusMenu);
         btnQuit.setVisible(statusMenu);
         btnSave.setVisible(statusMenu);
         lblHS.setVisible(statusMenu);
         lblHS1.setVisible(statusMenu);
         lblHS2.setVisible(statusMenu);
         lblHS3.setVisible(statusMenu);
         lblScore.setVisible(!statusMenu);
         lblLevens.setVisible(!statusMenu);
         paneGame.setVisible(true);
         this.statusMenu = statusMenu;
    }

    public void setModel(GameModel model) {
        this.model = model;
        //view = new GameView(model);
        // Key events
        paneGame.setFocusTraversable(true);
    }
}
