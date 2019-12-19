package Spel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import wandelaar.WandelaarModel;
import wandelaar.WandelaarView;

public class Controller {
    
    PersoonModel pModel = new PersoonModel();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnReset;

    @FXML
    private AnchorPane paneMain;

    @FXML
    void initialize() {
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'FXMLView.fxml'.";
        assert paneMain != null : "fx:id=\"paneMain\" was not injected: check your FXML file 'FXMLView.fxml'.";
        
        paneMain.setOnKeyPressed(e -> beweeg(e));
        btnReset.setOnAction(e -> reset());

    }
    private SpelView view;
    private Oorsprong oorsprong;
    private VastVW vastVW;
    public void setModel(PersoonModel pModel, Oorsprong oorsprong){
        this.pModel = pModel;
        this.oorsprong = oorsprong;
        VastVW vastVW = new VastVW(200, 200, 20, 20);
        view = new SpelView(pModel, vastVW, oorsprong);
        paneMain.getChildren().add(view);
    }
    public void beweeg(KeyEvent e){
        switch(e.getCode()){
            case RIGHT:
                oorsprong.links();
                update();
                break;
            case LEFT:
                oorsprong.rechts();
                update();
                break;
            case DOWN:
                oorsprong.omhoog();
                update();
                break;
            case UP:
                oorsprong.omlaag();
                update();
                break;
            
            
        }
    }
    
    public void test(){
        System.out.println("Test :p");
    }
    
    public void update(){
        view.update();
    }
    public void reset(){
        oorsprong.reset();
        update();
    }
}
