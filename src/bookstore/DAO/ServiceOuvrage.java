
package bookstore.DAO;

import bookstore.Entities.Ouvrage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import bookstore.Utility.Myconnection;


public class ServiceOuvrage implements InterfaceOuvrage {
    
    Myconnection cnx;
    public ServiceOuvrage() 
    {
        cnx=Myconnection.getIstance();
    }
    
    
    

    @Override
    public void ajouterOuvrage(Ouvrage p) {
        
        try {
            
       
            String req= "insert into ouvrage (idOuvrage,isbn,intitule,datesortie,quantite,prix,auteur,categorie) values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ps.setInt(1,p.getIdOuvrage());
            ps.setInt(2,p.getIsbn());
            ps.setString(3,p.getIntitule());
            ps.setString(4,p.getDate());
            ps.setInt(5,p.getQuantite());
            ps.setFloat(6,p.getPrix());
            ps.setString(7,p.getAuteur());
            ps.setString(8,p.getCategorie());
        
            ps.executeUpdate(); 
            System.out.println("ajout effectuee");
        } 
        catch (SQLException ex) {
        System.out.println("erreur ajout");
        }
    
    }

    @Override
    public List <Ouvrage> afficher() {
        List <Ouvrage> l = new ArrayList <Ouvrage> (); 
          try {
            String req1= "select * from ouvrage ";
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
          System.out.println("ISBN "+rs.getInt("isbn") +" INTITULE " + rs.getString ("intitule")+" DATE "+rs.getString("datesortie")
          + "QUANTITE "+ rs.getInt("quantite")+"PRIX"+rs.getString("auteur")+"auteur"+rs.getString("categorie")+"categorie");
         //System.out.println("INTITULE "+rs.getInt("INTITULE")); 
                Ouvrage o = new Ouvrage();
                o.setIdOuvrage(rs.getInt("idOuvrage"));
                o.setIsbn(rs.getInt("isbn"));
                o.setIntitule(rs.getString("intitule"));
                o.setDate(rs.getString("datesortie"));
                o.setQuantite(rs.getInt("quantite"));
                o.setPrix(rs.getFloat("prix"));
                o.setAuteur(rs.getString("auteur"));
                o.setCategorie(rs.getString("categorie"));
                l.add(o);
                
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage ");
        }
        
        return l;
    }
    
    
    
    public void supprimerOuvrage (int isbn)
    {
    
     try {
            String req= "delete from ouvrage where isbn = ?";
            Statement s= cnx.getConnection().createStatement();
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ps.setInt(1,isbn);
            ps.executeUpdate();
            System.out.println("suppression effectue");
    }
      catch (SQLException ex) {
        System.out.println("erreur suppression");
        }
     
    }
    
    public boolean chercherOuvrage (int isbn)
    {
        boolean exist =  false;
        try {
            String req1= "select * from ouvrage where isbn ="+Integer.toString(isbn);
            Statement s= cnx.getConnection().createStatement();
            ResultSet rs = s.executeQuery(req1);
            while(rs.next())
            {
                System.out.println("ISBN "+rs.getInt("ISBN") +"\n  INTITULE  " + rs.getString ("INTITULE")+"\n date de sortie "+rs.getString("datesortie")+"\n quantite "+rs.getInt("quantite")+" \n prix "+rs.getFloat("prix") );
             exist = true;
                System.out.println(exist);
            }}
        catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(exist);
        return exist;
    }
    
