package Spel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

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
    void initialize() {
        assert paneMain != null : "fx:id=\"paneMain\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert paneGame != null : "fx:id=\"paneGame\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert btnPlay != null : "fx:id=\"btnPlay\" was not injected: check your FXML file 'FXMLView.fxml'.";

        btnPlay.setOnAction(e->{
            
            // Toggle de play knop
            if (btnPlay.isVisible()) {
                
                // Verstop de knop
                btnPlay.setVisible(false);
                
                // Start het spel! :D
                VastVW vastVW = new VastVW(200, 200, 20, 20);
                view = new SpelView(model, vastVW, oorsprong);
                paneGame.getChildren().add(view);
                
                // Key events nog accepteren wanneer het spel gestart is
                paneGame.setOnKeyPressed(ev -> {
                    beweeg(ev);
                });
                
            } else
                btnPlay.setVisible(true);
        });
        
        //btnReset.setOnAction(e -> reset());
    }
    
    
    private SpelView view;
    private Oorsprong oorsprong;
    private VastVW vastVW;
    private PersoonModel model;
    private Stage stage;
    
    // Mijn god. Zo gaan we dat niet doen. Maar we fixen dit nadat we klaar zijn met da map
    public void setModel(PersoonModel model, Oorsprong oorsprong){
        this.model = model;
        this.oorsprong = oorsprong;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void beweeg(KeyEvent e){
        switch(e.getCode()){
            // Vervang deze WASD met uw AZERTY toetsen aub
            case RIGHT:
            case D:
                oorsprong.rechts();
                break;
            case LEFT:
            case A:
                oorsprong.links();
                break;
            case DOWN:
            case S:
                oorsprong.omlaag();
                break;
            case UP:
            case W:
                oorsprong.omhoog();
                break;
            case ESCAPE:
                stage.close();
                break;
        }
        update();
    }
    
    public void update(){
        view.update();
    }
    public void reset(){
        oorsprong.reset();
        update();
    }
}
