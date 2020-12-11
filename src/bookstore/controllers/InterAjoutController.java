/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.controllers;


import bookstore.DAO.ServiceCompte;
import bookstore.Entities.Compte;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author asus
 */
public class InterAjoutController implements Initializable {

    

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfCin;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private Label labelNom;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelPrenom;
    @FXML
    private Label labelCin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   
    @FXML
    private void annuler() {
    }

    @FXML
    private void ajouter(ActionEvent event) {
        
        ServiceCompte sc = new ServiceCompte();
        Compte c = new Compte();
        
        c.setNom(tfNom.getText());
        c.setPrenom(tfPrenom.getText());
        c.setEmail(tfEmail.getText());
        int cin = Integer.parseInt(tfCin.getText());
        c.setCin(cin);
        
        sc.ajouterCompte(c);
        
        ((Stage) (((Button)event.getSource()).getScene().getWindow())).close();
        
        
    }
    
}
