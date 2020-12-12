/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.controllers;

import bookstore.Entities.Ouvrage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import bookstore.DAO.ServiceOuvrage;


public class AffauthController implements Initializable {
    @FXML
    private TableColumn<Ouvrage, Integer> idouvrage;
    @FXML
    private TableColumn<Ouvrage, Integer> isbn;
    @FXML
    private TableColumn<Ouvrage,String> intitule;
    @FXML
    private TableColumn<Ouvrage,String> date;
    @FXML
    private TableColumn<Ouvrage, Integer> quantite;
    @FXML
    private TableColumn<Ouvrage, Float> prix;
    @FXML
    private TableColumn<Ouvrage,String> auteur;
    @FXML
    private TableColumn<Ouvrage,String> categorie;
    
   ObservableList <Ouvrage> ouv = FXCollections.observableArrayList();
    @FXML
    private TableView<Ouvrage> tab;
    
     private static String aut;

    public  String getAut() {
        return aut;
    }

    public  void setAut(String aut) {
        AffauthController.aut = aut;
    }

   
    
    
   public void f ()
   {
    ServiceOuvrage s = new ServiceOuvrage() ;
    ouv.addAll(s.afficherauth(aut));
    tab.setItems(ouv);
        
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        idouvrage.setCellValueFactory(new PropertyValueFactory<> ("idOuvrage"));
        isbn.setCellValueFactory(new PropertyValueFactory<> ("isbn"));
        intitule.setCellValueFactory(new PropertyValueFactory<> ("intitule"));
        date.setCellValueFactory(new PropertyValueFactory<> ("date"));
        quantite.setCellValueFactory(new PropertyValueFactory<> ("quantite"));
        prix.setCellValueFactory(new PropertyValueFactory<> ("prix"));
        auteur.setCellValueFactory(new PropertyValueFactory<> ("auteur"));
        categorie.setCellValueFactory(new PropertyValueFactory<> ("categorie"));
        
        
    }    
    
}
