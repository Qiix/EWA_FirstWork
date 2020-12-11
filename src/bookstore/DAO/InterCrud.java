/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAO;


import bookstore.Entities.Compte;
import java.util.List;
import javafx.collections.ObservableList;


public interface InterCrud {
    public ObservableList<Compte> afficher();
    public ObservableList<Compte> searchClient(String x);
    public void ajouterCompte(Compte c);
    public void supprimerCompte(int id);
    public void modifierCompte(Compte c2);
    public void rechercherCompte(int x);
    public void rechercherCompte(String x);
    
    //public void validerProfil();
}
