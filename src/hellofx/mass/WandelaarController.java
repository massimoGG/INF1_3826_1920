package wandelaar;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class WandelaarController {
    
    private WandelaarModel model;
    private WandelaarView view;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneApplicatie;

    @FXML
    private Button btnReset;

    @FXML
    private Label lblMenu;

    @FXML
    private AnchorPane paneWandelaar;

    @FXML
    void initialize() {
        assert paneApplicatie != null : "fx:id=\"paneApplicatie\" was not injected: check your FXML file 'FXMLWandelaarView.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'FXMLWandelaarView.fxml'.";
        assert lblMenu != null : "fx:id=\"lblMenu\" was not injected: check your FXML file 'FXMLWandelaarView.fxml'.";
        assert paneWandelaar != null : "fx:id=\"paneWandelaar\" was not injected: check your FXML file 'FXMLWandelaarView.fxml'.";
        
        paneWandelaar.setOnKeyPressed(e -> beweegWandelaar(e));
        btnReset.setOnAction(e -> reset());
    }


    /**
     * link gemaakt tussen view model en controller en de anchorpane
     */
    public void setModel(WandelaarModel model){
        this.model = model;
        view = new WandelaarView(model);
        paneWandelaar.getChildren().add(view);
        
        //focus leggen op wandelaar view
        view.setFocusTraversable(true);
        btnReset.setFocusTraversable(false);
        
        WandelaarBot bot = new WandelaarBot(model, this);
        Timer t = new Timer(true);
        t.scheduleAtFixedRate(bot, 0, 50);
    }
    
    public void beweegWandelaar(KeyEvent e){
        switch(e.getCode()){
            case LEFT:
                model.links();
                update();
                break;
            case RIGHT:
                model.rechts();
                update();
                break;
            case UP:
                model.boven();
                update();
                break;
            case DOWN:
                model.onder();
                update();
                break;
            
            
        }
        
    }
    public void update(){
        view.update();
    }
    
    public void reset(){
        model.reset();
        view.update();
        
    }

}
