package Game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Scene stage;

    @Override
    public void start(Stage stage) throws Exception{

        // FXML View
        FXMLLoader lader = new FXMLLoader(getClass().getResource("FXMLView.fxml"));
        Parent root = lader.load();

        // Model
        GameModel model = new GameModel();
        
        // Controller
        GameController controller = lader.getController();
        controller.setModel(model);
        
        // hoofdvenster
        Scene scene = new Scene(root, 400, 600);
        stage.setScene(scene);
        stage.setTitle("Polygon game");
        stage.show();
        model.setStage(stage);
    }
    
    public Scene getStage(){
        return stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
