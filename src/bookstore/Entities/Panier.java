package bookstore.Entities;

import java.util.ArrayList;

public class Panier {
    private String idPanier;
    private String idSession;
    ArrayList<ElementPanier> panier = new ArrayList<ElementPanier>();

    public Panier(String idPanier,String idSession) {
        this.idPanier=idPanier;
        this.idSession = idSession;
    }

    public String getIdPanier() {
        return idPanier;
    }

    public String getIdSession() {
        return idSession;
    }

    public void setIdPanier(String idPanier) {
        this.idPanier = idPanier;
    }

    public void setIdSession(String idSession) {
        this.idSession = idSession;
    }

    public void validerPanier(){

    }

    @Override
    public String toString() {
        return "Panier{" +
                "idPanier='" + idPanier + '\'' +
                ", idSession='" + idSession + '\'' +
                ", panier=" + panier +
                '}';
    }
}
