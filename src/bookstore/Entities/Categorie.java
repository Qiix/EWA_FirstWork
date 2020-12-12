package bookstore.Entities;

public class Categorie {
    private String idCategorie;
    private String nomCategorie;

    public Categorie(String idCategorie, String nomCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
    }

    public String getIdCategorie() {
        return idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "idCategorie='" + idCategorie + '\'' +
                ", nomCategorie='" + nomCategorie + '\'' +
                '}';
    }
}
