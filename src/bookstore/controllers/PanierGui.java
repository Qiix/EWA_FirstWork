package bookstore.controllers;

import com.jfoenix.controls.*;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import bookstore.Entities.ElementPanier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import bookstore.DAO.ServiceElementPanier;
import bookstore.DAO.ServicePanier;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PanierGui implements Initializable {

    @FXML
    private TableView<PanierModel> table =new TableView<>();

    @FXML
    private TableColumn<PanierModel, String> intituleColumn = new TableColumn<>();

    @FXML
    private TableColumn<PanierModel, String> prixColumn= new TableColumn<>();

    @FXML
    private TableColumn<PanierModel, Spinner<Integer>> quantiteColumn= new TableColumn<>();

    @FXML
    private TableColumn<PanierModel, String> typeColumn= new TableColumn<>();

    @FXML
    private TableColumn<PanierModel, JFXButton> deleteBtnColumn= new TableColumn<>();

    ObservableList<PanierModel> listView =FXCollections.observableArrayList();

    @FXML
    private JFXButton close_btn;
    @FXML
    private JFXButton confirmerBtn;
    @FXML
    private Label prixTotalLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ServicePanier sp = new ServicePanier();
        List<ElementPanier> panier = sp.afficherPanier("P001");

        for (ElementPanier e :panier){
            listView.add(new PanierModel(e.getIdElementPanier(),e.getIntituleEelementPanie(),e.getPrixElementPanier(),
                    e.getQuantiteElementPanier(),e.getTypeElementPanier()));
        }
        System.out.println(listView);
        intituleColumn.setCellValueFactory(new PropertyValueFactory<>("intitule"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("quantiteSpinner"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        deleteBtnColumn.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));
        table.setItems(listView);
        System.out.println(table.getItems());
        prixTotalLabel.setText(sp.calculerPrixTotal("P001")+" TND");
    }
    public void closePanier(){

        close_btn.getScene().getWindow().hide();
    }

    public void checkout(){
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("../../bookstore/fxml/checkoutGui.fxml"));
            Stage panier= new Stage();
            panier.setScene(new Scene(fxml));
            panier.initStyle(StageStyle.UNDECORATED);
            confirmerBtn.getScene().getWindow().hide();
            panier.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public class PanierModel  {
        private String id;
        String intitule;
        String prix;
        String quantite;
        Spinner<Integer> quantiteSpinner = new Spinner<>();
        String type;
        JFXButton deleteBtn;

        public PanierModel(String id,String intitule, float prix, int quantite, String type) {
            super();
            this.id = id;
            this.intitule = intitule;
            this.prix = prix + " TND";
            this.quantite= String.valueOf(quantite);
            this.quantiteSpinner.getStylesheets().add("bookstore/css/Spinner.css");
            int max=10;
            if (type.contentEquals("Emprunt")){
                this.quantiteSpinner.setEditable(false);
                max=1;
                this.quantiteSpinner.setOnMouseClicked(event -> {
                    ServiceElementPanier sep= new ServiceElementPanier();
                    sep.modifierElementPanier(this.id,this.quantiteSpinner.getValue());
                });
            }
            this.quantiteSpinner.setValueFactory(
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(1, max, quantite));

            this.type = type;
            this.deleteBtn = new JFXButton();
            this.deleteBtn.setGraphic(new FontAwesomeIconView(FontAwesomeIcon.TRASH));
            this.deleteBtn.setText(null);
            this.deleteBtn.setStyle("-fx-graphic-size: 18");
            this.deleteBtn.setOnAction(event -> {
                ServiceElementPanier sp= new ServiceElementPanier();
                sp.supprimerElementPanier(this.id);
                table.getItems().remove(this);
            });

        }



        public String getIntitule() {
            return intitule;
        }

        public String getPrix() {
            return prix;
        }

        public String getQuantite() {
            return quantite;
        }

        public Spinner<Integer> getQuantiteSpinner() {
            return quantiteSpinner;
        }

        public String getType() {
            return type;
        }

        public Button getDeleteBtn() {
            return deleteBtn;
        }



        public void setIntitule(String intitule) {
            this.intitule = intitule;
        }

        public void setPrix(String prix) {
            this.prix = prix;
        }

        public void setQuantite(String quantite) {
            this.quantite = quantite;
        }

        public void setQuantiteSpinner(Spinner<Integer> quantiteSpinner) {
            this.quantiteSpinner = quantiteSpinner;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setDeleteBtn(JFXButton deleteBtn) {
            this.deleteBtn = deleteBtn;
        }
    }

    public static class PanierGuiModel {

    }
}