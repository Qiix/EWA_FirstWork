package bookstore.controllers;

import com.gn.GNCarousel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import bookstore.Entities.ElementPanier;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import bookstore.DAO.ServicePanier;
import outerService.ServiceSms;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CheckoutGui implements Initializable {
    String idCommande;
    @FXML
    private JFXTextField phoneTF;

    @FXML
    private GNCarousel carousel ;

    @FXML
    private JFXButton confirmBtn;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private Label priceLabel;


    public void cancel(){
        cancelBtn.getScene().getWindow().hide();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ServicePanier sp= new ServicePanier();
        carousel.setItems(createItems());
        priceLabel.setText(sp.calculerPrixTotal("P001")+" TND");
        phoneTF.textProperty().addListener(new ChangeListener<String>() {
            //controle de saise (accepte seulement les chiffres
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    phoneTF.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    private ObservableList<Node> createItems(){
        ServicePanier sp = new ServicePanier();
        List<ElementPanier> panier = sp.afficherPanier("P001");
        ObservableList<Node> listView = FXCollections.observableArrayList();
        for (ElementPanier e :panier){

            Label title = new Label(e.getIntituleEelementPanie(), new FontAwesomeIconView(FontAwesomeIcon.BOOK));
            title.setStyle("-fx-text-fill : white;");
            title.setStyle("-fx-font-size: 18");
            Label price= new Label(String.valueOf(e.getPrixElementPanier()) + " TND");
            price.setStyle("-fx-text-fill : white;");
            VBox v1 = new VBox(title,price);
            v1.setAlignment(Pos.CENTER);
            v1.setStyle("-fx-background-color : #48CFAD;");
            listView.add(v1);
        }
        return listView;
    }


    public void sendSms() {
        try {
            ServiceSms.sendSms(phoneTF.getText());
            confirmBtn.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
