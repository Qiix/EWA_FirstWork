package bookstore.Entities;

import com.jfoenix.controls.JFXButton;
import bookstore.DAO.ServiceElementPanier;

import java.util.Date;


public class Ouvrage {
    private String idOuvrage;
    private String isbnOuvrage;
    private String intituleOuvrage;
    private Date dateSortieOuvrage;
    private Auteur auteur;
    private Categorie categorie;
    private String typeOuvrage;
    private int quantiteOuvrage;
    private float prixOuvrage;
    private String linkOuvrage;



    private String author,dateSortie,prix;

    private JFXButton addToCartBtn;

    public Ouvrage(String idOuvrage, String isbnOuvrage, String intituleOuvrage, Date dateSortieOuvrage, Auteur auteur, Categorie categorie, String typeOuvrage, int quantiteOuvrage, float prixOuvrage, String linkOuvrage) {
        this.idOuvrage = idOuvrage;
        this.isbnOuvrage = isbnOuvrage;
        this.intituleOuvrage = intituleOuvrage;
        this.dateSortieOuvrage = dateSortieOuvrage;
        this.auteur = auteur;
        this.categorie = categorie;
        this.typeOuvrage = typeOuvrage;
        this.quantiteOuvrage = quantiteOuvrage;
        this.prixOuvrage = prixOuvrage;
        this.linkOuvrage = linkOuvrage;
        this.author=this.auteur.getNomAuteur()+" "+this.auteur.getPrenomAuteur();
        this.dateSortie= this.dateSortieOuvrage.toString();
        this.prix = Float.toString(this.prixOuvrage);
        this.addToCartBtn= new JFXButton("ajouter au panier");
        this.addToCartBtn.setOnAction(event ->new ServiceElementPanier().ajouterElementPanier(idOuvrage,this,1,"P001"));
    }

    public String getAuthor() {
        return author;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public String getPrix() {
        return prix;
    }

    public JFXButton getAddToCartBtn() {
        return addToCartBtn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setAddToCartBtn(JFXButton addToCartBtn) {
        this.addToCartBtn = addToCartBtn;
    }

    public String getIdOuvrage() {
        return idOuvrage;
    }

    public String getIsbnOuvrage() {
        return isbnOuvrage;
    }

    public String getIntituleOuvrage() {
        return intituleOuvrage;
    }

    public Date getDateSortieOuvrage() {
        return dateSortieOuvrage;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public String getTypeOuvrage() {
        return typeOuvrage;
    }

    public int getQuantiteOuvrage() {
        return quantiteOuvrage;
    }

    public float getPrixOuvrage() {
        return prixOuvrage;
    }

    public String getLinkOuvrage() {
        return linkOuvrage;
    }

    public void setIdOuvrage(String idOuvrage) {
        this.idOuvrage = idOuvrage;
    }

    public void setIsbnOuvrage(String isbnOuvrage) {
        this.isbnOuvrage = isbnOuvrage;
    }

    public void setIntituleOuvrage(String intituleOuvrage) {
        this.intituleOuvrage = intituleOuvrage;
    }

    public void setDateSortieOuvrage(Date dateSortieOuvrage) {
        this.dateSortieOuvrage = dateSortieOuvrage;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setTypeOuvrage(String typeOuvrage) {
        this.typeOuvrage = typeOuvrage;
    }

    public void setQuantiteOuvrage(int quantiteOuvrage) {
        this.quantiteOuvrage = quantiteOuvrage;
    }

    public void setPrixOuvrage(float prixOuvrage) {
        this.prixOuvrage = prixOuvrage;
    }

    public void setLinkOuvrage(String linkOuvrage) {
        this.linkOuvrage = linkOuvrage;
    }

    @Override
    public String toString() {
        return "\nOuvrage{" +
                "idOuvrage='" + idOuvrage + '\'' +
                "\n isbnOuvrage='" + isbnOuvrage + '\'' +
                "\n intituleOuvrage='" + intituleOuvrage + '\'' +
                "\n dateSortieOuvrage=" + dateSortieOuvrage +
                "\n auteur=" + auteur +
                "\n categorie=" + categorie +
                "\n typeOuvrage='" + typeOuvrage + '\'' +
                "\n quantiteOuvrage=" + quantiteOuvrage +
                "\n prixOuvrage=" + prixOuvrage +
                "\n linkOuvrage='" + linkOuvrage + '\'' +
                "}\n";
    }
}
