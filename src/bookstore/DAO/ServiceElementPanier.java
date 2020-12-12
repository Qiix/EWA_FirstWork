package bookstore.DAO;

import bookstore.Entities.ElementPanier;
import bookstore.Entities.Ouvrage;
import bookstore.Entities.Panier;
import bookstore.interfaces.InterfaceElementPanier;
import bookstore.Utility.MyConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ServiceElementPanier implements InterfaceElementPanier {
    MyConnection connexion;

    public ServiceElementPanier() {
        connexion=MyConnection.getInstance();
    }

    @Override
    public void ajouterElementPanier(ElementPanier e) {
        String req ="INSERT INTO ELEMENTPANIER (idElementPanier,idPanier,idOuvrage," +
                "intituleElementPanier,prixElementPanier,typeElementPanier," +
                "quantiteElementPanier) " +
                "Values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=connexion.getConnexion().prepareStatement(req);
            ps.setString(1,e.getIdElementPanier());
            ps.setString(2,e.getIdPanier());
            ps.setString(3,e.getIdOuvrage());
            ps.setString(4,e.getIntituleEelementPanie());
            ps.setFloat(5,e.getPrixElementPanier());
            ps.setString(6,e.getTypeElementPanier());
            ps.setInt(7,e.getQuantiteElementPanier());


            ps.executeUpdate();

            System.out.println("ElementPanier Ajouté");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void ajouterElementPanier(String id,Ouvrage o,int q,String p) {
        ajouterElementPanier(new ElementPanier(id,p,
                o.getIdOuvrage(),o.getIntituleOuvrage(),o.getPrixOuvrage(),
                o.getTypeOuvrage(),q));
    }

    @Override
    public void modifierElementPanier(String id,int q) {
        String req ="UPDATE ELEMENTPANIER SET quantiteElementPanier="+q+"where idElementPanier=" +
                id+"";
        try {
            PreparedStatement ps=connexion.getConnexion().prepareStatement(req);

            ps.executeUpdate();

            System.out.println("ElementPanier Modifié");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List afficherElementPanier(Panier p) {
        return null;
    }

    @Override
    public void supprimerElementPanier(String idElementPanier) {
        String req ="DELETE FROM elementPanier WHERE (idElementPanier= ?)";
        try {
            PreparedStatement ps=connexion.getConnexion().prepareStatement(req);
            ps.setString(1,idElementPanier);
            ps.executeUpdate();
            System.out.println("Element Supprimé du Panier");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
