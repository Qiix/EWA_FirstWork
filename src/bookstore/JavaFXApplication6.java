/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author lenovo
 */
public class JavaFXApplication6 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       
        
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("fxml/FXMLDocument.fxml"));
      Parent root = loader.load();     
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show(); 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
