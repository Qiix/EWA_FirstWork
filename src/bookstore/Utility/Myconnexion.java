/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Utility;

/**
 *
 * @author lenovo
 */
import bookstore.Entities.Emprunt;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import static sun.security.jgss.GSSUtil.login;



/**
 *
 * @author lenovo
 */


public class Myconnexion {
    private String url="jdbc:mariadb://localhost:3307/projetouvrage";
    private String pwd="";
    private String login="root";
    private Connection connexion;
    private static Myconnexion instance;
    
    Connection conn = null;
   
private Myconnexion() 
{
        try {
            
            connexion = DriverManager.getConnection(url, login, pwd);
             System.out.println("la connexion est établie avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(Myconnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
} 

public static Myconnexion getInstance()
{
    if (instance == null)
    { 
        instance = new Myconnexion();
    }
return instance;
}
  
public Connection getConnexion ()
{
    return connexion;
}

public static ObservableList<Emprunt> getDatausers(){
        
        Myconnexion conn = Myconnexion.getInstance();
        ObservableList<Emprunt> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.getConnexion().prepareStatement("select * from Emprunt");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add( new Emprunt(rs.getInt("id"),rs.getInt("icClient"),rs.getString("nomEmp"),rs.getDate("dateDebut"),rs.getDate("dateFin")));               
            }
        } catch (Exception e) {
        }
        return list;
    }


}