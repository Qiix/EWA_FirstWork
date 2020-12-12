package bookstore.DAO;

import bookstore.Entities.ElementPanier;
import bookstore.Entities.Panier;
import bookstore.interfaces.InterfacePanier;
import bookstore.Utility.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServicePanier implements InterfacePanier {
    private MyConnection connexion;

    public ServicePanier (){
        connexion=MyConnection.getInstance();
    }


    @Override
    public void ajouterPanier(Panier p) {
        String req ="INSERT INTO PANIER (idPanier,idSession)"+
                "Values (?,?)";
        try {
            PreparedStatement ps=connexion.getConnexion().prepareStatement(req);
            ps.setString(1,p.getIdPanier());
            ps.setString(2,p.getIdSession());

            ps.executeUpdate();

            System.out.println("ElementPanier Ajouté");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List afficherPaniers() {
        String req="SELECT * FROM PANIER";
        ArrayList<Panier> list = new ArrayList<Panier>();
        try {
            Statement s = connexion.getConnexion().createStatement();
            ResultSet rs =s.executeQuery(req);
            while (rs.next()){
                list.add(new Panier(rs.getString("idPanier"),
                        rs.getString("idSession")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ElementPanier> afficherPanier(String panierId) {
        String req="SELECT * FROM ELEMENTPANIER where idPanier= "+"'"+panierId+"'";
        ArrayList<ElementPanier> list = new ArrayList<ElementPanier>();
        try {
            Statement s = connexion.getConnexion().createStatement();
            ResultSet rs =s.executeQuery(req);
            while (rs.next()){
                list.add(new ElementPanier(rs.getString("idElementPanier"),
                        rs.getString("idPanier"),
                        rs.getString("idOuvrage"),
                        rs.getString("intituleElementPanier"),
                        rs.getFloat("prixElementPanier"),
                        rs.getString("typeElementPanier"),
                        rs.getInt("quantiteElementPanier")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }


    @Override
    public void modifierPanier(Panier p1,Panier p2) {


    }

    @Override
    public void supprimerPanier(Panier p) {
        String req ="DELETE FROM PANIER WHERE (idPanier= ?)";
        try {
            PreparedStatement ps=connexion.getConnexion().prepareStatement(req);
            ps.setString(1,p.getIdPanier());
            ps.executeUpdate();
            System.out.println("Panier Supprimé");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    @Override
    public void viderPanier(Panier p) {
        String req ="DELETE FROM ElementPanier WHERE (idPanier= ?)";
        try {
            PreparedStatement ps=connexion.getConnexion().prepareStatement(req);
            ps.setString(1,p.getIdPanier());
            ps.executeUpdate();
            System.out.println("Panier Vidé");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String validerPanier(Panier p,String addresse){
        String idCommande = p.getIdPanier();
        ServiceCommande sc = new ServiceCommande();
        ServiceElementCommande sec =new ServiceElementCommande();

        sc.ajouterCommande(p,addresse);
        sec.ajouterElementCommande(this.afficherPanier(p.getIdPanier()),idCommande);
        this.viderPanier(p);
        this.supprimerPanier(p);
        System.out.println("Commande Validé");
        return idCommande;

    }

    public float calculerPrixTotal(String idPanier){
        List<ElementPanier> panier= afficherPanier(idPanier);
        float prix=0f;
        for(ElementPanier e : panier){
            prix+=e.getPrixElementPanier();
        }
        return prix;
    }
}
