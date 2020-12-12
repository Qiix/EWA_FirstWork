
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

public class TableAffichageController implements Initializable {
    @FXML
    private TableColumn<Ouvrage,Integer> idOuvrage;
    @FXML
    private TableColumn<Ouvrage,Integer> isbn;
    @FXML
    private TableColumn<Ouvrage,String> intitule;
    @FXML
    private TableColumn<Ouvrage,String> datesortie;
    @FXML
    private TableColumn<Ouvrage,Integer> quantite;
    @FXML
    private TableColumn<Ouvrage,Float> prix;
    @FXML
    private TableColumn<Ouvrage,String> auteur;
    @FXML
    private TableColumn<Ouvrage,String> categorie;
    //private TableView<Ouvrage> tableouvrage;

   
    ObservableList <Ouvrage> ouv = FXCollections.observableArrayList();
    @FXML
    private TableView<Ouvrage> tableouvvrage;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceOuvrage s = new ServiceOuvrage() ;
        ouv.addAll(s.afficher());
      
        
        idOuvrage.setCellValueFactory(new PropertyValueFactory<> ("idOuvrage"));
        isbn.setCellValueFactory(new PropertyValueFactory<> ("isbn"));
        intitule.setCellValueFactory(new PropertyValueFactory<> ("intitule"));
        datesortie.setCellValueFactory(new PropertyValueFactory<> ("date"));
        quantite.setCellValueFactory(new PropertyValueFactory<> ("quantite"));
        prix.setCellValueFactory(new PropertyValueFactory<> ("prix"));
        auteur.setCellValueFactory(new PropertyValueFactory<> ("auteur"));
        categorie.setCellValueFactory(new PropertyValueFactory<> ("categorie"));
        
        tableouvvrage.setItems(ouv);
    }
    
}
