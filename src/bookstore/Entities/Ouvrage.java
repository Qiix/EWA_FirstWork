
package bookstore.Entities;



public class Ouvrage {
    
  
    
    private int idOuvrage;
    private int isbn;
    private String intitule;
    private String date;
    private int quantite;
    private float prix;
    private String  categorie;
    private String auteur;
   // private String  type;*/

    public Ouvrage() {
    }

    public Ouvrage(int idOuvrage, int isbn, String intitule, String date, int quantite, float prix, String categorie, String auteur) {
        this.idOuvrage = idOuvrage;
        this.isbn = isbn;
        this.intitule = intitule;
        this.date = date;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie = categorie;
        this.auteur = auteur;
    }

    public int getIdOuvrage() {
        return idOuvrage;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getIntitule() {
        return intitule;
    }

    public String getDate() {
        return date;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getPrix() {
        return prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setIdOuvrage(int idOuvrage) {
        this.idOuvrage = idOuvrage;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Ouvrage{" + "idOuvrage=" + idOuvrage + ", isbn=" + isbn + ", intitule=" + intitule + '}';
    }

    
  
    
    
}
