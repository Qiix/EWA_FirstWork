



package bookstore.DAO;

import bookstore.Entities.Compte;
import bookstore.Utility.MyCnx;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ServiceCompte implements InterCrud{

    
    MyCnx cnx;
    
    public ServiceCompte()
    {
        cnx= MyCnx.getInstance();
    }
    
    
    @Override
    public ObservableList<Compte> afficher() {
        
        ObservableList<Compte> l = FXCollections.observableArrayList();
       
        String req="select * from client";
        
        try{
            Statement s = (Statement) cnx.getConnexion().createStatement();
            ResultSet rs = s.executeQuery(req);
            Compte c;
                
            while(rs.next()){
                c = new Compte(rs.getInt("id"), rs.getInt("cin"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
                l.add(c);
            }
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }
    
    @Override
    public ObservableList<Compte> searchClient(String x) {
        
        ObservableList<Compte> l = FXCollections.observableArrayList();
        
        
        try{
            String req="select * from client where nom='" + x + "' or prenom ='" + x + "' or email ='" + x + "';";
            Statement s = (Statement) cnx.getConnexion().createStatement();
            ResultSet rs = s.executeQuery(req);
            Compte c;
        
            while(rs.next()){
                c = new Compte(rs.getInt("id"), rs.getInt("cin"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
                l.add(c);
            }
        }
        catch(Exception e){
                 e.printStackTrace();
        }
             
        return l;
    }

    @Override
    public void ajouterCompte(Compte c) {
        
        String req="insert into client (cin,nom,prenom,email) values (?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) cnx.getConnexion().prepareStatement(req);
            ps.setLong(1, c.getCin());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getPrenom());
            ps.setString(4, c.getEmail());
            ps.executeUpdate();
            System.out.println("un compte est ajouté");
        } catch (SQLException ex) {
            System.out.println("erreur au niveau d'ajout");
        }
        
    }

    @Override
    public void supprimerCompte(int id) {
        String req="delete from client where id = ?";
        try {
            PreparedStatement ps = (PreparedStatement) cnx.getConnexion().prepareStatement(req);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("un compte est supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur au niveau de suppression");
        }
    }

    @Override
    public void modifierCompte(Compte c2) {
        
        //String req="update client set cin = ?, nom = ?, prenom = ?, email = ? where id ="+c2.getId()+";";
        try {
            String req="UPDATE client SET cin = ?, nom = ?, prenom = ?, email = ? WHERE id =?;";
            PreparedStatement ps = (PreparedStatement) cnx.getConnexion().prepareStatement(req);
            //ps.setInt(1,c2.getId());
            ps.setInt(1, c2.getCin());
            ps.setString(2, c2.getNom());
            ps.setString(3, c2.getPrenom());
            ps.setString(4, c2.getEmail());
            ps.setInt(5,c2.getId());
            ps.executeUpdate();
            
                System.out.println("un compte est modifié");
            
        } catch (SQLException ex) {
            System.out.println("erreur au niveau de modification");
        }
    }

    @Override
    public void rechercherCompte(String x) {
        try {
            
            String req="select * from client where nom='" + x + "' or prenom ='" + x + "' or email ='" + x + "';";
            
            Statement s = (Statement) cnx.getConnexion().createStatement();
            ResultSet rs = s.executeQuery(req);
            
            while(rs.next())
            {
                System.out.println("id :"+ rs.getInt("id")+" nom : "+rs.getString("nom")+ " prenom : "+rs.getString("prenom")
                +" cin : "+ rs.getLong("cin")+ " email : "+ rs.getString("email"));
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur au niveau de recherche");
        }
    }
    
    @Override
    public void rechercherCompte(int x) {
        
        
        //String req="select * from client where id =57 OR cin=57 " ;
        try {
            String req="select * from client where id =" + x + " OR cin =" + x + " ; ";
            
            Statement s = (Statement) cnx.getConnexion().createStatement();
            ResultSet rs = s.executeQuery(req);
            
            while(rs.next())
            {
                System.out.println("id :"+ rs.getInt("id")+" nom : "+rs.getString("nom")+ " prenom : "+rs.getString("prenom")
                +" cin : "+ rs.getLong("cin")+ " email : "+ rs.getString("email"));
            }
            
        } catch (SQLException ex) {
            System.out.println("erreur au niveau de recherche");
        }
    }

    

    
    
    
        
    
    
}
