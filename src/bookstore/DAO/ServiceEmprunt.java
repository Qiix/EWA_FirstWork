
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.DAO;

import bookstore.Entities.Emprunt;
import bookstore.Entities.Client;
import bookstore.DAO.InterfaceEmprunt;
import bookstore.Utility.Myconnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import bookstore.controllers.FXMLDocumentController;

/**
 *
 * @author lenovo
 */
public class ServiceEmprunt implements InterfaceEmprunt{
Myconnexion cnx;

public ServiceEmprunt()
{
    cnx= Myconnexion.getInstance();
    //Une instance de la classe connexion
}
    @Override
    public void ajouterEmprunt(Emprunt e) {
    try {
       //DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        String req= "insert into emprunt (icClient,nomEmp,dateDebut,dateFin) values(?,?,?,?)";
        PreparedStatement ps= cnx.getConnexion().prepareStatement(req);
        ps.setInt(1,e.getIcClient());
        ps.setString(2,e.getNomEmp());
        ps.setDate(3,new java.sql.Date(e.getDateDebut().getTime()));
        ps.setDate(4,new java.sql.Date(e.getDateFin().getTime()));
        ps.execute();
         System.out.println("Sucess add!");
    } catch (SQLException ex) {
        System.out.println(ex);
    }
    }
    
    public void supprimerEmprunt(int id) {
    try {
        String req= "Delete from emprunt where id="+id+";";
        PreparedStatement ps = cnx.getConnexion().prepareStatement(req);
        ps.executeUpdate(req);
        System.out.println("Sucess delete!");
    } catch (SQLException ex) {
        System.out.println("Error !!");
    }
    }

    @Override
    public List<Client> afficherClient() {
      List<Client> l = new ArrayList();
    try {
               String req= "select * from client";
        Statement s = cnx.getConnexion().createStatement();
        ResultSet rs = s.executeQuery(req);
        while(rs.next())
        { 
        Client c = new Client();
        c.setIdClient(rs.getInt("idClient"));
        c.setNomClient(rs.getString("nomClient"));
        l.add(c);        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
    return l;
    }
     public void afficherClientt(){
      
      try {
          String req= "select * from client";
        Statement s;

        s = cnx.getConnexion().createStatement();
         ResultSet rs = s.executeQuery(req);
        while(rs.next())
        { 
            System.out.println(rs.getString("nomClient"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServiceEmprunt.class.getName()).log(Level.SEVERE, null, ex);
    }
       
      
    }
    public void rechercherEmprunt(int id) {
    try {
         String req= "select * from emprunt where id="+id+";";
        Statement s = cnx.getConnexion().createStatement();
        ResultSet rs = s.executeQuery(req);
        while(rs.next())
        { 
            System.out.println("Identifiant emprunt : "+rs.getInt("id")+", Identifiant client : "+rs.getInt("icClient")+", Nom emprunt : "+rs.getString("nomEmp")+", Date de Debut : "+rs.getDate("dateDebut")+", Date de fin : "+rs.getDate("Datefin"));
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
    }

   public List<Emprunt> rechercherEmp(String nomEmp) {
    List<Emprunt> l = new ArrayList();
    try {
         String req= "select * from emprunt where id="+nomEmp+";";
        Statement s = cnx.getConnexion().createStatement();
        ResultSet rs = s.executeQuery(req);
        while(rs.next())
        { 
        Emprunt e = new Emprunt();
        e.setNomEmp(rs.getString("nomEmp"));
        e.setIcClient(rs.getInt("icClient"));
        e.setNomEmp(rs.getString("nomEmp"));
        e.setDateDebut(rs.getDate("dateDebut"));
        e.setDateFin(rs.getDate("DateFin"));
        l.add(e);        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
    return l;
    }


    @Override
    public List<Emprunt>afficherEmprunt() {
        List<Emprunt> l = new ArrayList();
    try {
         String req= "select * from emprunt";
        Statement s = cnx.getConnexion().createStatement();
        ResultSet rs = s.executeQuery(req);
        while(rs.next())
        { 
        Emprunt e = new Emprunt();
        e.setId(rs.getInt("id"));
        e.setIcClient(rs.getInt("icClient"));
        e.setNomEmp(rs.getString("nomEmp"));
        e.setDateDebut(rs.getDate("dateDebut"));
        e.setDateFin(rs.getDate("DateFin"));
        l.add(e);
        
        }
    } catch (SQLException ex) {
        System.out.println("Error !!");
    }
    return l;
    }

    
    public void modifierEmprunt(Emprunt e)
    {
    try {
            String req ="update emprunt SET nomEmp=(?),dateDebut=(?),dateFin=(?) where id=?;";
            PreparedStatement ps = cnx.getConnexion().prepareStatement(req);
            ps.setString(1,e.getNomEmp());
            ps.setDate(2,new java.sql.Date(e.getDateDebut().getTime()));
            ps.setDate(3,new java.sql.Date(e.getDateFin().getTime()));
            ps.setInt(4,e.getId());
            ps.executeUpdate();
            int rowsUpdated = ps.executeUpdate();
     if (rowsUpdated > 0) {
                System.out.println("un compte est modifié");
     }
        } catch (SQLException ex) {
            System.out.println("erreur au niveau de modification");
        }

   
    }
}
