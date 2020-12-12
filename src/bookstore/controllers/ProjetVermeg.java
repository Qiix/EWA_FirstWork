
package bookstore.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProjetVermeg extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       Parent root = FXMLLoader.load(getClass().getResource("../fxml/main2.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("modif.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource("suppouv.fxml"));
      // Parent root = FXMLLoader.load(getClass().getResource("tableAffichage.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
    
}
