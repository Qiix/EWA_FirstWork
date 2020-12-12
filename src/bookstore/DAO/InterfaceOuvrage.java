/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAO;

import bookstore.Entities.Ouvrage;
import java.util.List;
/**
 *
 * @author MY HP
 */
public interface InterfaceOuvrage {
    public void ajouterOuvrage(Ouvrage p);
    public List <Ouvrage> afficher();
    public List <Ouvrage> affichertitle(String s);
    public List <Ouvrage> afficherauth(String s);
    public List<Ouvrage> afficherisbn(int s);
    public List<Ouvrage> affichercat(String s);
    public List<Ouvrage> afficherdate(String s);
    public List <String> getEmail(List l); 
    public List<String> getIdauteur (List l);
}
