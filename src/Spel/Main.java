package Spel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Point2D;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        
        //Model aanmaken
        PersoonModel model = new PersoonModel();
        Oorsprong oorsprong = new Oorsprong(200,200);
        
        // FXML View
        FXMLLoader lader = new FXMLLoader(getClass().getResource("FXMLView.fxml"));
        Parent root = lader.load();
        
        // Controller
        Controller controller = lader.getController();
        controller.setModel(model, oorsprong);
        
        // hoofdvenster
        Scene scene = new Scene(root, 1280, 800);
        stage.setScene(scene);
        stage.setTitle("Prison game");
        stage.show();
        controller.setStage(stage);
    }

    private void tick() {
        // De tick functie die minstens 1/20 per sec gerunt wordt
        
    }
    
    private void render() {
        // De render functie die minstens 1/60 keren pe rseconden gerunt wordt
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
