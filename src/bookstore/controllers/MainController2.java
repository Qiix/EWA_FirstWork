
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.controllers;

import com.jfoenix.controls.JFXTextField;
import  bookstore.Entities.Ouvrage;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import bookstore.DAO.ServiceOuvrage;

/**
 * FXML Controller class
 *
 * @author MY HP
 */
public class MainController2 implements Initializable {
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

    
   
ObservableList <Ouvrage> ouv = FXCollections.observableArrayList();
    @FXML
    private Button addbook;
    @FXML
    private Button editbook;
    @FXML
    private Button viewbook;
    @FXML
    private Button deletebook;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void loadaddbook(ActionEvent event) {
        
        try {
      Stage stage = new Stage();
      FXMLLoader FLOADER = new FXMLLoader();
      Pane root;
      root = FLOADER.load(getClass().getResource("../fxml/FXMLDocument.fxml").openStream());
      stage.setScene(new Scene(root, 450,600));
      stage.showAndWait();
        }
        catch (IOException ex) {
         Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    
    }

    @FXML
    private void loaddeletebook(ActionEvent event) {
        
          try {
      Stage stage = new Stage();
      FXMLLoader FLOADER = new FXMLLoader();
      Pane root;
      root = FLOADER.load(getClass().getResource("../fxml/suppouv.fxml").openStream());
      stage.setScene(new Scene(root, 400,300));
      stage.showAndWait();
        }
        catch (IOException ex) {
         Logger.getLogger(SuppouvController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        
        
    }

    @FXML
    private void loadeditbook(ActionEvent event) {
        
          
          try {
      Stage stage = new Stage();
      FXMLLoader FLOADER = new FXMLLoader();
      Pane root;
      root = FLOADER.load(getClass().getResource("../fxml/modifier.fxml").openStream());
      stage.setScene(new Scene(root, 400,400));
      stage.showAndWait();
        }
        catch (IOException ex) {
         Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        
    }

    @FXML
    private void loadviewbooks(ActionEvent event) {
        
          try {
      Stage stage = new Stage();
      FXMLLoader FLOADER = new FXMLLoader();
      Pane root;
      root = FLOADER.load(getClass().getResource("../fxml/tableAffichage.fxml").openStream());
      stage.setScene(new Scene(root, 750,400));
      stage.showAndWait();
        }
        catch (IOException ex) {
         Logger.getLogger(TableAffichageController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

   

    @FXML
    private void loadviewauth(ActionEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/affauth2.fxml" ));
            Parent root = (Parent) loader.load();
            AffauthController2 as = loader.getController();
            String x = author.getText();
            System.out.println(" fel main sbn howa "+x);
              if (x.equals(""))
            {
              Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("alerte");
            alert.setHeaderText(null);
            alert.setContentText("champs vide");
            alert.showAndWait();
            } else {
            as.setAut(x);
            as.f();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 750,500));
             stage.showAndWait();
        }}
        catch (IOException ex) {
         Logger.getLogger(AffauthController2.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }

    @FXML
    private void loadtviewdate(ActionEvent event) {
              try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/afficherdate2.fxml" ));
            Parent root = (Parent) loader.load();
            AfficherdateController2 as = loader.getController();
            
            as.setIs(date.getText());
              if (date.getText().equals(""))
            {
              Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("alerte");
            alert.setHeaderText(null);
            alert.setContentText("champs vide");
            alert.showAndWait();
            } else {
            as.f();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 750,500));
             stage.showAndWait();}
        } catch (IOException ex) {
            Logger.getLogger(AfficherdateController2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadviewcat(ActionEvent event) {
                try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/affichercat2.fxml" ));
            Parent root = (Parent) loader.load();
            AffichercatController2 as = loader.getController();
            String v =category.getText();
            as.setCat(v);
            if (v.equals(""))
            {
              Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("alerte");
            alert.setHeaderText(null);
            alert.setContentText("champs vide");
            alert.showAndWait();
            } else {
            as.f();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 750,500));
             stage.showAndWait();}
        } catch (IOException ex) {
            Logger.getLogger(AffichercatController2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void loadviewisbn(ActionEvent event) {
        
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/afficherIsbn2.fxml" ));
            Parent root = (Parent) loader.load();
            AfficherIsbnController2 as = loader.getController();
            int x =Integer.parseInt(isbn.getText()) ;
            System.out.println(" fel main sbn howa "+x);
            as.setIs(x);
            as.f();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 750,500));
             stage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(AfficherIsbnController2.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
       
        
    


    @FXML
    private void loadviewbtitle(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/booktitle2.fxml" ));
            Parent root = (Parent) loader.load();
            BooktitleController2 as = loader.getController();
            String x;
            x = title.getText();
            System.out.println(" fel main sbn howa "+x);
            if (x.equals(""))
            {
              Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("alerte");
            alert.setHeaderText(null);
            alert.setContentText("champs vide");
            alert.showAndWait();
            } else {
            as.setT(x);
            as.f();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 750,500));
             stage.showAndWait();
        }}
        catch (IOException ex) {
         Logger.getLogger(BooktitleController2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
}
