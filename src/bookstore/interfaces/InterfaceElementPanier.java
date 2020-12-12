package bookstore.interfaces;

import bookstore.Entities.ElementPanier;
import bookstore.Entities.Ouvrage;
import bookstore.Entities.Panier;

import java.util.List;

public interface InterfaceElementPanier {
    public void ajouterElementPanier(ElementPanier e);
    public void ajouterElementPanier(String id,Ouvrage o,int q,String p);
    public void modifierElementPanier(String id,int q);
    public List afficherElementPanier(Panier p);
    public void supprimerElementPanier(String idElementPanier);
}
