package bookstore.Entities;

public class Auteur {
    private String idAuteur;
    private String nomAuteur;
    private String prenomAuteur;
    private String bioAuteur;

    public Auteur(String idAuteur, String nomAuteur, String prenomAuteur, String bioAuteur) {
        this.idAuteur = idAuteur;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
        this.bioAuteur = bioAuteur;
    }

    public String getIdAuteur() {
        return idAuteur;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public String getPrenomAuteur() {
        return prenomAuteur;
    }

    public String getBioAuteur() {
        return bioAuteur;
    }

    public void setIdAuteur(String idAuteur) {
        this.idAuteur = idAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public void setPrenomAuteur(String prenomAuteur) {
        this.prenomAuteur = prenomAuteur;
    }

    public void setBioAuteur(String bioAuteur) {
        this.bioAuteur = bioAuteur;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "idAuteur='" + idAuteur + '\'' +
                ", nomAuteur='" + nomAuteur + '\'' +
                ", prenomAuteur='" + prenomAuteur + '\'' +
                ", bioAuteur='" + bioAuteur + '\'' +
                '}';
    }
}
