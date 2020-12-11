
package bookstore.controllers;



import bookstore.DAO.ServiceCompte;
import bookstore.Entities.Compte;
import com.mysql.jdbc.Statement;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 *
 * @author asus
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TableView<Compte> listCompte;
    @FXML
    private TableColumn<Compte, Integer> id;
    @FXML
    private TableColumn<Compte, String> nom;
    @FXML
    private TableColumn<Compte, String> prenom;
    @FXML
    private TableColumn<Compte, String> email;
    @FXML
    private TableColumn<Compte, Integer> cin;
    @FXML
    private TextField search;

    public Compte c;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        afficheListeClient();
        
    }    

        
    @FXML
    private void afficheListeClient(){
        
        ServiceCompte sc= new ServiceCompte();
        ObservableList<Compte> l = sc.afficher();
        
        id.setCellValueFactory(new PropertyValueFactory<Compte, Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Compte, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Compte, String>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<Compte, String>("email"));
        cin.setCellValueFactory(new PropertyValueFactory<Compte, Integer>("cin"));
        
        listCompte.setItems(l);
        
    }
    
    
    
    @FXML
    private void AjoutClient(ActionEvent event) {
        
        
        
        Compte c= new Compte();
        Stage stage = new Stage();
        try {
            
            
            
            FXMLLoader FLOADER = new FXMLLoader();
            Pane root;
            root = FLOADER.load(getClass().getResource("../fxml/InterAjout.fxml").openStream());
            
            stage.setScene(new Scene(root, 300,400));
            stage.showAndWait();
            stage.close();
            
        } 
        catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
     
    }

    @FXML
    private void supprimeClient() {
        
        //MyCnx cnx = MyCnx.getInstance();
        ServiceCompte sc = new ServiceCompte();
        listCompte.setEditable(true);
        int index = listCompte.getSelectionModel().getSelectedIndex();
        //int index = listCompte.getSelectionModel().getSelectedIndex();
        
        if (index >= 0) 
        {
            int i = listCompte.getItems().get(index).getId() ;
            listCompte.getItems().remove(index);
            sc.supprimerCompte(i);
        } 
        else 
        {
            
            Alert alert = new Alert(AlertType.WARNING);
            //alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Alerte");
            alert.setHeaderText("pas de compte séléctionné");
            alert.setContentText("Veuillez choisir un compte pour le supprimer.");

            alert.showAndWait();
        }
    }

    @FXML
    private void rechercheCompte(ActionEvent event) {
        
        ServiceCompte sc = new ServiceCompte();
        String x = search.getText();
        ObservableList<Compte> l = sc.searchClient(x);
        
        id.setCellValueFactory(new PropertyValueFactory<Compte, Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Compte, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Compte, String>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<Compte, String>("email"));
        cin.setCellValueFactory(new PropertyValueFactory<Compte, Integer>("cin"));
        
        listCompte.setItems(l);
        
        
    }
    


    @FXML
    private void modifClient() {
        
        listCompte.setEditable(true);
        
        int index = listCompte.getSelectionModel().getSelectedIndex();
        
        if (index >= 0) 
        {
                Integer i = listCompte.getItems().get(index).getId();
                Integer c = listCompte.getItems().get(index).getCin();
                String n = listCompte.getItems().get(index).getNom();
                String p = listCompte.getItems().get(index).getPrenom();
                String e = listCompte.getItems().get(index).getEmail();
                
                tfNom.setText(n);
                tfPrenom.setText(p);
                tfEmail.setText(e);
                tfCin.setText(c.toString());
            
        } 
        else 
        {
            
            Alert alert = new Alert(AlertType.WARNING);
            
            alert.setTitle("Alerte");
            alert.setHeaderText("pas de compte séléctionné");
            alert.setContentText("Veuillez choisir un compte pour le modifie.");
            alert.showAndWait();
        }
        
        
    }
    
    private void effacer(){
        
        tfNom.setText(null);
        tfCin.setText(null);
        tfPrenom.setText(null);
        tfEmail.setText(null);
        
    }

    @FXML
    private void validerModif(ActionEvent event) {
        
        ServiceCompte sc = new ServiceCompte();
        Compte c = new Compte();
        int index = listCompte.getSelectionModel().getSelectedIndex();
        if (index >= 0) 
        {
            c.setId(listCompte.getItems().get(index).getId());
            c.setNom(tfNom.getText());
            c.setPrenom(tfPrenom.getText());
            c.setEmail(tfEmail.getText());
            c.setCin(Integer.parseInt(tfCin.getText()));
            sc.modifierCompte(c);
            
        }
        
        effacer();
        
       
    }

    @FXML
    private void validerProfil(ActionEvent event) {
        
        Stage stage = new Stage();
        try {
            
            
            
            FXMLLoader FLOADER = new FXMLLoader();
            Pane root;
            root = FLOADER.load(getClass().getResource("../fxml/ValiderProfil.fxml").openStream());
            
            stage.setScene(new Scene(root, 600,600));
            stage.showAndWait();
            stage.close();
            
        } 
        catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void viderChamps(ActionEvent event) {
        
        effacer();
        
    }
    
}

