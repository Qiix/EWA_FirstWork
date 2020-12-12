package bookstore.controllers;
import com.jfoenix.controls.JFXTextField;
import bookstore.Entities.Ouvrage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import bookstore.DAO.ServiceOuvrage;


public class DemandeventeController implements Initializable {
    @FXML
    private JFXTextField isbn;
    @FXML
    private JFXTextField intitule;
    @FXML
    private JFXTextField auteur;
    @FXML
    private JFXTextField dates;
    @FXML
    private Button envoie;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void envoievente(ActionEvent event) {
          ServiceOuvrage s = new ServiceOuvrage() ;
          int i = Integer.parseInt(isbn.getText());
          String in = intitule.getText();
          String aut = auteur.getText();
          String d = dates.getText();
          s.envoiDemandeVente(i, in, aut, d);
       Alert alert = new Alert (Alert.AlertType.INFORMATION);
            alert.setTitle("Envoi demande vente");
            alert.setHeaderText(null);
            alert.setContentText("Demande vente effectuée");
            alert.showAndWait();
         
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
    
}
