package bookstore.Entities;

public class ElementCommande {
    private String idElementCommande;
    private String idCommande;
    private String idOuvrage;
    private Float prixElementCommande;
    private int quantiteElementCommande;
    private String typeElementCommande;

    public ElementCommande(String idElementCommande, String idCommande, String idOuvrage, Float prixElementCommande, int quantiteElementCommande, String typeElementCommande) {
        this.idElementCommande = idElementCommande;
        this.idCommande = idCommande;
        this.idOuvrage = idOuvrage;
        this.prixElementCommande = prixElementCommande;
        this.quantiteElementCommande = quantiteElementCommande;
        this.typeElementCommande = typeElementCommande;
    }

    public String getIdElementCommande() {
        return idElementCommande;
    }

    public String getIdCommande() {
        return idCommande;
    }

    public String getIdOuvrage() {
        return idOuvrage;
    }

    public Float getPrixElementCommande() {
        return prixElementCommande;
    }

    public int getQuantiteElementCommande() {
        return quantiteElementCommande;
    }

    public String getTypeElementCommande() {
        return typeElementCommande;
    }

    public void setIdElementCommande(String idElementCommande) {
        this.idElementCommande = idElementCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    public void setIdOuvrage(String idOuvrage) {
        this.idOuvrage = idOuvrage;
    }

    public void setPrixElementCommande(Float prixElementCommande) {
        this.prixElementCommande = prixElementCommande;
    }

    public void setQuantiteElementCommande(int quantiteElementCommande) {
        this.quantiteElementCommande = quantiteElementCommande;
    }

    public void setTypeElementCommande(String typeElementCommande) {
        this.typeElementCommande = typeElementCommande;
    }

    @Override
    public String toString() {
        return "ElementCommande{" +
                "idElementCommande='" + idElementCommande + '\'' +
                ", idCommande='" + idCommande + '\'' +
                ", idOuvrage='" + idOuvrage + '\'' +
                ", prixElementCommande=" + prixElementCommande +
                ", quantiteElementCommande=" + quantiteElementCommande +
                ", typeElementCommande='" + typeElementCommande + '\'' +
                '}';
    }
}
