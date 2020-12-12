package bookstore.Entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class ElementPanier extends RecursiveTreeObject<ElementPanier> {

    private String idElementPanier;
    private String idPanier;
    private String idOuvrage;
    private String intituleEelementPanie;
    private float prixElementPanier;
    private String typeElementPanier;
    private int quantiteElementPanier;


    public ElementPanier(String idElementPanier,String idPanier, String idOuvrage, String intituleEelementPanie, float prixElementPanier, String typeElementPanier, int quantiteElementPanier) {
        super();
        this.idElementPanier = idElementPanier;
        this.idPanier = idPanier;
        this.idOuvrage = idOuvrage;
        this.intituleEelementPanie = intituleEelementPanie;
        this.prixElementPanier = prixElementPanier;
        this.typeElementPanier = typeElementPanier;
        this.quantiteElementPanier = quantiteElementPanier;
    }



    public String getIdElementPanier() {
        return idElementPanier;
    }

    public String getIdPanier() {
        return idPanier;
    }

    public String getIdOuvrage() {
        return idOuvrage;
    }

    public String getIntituleEelementPanie() {
        return intituleEelementPanie;
    }

    public float getPrixElementPanier() {
        return prixElementPanier;
    }

    public int getQuantiteElementPanier() {
        return quantiteElementPanier;
    }

    public void setIdElementPanier(String idElementPanier) {
        this.idElementPanier = idElementPanier;
    }

    public void setIdPanier(String idPanier) {
        this.idPanier = idPanier;
    }

    public void setIdOuvrage(String idOuvrage) {
        this.idOuvrage = idOuvrage;
    }

    public void setIntituleEelementPanie(String intituleEelementPanie) {
        this.intituleEelementPanie = intituleEelementPanie;
    }

    public void setPrixElementPanier(float prixElementPanier) {
        this.prixElementPanier = prixElementPanier;
    }

    public void setQuantiteElementPanier(int quantiteElementPanier) {
        this.quantiteElementPanier = quantiteElementPanier;
    }

    public String getTypeElementPanier() {
        return typeElementPanier;
    }

    public void setTypeElementPanier(String typeElementPanier) {
        this.typeElementPanier = typeElementPanier;
    }










    @Override
    public String toString() {
        return "ElementPanier{" +
                "idElementPanier='" + idElementPanier + '\'' +
                ", idPanier='" + idPanier + '\'' +
                ", idOuvrage='" + idOuvrage + '\'' +
                ", intituleEelementPanie='" + intituleEelementPanie + '\'' +
                ", prixElementPanier=" + prixElementPanier +
                ", typeElementPanier='" + typeElementPanier + '\'' +
                ", quantiteElementPanier=" + quantiteElementPanier +
                '}';
    }
}

