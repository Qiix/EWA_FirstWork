
package bookstore.controllers;

import com.jfoenix.controls.JFXTextField;
import bookstore.Entities.Ouvrage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import bookstore.DAO.ServiceOuvrage;
import outerService.envoieMail;

public class FXMLDocumentController implements Initializable {
     private TextField label;
    
    private Label labelAfficher;
    @FXML
    private TextField inrecherche;
    @FXML
    private ChoiceBox<String> listcategorie;
    @FXML
    private JFXTextField idouv;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXTextField intitule;
    @FXML
    private JFXTextField date;
    @FXML
    private JFXTextField quantite;
    
     ObservableList categliste = FXCollections.observableArrayList("neuf","occassion","emprunt");
    @FXML
    private JFXTextField isbn;
  
    @FXML
    private Button chercherouvrage;
    @FXML
    private ChoiceBox <String> listauteur;
    ObservableList <String > autliste = FXCollections.observableArrayList();

    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceOuvrage s = new ServiceOuvrage();
        List <String> lii = new ArrayList <String> ();
        lii = s.getIdauteur(lii);
        System.out.println(lii);
       
        for ( int i=0; i< lii.size(); i++)
        {
            System.out.println("fel for"+lii.get(i));
            autliste.add(lii.get(i));
            listauteur.setValue(lii.get(1));
            listauteur.setItems(autliste);
        }

        listcategorie.setValue("neuf");
        listcategorie.setItems(categliste); 
      
    }    

    @FXML
    private void ajouterOuvrage(ActionEvent event) {
        ServiceOuvrage s = new ServiceOuvrage() ;
        Ouvrage o1 = new Ouvrage();
        
        int id = Integer.parseInt(idouv.getText());
        o1.setIdOuvrage(id);
        
        int is = Integer.parseInt(isbn.getText());
        o1.setIsbn(is);
        
        o1.setIntitule(intitule.getText());
        o1.setDate(date.getText());
        int q = Integer.parseInt(quantite.getText());
        o1.setQuantite(q);
        float p = Float.parseFloat(prix.getText());
        o1.setPrix(p);
        
        
        String selectedChoice1;
        selectedChoice1 = listauteur.getValue();
        o1.setAuteur(selectedChoice1);
        
        
      //  o1.setAuteur(auteur.getText());
        
       String selectedChoice;
        selectedChoice = listcategorie.getValue();
        o1.setCategorie(selectedChoice);
        
        System.out.println(selectedChoice);
        s.ajouterOuvrage(o1);
        
        List <String> li = new ArrayList <String> ();
        s.getEmail(li);
         for (String li1 : li) {
             envoieMail.envoimail(li1);
         }
        
        
            Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout ouvrage");
            alert.setHeaderText(null);
            alert.setContentText("ajout effectuée");
            alert.showAndWait();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
 // afficherbtn.setOnAction (tableAffichage.show());
    private void afficherOuvrage(ActionEvent event) {
        ServiceOuvrage s = new ServiceOuvrage() ;
        labelAfficher.setText(s.afficher().toString());

    }


    private void chercherOuvrage(ActionEvent event) {
      ServiceOuvrage s = new ServiceOuvrage() ;
      Ouvrage o1 = new Ouvrage();
        int is = Integer.parseInt(inrecherche.getText());
        o1.setIsbn(is);
        s.chercherOuvrage(is);
        
    }


    @FXML
    private void loadchercherouvrage(ActionEvent event) {
        ServiceOuvrage s = new ServiceOuvrage() ;
        Ouvrage o1 = new Ouvrage();
        int is = Integer.parseInt(inrecherche.getText());
        o1.setIsbn(is);
        boolean exist =s.chercherOuvrage(is);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        if (exist == true )
        {
          
            alert.setTitle("Résultat recherche");
            alert.setHeaderText(null);
            alert.setContentText("ouvrage existant");
            alert.showAndWait();
        }
        if (exist == false){
        alert.setTitle("Résultat recherche");
        alert.setHeaderText(null);
        alert.setContentText("ouvrage non existant");
        alert.showAndWait();
        }
    }
}
