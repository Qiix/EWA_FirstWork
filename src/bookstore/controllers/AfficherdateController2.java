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

/**
 * FXML Controller class
 *
 * @author MY HP
 */
public class AfficherdateController2 implements Initializable {
    @FXML
    private TableView<Ouvrage> table;
    @FXML
    private TableColumn<Ouvrage,Integer> idouvrage;
    @FXML
    private TableColumn<Ouvrage,Integer> isbn;
    @FXML
    private TableColumn<Ouvrage,String> intitule;
    @FXML
    private TableColumn<Ouvrage,String> date;
    @FXML
    private TableColumn<Ouvrage,Integer> quantite;
    @FXML
    private TableColumn<Ouvrage,Float> prix;
    @FXML
    private TableColumn<Ouvrage,String> auteur;
    @FXML
    private TableColumn<Ouvrage,String> categorie;
    ObservableList <Ouvrage> ouv = FXCollections.observableArrayList();
 private static String is;

    public  String getIs() {
        return is;
    }

    public void setIs(String is) {
        AfficherdateController2.is = is;
    }

   
 
    public void f ()
    {
        ServiceOuvrage s = new ServiceOuvrage() ;
        System.out.println("fil contr isbn "+is);
        ouv.addAll(s.afficherdate(is));
        table.setItems(ouv);
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
