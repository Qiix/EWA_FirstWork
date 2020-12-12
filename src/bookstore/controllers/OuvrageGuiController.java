package bookstore.controllers;

import com.jfoenix.controls.JFXButton;
import bookstore.Entities.Ouvrage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import bookstore.DAO.ServiceOuvrage;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OuvrageGuiController implements Initializable {
    @FXML
    public TableView<Ouvrage> table ;
    @FXML
    public TableColumn<Ouvrage,String> col_intitule;
    @FXML
    public TableColumn<Ouvrage,String> col_isbn;
    @FXML
    public TableColumn<Ouvrage,String> col_auteur;
    @FXML
    public TableColumn<Ouvrage,String> col_dateSortie;
    @FXML
    public TableColumn<Ouvrage,String> col_prix;
    @FXML
    public TableColumn<Ouvrage,String> col_type;
    @FXML
    public TableColumn<Ouvrage, JFXButton> col_btns;
    public Button showCartBtn;
    ObservableList<Ouvrage> oblist = FXCollections.observableArrayList();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ServiceOuvrage so = new ServiceOuvrage();
        List<Ouvrage> listOuvrages=so.afficherOuvrages();
        for (Ouvrage o : listOuvrages)
            oblist.add(o);



        col_intitule.setCellValueFactory(new PropertyValueFactory<>("intituleOuvrage"));
        col_isbn.setCellValueFactory(new PropertyValueFactory<>("isbnOuvrage"));
        col_auteur.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_dateSortie.setCellValueFactory(new PropertyValueFactory<>("dateSortie"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("typeOuvrage"));
        col_btns.setCellValueFactory(new PropertyValueFactory<>("addToCartBtn"));

        table.setItems(oblist);
    }

    public static class OuvrageModel {
        String intitule,
                isbn,
                auteur,
                dateSortie,
                prix,
                type;
        JFXButton addToCartBtn;

        public OuvrageModel(String intitule, String isbn, String auteur, String dateSortie, String prix, String type) {
            this.intitule = intitule;
            this.isbn = isbn;
            this.auteur = auteur;
            this.dateSortie = dateSortie;
            this.prix = prix;
            this.type = type;
            this.addToCartBtn = new JFXButton("Ajout au Panier");
    //        addToCartBtn.setOnAction(event -> new ServiceElementPanier().ajouterElementPanier());
        }

        public void setIntitule(String intitule) {
            this.intitule = intitule;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public void setAuteur(String auteur) {
            this.auteur = auteur;
        }

        public void setDateSortie(String dateSortie) {
            this.dateSortie = dateSortie;
        }

        public void setPrix(String prix) {
            this.prix = prix;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setAddToCartBtn(JFXButton addToCartBtn) {
            this.addToCartBtn = addToCartBtn;
        }

        public String getIntitule() {
            return intitule;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getAuteur() {
            return auteur;
        }

        public String getDateSortie() {
            return dateSortie;
        }

        public String getPrix() {
            return prix;
        }

        public String getType() {
            return type;
        }

        public JFXButton getAddToCartBtn() {
            return addToCartBtn;
        }
    }
}
