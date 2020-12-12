package bookstore.interfaces;

import bookstore.Entities.Panier;

import java.util.List;


public interface InterfacePanier {
public void ajouterPanier(Panier p);
public void modifierPanier(Panier p1,Panier p2);
public List afficherPanier(String panierId);
public List afficherPaniers();
public void supprimerPanier(Panier e);
public void viderPanier(Panier p);
public String validerPanier(Panier p,String adresse);
}