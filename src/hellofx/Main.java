package hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        // FXML View
        FXMLLoader lader = new FXMLLoader(getClass().getResource("FXMLView.fxml"));
        Parent root = lader.load();
        
        // Controller
        Controller controller = lader.getController();
        
        // hoofdvenster
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Prefab FXML applicatie");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
