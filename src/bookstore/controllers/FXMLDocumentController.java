/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.controllers;
import javafx.scene.control.TextField;
import bookstore.Entities.Emprunt;
import bookstore.Entities.Client;
import bookstore.Entities.ListeClient;
import bookstore.DAO.ServiceEmprunt;
import bookstore.Utility.Myconnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.util.Date; 


/**
 *
 * @author lenovo
 */
public class FXMLDocumentController implements Initializable {
    int index = -1;
    private Label label;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfDeb;
    @FXML
    private TextField tfFin;
    private TextField tfIdSupp;
    @FXML
    private Label labelRechercher;
    @FXML
    private TextField tfrech;
    private TextField tfIdEmprModif;
    private TextField tfIdCltModif;

    
    private ListView<Emprunt> ls;
    @FXML
    public TableView<Emprunt> tableEmp;
    @FXML
    private TableColumn<Emprunt, Integer> coId;
    @FXML
    private TableColumn<Emprunt, Integer> coIdClt;
    @FXML
    private TableColumn<Emprunt, String> CoNomEmp;
    @FXML
    private TableColumn<Emprunt, Date> coDateDeb;
    @FXML
    private TableColumn<Emprunt, Date> coDateFin;
  
    private TextField idd;
    @FXML
    private Button clear;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showEmprunt();
        ServiceEmprunt s = new ServiceEmprunt();
 
       
    }
    
    public ObservableList<Emprunt> getEmpruntList()
   {
     ObservableList<Emprunt> empruntlist=
                FXCollections.observableArrayList();
      String req= "select * from Emprunt";
        Myconnexion cnx = Myconnexion.getInstance();
    try {
        Statement s = cnx.getConnexion().createStatement();
        ResultSet rs = s.executeQuery(req);
        Emprunt emprunt;
        while(rs.next())
        {
            emprunt = new Emprunt(rs.getInt("id"),rs.getInt("icClient"),rs.getString("nomEmp"),rs.getDate("dateDebut"),rs.getDate("dateFin"));
            empruntlist.add(emprunt);
        }
    } catch (Exception e) {
e.printStackTrace();   }
    return empruntlist;
 }
    
    
   
    
      public ObservableList<Emprunt> rechEmpruntList(String nom)
   {
     ObservableList<Emprunt> empruntlist=
                FXCollections.observableArrayList();
      String req= "select * from emprunt where nomEmp='"+nom+"';";
        Myconnexion cnx = Myconnexion.getInstance();
    try {
        Statement s = cnx.getConnexion().createStatement();
        ResultSet rs = s.executeQuery(req);
        Emprunt emprunt;
        while(rs.next())
        {
            emprunt = new Emprunt(rs.getInt("id"),rs.getInt("icClient"),rs.getString("nomEmp"),rs.getDate("dateDebut"),rs.getDate("dateFin"));
            empruntlist.add(emprunt);
        }
    } catch (Exception e) {
e.printStackTrace();   }
    return empruntlist;
 }

 public void showEmprunt()
 {
     ObservableList<Emprunt> list= getEmpruntList();
     coId.setCellValueFactory(new PropertyValueFactory<Emprunt, Integer>("id"));
     coIdClt.setCellValueFactory(new PropertyValueFactory<Emprunt, Integer>("icClient"));
     CoNomEmp.setCellValueFactory(new PropertyValueFactory<Emprunt, String>("nomEmp"));
     coDateDeb.setCellValueFactory(new PropertyValueFactory<Emprunt, Date>("dateDebut"));
     coDateFin.setCellValueFactory(new PropertyValueFactory<Emprunt, Date>("dateFin"));
     tableEmp.setItems(list);
    
     
     
}

    @FXML
    private void RechercherEmprunt(ActionEvent event) {
        ServiceEmprunt s = new ServiceEmprunt();
        RechEmprunt();
    }
    
     public void RechEmprunt()
 {

     ObservableList<Emprunt> list= rechEmpruntList(tfrech.getText());
     coId.setCellValueFactory(new PropertyValueFactory<Emprunt, Integer>("id"));
     coIdClt.setCellValueFactory(new PropertyValueFactory<Emprunt, Integer>("icClient"));
     CoNomEmp.setCellValueFactory(new PropertyValueFactory<Emprunt, String>("nomEmp"));
     coDateDeb.setCellValueFactory(new PropertyValueFactory<Emprunt, Date>("dateDebut"));
     coDateFin.setCellValueFactory(new PropertyValueFactory<Emprunt, Date>("dateFin"));
     tableEmp.setItems(list);
     
}
   
  
    @FXML
    private void InterfaceAjouter(ActionEvent event) {
          try {
             Stage stage = new Stage();
      FXMLLoader FLOADER = new FXMLLoader();
      Pane root;
      root = FLOADER.load(getClass().getResource("../fxml/FXMLAjout.fxml").openStream());
      stage.setScene(new Scene(root, 600,600));
      stage.showAndWait();

        } catch (IOException ex) {
         Logger.getLogger(FXMLAjoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 private void clearForm()
    { 
    tfnom.clear();
    tfDeb.clear();
    tfFin.clear();
            } 

 
    @FXML
    private void onSupprimeAction(ActionEvent event) {
        
         ServiceEmprunt sc = new ServiceEmprunt();
        tableEmp.setEditable(true);
        
        int index = tableEmp.getSelectionModel().getSelectedIndex();
        if (index >= 0) 
        {   int i = tableEmp.getItems().get(index).getId();
            tableEmp.getItems().remove(index);
            
            sc.supprimerEmprunt(i);
             Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText(null);
            alert.setContentText("suppression effectuée");
            alert.showAndWait();
            
        } 
        
        else 
        {
            
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Alerte");
            alert.setHeaderText("Pas d'emprunt séléctionné");
            alert.setContentText("Veuillez choisir un emprunt pour le supprimer.");

            alert.showAndWait();
        }

    }

    @FXML
    private void OnclearAction(ActionEvent event) {
     clearForm();
    }

   @FXML
    private void OnModifierAction(ActionEvent event) {
         ServiceEmprunt sc = new ServiceEmprunt();
       
        tableEmp.setEditable(true);
        
        int index = tableEmp.getSelectionModel().getSelectedIndex();
        if (index >= 0) 
        {
           Integer a = tableEmp.getItems().get(index).getId();
           String c  = tableEmp.getItems().get(index).getNomEmp();
           Date d1 =  tableEmp.getItems().get(index).getDateDebut();
           Date d2 =  tableEmp.getItems().get(index).getDateFin();
           tfnom.setText(c);
           tfDeb.setText(d1.toString());
           tfFin.setText(d2.toString());  
        } 
        
    }

    @FXML
    private void onValiderAction(ActionEvent event) throws ParseException {
        ServiceEmprunt sc = new ServiceEmprunt();
DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
Emprunt c = new Emprunt();
        int index = tableEmp.getSelectionModel().getSelectedIndex();
        if (index >= 0) 
        {
            c.setId(tableEmp.getItems().get(index).getId());
            c.setNomEmp(tfnom.getText());
            c.setDateDebut((dateFormat.parse(tfDeb.getText())));
            c.setDateFin((dateFormat.parse(tfFin.getText())));
            sc.modifierEmprunt(c);
            
        }
        
        clearForm();
        
    }
         

   

    
}
