
package bookstore.Utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyCnx {
    
    private String url="jdbc:mysql://localhost:3306/bookstoreessai";
    private String login="root";
    private String pwd="";
    private Connection cnx;
    private static MyCnx instance;
    
    private MyCnx(){
        try {
            cnx= DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
            Logger.getLogger(MyCnx.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static MyCnx getInstance(){
        if(instance == null)
            instance = new MyCnx();
        
        return instance;
    }
    
    public Connection getConnexion(){
        return cnx;
    }
    
}
