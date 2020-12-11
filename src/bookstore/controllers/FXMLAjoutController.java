/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.controllers;

import bookstore.Entities.Emprunt;
import bookstore.Entities.Client;
import bookstore.DAO.ServiceEmprunt;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class FXMLAjoutController implements Initializable {

    @FXML
    private ComboBox<Client> comclient;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfDeb;
    @FXML
    private TextField tfFin;
    @FXML
    private Button clear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ServiceEmprunt s = new ServiceEmprunt();
         comclient.getItems().addAll(s.afficherClient());
    }    

    @FXML
    private void AjouterEmprunt(ActionEvent event) throws Exception{
          DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        ServiceEmprunt s = new ServiceEmprunt();
        Emprunt e = new Emprunt();
        e.setIcClient((comclient.getValue().getIdClient()));
        e.setNomEmp(tfnom.getText());
        e.setDateDebut(dateFormat.parse(tfDeb.getText()));
        e.setDateFin(dateFormat.parse(tfFin.getText()));
        s.ajouterEmprunt(e);

        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close(); 
       
    }

    
    private void clearForm()
    {tfnom.clear();
    tfDeb.clear();
    tfFin.clear();
            }
    @FXML
    private void onclearaction(ActionEvent event) {
        clearForm();
    }
    
}
