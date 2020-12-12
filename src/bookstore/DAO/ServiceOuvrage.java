package bookstore.DAO;

import bookstore.Entities.Auteur;
import bookstore.Entities.Categorie;
import bookstore.Entities.Ouvrage;
import bookstore.Utility.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServiceOuvrage {
    private MyConnection connexion;
    HashMap<String, Ouvrage> ouvrages;

    public ServiceOuvrage(){
        ouvrages= new HashMap<>();
        connexion=MyConnection.getInstance();
    }

    public void ajouterOuvrage(Ouvrage o){
        if (this.ouvrages.containsKey(o.getIdOuvrage())) {
            System.out.println("Ouvrage déja existant! Veuillez le modifier.");
        } else {
            String req = "INSERT INTO OUVRAGES (idOuvrage,IsbnOuvrage,IntituleOuvrage,DateSortieOuvrage," +
                    "idAuteur,idCategorie,typeOuvrage,quantiteOuvrage,prixOuvrage,linkOuvrage)  " +
                    "Values (?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = connexion.getConnexion().prepareStatement(req);
                ps.setString(1, o.getIdOuvrage());
                ps.setString(2, o.getIsbnOuvrage());
                ps.setString(3, o.getIntituleOuvrage());
                ps.setDate(4, new Date(o.getDateSortieOuvrage().getTime()));
                ps.setString(5, o.getAuteur().getIdAuteur());
                ps.setString(6, o.getCategorie().getIdCategorie());
                ps.setString(7, o.getTypeOuvrage());
                ps.setInt(8, o.getQuantiteOuvrage());
                ps.setFloat(9, o.getPrixOuvrage());
                ps.setString(10, o.getLinkOuvrage());

                ps.executeUpdate();
                ouvrages.put(o.getIdOuvrage(), o);
                System.out.println("Ouvrage Ajouté");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public List afficherOuvrages(){
        String req="SELECT * FROM OUVRAGES";
        String idOuvrage,isbnOuvrage,intituleOuvrage,typeOuvrage,linkOuvrage;
        java.util.Date dateSortieOuvrage;
        Auteur auteur;
        Categorie categorie;
        int quantiteOuvrage;
        float prixOuvrage;
        ArrayList<Ouvrage> list = new ArrayList<Ouvrage>();
            try {
            Statement s = connexion.getConnexion().createStatement();

            ResultSet rs =s.executeQuery(req);
            while (rs.next()){
                idOuvrage= rs.getString("idOuvrage");
                isbnOuvrage = rs.getString("isbnOuvrage");
                intituleOuvrage = rs.getString("intituleOuvrage");
                dateSortieOuvrage = rs.getDate("dateSortieOuvrage");
                typeOuvrage = rs.getString("typeOuvrage");
                quantiteOuvrage = rs.getInt("quantiteOuvrage");
                prixOuvrage = rs.getFloat("prixOuvrage");
                linkOuvrage = rs.getString("linkOuvrage");
                ResultSet rsA=connexion.getConnexion().createStatement().executeQuery("Select * from Auteurs where idAuteur='"+rs.getString("idAuteur")+"'");
                ResultSet rsC=connexion.getConnexion().createStatement().executeQuery("Select * from Categories where idCategorie='"+rs.getString("idCategorie")+"'");
                    rsA.next();
                    auteur =new Auteur(rsA.getString("idAuteur"),rsA.getString("nomAuteur"),rsA.getString("prenomAuteur"),rsA.getString("bioAuteur")) ;

                    rsC.next();
                    categorie = new Categorie(rsC.getString("idCategorie"),rsC.getString("nomCategorie"));


                list.add(new Ouvrage(idOuvrage,isbnOuvrage,intituleOuvrage,
                        dateSortieOuvrage,auteur,categorie,typeOuvrage,
                        quantiteOuvrage,prixOuvrage,linkOuvrage));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            return list;
    }
}

