package bookstore.controllers;

import com.gn.GNCarousel;
import com.jfoenix.controls.JFXButton;
import bookstore.Entities.Panier;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import bookstore.DAO.ServicePanier;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientGui implements Initializable {
    @FXML
    private BorderPane borderPane;
    @FXML
    private JFXButton showCartBtn;
    Parent fxml;
    ServicePanier sp=new ServicePanier();
    private String idSession="001";
    private String idPanier="P"+ idSession;
    @FXML
    private GNCarousel carousel;
    public Panier getPanier() {
        return panier;
    }

    private Panier panier;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("../ouvrage/OuvrageGui.fxml"));
            borderPane.setCenter(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.panier = new Panier(idPanier,idSession);
//        sp.ajouterPanier(panier);

    }
    public void showCart(){
        try {
            fxml = FXMLLoader.load(getClass().getResource("../paniermodern/PanierGui.fxml"));
            Stage panier= new Stage();
            panier.setScene(new Scene(fxml));
            panier.initStyle(StageStyle.UNDECORATED);
            panier.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void closeCart(){
        try {
            fxml = FXMLLoader.load(getClass().getResource("../ouvrage/OuvrageGui.fxml"));
            borderPane.setCenter(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "ClientGui{" +
                "panier=" + panier +
                '}';
    }
}
