/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.controllers;

import bookstore.Entities.Ouvrage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import bookstore.DAO.ServiceOuvrage;

/**
 * FXML Controller class
 *
 * @author MY HP
 */
public class SuppouvController implements Initializable {
    @FXML
    private TextField isbn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supprimerOuvrage(ActionEvent event) {
     
        ServiceOuvrage s = new ServiceOuvrage() ;
      Ouvrage o1 = new Ouvrage();
      int is = Integer.parseInt(isbn.getText());
        o1.setIsbn(is);
        s.supprimerOuvrage(is);
         Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Résultat recherche");
            alert.setHeaderText(null);
            alert.setContentText("suppression effectuée");
            alert.showAndWait();
         
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
    
}
