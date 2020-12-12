package bookstore.DAO;

import bookstore.Entities.*;
import bookstore.Utility.MyConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ServiceElementCommande {
    MyConnection connexion;

    public ServiceElementCommande() {
        connexion = MyConnection.getInstance();
    }


    public void ajouterElementCommande(ElementCommande e) {
        String req ="INSERT INTO ELEMENTCOMMANDE (idElementCommande,idCommande,idOuvrage," +
                "prixElementCommande,quantiteElementCommande,typeElementCommande)" +
                "Values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps=connexion.getConnexion().prepareStatement(req);
            ps.setString(1,e.getIdElementCommande());
            ps.setString(2,e.getIdCommande());
            ps.setString(3,e.getIdOuvrage());
            ps.setFloat(4,e.getPrixElementCommande());
            ps.setInt(5,e.getQuantiteElementCommande());
            ps.setString(6,e.getTypeElementCommande());

            ps.executeUpdate();

            System.out.println("ElementPanier Ajouté");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void ajouterElementCommande(ElementPanier e, String idCommande) {
        ajouterElementCommande(new ElementCommande(e.getIdElementPanier(),
                idCommande,e.getIdOuvrage(),e.getPrixElementPanier(),e.getQuantiteElementPanier(),e.getTypeElementPanier()));
    }

    public void ajouterElementCommande(List<ElementPanier> l, String idCommande) {
        for (ElementPanier e : l)
        ajouterElementCommande(new ElementCommande(e.getIdElementPanier(),
                idCommande,e.getIdOuvrage(),e.getPrixElementPanier(),e.getQuantiteElementPanier(),e.getTypeElementPanier()));
    }


}
