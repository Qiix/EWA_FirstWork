package bookstore.controllers;
import com.jfoenix.controls.JFXTextField;
import bookstore.Entities.Ouvrage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import bookstore.DAO.ServiceOuvrage;


public class MainController implements Initializable {
   
    @FXML
    private JFXTextField title;
    @FXML
    private JFXTextField author;
    @FXML
    private JFXTextField date;
    @FXML
    private JFXTextField category;
    @FXML
    private JFXTextField isbn;
    @FXML
    private TableView<Ouvrage> table;
    @FXML
    private TableColumn<Ouvrage,Integer> idouvrage;
    @FXML
    private TableColumn<Ouvrage,Integer> isbnn;
    @FXML
    private TableColumn<Ouvrage,String> intitule;
    @FXML
    private TableColumn<Ouvrage,String> dates;
    @FXML
    private TableColumn<Ouvrage,Integer> quantite;
    @FXML
    private TableColumn<Ouvrage,Float> prix;
    @FXML
    private TableColumn<Ouvrage,String> auteur;
    @FXML
    private TableColumn<Ouvrage,String> categorie;
    
 ObservableList <Ouvrage> ouv = FXCollections.observableArrayList();
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        ServiceOuvrage s = new ServiceOuvrage() ;
        ouv.addAll(s.afficher());
      
        
        idouvrage.setCellValueFactory(new PropertyValueFactory<> ("idOuvrage"));
        isbnn.setCellValueFactory(new PropertyValueFactory<> ("isbn"));
        intitule.setCellValueFactory(new PropertyValueFactory<> ("intitule"));
        dates.setCellValueFactory(new PropertyValueFactory<> ("date"));
        quantite.setCellValueFactory(new PropertyValueFactory<> ("quantite"));
        prix.setCellValueFactory(new PropertyValueFactory<> ("prix"));
        auteur.setCellValueFactory(new PropertyValueFactory<> ("auteur"));
        categorie.setCellValueFactory(new PropertyValueFactory<> ("categorie"));
        
        table.setItems(ouv);
    }    

  
    /*private void loadviewbooks(ActionEvent event) {
        
          try {
      Stage stage = new Stage();
      FXMLLoader FLOADER = new FXMLLoader();
      Pane root;
      root = FLOADER.load(getClass().getResource("tableAffichage.fxml").openStream());
      stage.setScene(new Scene(root, 750,400));
      stage.showAndWait();
        }
        catch (IOException ex) {
         Logger.getLogger(TableAffichageController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }*/

   

    @FXML
    private void loadviewauth(ActionEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/affauth.fxml" ));
            Parent root = (Parent) loader.load();
            AffauthController as = loader.getController();
            String x = author.getText();
              if (x.equals(""))
            {
              Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("alerte");
            alert.setHeaderText(null);
            alert.setContentText("champs vide");
            alert.showAndWait();
            } else {
            System.out.println(" fel main sbn howa "+x);
            
            as.setAut(x);
            as.f();
            Stage stage = new Stage();
            stage.setScene(new Scene(root,630,400));
             stage.showAndWait();
        }}
        catch (IOException ex) {
         Logger.getLogger(AffauthController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }

    @FXML
    private void loadtviewdate(ActionEvent event) {
              try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/afficherdate.fxml" ));
            Parent root = (Parent) loader.load();
            AfficherdateController as = loader.getController();
            
            as.setIs(date.getText());
              if (date.getText().equals(""))
            {
              Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("alerte");
            alert.setHeaderText(null);
            alert.setContentText("champs vide");
            alert.showAndWait();
            }  else {
            as.f();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 630,400));
             stage.showAndWait();}
        } catch (IOException ex) {
            Logger.getLogger(AfficherdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadviewcat(ActionEvent event) {
                try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/affichercat.fxml" ));
            Parent root = (Parent) loader.load();
            AffichercatController as = loader.getController();
            String v =category.getText();
              if (v.equals(""))
            {
              Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("alerte");
            alert.setHeaderText(null);
            alert.setContentText("champs vide");
            alert.showAndWait();
            }else {
            as.setCat(v);
            as.f();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 630,400));
             stage.showAndWait();}
        } catch (IOException ex) {
            Logger.getLogger(AffichercatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadviewisbn(ActionEvent event) {
        
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/afficherIsbn.fxml" ));
            Parent root = (Parent) loader.load();
            AfficherIsbnController as = loader.getController();
            int x =Integer.parseInt(isbn.getText()) ;
            System.out.println(" fel main sbn howa "+x);
            as.setIs(x);
            as.f();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 630,400));
             stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AfficherIsbnController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
       
        
   


    @FXML
    private void loadviewbtitle(ActionEvent event) {
        try {
          
            //System.out.println(getClass().getResource("../fxml/booktitle.fxml").toString());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/booktitle.fxml" ));
            
            Parent root = (Parent) loader.load();
            BooktitleController as = loader.getController();
            String x;
            x = title.getText();
            if (x.equals(""))
            {
              Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("alerte");
            alert.setHeaderText(null);
            alert.setContentText("champs vide");
            alert.showAndWait();
            }
            else {
            System.out.println(" fel main sbn howa "+x);
            
            as.setT(x);
            as.f();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 630,400));
             stage.showAndWait();
            }
        }
        catch (IOException ex) {
         Logger.getLogger(BooktitleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }


   

 
   
    
    
}
