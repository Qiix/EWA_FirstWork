package bookstore.DAO;

import bookstore.Entities.Commande;
import bookstore.Entities.ElementCommande;
import bookstore.Entities.ElementPanier;
import bookstore.Entities.Panier;
import bookstore.Utility.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceCommande {
    MyConnection connexion;

    public ServiceCommande() {
        connexion = MyConnection.getInstance();
    }


    public void ajouterCommande(Commande c) {
        String req ="INSERT INTO Commande (idCommande,dateCommande,prixCommande,adresseCommande)"+
                "Values (?,?,?,?)";
        try {
            PreparedStatement ps=connexion.getConnexion().prepareStatement(req);
            ps.setString(1,c.getIdCommande());
            ps.setDate(2,new Date(c.getDateCommande().getTime()));
            ps.setFloat(3,c.getPrixCommande());
            ps.setString(4,c.getAdresseCommande());
            ps.executeUpdate();

            System.out.println("Commande Ajoutée");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void ajouterCommande(Panier p,String addresse){
        float prix=0;
        ServicePanier sp = new ServicePanier();
        for (ElementPanier e :sp.afficherPanier(p.getIdPanier())){
            prix+=e.getPrixElementPanier() *e.getQuantiteElementPanier();
        }
        ajouterCommande(new Commande(p.getIdPanier(),prix,addresse));
    }

    public List afficherCommandes() {
        String req="SELECT * FROM COMMANDE";
        ArrayList<Commande> list = new ArrayList<Commande>();
        try {
            Statement s = connexion.getConnexion().createStatement();
            ResultSet rs =s.executeQuery(req);
            while (rs.next()){
                list.add(new Commande(rs.getString("idCommande"),
                        rs.getDate("dateCommande"),
                        rs.getFloat("prixCommande"),
                        rs.getString("adresseCommande")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public float getPrixCommande (String idCommande){
        float prix;
        String req="SELECT prixCommande FROM Commande where idCommande= "+"'"+idCommande+"'";
        try {
            Statement s = connexion.getConnexion().createStatement();
            ResultSet rs =s.executeQuery(req);
            if (rs.next()) {
                prix = rs.getFloat("prixCommande");
                return prix ;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0f ;
    }
    public List afficherCommande(String idCommande) {
        String req="SELECT * FROM ELEMENTCommande where idCommande= "+"'"+idCommande+"'";
        ArrayList<ElementCommande> list = new ArrayList<ElementCommande>();
        try {
            Statement s = connexion.getConnexion().createStatement();
            ResultSet rs =s.executeQuery(req);
            while (rs.next()){
                list.add(new ElementCommande(rs.getString("idElementCommande"),
                        rs.getString("idCommande"),
                        rs.getString("idOuvrage"),
                        rs.getFloat("prixElementCommande"),
                        rs.getInt("quantiteElementCommande"),
                        rs.getString("typeElementCommande")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }

    }
