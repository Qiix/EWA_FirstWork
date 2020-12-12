package bookstore.Entities;

import java.util.Date;

public class Commande {
    private String idCommande;
    private Date dateCommande;
    private float prixCommande;
    private String adresseCommande;

    public Commande(String idCommande, Date dateCommande, float prixCommande, String adresseCommande) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.prixCommande = prixCommande;
        this.adresseCommande = adresseCommande;
    }

    public Commande(String idCommande, float prixCommande, String adresseCommande) {

        this.idCommande = idCommande;
        this.dateCommande = new Date(System.currentTimeMillis());
        this.prixCommande = prixCommande;
        this.adresseCommande = adresseCommande;
    }

    public String getIdCommande() {
        return idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public float getPrixCommande() {
        return prixCommande;
    }

    public String getAdresseCommande() {
        return adresseCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public void setPrixCommande(float prixCommande) {
        this.prixCommande = prixCommande;
    }

    public void setAdresseCommande(String adresseCommande) {
        this.adresseCommande = adresseCommande;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "idCommande='" + idCommande + '\'' +
                ", dateCommande=" + dateCommande +
                ", prixCommande=" + prixCommande +
                ", adresseCommande='" + adresseCommande + '\'' +
                '}';
    }
}
