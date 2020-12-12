
package bookstore;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testclient extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       
       Parent root = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
      // Parent root = FXMLLoader.load(getClass().getResource("demandevente.fxml"));
        Scene scene = new Scene(root, 650,450);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
     
        
        
    }
    
}
