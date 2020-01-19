package Game;

import Game.Objects.Highscore;
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
    private Label lblScore;

    @FXML
    private Label lblLevens;

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
                

                // De updater (50 TPS)
                if (!isRunning) {
                    Core core = new Core(model, view, this);
                    Thread t = new Thread(core);
                    t.setDaemon(true);
                    t.start();
                    isRunning = true;
                }
                
                // Maximum X
                model.setMaxX(paneGame.getWidth() - 10);

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
        
        btnQuit.setOnAction(e -> {
            model.stopSpel();
        });
        
        btnLoad.setOnAction(e -> {
            model.load();
        });
        
        btnSave.setOnAction(e -> {
            model.toJson();
        });
    }

    private GameModel model;
    private GameView view;
    
    // Zorgt ervoor dat we niet meer dan 1 core thread hebben
    private boolean isRunning = false;
    
    // Zo weet de core als het verder moet "ticken"
    private boolean statusMenu = true;
    
    public void setStatus(boolean s) {
        this.statusMenu = s;
    }
    
    public boolean getStatus() {
        return this.statusMenu;
    }
         
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
        model.loadHighscore();
        Highscore highscore = model.getHighscore();
        setTekstHighscore1("Highscore 1:" + highscore.getHighscore1());
        setTekstHighscore2("Highscore 2:" + highscore.getHighscore2());
        setTekstHighscore3("Highscore 3:" + highscore.getHighscore3());
    }
    
    public void setTekstScore(String string){
        lblScore.setText(string);
    }
    
    public void setTekstLevens(String string){
        lblLevens.setText(string);
    }
    
    public void setTekstHighscore1(String string){
        lblHS1.setText(string);
    }
    
    public void setTekstHighscore2(String string){
        lblHS2.setText(string);
    }
    
    public void setTekstHighscore3(String string){
        lblHS3.setText(string);
    }
}
