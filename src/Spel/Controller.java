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

    }
    private SpelView view;
    
    public void setModel(PersoonModel pModel){
        this.pModel = pModel;
        view = new SpelView(pModel);
        paneMain.getChildren().add(view);
    }
    public void beweeg(KeyEvent e){
        switch(e.getCode()){
            case LEFT:
                pModel.links();
                update();
                break;
            case RIGHT:
                pModel.rechts();
                update();
                break;
            case UP:
                pModel.omhoog();
                update();
                break;
            case DOWN:
                pModel.omlaag();
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
    
}