    public void modifierOuvrage (int isbn,String intitule)
    {
        try {
        String req = "UPDATE ouvrage SET intitule =? WHERE isbn =?";
            Statement s= cnx.getConnection().createStatement();
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ps.setString(1,intitule);
            ps.setInt(2,isbn);
            ps.executeUpdate();
            System.out.println("modification effectue");
        }
         catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
     public void modifierOuvrage2 (int isbn,String intitule, int quantite,float prix)
    {
        try {
        String req = "UPDATE ouvrage SET intitule =?,quantite=?,prix=? WHERE isbn =?";
            Statement s= cnx.getConnection().createStatement();
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ps.setString(1,intitule);
            ps.setInt(2,quantite);
            ps.setFloat(3,prix);
            ps.setInt(4,isbn);
            ps.executeUpdate();
            System.out.println("modification effectue");
        }
         catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Ouvrage> affichertitle(String s) {
     List <Ouvrage> l = new ArrayList <Ouvrage> (); 
          try {
            String req1= "select * from ouvrage where intitule='"+s+"'";
           
            Statement ss= cnx.getConnection().createStatement();
            ResultSet rs = ss.executeQuery(req1);
            while(rs.next())
            {
                //System.out.println("fi service "+s);
          System.out.println(" fi service  ISBN "+rs.getInt("isbn") +" INTITULE " + rs.getString ("intitule")+" DATE "+rs.getString("datesortie")
          + "QUANTITE "+ rs.getInt("quantite")+"PRIX"+rs.getString("auteur")+"auteur"+rs.getString("categorie")+"categorie");
         //System.out.println("INTITULE "+rs.getInt("INTITULE")); 
                Ouvrage o = new Ouvrage();
                o.setIdOuvrage(rs.getInt("idOuvrage"));
                o.setIsbn(rs.getInt("isbn"));
                o.setIntitule(rs.getString("intitule"));
                o.setDate(rs.getString("datesortie"));
                o.setQuantite(rs.getInt("quantite"));
                o.setPrix(rs.getFloat("prix"));
                o.setAuteur(rs.getString("auteur"));
                o.setCategorie(rs.getString("categorie"));
                l.add(o);
                
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage ");
        }
        
        return l;
        
    }

    @Override
    public List<Ouvrage> afficherauth(String s) {
          List <Ouvrage> l = new ArrayList <Ouvrage> (); 
          try {
            String req1= "select * from ouvrage where auteur='"+s+"'";
           
            Statement ss= cnx.getConnection().createStatement();
            ResultSet rs = ss.executeQuery(req1);
            while(rs.next())
            {
                //System.out.println("fi service "+s);
          System.out.println(" fi service  ISBN "+rs.getInt("isbn") +" INTITULE " + rs.getString ("intitule")+" DATE "+rs.getString("datesortie")
          + "QUANTITE "+ rs.getInt("quantite")+"PRIX"+rs.getString("auteur")+"auteur"+rs.getString("categorie")+"categorie");
         //System.out.println("INTITULE "+rs.getInt("INTITULE")); 
                Ouvrage o = new Ouvrage();
                o.setIdOuvrage(rs.getInt("idOuvrage"));
                o.setIsbn(rs.getInt("isbn"));
                o.setIntitule(rs.getString("intitule"));
                o.setDate(rs.getString("datesortie"));
                o.setQuantite(rs.getInt("quantite"));
                o.setPrix(rs.getFloat("prix"));
                o.setAuteur(rs.getString("auteur"));
                o.setCategorie(rs.getString("categorie"));
                l.add(o);
                
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage ");
        }
        
        return l;
    }
/**************************************************************************************************************/

    @Override
    public List<Ouvrage> afficherisbn(int s) {
        
          List <Ouvrage> l = new ArrayList <Ouvrage> (); 
          try {
            String req1= "select * from ouvrage where isbn="+s;
           
            Statement ss= cnx.getConnection().createStatement();
            ResultSet rs = ss.executeQuery(req1);
            while(rs.next())
            {
                //System.out.println("fi service "+s);
          System.out.println(" fi service  ISBN "+rs.getInt("isbn") +" INTITULE " + rs.getString ("intitule")+" DATE "+rs.getString("datesortie")
          + "QUANTITE "+ rs.getInt("quantite")+"PRIX"+rs.getString("auteur")+"auteur"+rs.getString("categorie")+"categorie");
         //System.out.println("INTITULE "+rs.getInt("INTITULE")); 
                Ouvrage o = new Ouvrage();
                o.setIdOuvrage(rs.getInt("idOuvrage"));
                o.setIsbn(rs.getInt("isbn"));
                o.setIntitule(rs.getString("intitule"));
                o.setDate(rs.getString("datesortie"));
                o.setQuantite(rs.getInt("quantite"));
                o.setPrix(rs.getFloat("prix"));
                o.setAuteur(rs.getString("auteur"));
                o.setCategorie(rs.getString("categorie"));
                l.add(o);
                
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage ");
        }
        
        return l;
    }

    
    @Override
     public List<Ouvrage> afficherdate(String s) {
        
          List <Ouvrage> l = new ArrayList <Ouvrage> (); 
          try {
              
            String req1= "select * from ouvrage where datesortie='"+s+"'";
           
            Statement ss= cnx.getConnection().createStatement();
            ResultSet rs = ss.executeQuery(req1);
            while(rs.next())
            {
                //System.out.println("fi service "+s);
          System.out.println(" fi service  ISBN "+rs.getInt("isbn") +" INTITULE " + rs.getString ("intitule")+" DATE "+rs.getString("datesortie")
          + "QUANTITE "+ rs.getInt("quantite")+"PRIX"+rs.getString("auteur")+"auteur"+rs.getString("categorie")+"categorie");
         //System.out.println("INTITULE "+rs.getInt("INTITULE")); 
                Ouvrage o = new Ouvrage();
                o.setIdOuvrage(rs.getInt("idOuvrage"));
                o.setIsbn(rs.getInt("isbn"));
                o.setIntitule(rs.getString("intitule"));
                o.setDate(rs.getString("datesortie"));
                o.setQuantite(rs.getInt("quantite"));
                o.setPrix(rs.getFloat("prix"));
                o.setAuteur(rs.getString("auteur"));
                o.setCategorie(rs.getString("categorie"));
                l.add(o);
                
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage ");
        }
        
        return l;
    }
    
    @Override
    public List<Ouvrage> affichercat(String s) {
        
          List <Ouvrage> l = new ArrayList <Ouvrage> (); 
          try {
              
            String req1= "select * from ouvrage where categorie='"+s+"'";
            Statement ss= cnx.getConnection().createStatement();
            ResultSet rs = ss.executeQuery(req1);
            while(rs.next())
            {
                //System.out.println("fi service "+s);
          System.out.println(" fi service  ISBN "+rs.getInt("isbn") +" INTITULE " + rs.getString ("intitule")+" DATE "+rs.getString("datesortie")
          + "QUANTITE "+ rs.getInt("quantite")+"PRIX"+rs.getString("auteur")+"auteur"+rs.getString("categorie")+"categorie");
         //System.out.println("INTITULE "+rs.getInt("INTITULE")); 
                Ouvrage o = new Ouvrage();
                o.setIdOuvrage(rs.getInt("idOuvrage"));
                o.setIsbn(rs.getInt("isbn"));
                o.setIntitule(rs.getString("intitule"));
                o.setDate(rs.getString("datesortie"));
                o.setQuantite(rs.getInt("quantite"));
                o.setPrix(rs.getFloat("prix"));
                o.setAuteur(rs.getString("auteur"));
                o.setCategorie(rs.getString("categorie"));
                l.add(o);
                
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage ");
        }
        
        return l;
    }

    @Override
    public List<String> getEmail(List l) {
        
        // List <String> l = new ArrayList <String> (); 
          try {
            String req1= "select email from client";
           
            Statement ss= cnx.getConnection().createStatement();
            ResultSet rs = ss.executeQuery(req1);
            while(rs.next())
            {
          System.out.println("email" + rs.getString ("email"));
       
                 String e;
                 e=rs.getString("email");
               
                l.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage email ");
        }
        return l;
    }
    @Override
    public List getIdauteur (List l)
    {
           try {
            String req1= "select idAuteur from auteur";
           
            Statement ss= cnx.getConnection().createStatement();
            ResultSet rs = ss.executeQuery(req1);
            while(rs.next())
            {
          System.out.println("id auteur " + rs.getString ("idAuteur"));
       
                 String e;
                 e=rs.getString("idAuteur");
               
                l.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("erreur affichage email ");
        }
        return l;
    }
    
    public void envoiDemandeVente (int x, String s,String y, String z)
    {
        try {
            String req= "insert into demandevente (isbn,intitule,datesortie,auteur) values (?,?,?,?)";
            PreparedStatement ps = cnx.getConnection().prepareStatement(req);
            ps.setInt(1,x);
            ps.setString(2,s);
            ps.setString(3,y);
            ps.setString(4,z);
            ps.executeUpdate(); 
            System.out.println("demande effectuee");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOuvrage.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
