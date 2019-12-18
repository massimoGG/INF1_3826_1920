package wandelaar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        
        //Model aan maken
        WandelaarModel model = new WandelaarModel();
        
        
        
        
        
        
        
        // FXML View
        FXMLLoader lader = new FXMLLoader(getClass().getResource("FXMLWandelaarView.fxml"));
        Parent root = lader.load();
        
        // WandelaarController
        WandelaarController controller = lader.getController();
        controller.setModel(model);
        
        // hoofdvenster
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("WandelaarsApp");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
