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
public class ModifierController implements Initializable {
    @FXML
    private TextField isbn;
    @FXML
    private TextField intitule;
    @FXML
    private TextField prix;
    @FXML
    private TextField quantite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierOuvrage(ActionEvent event) {
         Alert alert = new Alert (Alert.AlertType.INFORMATION);
        ServiceOuvrage s = new ServiceOuvrage() ;
          Ouvrage o1 = new Ouvrage();
        o1.setIntitule(intitule.getText());
        float p = Float.parseFloat(prix.getText());
        o1.setPrix(p);
        int q = Integer.parseInt(quantite.getText());
        o1.setQuantite(q);
        int is = Integer.parseInt(isbn.getText());
        s.modifierOuvrage2(is,intitule.getText(),q,p);
        alert.setTitle("Résultat recherche");
            alert.setHeaderText(null);
            alert.setContentText("modification effectuée");
            alert.showAndWait();
  
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        
    }
    
}
