/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAO;

import bookstore.Entities.Emprunt;
import bookstore.Entities.Client;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author lenovo
 */
public interface InterfaceEmprunt {
    public void ajouterEmprunt(Emprunt e);
    public List<Emprunt> afficherEmprunt();
    public void supprimerEmprunt(int id);
    public void modifierEmprunt(Emprunt e);
    public void rechercherEmprunt(int id);
    public List<Emprunt> rechercherEmp(String nomEmp);
    public List<Client>afficherClient();
}
